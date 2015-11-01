package co.duanduan.exp2015.exp01;

/**
 * Created by 段育凯 on 2015/10/23.
 */
public class Coffee extends Product{
    private String origin;
    private String roast;
    private String flavor;
    private String aroma;
    private String acidity;
    private String body;
    public Coffee(String initialCode,
                  String initialDescription,
                  double initialPrice,
                  String initialOrigin,
                  String initialRoast,
                  String initialFlavor,
                  String initialAroma,
                  String initialAcidity,
                  String initialBody){
        super(initialCode, initialDescription, initialPrice);
        this.origin = initialOrigin;
        this.roast = initialRoast;
        this.flavor = initialFlavor;
        this.aroma = initialAroma;
        this.acidity = initialAcidity;
        this.body = initialBody;
    }

    public String getOrigin() {
        return origin;
    }

    public String getRoast() {
        return roast;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getAroma() {
        return aroma;
    }

    public String getAcidity() {
        return acidity;
    }

    public String getBody() {
        return body;
    }
    public String toString() {
        return super.toString() + "_" + getOrigin() + "_" + getRoast() + "_" +
                getFlavor() + "_" + getAroma() + "_" + getAcidity() + "_" + getBody();
    }
}
