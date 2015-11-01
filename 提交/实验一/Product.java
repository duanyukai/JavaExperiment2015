package co.duanduan.exp2015.exp01;

/**
 * Created by 段育凯 on 2015/10/23.
 */
public class Product {
    private String code;
    private String description;
    private double price;

    public Product(String initialCode, String initialDescription, double initialPrice){
        this.code = initialCode;
        this.description = initialDescription;
        this.price = initialPrice;
    }
    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;
        return code.equals(product.code);
    }
    public String toString(){
        return code + "_" + description + "_" + price;
    }
}
