package co.duanduan.exp2015.exp01;

/**
 * Created by 段育凯 on 2015/10/23.
 */
public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product initialProduct, int initialQuantity){
        this.product = initialProduct;
        this.quantity = initialQuantity;
    }
    public Product getProduct(){
        return this.product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
    public double getValue(){
        return this.quantity * product.getPrice();
    }
    public String toString(){
        return this.getQuantity() + " " + product.getCode() + " " + product.getPrice();
    }
}
