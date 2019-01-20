package Factory;

public class Product{
    private String description;
    private long barcode;
    private String serialNumber;
    private GoldenTicket prizeTicket;

    public Product(String description, long barcode, String serialNumber){
        this.description = description;
        this.barcode = barcode;
        this.serialNumber = serialNumber;
        this.prizeTicket = null; 
    }

    public Product(String description, long barcode, String serialNumber, GoldenTicket prizeTicket){
        this.description = description;
        this.barcode = barcode;
        this.serialNumber = serialNumber;
        this.prizeTicket = prizeTicket; 
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public long getBarcode(){
        return barcode;
    }

    public void setBarcode(long barcode){
        this.barcode = barcode;
    }

    public String getSerialNumber(){
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }

    public GoldenTicket getPrizeTicket(){
        return prizeTicket;
    }

    public String getPrizeTicketString(){
        return (new StringBuilder()).append(prizeTicket.getCode()).append(",").append(prizeTicket.getDateRaffled()).append(",").toString();
    }

    public void setPrizeTicket(GoldenTicket prizeTicket){
        this.prizeTicket = prizeTicket;
    }

}