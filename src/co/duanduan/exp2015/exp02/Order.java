package co.duanduan.exp2015.exp02;

import co.duanduan.exp2015.exp01.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 段育凯 on 2015/10/24.
 */
public class Order implements Iterable<OrderItem>{
    private ArrayList<OrderItem> items;

    public Order(){
        this.items = new ArrayList<>();
    }
    public void addItem(OrderItem orderItem){
        this.items.add(orderItem);
    }
    public void removeItem(OrderItem orderItem){
        this.items.remove(orderItem);
    }
    public Iterator<OrderItem> iterator(){
        return items.iterator();
    }
    public OrderItem getItem(Product product){
        for(OrderItem o: this.items){
            if(o.getProduct().equals(product)){
                return o;
            }
        }
        return null;
    }
    public int getNumberOfItems(){
        return this.items.size();
    }
    public double getTotalCost(){
        double total = 0.0;
        for(OrderItem o : items){
            total += o.getValue();
        }
        return total;
    }
    /**
     * 为实验5、6增加的方法
     */
    public OrderItem[] getItems() {
        return (OrderItem[])this.items.toArray();
    }
}
