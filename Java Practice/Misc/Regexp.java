import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regexp {
public static void main(String[] args) {
	Pattern pattern = Pattern.compile("[a-zA-z]?");
	Matcher matcher = pattern.matcher("pwwkew");
	while(matcher.find()) {
		System.out.println(matcher.group()+" " + matcher.start()+" "+matcher.end());
	}
}
}
