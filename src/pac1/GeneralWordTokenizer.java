package pac1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralWordTokenizer {

	public static void main(String[] args) {
		// create a Pattern object to parse each line
		Pattern wordPattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9]+");
		while (true) {
			Scanner sc = new Scanner(System.in);
			String line = sc.nextLine();
			if (line.equals("quit"))
				break;
			else {
				// and a Matcher to parse it
				Matcher myMatcher = wordPattern.matcher(line);
				while (myMatcher.find()) {
					// get the next pattern, and convert it to lower case
					String returnVal = myMatcher.group();
					returnVal = new String(returnVal.toLowerCase());
					System.out.print(returnVal + " ");
				}
			}
//			sc.close();
		}

	}
}
