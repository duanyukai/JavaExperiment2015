package co.duanduan.exp2015.exp03;

import co.duanduan.exp2015.exp01.*;
import co.duanduan.exp2015.exp02.*;
/**
 * Created by dyk on 10/24/15.
 */
public class PlainTextSalesFormatter implements SalesFormatter{
    private static PlainTextSalesFormatter singletonInstance = new PlainTextSalesFormatter();

    private PlainTextSalesFormatter(){
    }
    public static PlainTextSalesFormatter getSingletonInstance(){
        return PlainTextSalesFormatter.singletonInstance;
    }
    public String formatSales(Sales sales){
        StringBuilder s = new StringBuilder("\n");

        int number = 1;
        for(Order o : sales){
            s.append("------------------------\n")
                    .append("Order ")
                    .append(number)
                    .append("\n\n");
            for(OrderItem i : o){
                s.append(i.getQuantity())
                        .append(' ')
                        .append(i.getProduct().getCode())
                        .append(' ')
                        .append(i.getProduct().getPrice())
                        .append('\n');
            }
            s.append("\nTotal = ")
             .append(o.getTotalCost())
             .append('\n');
            number++;
        }
        return s.toString();
    }
}