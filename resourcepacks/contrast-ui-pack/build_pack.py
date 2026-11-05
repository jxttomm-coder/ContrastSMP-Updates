from pathlib import Path
from zipfile import ZIP_DEFLATED, ZipFile

from PIL import Image, ImageDraw


ROOT = Path(__file__).resolve().parent
PROJECT = ROOT.parents[1]
SOURCE_LOGO = PROJECT / "src" / "static" / "images" / "logo.png"
SOURCE_BANNER = PROJECT / "src" / "static" / "images" / "contrast-banner.png"
OUTPUT = ROOT / "Contrast SMP UI.zip"
MOD_ASSETS = PROJECT / "contrast-modpack" / "contrast-quick-exit" / "src" / "main" / "resources" / "assets" / "contrast_quick_exit" / "textures" / "gui"


def wordmark(size: tuple[int, int]) -> Image.Image:
    logo = Image.open(SOURCE_LOGO).convert("RGBA")
    cropped = logo.crop((0, 525, logo.width, 930))
    alpha_bounds = cropped.getchannel("A").getbbox()
    if alpha_bounds:
        cropped = cropped.crop(alpha_bounds)
    cropped.thumbnail(size, Image.Resampling.LANCZOS)
    return cropped


def button_texture(kind: str) -> Image.Image:
    palettes = {
        "normal": ((5, 18, 34), (10, 39, 68), (20, 74, 116)),
        "highlighted": ((7, 42, 73), (11, 71, 117), (19, 128, 190)),
        "disabled": ((13, 24, 36), (22, 37, 53), (39, 57, 73)),
    }
    top, middle, bottom = palettes[kind]
    image = Image.new("RGBA", (200, 20))
    draw = ImageDraw.Draw(image)
    for y in range(20):
        mix = y / 19
        color = tuple(round(a * (1 - mix) + b * mix) for a, b in zip(top, middle)) if y < 10 else tuple(
            round(a * (1 - (mix - 0.5) * 2) + b * ((mix - 0.5) * 2)) for a, b in zip(middle, bottom)
        )
        draw.line((0, y, 199, y), fill=(*color, 255))
    edge = (37, 145, 218, 255) if kind == "highlighted" else (17, 75, 119, 255)
    draw.rectangle((0, 0, 199, 19), outline=edge)
    draw.line((1, 1, 198, 1), fill=(76, 168, 220, 180) if kind == "highlighted" else (39, 105, 151, 170))
    draw.line((1, 18, 198, 18), fill=(1, 8, 18, 255))
    return image


def build() -> None:
    assets = ROOT / "assets" / "minecraft" / "textures" / "gui"
    title = assets / "title"
    widget = assets / "sprites" / "widget"
    title.mkdir(parents=True, exist_ok=True)
    widget.mkdir(parents=True, exist_ok=True)

    logo = Image.new("RGBA", (1024, 256), (0, 0, 0, 0))
    mark = wordmark((250, 62))
    logo.alpha_composite(mark, ((256 - mark.width) // 2, (64 - mark.height) // 2))
    logo.save(title / "minecraft.png")

    loading_logo = Image.new("RGBA", (120, 120), (0, 0, 0, 0))
    mark = wordmark((116, 54))
    for y in (3, 63):
        loading_logo.alpha_composite(mark, ((120 - mark.width) // 2, y + (54 - mark.height) // 2))
    MOD_ASSETS.mkdir(parents=True, exist_ok=True)
    loading_logo.save(MOD_ASSETS / "brand_logo.png")
    Image.open(SOURCE_BANNER).convert("RGBA").save(MOD_ASSETS / "contrast_banner.png")

    for name in ("button", "button_highlighted", "button_disabled"):
        suffix = name.removeprefix("button_") if name != "button" else "normal"
        button_texture(suffix).save(widget / f"{name}.png")

    metadata = """{
  "pack": {
    "description": "Contrast SMP blue menu and branded logo",
    "pack_format": 64,
    "min_format": [64, 0],
    "max_format": [64, 0],
    "supported_formats": [64, 64]
  }
}
"""
    (ROOT / "pack.mcmeta").write_text(metadata, encoding="utf-8")
    with ZipFile(OUTPUT, "w", ZIP_DEFLATED) as archive:
        archive.write(ROOT / "pack.mcmeta", "pack.mcmeta")
        for file in sorted((ROOT / "assets").rglob("*")):
            if file.is_file():
                archive.write(file, file.relative_to(ROOT).as_posix())
    print(OUTPUT, OUTPUT.stat().st_size)


if __name__ == "__main__":
    build()
