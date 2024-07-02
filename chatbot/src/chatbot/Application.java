package chatbot;

/**
 *
 * @author rohit
 */
import java.awt.*;
import java.io.*;
import java.util.*;
public class Application {
    static String App="";
    boolean found=true;
    public void findFile(String name,File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if(found){
            if (fil.isDirectory())
            {
                App="";
                findFile(name,fil);
            }
            else if (name.equalsIgnoreCase(fil.getName()))
            {
                File addr=fil.getParentFile();
                App=addr.toString()+"\\"+name;
                found=false;
            }
            }
    }
    }
    public void openApplication(String Name)
    {
        try{
        if(Desktop.isDesktopSupported())
            {
            Desktop desk=Desktop.getDesktop();
            File fil=new File("C:\\Windows\\System32\\");
            File[] list = fil.listFiles();
            //System.out.println(Arrays.toString(list));
            if(Arrays.toString(list).contains(Name+".exe"))
            {
                App="C:\\Windows\\System32\\"+Name+".exe";
                System.out.println(App);
            }
            else{
            File file=new File("C:\\Program Files");
            found=true;
            findFile(Name+".exe",file);
            }
            desk.open(new java.io.File(App));
            }
        }catch(IOException e){System.out.println("unable to open application");}
        catch(Exception e){System.out.println("unable to open application please check your application name");}
    }
}
