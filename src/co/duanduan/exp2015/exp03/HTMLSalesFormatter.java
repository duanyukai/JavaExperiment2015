package co.duanduan.exp2015.exp03;

import co.duanduan.exp2015.exp01.*;
import co.duanduan.exp2015.exp02.*;

/**
 * Created by dyk on 10/24/15.
 */
public class HTMLSalesFormatter implements SalesFormatter{
    private static HTMLSalesFormatter singletonInstance = new HTMLSalesFormatter();

    private HTMLSalesFormatter(){
    }
    public static HTMLSalesFormatter getSingletonInstance(){
        return HTMLSalesFormatter.singletonInstance;
    }
    public String formatSales(Sales sales){
        StringBuilder s = new StringBuilder("\n");

        s.append("<html>\n")
         .append("\t<body>\n")
         .append("\t\t<center><h2>Orders</h2></center>\n");
        for(Order o : sales){
            for(OrderItem i : o){
                s.append("\t\t<hr>\n")
                    .append("\t\t<h4>Total = ")
                    .append(o.getTotalCost())
                    .append(" </h4>\n")
                    .append("\t\t<p>\n")
                    .append("\t\t\t<b>code:</b> ")
                    .append(i.getProduct().getCode())
                    .append("<br>\n")
                    .append("\t\t\t<b>quantity:</b> ")
                    .append(i.getQuantity())
                    .append("<br>\n")
                    .append("\t\t\t<b>price:</b> ")
                    .append(i.getProduct().getPrice())
                    .append("\n")
                    .append("\t\t</p>\n");
            }
        }
        s.append("\t</body>\n</html>");
        return s.toString();
    }
}
