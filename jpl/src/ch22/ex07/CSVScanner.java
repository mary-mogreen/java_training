/**
 * 
 */
package ch22.ex07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * @author mary-mogreen
 *
 */
public class CSVScanner {

	
	/**
	 * 
	 * @param source
	 * @param n 期待されるデータのセル数
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> readCSVTable(Readable source, int n) throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		String exp = "^(.*)";
		for (int i = 0; i < n - 1; i++)
			exp += ",(.*)";
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cells = new String[n];
				MatchResult match = in.match();
				for (int i = 0; i < cells.length; i++)
					cells[i] = match.group(i + 1);
				vals.add(cells);
				in.nextLine(); // 改行を読み飛ばし
			} else {
				throw new IOException("input format error");
			}
		}
		
		IOException ex = in.ioException();
		if (ex != null)
			throw ex;
		
		return vals;
	}
	
	public static void main(String[] args) {
		String testpath = "/Users/katouyuuya/git/java_training2015/jpl/src/ch22/ex07/test.csv";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(testpath));
		
			List<String[]> list = CSVScanner.readCSVTable(in, 4);
			for (String[] values: list) {
				for (int i = 0; i < values.length; i++)
					System.out.print(values[i] + "\t");
				System.out.println();
			}
		} catch (IOException e) {
			System.err.println("");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch(IOException e) {
					System.err.println("finally");
				}
			}
		}
	}
}
