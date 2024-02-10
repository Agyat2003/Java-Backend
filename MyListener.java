import javax.servlet.*;

public class MyListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent ev){
        System.out.println("Context Initialized Executed");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){

        }
    }
    public void contextDestroyed(ServletContextEvent ev){
        System.out.println("Context Destroyed Executed");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){

        }
    }
}
 