package server;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public static void main(String argv[]) throws Exception {
    	
    	// 8080 포트로 요청이 들어온다고 보고 소켓 생성
        ServerSocket listenSocket = new ServerSocket(8080);
        
        // 클라이언트가 연결될때까지 대기한다.
        Socket socket;
        System.out.println("Socket Create");
        while ( (socket = listenSocket.accept()) != null ) {
        	ClientRequest cr = new ClientRequest();
        	cr.connect(socket);
            cr.start();
        }
    }
}
