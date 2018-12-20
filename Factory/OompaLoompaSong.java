package Factory;

import java.util.ArrayList;
import java.util.Random;

public class OompaLoompaSong{

    private int line_count;
    private ArrayList<String> song_lyrics = new ArrayList<String>() { 
            { 
                add("Oompa loompa doompety doo");
                add("I've got a perfect puzzle for you");
                add("Oompa loompa doompety dee");
                add("If you are wise you'll listen to me");
                add("What do you get when you guzzle down sweets");
                add("Eating as much as an elephant eats");
                add("What are you at, getting terribly fat");
                add("What do you think will come of that");
                add("I don't like the look of it");
                add("Oompa loompa doompety da");
                add("If you're not greedy, you will go far");
                add("You will live in happiness too");
                add("Like the Oompa Loompa Doompety do");
                add("Doompety do");
                add("Oompa loompa doompety doo");
                add("I've got another puzzle for you");
                add("Oompa loompa doompeda dee");
                add("If you are wise you'll listen to me");
                add("Gum chewing's fine when it's once in a while");
                add("It stops you from smoking and brightens your smile");
                add("But it's repulsive, revolting and wrong");
                add("Chewing and chewing all day long");
                add("The way that a cow does");
            } 
        };
    private Random rand = new Random(); 

    //Constructors:
    // define how many lines  the song shall have
    public OompaLoompaSong(int lines)
    {
        line_count = lines;
    }

    // Return a String with the song
    public String sing(){
        String return_string = "";
        for(int i = 0; i<line_count;i++)
        {
            return_string += song_lyrics.get(rand.nextInt(23)) + "\n";
        }
        return return_string;
    }
}