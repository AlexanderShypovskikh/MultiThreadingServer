import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Al on 30.07.2016.
 */
public class ServerClass {

    public static void main(String[] args) {
        Socket socket;
            try(ServerSocket server = new ServerSocket(8080)) {
                 while (true) {
                     System.out.println("Server is waiting...");
                     socket = server.accept();
                     Thread thread = new Thread(new ServerThreadHelper(socket));
                     thread.start();
                 }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

}

