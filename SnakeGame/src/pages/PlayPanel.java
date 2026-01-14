import javax.swing.JPanel;
import java.awt.BorderLayout;
import resources.CustomColors;
import pages.PagesContext;

public class PlayPanel extends JPanel {
    public PlayPanel(PagesContext context) {
        this.setBackground(CustomColors.lightGreen());
        this.setLayout(new BorderLayout());
    }
}
