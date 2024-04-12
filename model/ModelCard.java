/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.Icon;

/**
 *
 * @author anhth
 */
public class ModelCard {
    private String title;
    private String type;
    private double values;
    private int percentage;
    private Icon icon;

    public ModelCard() {
    }

    public ModelCard(String title, String type, double values, Icon icon) {
        this.title = title;
        this.type = type;
        this.values = values;
        this.icon = icon;
    }
    
    public ModelCard(String title, String type, double values, int percentage, Icon icon) {
        this.title = title;
        this.type = type;
        this.values = values;
        this.percentage = percentage;
        this.icon = icon;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    
    
}
