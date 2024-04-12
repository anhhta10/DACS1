
package view.main;

import controller.ControllerMainSystem;
import event.EventMenuSelected;
import event.EventPopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelUser;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import swing.icon.GoogleMaterialDesignIcons;
import swing.icon.IconFontSwing;
import view.main.component.PanelHeader;
import view.main.component.PanelMenu;
import view.main.component.content.Home;
import view.main.component.PanelContent;

/**
 *
 * @author anhth
 */
public class MainSystem extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelMenu menu;
    private PanelHeader header;
    private PanelContent content;
    private Animator animator;
    private final ModelUser user;
    
    public MainSystem(ModelUser user) throws SQLException {
        this.user = user;
        initComponents();
        init();
    }
    
    private void init() throws SQLException {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new PanelMenu();
        header = new PanelHeader();
        content = new PanelContent();
        System.out.println("user" + user.getUserName());
        
        EventMenuSelected menuSelectedEvent = new ControllerMainSystem(bg, layout, content, user);
        
        menu.addEventSelected(menuSelectedEvent);
        
        EventPopupMenu popupMenuEvent = new ControllerMainSystem(MainSystem.this);
        
        menu.addEventPopupMenu(popupMenuEvent);
        
        menu.initMenuItem();
//        
//        menu.setBackground(Color.red);
//        header.setBackground(Color.blue);
//        content.setBackground(Color.green);
        
        bg.add(menu, "w 230!, spany 2"); // spany is like rowspan in table of html :)!
        bg.add(header, "h 42!, wrap");
        bg.add(content, "w 100%, h 100%");
        
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                double width;
                if(menu.isShowMenu()) {
                    width = 53 + (178 * (1f-fraction));
                } else {
                    width = 53 + (178 * fraction);
                }
                layout.setComponentConstraints(menu, "w " +width +"!, spany 2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if(menu.isShowMenu()) {
                    menu.hideAllMenu();
                }
            }
            
        });
        
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());

        content.showForm(new Home(user));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(ModelUser user) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainSystem(user).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
