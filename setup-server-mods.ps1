$ErrorActionPreference = 'Stop'

$manifestUrl = 'https://github.com/jxttomm-coder/ContrastSMP-Updates/releases/latest/download/server-mods.json'
$modsDirectory = Join-Path (Get-Location).Path 'mods'
$manifestPath = Join-Path ([System.IO.Path]::GetTempPath()) ('contrast-season2-server-' + [guid]::NewGuid().ToString('N') + '.json')

try {
    Invoke-WebRequest -Uri $manifestUrl -OutFile $manifestPath
    $manifest = Get-Content -LiteralPath $manifestPath -Raw | ConvertFrom-Json
    if ($manifest.minecraftVersion -ne '1.20.1' -or $manifest.forgeLoaderVersion -ne '47.4.28' -or -not $manifest.files) {
        throw 'The downloaded server manifest is not a valid Season 2 Forge 1.20.1 pack.'
    }
    New-Item -ItemType Directory -Path $modsDirectory -Force | Out-Null

    # The fixed ore mod has a new versioned filename; preserve the broken version before updating.
    $managedNames = @($manifest.files | ForEach-Object { $_.name })
    $obsoleteManagedMods = @('ContrastSMP-Season2-Ore-Boost-1.0.0.jar')
    foreach ($oldName in $obsoleteManagedMods) {
        if ($managedNames -notcontains $oldName) {
            $oldTarget = Join-Path $modsDirectory $oldName
            if (Test-Path -LiteralPath $oldTarget) {
                $backupDirectory = Join-Path $modsDirectory '.contrast-season2-backups'
                New-Item -ItemType Directory -Path $backupDirectory -Force | Out-Null
                Move-Item -LiteralPath $oldTarget -Destination (Join-Path $backupDirectory ($oldName + '.' + (Get-Date -Format 'yyyyMMddHHmmss') + '.bak'))
                Write-Output "Backed up obsolete mod: $oldName"
            }
        }
    }

    foreach ($file in $manifest.files) {
        if ($file.name -notmatch '^[A-Za-z0-9 _().+@-]{1,180}\.jar$' -or
            $file.url -notmatch '^https://' -or $file.sha256 -notmatch '^[a-fA-F0-9]{64}$' -or
            $file.size -lt 1 -or $file.size -gt 300MB) {
            throw "The server manifest contains an invalid entry: $($file.name)"
        }

        $target = Join-Path $modsDirectory $file.name
        $temporary = Join-Path $modsDirectory ('.contrast-download-' + [guid]::NewGuid().ToString('N') + '.jar')
        if (Test-Path -LiteralPath $target) {
            $current = Get-FileHash -LiteralPath $target -Algorithm SHA256
            if ($current.Hash -eq $file.sha256.ToUpperInvariant() -and (Get-Item -LiteralPath $target).Length -eq $file.size) {
                Write-Output "Current: $($file.name)"
                continue
            }
        }

        try {
            Invoke-WebRequest -Uri $file.url -OutFile $temporary
            $download = Get-Item -LiteralPath $temporary
            $hash = Get-FileHash -LiteralPath $temporary -Algorithm SHA256
            if ($download.Length -ne $file.size -or $hash.Hash -ne $file.sha256.ToUpperInvariant()) {
                throw "Size or SHA-256 verification failed for $($file.name)."
            }
            if (Test-Path -LiteralPath $target) {
                $backupDirectory = Join-Path $modsDirectory '.contrast-season2-backups'
                New-Item -ItemType Directory -Path $backupDirectory -Force | Out-Null
                Move-Item -LiteralPath $target -Destination (Join-Path $backupDirectory ($file.name + '.' + (Get-Date -Format 'yyyyMMddHHmmss') + '.bak'))
            }
            Move-Item -LiteralPath $temporary -Destination $target
            Write-Output "Installed: $($file.name)"
        } finally {
            Remove-Item -LiteralPath $temporary -Force -ErrorAction SilentlyContinue
        }
    }
    Write-Output "Season 2 server mods are ready. Minecraft $($manifest.minecraftVersion), Forge $($manifest.forgeLoaderVersion)."
} finally {
    Remove-Item -LiteralPath $manifestPath -Force -ErrorAction SilentlyContinue
}
