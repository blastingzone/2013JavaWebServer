package server;

public class URLParser {
	// 줄바꿈
	public static final String NEWLINE = System.getProperty("line.separator");

	static String getRequestMethod(String header) {
		// request 정보는 header 맨 앞에서부터 첫 번째 띄워쓰기까지 있으므로
		String requestMethod = "";
		
		if ( header.indexOf(" ") > 0 )
			requestMethod = header.substring(0, header.indexOf(" "));
		
		return requestMethod;
	}

	public static String getRequestPath(String requestPath) {
		System.out.println(requestPath);
		// 첫 번째 공백으로부터 한 칸 뒤
		int URLStartPosition = requestPath.indexOf(" ") + 1;
		// 두 번째 공백까지
		int URLEndPosition = requestPath.indexOf(" ", URLStartPosition );
		
		// test
		//System.out.println(URLStartPosition +" "+ URLEndPosition);
		// 시작점은 끝점보다 앞이어야 한다.
		if ( URLStartPosition < URLEndPosition )
			return requestPath.substring(URLStartPosition, URLEndPosition);
		else
			return "error.html";
	}
	
	public static String getContentType(String header) {
		int StartPosition = header.indexOf(".") + 1;
		int EndPosition = header.indexOf(" ", StartPosition);
		
		if ( StartPosition < EndPosition )
		{
			return header.substring(StartPosition, EndPosition);
		}
		else
			return "";
	}
	
	public static int getContentLength(String header) {
		
		String CL = "Content-Length:";
		String Length = "-1";
		
		// header에 ContentLength: 라는 단어가 들어있으면
		if ( header.contains( CL ) ) {
			// 이 단어가 끝나는 부분의 인덱스부터
			int StartPosition = header.indexOf( CL ) + CL.length() + 1;
			// 다음 줄바꿈까지가 Post 데이터의 길이에 해당한다.
			int EndPosition = header.indexOf(NEWLINE, StartPosition);
			
			Length = header.substring(StartPosition, EndPosition);
			// test
			System.out.println("==========Content Length Start=============");
			System.out.println(Length);
			System.out.println("==========Content Length End=============");
		}
		
		// if return -1 == error
		return Integer.parseInt(Length);
	}
}
