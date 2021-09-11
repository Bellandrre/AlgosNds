import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLify {
	public static void main(String[] args) {
		String a = "Mr John Smith     ";
		int length = a.length();
		URLifyy(a, length);
	}

	private static void URLifyy(String a, int length) {
		String b = a.trim();
		Pattern p = Pattern.compile("\\s");
		
		Matcher m = p.matcher(b);
		
		m.replaceAll("%20");
		
		System.out.println(m.replaceAll("%20"));
	
	}
}
