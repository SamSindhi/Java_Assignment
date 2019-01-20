import Factory.Being.Generic;
import Factory.Being.Kid;
import Factory.Being.OompaLoompa;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import Factory.GoldenTicket;
import Factory.Product;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;
import java.text.ParseException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class FileMan{
    private static ArrayList<Generic> beingsList = new ArrayList<Generic>();
    private static ArrayList<Product> productsList = new ArrayList<Product>();
    private static SimpleDateFormat defaultDateFormat  = new SimpleDateFormat("dd/MM/yyyy");

    public FileMan(){
        loadProducts();
    }

    public static void addBeing(Generic beingToAdd){
        beingsList.add(beingToAdd);

        String filePath = "";
        if (beingToAdd instanceof Kid){
            filePath = "Factory\\Storage\\K" + beingToAdd.getCode() + ".txt";
        }
        else{
            filePath = "Factory\\Storage\\O" + beingToAdd.getCode() + ".txt";
        }

        File tmpFile = new File(filePath);
        if(tmpFile.exists() == false)
        {
            try{
                tmpFile.createNewFile();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        
        try (PrintWriter out = new PrintWriter(filePath)) {
            
            if (beingToAdd instanceof Kid){
                Kid kidToAdd = (Kid) beingToAdd;
                String output = (new StringBuilder()).append(kidToAdd.getCode()).append(",").append(kidToAdd.getName()).append(",").append(kidToAdd.getBirthday()).append(",").append(kidToAdd.getPlaceOfBirth()).toString();
                out.println(output);
            }else{
                OompaLoompa oompaLoompaToAdd = (OompaLoompa) beingToAdd;
                String output = (new StringBuilder()).append(oompaLoompaToAdd.getCode()).append(",").append(oompaLoompaToAdd.getName()).append(",").append(oompaLoompaToAdd.getHeight()).append(",").append(oompaLoompaToAdd.getFavouriteFood()).toString();
                out.println(output);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }    

    public static ArrayList<Generic> getBeings(){
        return beingsList;
    }

    public static void saveProducts(){
        String filePath = "Factory\\Storage\\Products.txt";

        File tmpFile = new File(filePath);
        if(tmpFile.exists() == false)
        {
            try{
                tmpFile.createNewFile();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        
        try (PrintWriter out = new PrintWriter(filePath)) {
            for (Product currentProduct : productsList)  
            {
                String output = (new StringBuilder()).append(currentProduct.getBarcode()).append(",").append(currentProduct.getSerialNumber()).append(",").append(currentProduct.getDescription()).append(",").append(currentProduct.getPrizeTicketString()).toString();
                out.println(output);
            }            
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void loadProducts(){
        String filePath = "Factory\\Storage\\Products.txt";
        
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(item->{
                String[] parts = item.split(",");
                String description = parts[2];
                long barcode = Long.parseLong(parts[0]);
                String serialNumber = parts[1];
                
                if(parts.length == 4){
                    try{
                    String code = parts[3];                    
                    Date raffledDate = defaultDateFormat.parse(parts[4]);
                    GoldenTicket prizeTicket = new GoldenTicket(code,raffledDate);
                    productsList.add(new Product(description,barcode,serialNumber,prizeTicket));
                    }catch(ParseException e)
                    {
                        e.printStackTrace();
                    }
                }else
                {
                    productsList.add(new Product(description,barcode,serialNumber));
                }
                
            });
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Product findProductByBarcode(long barcode){
        for (Product currentProduct : productsList)  
        {
            if(currentProduct.getBarcode() == barcode){
                return currentProduct;
            }
        }

        return null;
    }

    public static void removeProduct(String serialNumber, long barcode){
        int indexToRemove = -10;
        for(int i=0;i<=productsList.size();i++){  
            if((productsList.get(i)).getBarcode() == barcode && (productsList.get(i)).getSerialNumber() == serialNumber){
                indexToRemove = i;
                break;
            }
        }
        productsList.remove(indexToRemove);
        saveProducts();
    }

    public static Product getRandomProduct()
    {
        Random rand = new Random();
        return productsList.get(rand.nextInt(fileManager.get) + 1);
    }

    public static GoldenTicket getNewGoldenTicket()
    {
        Random rand = new Random();
        return productsList.get(rand.nextInt(fileManager.get) + 1);
    }
}