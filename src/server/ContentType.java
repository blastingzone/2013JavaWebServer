package server;

public enum ContentType {
	HTML("text/html"),
	CSS("text/css"),
	JS("text/javascript"),
	JPG("image/jpeg"),
	JPEG("image/jpeg"),
	GIF("image/gif"),
	BMP("image/bmp"),
	JSON("application/json"),
	PDF("application/pdf");
	
	private String content;
	
	ContentType(String content) {
		this.content = content;
	}
	
	public String getContentType() {
		return content;
	}
}
