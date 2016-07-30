import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Al on 30.07.2016.
 */
public class ClientClass implements Runnable {
    //private  Socket socket = null;

    public void run(){
       sendMessage();
    }


     public void sendMessage(){
        // if(!socket.isClosed()){
             int i = 0;
             try{
                 Socket socket = new Socket("127.0.0.1",8080);
                 //System.out.println(socket);
                 PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                 //System.out.println(socket);
                 System.out.println(Thread.currentThread().getName());
                  out.println(Thread.currentThread().getName());
                 // while(i < 10) {
                  //   out.println(" " + i);
                     out.flush();
                 //    i++;
                 //}
             } catch (IOException e){
              e.printStackTrace();
             }
         //}//else{
          //   System.out.println("Socket is CLOSED");
          //   System.exit(-1);
         //}


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
