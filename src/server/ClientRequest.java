package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientRequest extends Thread {
	
	public static final String HTMLPATH = "./webSource";
	
	// 로그 기록
	private final static Logger log = Logger.getLogger(ClientRequest.class.getName());
	
	private Socket clientAndServerConn = null;
	
	// 쓰레드에서 하는 일
	public void run() {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = clientAndServerConn.getInputStream(); // 요청 받는 곳
			os = clientAndServerConn.getOutputStream(); // 결과 돌려주는 곳
			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			// 클라이언트 요청으로부터 header를 읽어온다.
			String HttpHeader = RequestHeaderBuilder.headBuild(br);
			
			// test
			System.out.println("=======RequestHeaderSTART=======");
			System.out.println(HttpHeader);
			System.out.println("=======RequestHeaderEND=======");
			
			// 헤더에 문제가 있으면 연결을 끊고 내보낸다
			if (HttpHeader == null || HttpHeader.equals(""))
			{
				System.out.println("Header Error!");
				clientAndServerConn.close();
				return;
			}
			

			////////////////////////////////////////////////
			// Request Type을 보고 전송 방식을 결정
			///////////////////////////////////////////////
			
			String request = URLParser.getRequestType(HttpHeader);
			
			// test
			System.out.println("=======RequestTypeSTART=======");
			System.out.println("Request Type : " + request);
			System.out.println("=======RequestTypeEND=======");
			
			// ContentType을 가져와야 // 기본 : HTML
			String RequestContentType = URLParser.getContentType(HttpHeader);
			ContentType ct = ContentTypeParser.setContentType(RequestContentType);
			
			// test
			System.out.println("=======ContentTypeSTART=======");
			System.out.println(ct.name());
			System.out.println("=======ContentTypeEND=======");
			
			///////////////////////////////////////////
			// 데이터 전송
			///////////////////////////////////////////

			// header와 header에 들어갈 코드들
			
			String ResponseHeader = "";
			String ResponseCode = "";
			
			// 요청받은 파일 경로의 파일을 연다
			String requestedFilePath = HTMLPATH + URLParser.getRequestPath(HttpHeader);
			
			File serverFile = new File(requestedFilePath);
			
			// 요청한 파일이 없을 경우
			if ( !serverFile.exists() )
			{
				// 404로 보내버림
				serverFile = new File(HTMLPATH + "/error.html");
				ResponseCode = "404";
				ResponseHeader = ResponseHeadBuilder.buildHeader(serverFile.length(), ResponseCode, ct);
			}
			else
			{
				// 파일이 있으면 코드 200
				ResponseCode = "200";
				ResponseHeader = ResponseHeadBuilder.buildHeader(serverFile.length(), ResponseCode, ct);
			}
			
			//test
			System.out.println("=======ResponseHeaderSTART=======");
	 		System.out.println(ResponseHeader);
	 		System.out.println("=======ResponseHeaderEND=======");
			
			// 데이터 전송을 위한 클래스를 선언
			DataOutputStream dos = new DataOutputStream(os);
			FileInputStream fis = new FileInputStream(serverFile);
			
			// 빌드된 헤더를 dos에 써준다
			dos.writeBytes(ResponseHeader);
			
			// 파일에서 데이터가 없을 때까지 읽어서 보내준다
			int data = fis.read();
            while (data != -1) {
                    dos.write(data);
                    data = fis.read();
            }
            
            fis.close();
            dos.close();
			
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
