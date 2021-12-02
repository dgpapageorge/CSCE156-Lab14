package unl.cse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A basic JSON validator. This validator only checks that the JSON file is
 * well-balanced: that all opening brackets have a corresponding closing bracket
 * and that they follow legal nesting rules.
 * 
 */
public class JsonValidator {

	public static boolean isValidJSON(String jsonString) {
		String[] jstring = jsonString.split("");
		Stack<String> bracket = new Stack<>();
		Stack<String> curly = new Stack<>();
		for (int i = 0; i < jstring.length;i++)
		{
			if (jstring[i].equals("{"))
			{
				curly.push(jstring[i]);
			}
			else if (jstring[i].equals("}"))
			{
				if (curly.isEmpty())
				{
					return false;
				}
				else
				{
					curly.pop();
				}
			}
			else if (jstring[i].equals("["))
			{
				bracket.push(jstring[i]);
			}
			else if (jstring[i].equals("]"))
			{
				if (bracket.isEmpty())
				{
					return false;
				}
				else
				{
					bracket.pop();
				}
			}
		}
		if (curly.isEmpty() && bracket.isEmpty())
			return true;
		return false;
	}

	public static String getFileContents(String fileName) {
		StringBuilder sb = new StringBuilder();
		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		while (s.hasNextLine()) {
			sb.append(s.nextLine());
		}
		s.close();
		return sb.toString();
	}

	public static void main(String[] args) {
		String jsonFileName = "data/data001.json";
		String jsonString = getFileContents(jsonFileName);
		System.out.println(isValidJSON(jsonString) ? "Valid" : "Invalid");
	}
}
