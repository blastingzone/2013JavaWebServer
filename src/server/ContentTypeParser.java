package server;

public class ContentTypeParser {
	static String getContentType(ContentType type)
	{
		return type.getContentType();
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
