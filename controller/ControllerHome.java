/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.PaymentDAO;
import DAO.ProductDAO;
import chart.Chart;
import chart.ModelChart;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.stream.Stream;
import javax.swing.Icon;
import model.FinancialReport;
import model.InventorySummary;
import model.ModelCard;
import model.ModelUser;
import swing.icon.GoogleMaterialDesignIcons;
import swing.icon.IconFontSwing;
import view.component.PanelCard;

public class ControllerHome implements MouseListener{
    private ModelUser user;
    private PanelCard Card1;
    private PanelCard Card2;
    private PanelCard Card3;
    private PanelCard Card4;
    private Chart chart;
    
    public ControllerHome(ModelUser user,PanelCard Card1, PanelCard Card2, PanelCard Card3, PanelCard Card4,Chart chart) throws SQLException {
        this.user = user;
        this.Card1 = Card1;
        this.Card2 = Card2;
        this.Card3 = Card3;
        this.Card4 = Card4;
        this.chart = chart;
        initCardData();
        initChartData();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void initCardData() throws SQLException {
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.HOME, 60, Color.BLUE);
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BOOK, 60, Color.YELLOW);
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.WC, 60, Color.GREEN);
        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.WC, 60, Color.ORANGE);

        InventorySummary iS = new ProductDAO().inventorySummary(user.getBusinessID());
        
        Card1.setData(new ModelCard("", "Giá trị kho", iS.getTotalInventory(),icon1), "đ");
        
        Card2.setData(new ModelCard("", "Số lượng", iS.getRemaing(), icon2), "");

        Card3.setData(new ModelCard("", "Sản phẩm còn bán", iS.getAvailable(), icon3),"");
        
        Card4.setData(new ModelCard("", "Sản phẩm sắp hết", iS.getLowStock(), icon4),"");
    }
    
    private void initChartData() throws SQLException {
        Stream<FinancialReport> stream = new PaymentDAO().revenue(user.getBusinessID());
        
        chart.addLegend("revenue", new Color(69,62,255));
        chart.addLegend("profit", new Color(82,255,116));
        chart.addLegend("loss", new Color(250,111,8));
////        chart.addLegend("Cost", new Color(139, 229, 222));
//                chart.addData(new ModelChart(String.valueOf("a"), 200, 0, 100));
//
        stream.forEach(s -> {
            if(s.getProfit() > 0){
                chart.addData(new ModelChart(String.valueOf(s.getDmy()), s.getRevenue(), s.getProfit(), 0));
            } else {
                chart.addData(new ModelChart(String.valueOf(s.getDmy()), s.getRevenue(),0, -s.getProfit()));
            }
            
        });
    }

    
    
}
