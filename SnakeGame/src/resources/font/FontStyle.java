package resources.font;

import java.awt.font.TextAttribute;

public enum FontStyle {
    BOLD(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD),
    ITALIC(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE),
    UNDERLINE(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON),
    STRIKETHROUGH(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);

    final TextAttribute key;
    final Object value;

    FontStyle(TextAttribute key, Object value) {
        this.key = key;
        this.value = value;
    }
}
