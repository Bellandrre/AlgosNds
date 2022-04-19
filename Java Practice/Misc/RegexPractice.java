import java.util.regex.*;

public class RegexPractice {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\w");
		Matcher match = pattern.matcher("abcd w karthik");
		while(match.find()) {
			System.out.print(match.group()+" ");
		}
		
	}

}
