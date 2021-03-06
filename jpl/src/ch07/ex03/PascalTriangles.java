/**
 *
 */
package ch07.ex03;

/**
 * @author mary-mogreen
 *
 */
public class PascalTriangles {
	/**
	 * パスカルの三角形配列を返す
	 * @param depth
	 * @return
	 */
	public static int[][] createPascalTriangles(int depth) {
		int[][] pascalTriangles = new int[depth][];
		for(int i = 0; i < depth; i++) {
			pascalTriangles[i] = new int[i + 1];
			for(int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i)
					pascalTriangles[i][j] = 1;
				else
					pascalTriangles[i][j] = pascalTriangles[i - 1][j - 1] + pascalTriangles[i - 1][j];
			}
		}
		return pascalTriangles;
	}

	/**
	 * 二次元配列を表示する
	 * @param pt
	 */
	public static void showPascalTriangles(int[][] pt) {
		for (int[] p: pt) {
			for (int i: p)
				System.out.printf("%d ", i);
			System.out.printf("%n");
		}
	}

	/**
	 * パスカルの三角形を表示する
	 * @param depth
	 */
	public static void showPascalTriangles(int depth) {
		showPascalTriangles(createPascalTriangles(depth));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//showPascalTriangles(-1);
		showPascalTriangles(12);
		showPascalTriangles(20);
		showPascalTriangles(5);


	}

}
