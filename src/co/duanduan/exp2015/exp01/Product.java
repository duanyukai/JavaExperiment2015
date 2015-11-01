package co.duanduan.exp2015.exp01;

import co.duanduan.exp2015.exp_extra.DataField;

import java.util.ArrayList;

/**
 * Created by 段育凯 on 2015/10/23.
 */
public class Product {
    private String code;
    private String description;
    private double price;

    public Product(String initialCode, String initialDescription, double initialPrice) {
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

    public String toString() {
        return code + "_" + description + "_" + price;
    }

    /**
     * 额外添加，为实验5、6服务
     */
    public ArrayList<DataField> getDataFields() {
        ArrayList<DataField> dataField = new ArrayList<>();
        dataField.add(new DataField("Code", this.getCode()));
        dataField.add(new DataField("Description", this.getDescription()));
        dataField.add(new DataField("Price", Double.toString(this.getPrice())));
        return dataField;
    }
}