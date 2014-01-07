package server;

public class ResponseHeadBuilder {
	// 줄바꿈
	public static final String NEWLINE = System.getProperty("line.separator");
	
	// 파일 길이, 응답 코드, 콘텐츠 타입을 가져와서 응답 헤더를 만든다
	public static String buildHeader(long ContentLength, String ResponseCode, ContentType type){
		String header = "";
		header = "HTTP/1.0 " + ResponseCode + " Document Follows " + NEWLINE;
		header += "Content-Type: " + ContentTypeParser.getContentType(type) + " ;charset=utf-8" + NEWLINE;
 		header += "Cache-Control: max-age=2400, must-revalidate" + NEWLINE;
 		header += "Content-Length: " + ContentLength + NEWLINE + NEWLINE;
 		
 		return header;
	}
}
