public class Text {
    String text;

    public Text(String text) {
        this.text = text;
    }

    public Text() {
        this.text = null;
    }

    public void set(String newStr) {
        this.text = newStr;
    }

    public String get() {
        return this.text;
    }
}
