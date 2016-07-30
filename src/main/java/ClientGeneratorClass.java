/**
 * Created by Al on 30.07.2016.
 */
public class ClientGeneratorClass {

    public static void main(String[] args) {
        Thread[] thread = new Thread[300];

        for(int i = 0; i < 300; i++)
            thread[i] = new Thread(new ClientClass());

        for(int i = 0; i < 300; i++)
            thread[i].start();


    }
}
