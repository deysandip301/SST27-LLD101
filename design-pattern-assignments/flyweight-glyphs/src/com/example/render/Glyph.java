package com.example.render;

public class Glyph {
    // Flyweight: style is shared, only char is extrinsic
    private final char ch;
    private final TextStyle style;

    public Glyph(char ch, TextStyle style) {
        this.ch = ch;
        this.style = style;
    }

    public int drawCost() {
        return style.getSize() + (style.isBold() ? 10 : 0);
    }

    public char getCh() {
        return ch;
    }

    public TextStyle getStyle() {
        return style;
    }
}
