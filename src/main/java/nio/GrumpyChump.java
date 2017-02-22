package nio;


import java.io.IOException;
import java.net.Socket;

public class GrumpyChump {
    public static void main(String[] args) throws InterruptedException {
        Socket[] sockets = new Socket[3000];
        for (int i = 0; i < sockets.length; i++) {
            try {
                sockets[i] = new Socket("localhost", 8080);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        Thread.sleep(10000000);
    }

}
