
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import model.ModelMessage;
import model.ModelUser;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import service.ServiceGmail;
import DAO.UserDAO;
import swing.TextField;
import view.main.MainSystem;
import view.component.Message;
import view.component.PanelVerify;
import view.login.Login;
import view.login.PanelLoginAndRegister;

/**
 *
 * @author anhth
 */
public class ControllerLogin implements ActionListener{
    private final Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{0,}+@[a-zA-Z]{2,}(\\.[a-zA-Z]{2,}{1,3}$)");
    
    private final JFrame login;
    private final JLayeredPane bg;
    private final UserDAO dao;
    private final MigLayout layout;
    private final PanelVerify verify;
    private final PanelLoginAndRegister loginAndRegister;
    private boolean isLogin;
    private String veridyCode = "0";
    private ModelUser user = null;

    public ControllerLogin(JFrame login,JLayeredPane bg, MigLayout layout, PanelVerify verify, PanelLoginAndRegister loginAndRegister) {
        dao = new UserDAO();
        this.login = login;
        this.bg = bg;
        this.layout = layout;
        this.verify = verify;
        this.loginAndRegister = loginAndRegister;
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        String btnValue = a.getActionCommand();
        switch (btnValue) {
            case "SIGN UP" -> {
                register();
            }
            case "SIGN IN" -> {
                login();
            }
            case "Forget your password?" -> {
                forget();
            }
            case "Or Register" -> {
                changePanel();
            }
            case "Or Login" -> {
                changePanel();
            }
            case "OK" -> {  
                changedPassOk();
            }
            default -> {
            }
        }
    }
    
    private void register() {
        ModelUser user = loginAndRegister.getUser();
        try {
            boolean validUser = !user.getUserName().isEmpty();
            boolean validEmail = p.matcher(user.getEmail()).find();
            boolean validPass = user.getPassword().length() > 8;
            boolean compare = user.comparePass();
            
            if(validUser){
                if(validEmail){
                    if(dao.checkDuplicateEmail(user.getEmail())){
                        showMessage(Message.MessageType.ERROR, "Email already exit");
                    } else {
                        if(validPass){
                            if(compare){
                                dao.insertUser(user);
                                showMessage(Message.MessageType.SUCCESS, "registered successfully");
                            } else {
                                showMessage(Message.MessageType.ERROR, "Passwork is incorrect");
                            }
                        } else {
                            showMessage(Message.MessageType.ERROR, "Passwork should be more than 8 characters");
                        }
                    }
                } else {
                    showMessage(Message.MessageType.ERROR, "Email is not Valid!");
                }
            } else {
                showMessage(Message.MessageType.ERROR, "User name is not Valid!");
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(Message.MessageType.ERROR, "Warring");
        }
    }
    
    private void login() {
        ModelUser data = loginAndRegister.getDataLogin();
        try {
            ModelUser user = dao.login(data);
            if(user != null){
                login.dispose();
                MainSystem.main(user);
            } else {
                showMessage(Message.MessageType.ERROR, "Email and Password is incorrect!");
            }
        } catch (SQLException e) {
            showMessage(Message.MessageType.ERROR, "ERROR");
        }
    }
    
    private void forget() {
        verify.setVisible(true);
        MouseListener ml = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                verify.getUser();
                sendMain();
            }
        };
        verify.addEvent(ml);
    }
    
    private void sendMain(){
        this.user = verify.getUser();
        TextField btn = verify.getBtnTxtCode();
        
        DecimalFormat df = new DecimalFormat("000000");
        Random rand = new Random();
        this.veridyCode = df.format(rand.nextInt(1000000));
        
        new Thread(() -> {
            try {
                if(dao.checkGmail(user.getEmail())){
                    ModelMessage ms = new ServiceGmail().send(user.getEmail(), this.veridyCode, "Verify Code");
                    if(ms.isSuccess()){
                        btn.setSuffixButton("Sent");
                        btn.setLoading(false);
                        
                        try {
                            Thread.sleep(5000);
                            btn.setSuffixButton("Send");
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        btn.setLoading(false);
                        showMessage(Message.MessageType.ERROR, "Email is not valid");
                    }
                } else {
                    btn.setLoading(false);
                    showMessage(Message.MessageType.ERROR, "Email is not valid or not exit!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
   
    private void changePanel() {
        isLogin = !isLogin;
        loginAndRegister.showRegister(isLogin);
    }
    
    private void changedPassOk() {
        ModelUser user1 = verify.getUser();
        boolean compareVerifyCode = this.veridyCode.equals(verify.getBtnTxtCode().getText());
        

        String emailNew = user1.getEmail();
        boolean validPass = user1.getPassword().length() > 8;
        boolean comparePass = user1.comparePass();
        
//        check user already exists
        String emailOld = null;
        boolean comapareEmail = false;
        try {
            emailOld = user.getEmail();
            comapareEmail = emailOld.equals(emailNew);
        } catch (Exception e) {
            showMessage(Message.MessageType.ERROR, "This user is not exists!");
        }

        try{
            if(user != null){
                if(compareVerifyCode && comapareEmail){
                    if(validPass){
                        if(comparePass){
                            showMessage(Message.MessageType.SUCCESS, "changed password successfully");
                            dao.updatePass(emailOld, user1.getPassword());
                            verify.setVisible(false);
                        } else {
                            showMessage(Message.MessageType.ERROR, "Password is incorrect!");
                        }
                    } else {                           
                        showMessage(Message.MessageType.ERROR, "Password must be more than 8 latters!");
                    }
                } else {
                    showMessage(Message.MessageType.ERROR, "Verify Code is incorrect!");
                }
            }
        } catch (Exception e) {
            showMessage(Message.MessageType.ERROR, "ERROR");
        }
    }
    
    private void showMessage(Message.MessageType messageType, String message){
        Message ms = new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al -30", 0); //  Insert to bg fist index 0
                    ms.setVisible(true);
                    bg.setComponentZOrder(ms, 0);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                } else {
                    ms.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(() -> {
            try {
                Thread.sleep(2500);
                animator.start();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }).start();
    }
}
