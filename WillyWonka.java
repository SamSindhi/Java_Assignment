import java.text.SimpleDateFormat;  
import java.util.Date;

import Factory.OompaLoompaSong;
import Factory.Being.Generic;
import Factory.Being.Kid;
import Factory.Being.OompaLoompa;
import Factory.Product;


public class WillyWonka{

    private static String menu_items = "Please select from the following items:\n"+
    "1 - Register Prize tickets\n"+
    "2 - List all prize tickets\n"+
    "3 - List only raffled tickets\n"+
    "4 - Create a new Oompa Loompa song\n"+
    "5 - Register Beings\n"+
    "6 - Register Products\n"+
    "7 - Ruffle tickets\n"+
    "8 - Register sale\n"+
    "9 - List winners\n"+
    "0 - Quit";
    private static int menu_number = 0;    

    public static void main(String[] args)
    {        
        do{
            System.out.println(menu_items);
            try{
                    menu_number = Integer.parseInt(System.console().readLine());
                    System.out.println(repeat("=",20));
                    System.out.println("You pressed " + menu_number);

                    switch (menu_number) {
                        case 1:  System.out.println("You pressed 1");
                            break;
                        case 2:  System.out.println("You pressed 2");
                            break;
                        case 3:  System.out.println("You pressed 3");
                            break;
                        case 4:                            
                            System.out.println("Please tell me the number of lines of the song:");
                            int song_length = Integer.parseInt(System.console().readLine());
                            OompaLoompaSong ol_song = new OompaLoompaSong(song_length);
                            System.out.println();
                            System.out.println("Your song is:");
                            System.out.println(ol_song.sing());
                            break;
                        case 5:
                            System.out.println("Press 1 for Kid Registration or 2 for Oompa Loompa Registration:");
                            int decision = Integer.parseInt(System.console().readLine());
                            switch (decision) {
                                case 1:
                                    System.out.println("Code of Kid:");
                                    int codeOfKid = Integer.parseInt(System.console().readLine());
                                    System.out.println("Name of Kid:");
                                    String nameOfKid = System.console().readLine();
                                    System.out.println("Birthday (dd/MM/yyyy) of Kid:");
                                    Date birthdayOfKid = defaultDateFormat.parse(System.console().readLine());
                                    System.out.println("Place of Birth of Kid:");
                                    String placeOfBirthOfKid = System.console().readLine();
                                    fileManager.addBeing(new Kid(codeOfKid, nameOfKid, birthdayOfKid, placeOfBirthOfKid));
                                    System.out.println("Added Successfully!");
                                    break;
                                case 2:
                                    System.out.println("Code of Oompa Loompa:");
                                    int codeOfOompaLoompa = Integer.parseInt(System.console().readLine());
                                    System.out.println("Name of Oompa Loompa:");
                                    String nameOfOompaLoompa = System.console().readLine();
                                    System.out.println("Height of Oompa Loompa:");
                                    int heightOfOompaLoompa = Integer.parseInt(System.console().readLine());
                                    System.out.println("Favourite Food of Oompa Loompa:");
                                    String favouriteFoodOfOompaLoompa = System.console().readLine();
                                    fileManager.addBeing(new OompaLoompa(codeOfOompaLoompa, nameOfOompaLoompa, heightOfOompaLoompa, favouriteFoodOfOompaLoompa));
                                    System.out.println("Added Successfully!");
                                    break;
                            }
                            break;
                        case 6:  System.out.println("Press 1 for Product without Ticket and 2 for Product with Ticket:");
                            int case6decision = Integer.parseInt(System.console().readLine());
                            System.out.println("Description of Product:");
                            int codeOfKid = Integer.parseInt(System.console().readLine());
                            System.out.println("Barcode of Product:");
                            String nameOfKid = System.console().readLine();
                            System.out.println("Serial Number of Product:");
                            Date birthdayOfKid = defaultDateFormat.parse(System.console().readLine());
                            
                            switch (case6decision) {
                                case 1:
                                    
                                    
                                    break;
                                case 2:
                                    System.out.println("Code of Oompa Loompa:");
                                    int codeOfOompaLoompa = Integer.parseInt(System.console().readLine());
                                    System.out.println("Name of Oompa Loompa:");
                                    String nameOfOompaLoompa = System.console().readLine();
                                    System.out.println("Height of Oompa Loompa:");
                                    int heightOfOompaLoompa = Integer.parseInt(System.console().readLine());
                                    System.out.println("Favourite Food of Oompa Loompa:");
                                    String favouriteFoodOfOompaLoompa = System.console().readLine();
                                    fileManager.addBeing(new OompaLoompa(codeOfOompaLoompa, nameOfOompaLoompa, heightOfOompaLoompa, favouriteFoodOfOompaLoompa));
                                    System.out.println("Added Successfully!");
                                    break;
                            }
                            break;
                        case 7: 
                            System.out.println("How many Golden Tickets to Ruffle?");
                            int count = Integer.parseInt(System.console().readLine());
                            
                            for(int i=0;i<=count;i++){
                                fileManager.getRandomProduct().setPrizeTicket(fileManager.getNewGoldenTicket());
                            }
                            break;
                        case 8:  
                            System.out.println("Please enter the User Code:");
                            int userCode = Integer.parseInt(System.console().readLine());
                            System.out.println("Please enter the Product Barcode:");
                            long productBarcode = Long.parseLong(System.console().readLine());

                            for (Generic being : fileManager.getBeings())  
                            {
                                if(being instanceof Kid){
                                    Kid currentKid = (Kid)being;
                                    if(currentKid.getCode() == userCode)
                                    {
                                        Product purchasedProduct = fileManager.findProductByBarcode(productBarcode);
                                        currentKid.addPurchasedProduct(purchasedProduct);
                                        fileManager.removeProduct(purchasedProduct.getSerialNumber(), purchasedProduct.getBarcode());
                                    }
                                }
                            } 

                            break;
                        case 9:  
                            System.out.println("The Winners are:");
                            for (Generic being : fileManager.getBeings())  
                            {
                                if(being instanceof Kid){
                                    Kid currentKid = (Kid)being;
                                    for (Product currentProduct : currentKid.getPurchasedProducts())  
                                    {
                                        if(currentProduct.getPrizeTicket() != null)
                                        {
                                            System.out.println(currentKid.getName());
                                        }
                                    }
                                }
                            } 
                            break;
                        case 0:  break;
                        default: System.out.println("You pressed something I cannot do");
                            break;
                    }

                    System.out.println(repeat("=",20) + "\n");
                }
                catch(Exception ex)
                {

                }
        }while(menu_number != 0);
        
    }
    
    private static SimpleDateFormat defaultDateFormat  = new SimpleDateFormat("dd/MM/yyyy");
    private static FileMan fileManager = new FileMan();

    public static String repeat(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }
}