package Factory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

public class GoldenTicket{
    private String code;
    private Date raffledDate;

    private static SimpleDateFormat defaultDateFormat  = new SimpleDateFormat("dd/MM/yyyy");

    public GoldenTicket()
    {

    }

    public GoldenTicket(String code, Date raffled)
    {
        this.code = code;
        this.raffledDate = raffled;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getDateRaffled(){
        return defaultDateFormat.format(raffledDate);
    }

    public boolean isRaffled()
    {
        return this.raffledDate != null;
    }
}