package ArraysAndString;
import java.util.regex.*;
public class Solution3 {
	public static void main(String[] args) {
		String input = "Mr John Smith    ";
		System.out.println(urlify(input));
		
	}
	//Simple solution using Regex
	public static String urlify(String input) {
		input = input.trim();
		Pattern pattern = Pattern.compile("\\s");
		Matcher match = pattern.matcher(input);
		input = match.replaceAll("%20");
		return input;
	}
}
