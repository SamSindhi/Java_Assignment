package Factory.Being;

public class OompaLoompa extends Generic {
    private int height;
    private String favouriteFood;

    public OompaLoompa(int code, String name, int height, String favouriteFood)
    {
        super(code,name);
        this.height = height;
        this.favouriteFood = favouriteFood;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public String getFavouriteFood(){
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood){
        this.favouriteFood = favouriteFood;
    }
}