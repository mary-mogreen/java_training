/**
 * 
 */
package ch24.ex01;

import java.util.ListResourceBundle;

/**
 * @author mary-mogreen
 *
 */
public class GlobalRes extends ListResourceBundle {
	public static final String HELLO = "hello";
	public static final String GOODBYE = "goodbye";
	
	public Object[][] getContents() {
		return contents;
	}
	
	private static final Object[][] contents = {
		{ GlobalRes.HELLO, "Ciao" },
		{ GlobalRes.GOODBYE, "Ciao" },
	};
}
