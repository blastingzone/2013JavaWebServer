package server;

public class URLParser {
	// 줄바꿈
	public static final String NEWLINE = System.getProperty("line.separator");

	static String getRequestType(String header) {
		// request 정보는 header 맨 앞에서부터 첫 번째 띄워쓰기까지 있으므로
		String requestType = "";
		
		if ( header.indexOf(" ") > 0 )
			requestType = header.substring(0, header.indexOf(" "));
		
		return requestType;
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

	public static String getRequestHost(String header) {
		String result = "";
		
		String lines[] = header.split(NEWLINE);
		
		for (String line : lines) {
			if (line.indexOf("Host: ") != -1) {
				// Host: 부분을 떼버린다
				result = line.replace("Host: ", "");
				break;
			}
		}
		// Host: 가 없으면 "" 리턴
		return result;
	}
}
