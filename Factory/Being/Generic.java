package Factory.Being;

public class Generic{
    private int code;
    private String name;

    public Generic(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}