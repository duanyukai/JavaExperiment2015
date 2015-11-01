package co.duanduan.exp2015.exp03;

import co.duanduan.exp2015.exp01.*;
import co.duanduan.exp2015.exp02.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOError;
import java.io.StringWriter;

/**
 * Created by dyk on 10/24/15.
 *   <Sales>
 *      <Order total="totalCost">
 *          <OrderItem quantity="quantity1" price="price1">
 *              code1
 *          </OrderItem>
 *          ...
 *          <OrderItem quantity="quantityN" price="priceN">
 *              codeN
 *          </OrderItem>
 *      </Order>
 *      ...
 *   </Sales>
 */
public class XMLSalesFormatter implements SalesFormatter{
    private static XMLSalesFormatter singletonInstance = new XMLSalesFormatter();

    private XMLSalesFormatter(){
    }
    static public XMLSalesFormatter getSingletonInstance(){
        return XMLSalesFormatter.singletonInstance;
    }
    public String formatSales(Sales sales){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder;
            docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElmt = doc.createElement("Sales");
            doc.appendChild(rootElmt);

            for(Order o : sales){
                Element order = doc.createElement("Order");
                order.setAttribute("total",Double.toString(o.getTotalCost()));
                rootElmt.appendChild(order);
                for(OrderItem i : o){
                    Element orderItem = doc.createElement("OrderItem");
                    orderItem.setAttribute("quantity",Double.toString(i.getQuantity()));
                    orderItem.setAttribute("price",Double.toString(i.getProduct().getPrice()));
                    orderItem.appendChild(doc.createTextNode(i.getProduct().getCode()));
                    order.appendChild(orderItem);
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "YES");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            StringWriter writer = new StringWriter();

            transformer.transform(new DOMSource(doc), new StreamResult(writer));

            return writer.toString();

        }catch(ParserConfigurationException | TransformerException e ){
            System.out.println(e.getMessage());
        }
        return "";
    }
}
