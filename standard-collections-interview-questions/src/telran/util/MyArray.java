package telran.util;

import java.util.HashMap;

/**
 * All methods of the class should have complexity O[1]
 * 
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
	private final HashMap<Integer, T> array;
	private final int size;

	public MyArray(int size) {
		array = new HashMap<>();
		this.size = size;
	}

	public MyArray() {
		this(0);
	}

	/**
	 * sets all array's elements with a given value
	 * 
	 * @param value
	 */
	public void setAll(T value) {
		for (int i = 0; i < size; i++) {
			array.put(i, value);
		}
	}

	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
		final T t = (T) array.get(index);
		return t;
	}

	/**
	 * sets a given value at a given index throws IndexOutOfBoundsException in the
	 * case of wrong index
	 * 
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		array.put(index, value);
	}
}
