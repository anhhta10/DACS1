package swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *
 * @author anhth
 */

public class ScrollBar extends JScrollBar {

    public ScrollBar() {
        setUI(new ScrollBarUI());
        setPreferredSize(new Dimension(3, 5));
        setForeground(new Color(255, 255, 255, 80));
        setUnitIncrement(20);
        setOpaque(false);
    }
}