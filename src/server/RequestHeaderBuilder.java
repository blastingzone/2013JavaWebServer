package server;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestHeaderBuilder {
	static public String headBuild(BufferedReader br) throws IOException {
		String line = "";
		String header = "";
		
		do {
			line = br.readLine();
			header += line;
			header += URLParser.NEWLINE;
		} while ( line != null && !"".equals(line));
		
		return header;
	}
}
