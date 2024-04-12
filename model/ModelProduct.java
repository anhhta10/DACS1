
package model;

/**
 *
 * @author anhth
 */
public class ModelProduct {
    private int id;
    private String name;
    private double price;
    private double purchasePrice;
    private int stock;
    private String unit;
    private String category;
    private String description;


    public ModelProduct() {
    }

    public ModelProduct(String name, double price, double purchasePrice, String unit, String category, String description) {
        this.name = name;
        this.price = price;
        this.purchasePrice = purchasePrice;
        this.unit = unit;
        this.category = category;
        this.description = description;
    }
    
    public ModelProduct(int id, String name, double price, double purchasePrice, int stock, String unit, String category,  String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
        this.category = category;
        this.unit = unit;
    }
    
    public ModelProduct(String name, double price, int stock, String unit, String category, String description) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.unit = unit;
    }
    
    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
