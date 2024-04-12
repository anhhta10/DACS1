package controller.InOut;

import DAO.ProductDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.stream.Stream;
import javax.swing.JLayeredPane;
import javax.swing.table.DefaultTableModel;
import model.ModelProduct;
import model.ModelUser;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import swing.mesage.MyMessage;
import swing.table.SpinnerCell;
import swing.table.Table;
import swing.table.TableActionCellEditor;
import swing.table.TableActionCellRender;
import swing.table.TableActionEvent;
import view.component.dialog.ImportProductDialog;

/**
 *
 * @author anhth
 */
public class ControllerIn implements ActionListener{
    private ModelUser user;
    private Table table1;
    private Table table2;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    
    private ImportProductDialog ipDialog;
    private JLayeredPane bg;
    private MigLayout layout;
    private int w;
    
    public ControllerIn(ModelUser user, ImportProductDialog ipDialog, JLayeredPane bg, MigLayout layout, Table table1, Table table2) throws SQLException {
        this.user = user;
        this.ipDialog = ipDialog;
        this.bg = bg;
        this.layout = layout;
        this.w = ipDialog.getWidth();
        this.table1 = table1;
        this.table2 = table2;
        this.model1 = (DefaultTableModel) table1.getModel();
        this.model2 = (DefaultTableModel) table2.getModel();
        setTable();
        initData();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void initData() throws SQLException{
        Stream<ModelProduct> products = new ProductDAO().getProducts(user.getBusinessID());
        
        int[] no = {0};
        products.forEach(product -> {
            ++no[0];
            model1.addRow(new Object[] {
                no[0],
                "PD"+product.getId(),
                product.getName(),
                product.getStock(),
                product.getPurchasePrice(),
                0
            });
        });
    }
//==================================================== EVENT MESSAGE ===========================================================
    private void showMessage(MyMessage.MessageType messageType, String title, String message){
        MyMessage ms = new MyMessage();
        ms.showMessage(messageType, title, message);

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0 25", 0); //  Insert to bg fist index 0
                    ms.setVisible(true);
                    bg.setComponentZOrder(ms, 0);
                    bg.repaint();

                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = (ms.getWidth()+20) * (1f - fraction);
                } else {
                    f = (ms.getWidth()+20) * fraction;
                }
                System.out.println(bg.getWidth());

                layout.setComponentConstraints(ms, "pos " +(w-f)+ " 25");
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
        Animator animator = new Animator(750, target);
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
    
    
//==================================================== EVENT BTN TABLE ===========================================================
    private void setTable() {
        
    //=========================== Table 1 ==================================
        TableActionEvent event1 = new TableActionEvent(){
            @Override
            public void onBtn1(int row) {
                showMessage(MyMessage.MessageType.SUCCESS, "Helo", "NGU");
                System.out.println("press");
            }

            @Override
            public void onBtn2(int row) {
            }

            @Override
            public void onBtn3(int row) {
            }
        };
        
        TableActionCellRender render1 = new TableActionCellRender();
        TableActionCellEditor editor1 = new TableActionCellEditor(event1);
        table1.getColumnModel().getColumn(6).setCellRenderer(render1);
        table1.getColumnModel().getColumn(6).setCellEditor(editor1);
        table1.getColumnModel().getColumn(5).setCellEditor(new SpinnerCell());
        
        render1.showBtn(true, false, false);
        editor1.showBtn(true, false, false);
        
    //=========================== Table 2 ==================================
        TableActionEvent event2 = new TableActionEvent(){
            @Override
            public void onBtn1(int row) {
            }

            @Override
            public void onBtn2(int row) {
            }

            @Override
            public void onBtn3(int row) {
            }
        };
        
        TableActionCellRender render2 = new TableActionCellRender();
        TableActionCellEditor editor2 = new TableActionCellEditor(event2);
        table2.getColumnModel().getColumn(6).setCellRenderer(render2);
        table2.getColumnModel().getColumn(6).setCellEditor(editor2);
        table1.getColumnModel().getColumn(3).setCellEditor(new SpinnerCell());
        
        render2.showBtn(false, true, false);
        editor2.showBtn(false, true, false);
    //============================================================================
    

    }
//=============================================================================================================================

}
