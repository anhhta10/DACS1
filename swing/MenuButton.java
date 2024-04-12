package swing;

import event.EventMenu;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MenuButton extends JButton {

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;
    private Animator animator;
    private int targetSize;
    private float animatSize;
    private Point pressedPoint;
    private float alpha;
    private Color effectColor = new Color(0, 0, 0, 150);
    private Color hover;

    public MenuButton(Icon icon, String text) {
        super(text);
        setIcon(icon);
        init();
        setBorder(new EmptyBorder(1, 20, 1, 1));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
        
    public MenuButton(Icon icon, int p, String text){
        super(String.format("%"+ (p+text.length())+"s", text));
        setIcon(icon);
        init();
        setBorder(new EmptyBorder(1, 20, 1, 1));
        setBackground(Color.red);
    }

    public MenuButton(String text) {
        super(text);
        init();
        setBorder(new EmptyBorder(1, 50, 1, 1));
    }

    public MenuButton(String text, boolean subMenu) {
        super(text);
        init();
    }

    private void init() {
        setContentAreaFilled(false);
        setForeground(new Color(30, 30, 30));
        setHorizontalAlignment(JButton.LEFT);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                targetSize = Math.max(getWidth(), getHeight()) * 2;
                animatSize = 0;
                pressedPoint = me.getPoint();
                alpha = 0.5f;
                if (animator.isRunning()) {
                    animator.stop();
                }
                animator.start();
            }
        });
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (fraction > 0.5f) {
                    alpha = 1 - fraction;
                }
                animatSize = fraction * targetSize;
                repaint();
            }
        };
        animator = new Animator(350, target);
        animator.setResolution(0);
        
    }


    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (pressedPoint != null) {
            g2.setColor(effectColor);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2.fillOval((int) (pressedPoint.x - animatSize / 2), (int) (pressedPoint.y - animatSize / 2), (int) animatSize, (int) animatSize);
        }
       
        
        g2.setComposite(AlphaComposite.SrcOver);
        super.paintComponent(grphcs);
        
    }
    
    private void hover() {
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent event) {
                changeColor(getBackground(), hover);
                setBackground(Color.red);
            }
            
            @Override
            public void mouseEntered(MouseEvent event){
                changeColor(getBackground(), hover);
            }
        });
    }
    
    private void changeColor(Color c1, Color c2){
        hover = c1;
        setBackground(c2);
    }
    
    public Color getHover() {
        return hover;
    }

    public void setHover(Color hover) {
        this.hover = hover;
        hover();
    }

}