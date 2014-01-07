package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class WebServer {
	private final static Logger log = Logger.getLogger(WebServer.class.getName());
	
    public static void main(String argv[]) throws Exception {
    	
    	// 8080 포트로 요청이 들어오면 소켓 생
        ServerSocket listenSocket = new ServerSocket(8080);
        
        // 클라이언트가 연결될때까지 대기한다.
        Socket socket;
        while ( (socket = listenSocket.accept()) != null ) {
        	ClientRequest cr = new ClientRequest();
        	cr.connect(socket);
            cr.start();
        }
    }
}
