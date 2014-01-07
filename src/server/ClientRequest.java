package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientRequest extends Thread {
	
	// 로그 기록
	private final static Logger log = Logger.getLogger(ClientRequest.class.getName());
	
	private Socket clientAndServerConn;
	
	// 쓰레드에서 하는 일
	public void run() {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = clientAndServerConn.getInputStream(); // 요청 받는 곳
			os = clientAndServerConn.getOutputStream(); // 결과 돌려주는 곳
			
			// 구현해야 함.

			clientAndServerConn.close();
		} catch (IOException e) {
			// 에러 로깅
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	// 소켓을 받아옴
	public void connect(Socket socket) {
		clientAndServerConn = socket;
	}
}
