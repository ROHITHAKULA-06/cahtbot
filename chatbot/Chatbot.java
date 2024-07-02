package chatbot;

/**
 *
 * @author rohit
 */
import java.util.Scanner;
import chatbot.Application;
public class Chatbot {
    public static void main(String[] args) {
        url search=new url();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter 'exit' to stop execution, \nType to search in browser,\ntype open to open an application on this computer\n\n");
        while(true){
        System.out.print("$ ");
        String browse=sc.nextLine();
        browse=browse.toLowerCase();
        String action;
        if(browse.equalsIgnoreCase("exit"))
            System.exit(0);
        if(browse.startsWith("open "))
        {
            action=browse.substring(5);
            System.out.println("opening application");
            try{
            Thread.sleep(1500);
            }catch(InterruptedException e){}
            search.openApplication(action);
        }
        else if(browse.startsWith("search "))
        {
            action=browse.substring(7);
            System.out.println("processing request");
            try{
            Thread.sleep(1500);
            }catch(InterruptedException e){}
            search.search(action);
        }
        else
        {
            System.out.println("invalid request");
        }
    }
}
}