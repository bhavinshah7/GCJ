package gcj16.round1A;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;

public class TheLastWord {

	public String lastWord(String input) {
		StringBuilder res = new StringBuilder();

		char ch1 = input.charAt(0);
		res.append(ch1);
		char ch2;
		for (int i = 1; i < input.length(); i++) {
			ch2 = input.charAt(i);
			if (ch2 >= ch1) {
				res.insert(0, ch2);
				ch1 = ch2;
			} else {
				res.append(ch2);
			}
		}

		return res.toString();
	}

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader("resources//A-large-practice.in"));
				Formatter fmt = new Formatter(new FileOutputStream("resources//A-large-practice.out"));) {

			TheLastWord tlw = new TheLastWord();
			int T = Integer.parseInt(br.readLine());
			String input = null;
			for (int i = 1; i <= T; i++) {
				input = br.readLine();
				String result = tlw.lastWord(input.trim());
				fmt.format("Case #%d: %s%n", i, result);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
