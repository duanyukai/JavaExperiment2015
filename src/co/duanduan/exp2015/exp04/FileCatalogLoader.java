package co.duanduan.exp2015.exp04;

import co.duanduan.exp2015.exp01.*;
import co.duanduan.exp2015.exp02.*;
import co.duanduan.exp2015.exp03.*;

import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Created by dyk on 10/31/15.
 */
public class FileCatalogLoader implements CatalogLoader{

    private Product readProduct(String line) throws DataFormatException{
        //Product_ code _ description _ price
        StringTokenizer st = new StringTokenizer(line,"_",false);

        if(st.countTokens() != 4)
            throw new DataFormatException(line);
        st.nextToken();
        try{
            return new Product(st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()));
        } catch (NumberFormatException e) {
            throw new DataFormatException(line);
        }

    }
    private Coffee readCoffee(String line) throws DataFormatException{
        //Coffee_ code _ description _ price _ origin _ roast _ flavor _ aroma _ acidity _ body
        StringTokenizer st = new StringTokenizer(line,"_",false);
        if(st.countTokens() != 10)
            throw new DataFormatException(line);
        st.nextToken();
        try {
            return new Coffee(
                    st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()),
                    st.nextToken(), st.nextToken(), st.nextToken(),
                    st.nextToken(), st.nextToken(), st.nextToken()
            );
        }catch(NumberFormatException e) {
            throw new DataFormatException(line);
        }
    }
    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException{
        //Brewer_ code _ description _ price _ model _ waterSupply _ numberOfCups
        StringTokenizer st = new StringTokenizer(line,"_",false);
        if(st.countTokens() != 7)
            throw new DataFormatException(line);
        try{
            st.nextToken();
            return new CoffeeBrewer(
                    st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()),
                    st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken())
            );
        } catch (NumberFormatException e) {
            throw new DataFormatException(line);
        }
    }
    public Catalog loadCatalog(String filename) throws FileNotFoundException, IOException, DataFormatException{
        FileReader reader = new FileReader(filename);
        Scanner scanner = new Scanner(reader);

        String line;

        Catalog catalog = new Catalog();

        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            if(line.startsWith("Product")){
                catalog.addProduct(readProduct(line));
            }else if(line.startsWith("Coffee")){
                catalog.addProduct(readCoffee(line));
            }else if(line.startsWith("Brewer")){
                catalog.addProduct(readCoffeeBrewer(line));
            }
        }
        return catalog;
    }
}
