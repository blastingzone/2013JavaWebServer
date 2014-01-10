package server;

public class ResponseHeadBuilder {
	// 파일 길이, 응답 코드, 콘텐츠 타입을 가져와서 응답 헤더를 만든다
	public static String buildHeader(long ContentLength, String ResponseCode, ContentType type){
		String header = "";
		header = "HTTP/1.0 " + ResponseCode + " Document Follows " + URLParser.NEWLINE;
		header += "Server: TestJavaServer " + URLParser.NEWLINE;
		header += "Content-Type: " + type.getContentType() + " ;charset=utf-8" + URLParser.NEWLINE;
		header += "Accept-Ranges: Bytes" + URLParser.NEWLINE;
 		header += "Cache-Control: max-age=600, must-revalidate" + URLParser.NEWLINE;
 		header += "Content-Length: " + ContentLength + URLParser.NEWLINE + URLParser.NEWLINE;
 		
 		return header;
	}
}
