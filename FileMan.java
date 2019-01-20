import Factory.Being.Generic;
import Factory.Being.Kid;
import Factory.Being.OompaLoompa;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileMan{
    private static ArrayList<Generic> beingsList = new ArrayList<Generic>();

    public FileMan(){
        
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
}