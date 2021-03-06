/**
 *
 */
package ch03.ex12;

import ch03.ex11.SortMetrics;

/**
 * @author mary-mogreen
 *
 */
public abstract class SortHarness {
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	private static boolean isLock = false;

	public final SortMetrics sort(Object[] data) {
		if (!isLock) {
			isLock = true;
			values = data;
			curMetrics.init();
			doSort();
			isLock = false;
		}
		return getMetrics();
	}

	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}

	protected final int getDataLength() {
		return values.length;
	}

	protected final Object probe(int i) {
		curMetrics.probeCnt++;
		return values[i];
	}

	protected final int compare(int i, int j) {
		curMetrics.compareCnt++;
		return doCompare(values[i], values[j]);
	}

	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

	protected abstract void doSort();
	protected abstract int doCompare(Object value1, Object value2);

}
