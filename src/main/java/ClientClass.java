import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Al on 30.07.2016.
 */
public class ClientClass implements Runnable {
    public void run(){
       sendMessage();
    }


     public void sendMessage(){
             int i = 0;
             try{
                 Socket socket = new Socket("127.0.0.1",8080);
                 PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                 System.out.println(Thread.currentThread().getName());
                  out.println(Thread.currentThread().getName());
                     out.flush();
             } catch (IOException e){
              e.printStackTrace();
             }
      }

     public Socket getConnection(){
         try(Socket socket = new Socket("127.0.0.1",8080)){
             return socket;
         }catch (IOException e){
             e.printStackTrace();
         }
         return null;
     }
}
