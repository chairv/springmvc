package netty.fakeThread;

import java.net.ServerSocket;
import java.net.Socket;

import com.io.TimeServerHandlerExecutePool;
import com.io.TimeserverHandler;

/**
 * Created by tancw on 2017/8/31.
 */
public class TimeServer {
    public static void main(String[] args) {
     int port = 8080;
        ServerSocket server = null;
        try{
            server = new ServerSocket(port);
            System.out.println("The time server is start int port:" + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50,100000);
            while (true){
                socket = server.accept();
                singleExecutor.execute(new TimeserverHandler(socket));
            }
        }catch (Exception e){

        }
    }
}

