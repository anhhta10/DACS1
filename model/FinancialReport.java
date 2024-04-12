
package model;

import java.time.LocalDate;

/**
 *
 * @author anhth
 */
public class FinancialReport {
    private LocalDate dmy;
    private int date;
    private int month;
    private int year;
    private double revenue;
    private double profit;

    public FinancialReport(LocalDate dmy, int date, int month, int year, double revenue, double profit) {
        this.dmy = dmy;
        this.date = date;
        this.month = month;
        this.year = year;
        this.revenue = revenue;
        this.profit = profit;
    }
    

    public FinancialReport() {
    }

    public LocalDate getDmy() {
        return dmy;
    }

    public void setDmy(LocalDate dmy) {
        this.dmy = dmy;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
    
    
    
    
}
