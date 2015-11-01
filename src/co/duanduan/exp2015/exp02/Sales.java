package co.duanduan.exp2015.exp02;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 段育凯 on 2015/10/24.
 */
public class Sales implements Iterable<Order>{
    private ArrayList<Order> orders;

    public Sales(){
        this.orders = new ArrayList<>();
    }
    public void addOrder(Order order){
        this.orders.add(order);
    }
    public Iterator<Order> iterator(){
        return this.orders.iterator();
    }
    public int getNumberOfOrders(){
        return this.orders.size();
    }
}
