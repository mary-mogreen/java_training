/**
 * 
 */
package ch22.ex01;

/**
 * @author mary-mogreen
 *
 */
public class FloatFormat {

	
	public static void printFloats(float[] floats, int cols) {
		if (cols < 1)
			cols = 1;
		
		int w = 80 / cols;
		
		for (int i = 0; i < floats.length; i++) {
			String n = (i + 1) % cols == 0 ? "%n": "";
			System.out.printf("%1$ " + w + ".4g" + n, floats[i]);
		}
	}
	
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("testを実行");
			test();
		} else {
			float[] floats = new float[args.length - 1];
			for (int i = 0; i < args.length - 1; i++) {
				floats[i] = Float.parseFloat(args[i]);
			}
			int cols = Integer.parseInt(args[args.length - 1]);
			FloatFormat.printFloats(floats, cols);
		}
	}
	
	public static void test() {
		FloatFormat.printFloats(new float[] {
				1.234f, 34.55555f, 543f, -87654.453f, 0.0000432f, 543.2507f, -22.222222222455f, 8.24252343634f, -423654848.54f 
		}, 2);
	}
}
