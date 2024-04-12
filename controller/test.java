package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author anhth
 */
public class test implements ActionListener{
    private boolean isOpen = true;
    private JPanel main;
    private JPanel sidebar;
    private JPanel content;
    
    public test(JPanel main, JPanel sidebar, JPanel content){
        this.main = main;
        this.sidebar = sidebar;
        this.content = content;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = (String)((JComponent) e.getSource()).getClientProperty("btn");
        if(buttonName != null){
            if(buttonName.equals("btnMenu")){
               OpenAndCloseMenu();
            }
        }
    }
    
    private void OpenAndCloseMenu() {
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction){
                double fractionMenu;
                double fractionContent = 0;
                if(isOpen){
                    // 230 is the original width
                    fractionMenu = 230 - 230*fraction;
                    fractionContent = content.getWidth() + 230*fraction;
                    if(fractionMenu < 64){
                        fractionMenu = 64;
                        fractionContent = content.getWidth() + 166;
                    }
                } else {
                    fractionMenu = 166*fraction + 64;
                    fractionContent = content.getWidth() - 166*fraction;
                }
                
                sidebar.setPreferredSize(new Dimension((int) fractionMenu, main.getHeight()));
                content.setPreferredSize(new Dimension((int) fractionContent, main.getHeight()));
                main.revalidate();
            }
            
            @Override
            public void end() {
                isOpen = !isOpen;
            }
        };
        
        Animator animator = new Animator(200, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();

    }
}
