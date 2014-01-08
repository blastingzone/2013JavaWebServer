package server;

public class ContentTypeParser {
	static String getContentType(ContentType type)
	{
		switch(type)
		{
		case HTML:
			return "text/html";
		case CSS:
			return "text/css";
		case JS:
			return "text/javascript";
		case JPG:
			return "image/jpeg";
		case JPEG:
			return "image/jpeg";
		case GIF:
			return "image/gif";
		case BMP:
			return "image/bmp";
		case JSON:
			return "application/json";
		case PDF:
			return "application/pdf";
		default:
			return "text/html";
		}
	}
	
	static ContentType setContentType(String type)
	{
		if ( "html".equals(type) )
			return ContentType.HTML;
		
		if ( "css".equals(type) )
			return ContentType.CSS;
		
		if ( "js".equals(type) )
			return ContentType.JS;
		
		if ( "jpeg".equals(type) )
			return ContentType.JPEG;
		
		if ( "jpg".equals(type) )
			return ContentType.JPEG;
		
		if ( "gif".equals(type) )
			return ContentType.GIF;
		
		if ( "bmp".equals(type) )
			return ContentType.BMP;
		
		if ( "pdf".equals(type) )
			return ContentType.PDF;
		
		if ( "json".equals(type) )
			return ContentType.JSON;
			
		return ContentType.HTML;
	}
}
