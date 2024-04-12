/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class InventorySummary {
    private int remaing;
    private int available;
    private double totalInventory;
    private int lowStock;

    public InventorySummary() {
    }

    public InventorySummary(int remaing, int available, double totalInventory, int lowStock) {
        this.remaing = remaing;
        this.available = available;
        this.totalInventory = totalInventory;
        this.lowStock = lowStock;
    }
    
    public int getRemaing() {
        return remaing;
    }

    public void setRemaing(int remaing) {
        this.remaing = remaing;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public double getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(double totalInventory) {
        this.totalInventory = totalInventory;
    }

    public int getLowStock() {
        return lowStock;
    }

    public void setLowStock(int lowStock) {
        this.lowStock = lowStock;
    }

}
