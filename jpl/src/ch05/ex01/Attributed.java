/**
 *
 */
package ch05.ex01;

/**
 * @author mary-mogreen
 *
 */
public interface Attributed {
	void add(Attr newAttr);
	Attr find(String attrName);
	Attr remove(String attrName);
	java.util.Iterator<Attr> attrs();

	class Attr {

	}

}
