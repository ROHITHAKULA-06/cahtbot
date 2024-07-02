package chatbot;

/**
 *
 * @author rohit
 */
import java.net.*;
import java.awt.*;
public class url extends Application{
    public void search(String srch)
    {
        String url="https://www.google.com/search?q=+"+srch.replace(" ","+");
        try{
        if(Desktop.isDesktopSupported())
        {
            Desktop serch=Desktop.getDesktop();
            serch.browse(new URI(url));
        }
        }catch(Exception e){System.err.println("something went wrong");}
    }
}
