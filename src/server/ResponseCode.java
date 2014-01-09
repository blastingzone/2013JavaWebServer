package server;

public enum ResponseCode {
	OK("200"), NO_CONTENT("204"), NOT_FOUND("404"), NOT_IMPLEMENT("501"), MOVE_PERMANENTLY("301");
	
	private String code;
	
	ResponseCode(String Code) {
		code = Code;
	}
	
	public String getCode() {
		return code;
	}
}
