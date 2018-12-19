import Factory.OompaLoompaSong;

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
                    System.out.println("You pressed "+ menu_number);

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
                        case 5:  System.out.println("You pressed 5");
                            break;
                        case 6:  System.out.println("You pressed 6");
                            break;
                        case 7:  System.out.println("You pressed 7");
                            break;
                        case 8:  System.out.println("You pressed 8");
                            break;
                        case 9:  System.out.println("You pressed 9");
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

    public static String repeat(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }
}