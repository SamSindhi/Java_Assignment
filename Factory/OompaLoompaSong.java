package Factory;

public class OompaLoompaSong{

    private int line_count;

    //Constructors:
    // define how many lines  the song shall have
    public OompaLoompaSong(int lines)
    {
        line_count = lines;
    }  

    // Return a String with the song
    public String sing(){
        return "Tri Poloski";
    }
}