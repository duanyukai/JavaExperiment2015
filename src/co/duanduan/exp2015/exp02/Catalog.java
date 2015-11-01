package co.duanduan.exp2015.exp02;

import co.duanduan.exp2015.exp01.Product;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 段育凯 on 2015/10/23.
 */
public class Catalog implements  Iterable<Product> {
    private ArrayList<Product> products;

    public Catalog(){
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product){
        this.products.add(product);
    }
    public Product getProduct(String code){
        for(Product p : this.products){
            if(p.getCode().equals(code))
                return p;
        }
        return null;
    }
    public Iterator<Product> iterator(){
        return this.products.iterator();
    }
    public int getNumberOfProducts(){
        return this.products.size();
    }
    /**
     * 额外添加，为实验5服务
     */
    public String[] getCodes() {
        String[] codes = new String[this.getNumberOfProducts()];
        int i = 0;

        for(Product p : this.products){
            codes[i++] = p.getCode();
        }

        return codes;
    }
}
