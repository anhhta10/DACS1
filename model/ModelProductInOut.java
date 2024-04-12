/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author anhth
 */
public class ModelProductInOut {
    private int id;
    private String type;
    private double amount;
    private LocalDate date;
    private LocalTime time;
    private int payerId;
    private int collectorId;
    private int performerId;
    private String payer;
    private String collector;
    private String performer;
    private String description;
    private String productId;
    private int quantity;

    public ModelProductInOut() {
    }
    
    public ModelProductInOut(int id, double amount, LocalDate date, LocalTime time,String payer, String collector, String performer, String description) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.payer = payer;
        this.collector = collector;
        this.performer = performer;
        this.description = description;
    }

    public ModelProductInOut(int id, double amount, LocalDate date, LocalTime time,int payerId, int collectorId, int performerId, String description) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.payerId = payerId;
        this.collectorId = collectorId;
        this.performerId = performerId;
        this.description = description;
    }

    public ModelProductInOut(int id, String productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public int getPayerId() {
        return payerId;
    }

    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }

    public int getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(int collectorId) {
        this.collectorId = collectorId;
    }

    public int getPerformerId() {
        return performerId;
    }

    public void setPerformerId(int performerId) {
        this.performerId = performerId;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
