package Factory.Being;

import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import Factory.Product;

public class Kid extends Generic {
    private Date birthday;
    private String placeOfBirth;
    private ArrayList<Product> purchasedProducts = new ArrayList<Product>();
    private static SimpleDateFormat defaultDateFormat  = new SimpleDateFormat("dd/MM/yyyy");

    public Kid(int code, String name, Date birthday, String placeOfBirth)
    {
        super(code,name);
        this.birthday = birthday;
        this.placeOfBirth = placeOfBirth;
    }

    public void addPurchasedProduct (Product productToAdd)
    {
        purchasedProducts.add(productToAdd);    
    }

    public ArrayList<Product> getPurchasedProducts()
    {
        return purchasedProducts;    
    }

    public String getBirthday(){
        return defaultDateFormat.format(birthday);
    }

    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public String getPlaceOfBirth(){
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth){
        this.placeOfBirth = placeOfBirth;
    }
}