/**
 *
 */
package ch01.ex16;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author mary-mogreen
 *
 */
public class MyUtilities {
	public double [] getDataSet(String setName)
		throws BadDataSetException
	{
		String file = setName + ".dset";
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			return readDataSet(in);
		} catch (IOException e) {
			throw new BadDataSetException(file, e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				; // 無視：データの読み込みは成功しているか、あるいは、
				  // BadDataSetExceptionをスローしようとしている
			}
		}
	}

	public double [] readDataSet(FileInputStream in) {
		return new double [100];
	}
}
