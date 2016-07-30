import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Al on 30.07.2016.
 */
public class ServerThreadHelper implements  Runnable {
    private Socket socket;
    private BufferedReader buff;

    public void run(){
        getInputData();
    }
   public ServerThreadHelper(Socket socket){
       this.socket = socket;
   }

    public void getInputData(){
        try{
         buff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         String answr;
          while ((answr = buff.readLine()) != null)
            System.out.println("Server got:"+answr);
           buff.close();
            socket.close();
     }catch (IOException e){
            //e.printStackTrace();
            System.out.println("У потока"+Thread.currentThread().getName()+"сеанс окончен");
        }

}
}
