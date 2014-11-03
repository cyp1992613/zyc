package com.zyc.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Util {

public String getInputStreamByWebsite(String website) throws IOException{
		
		URL url = new URL(website);		
		InputStreamReader input = new InputStreamReader(url.openConnection().getInputStream());
		Scanner scanner = new Scanner(input);
		StringBuffer sb = new StringBuffer();
		while (scanner.hasNext()) {
			sb.append(scanner.nextLine());
		}
		input.close();
		return sb.toString();
	}
	
}
