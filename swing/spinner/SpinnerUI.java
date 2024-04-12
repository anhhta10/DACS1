
package swing.spinner;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSpinnerUI;

public class SpinnerUI extends BasicSpinnerUI{
    
    @Override
    public void installUI(JComponent c) {
        super.installUI(c); 
        spinner.setEditor(new Editor(spinner));
    }
    
    @Override
    protected Component createNextButton() {
        ArrowButton btn = new ArrowButton(true);
        installNextButtonListeners(btn);
        return btn;
    }

    @Override
    protected Component createPreviousButton() {
        ArrowButton btn = new ArrowButton(false);
        installPreviousButtonListeners(btn);
        return btn;
    }

    public class Editor extends JTextField implements ChangeListener{
        private JSpinner spinner;
        public Editor(JSpinner spinner){
//            setBackground(new Color(0,0,0,0));
            this.spinner = spinner;
            spinner.addChangeListener(this);
            
            setText("0");
            
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    updateSpinnerValue();
                }
            });
        }
        
        @Override
        public void stateChanged(ChangeEvent e) {
            setText(spinner.getValue().toString());
        }
        
        
        private void updateSpinnerValue() {
            try {

                // Cố gắng chuyển đổi văn bản thành một giá trị số
                Object value = Integer.parseInt(getText());
                spinner.setValue(value);
                setText(spinner.getValue().toString());

            } catch (NumberFormatException ex) {

                // Nếu không thể chuyển đổi, giữ nguyên giá trị hiện tại của spinner
                setText(spinner.getValue().toString());
            }
        }

    }
    
    
    private class ArrowButton extends JButton {
        private final boolean next;
        public ArrowButton(boolean next) {
            this.next = next;
            setContentAreaFilled(false);
            setFocusable(false);
            setBorder(new EmptyBorder(5, 5, 5, 5));
            setBackground(new Color(231, 231, 231));
            setForeground(new Color(150, 150, 150));
        }

        @Override
        public void paint(Graphics grphcs) {
            super.paint(grphcs);
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if(next){
                int width = getWidth();
                int height = getHeight();
                int sizeX = 12;
                int sizeY = 8;
                int x = (width - sizeX) / 2;
                int y = (height - sizeY) / 2;
                int px[] = {x + sizeX / 2,x + sizeX, x};
                int py[] = { y, y + sizeY, y + sizeY};
            g2.setColor(getBackground());
            g2.fillPolygon(px, py, px.length);
            } else {
                int width = getWidth();
                int height = getHeight();
                int sizeX = 12;
                int sizeY = 8;
                int x = (width - sizeX) / 2;
                int y = (height - sizeY) / 2;
                int px[] = {x, x + sizeX, x + sizeX / 2};
                int py[] = {y, y, y + sizeY};
                g2.setColor(getBackground());
                g2.fillPolygon(px, py, px.length);
            }
            g2.dispose();
        }
    }
}
