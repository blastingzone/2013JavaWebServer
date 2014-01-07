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
		default:
			return "text/html";
		}
	}
}
