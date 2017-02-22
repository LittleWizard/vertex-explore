package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOBlockingServer {
    public static void main(String... args) throws IOException {
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(8080));
        while(true) {
            SocketChannel s = ss.accept();
            System.out.println(s);
            handle(s);
        }
    }
    private static void handle(SocketChannel s) {
        ByteBuffer buf = ByteBuffer.allocateDirect(80);
        try {
            while((s.read(buf)) != -1) {
                buf.flip();
                transmogrifyByteBuffer(buf);
                while(buf.hasRemaining()){
                    System.out.println("writing ....");
                    s.write(buf);
                }
                buf.compact();
            }
            System.out.println("end of stream......");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void transmogrifyByteBuffer(ByteBuffer buf){
        for(int i = 0; i < buf.limit(); i++) {
            buf.put(i, (byte) transmogrify(buf.get(i)));
        }
    }

    private static int transmogrify(int data) {
        return Character.isLetter(data) ?
                data ^ ' ' : data;
    }
}
