package co.duanduan.exp2015.exp01;

/**
 * Created by 段育凯 on 2015/10/23.
 */
public class CoffeeBrewer extends Product{
    private String model;
    private String waterSupply;
    private int numberOfCups;

    public CoffeeBrewer(String initialCode,
                        String initialDescription,
                        double initialPrice,
                        String initialModel,
                        String initialWaterSupply,
                        int initialNumberOfCups){
        super(initialCode, initialDescription, initialPrice);
        this.model = initialModel;
        this.waterSupply = initialWaterSupply;
        this.numberOfCups = initialNumberOfCups;
    }
    public String getModel(){
        return model;
    }

    public String getWaterSupply(){
        return waterSupply;
    }

    public int getNumberOfCups(){
        return numberOfCups;
    }
    public String toString(){
        return super.toString() + "_" + getModel() + "_" + getWaterSupply() + "_" + getNumberOfCups();
    }
}
