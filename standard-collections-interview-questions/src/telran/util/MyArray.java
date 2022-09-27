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
	public Object[] array;
	public int size;
	private HashMap<Integer, T> map;// = new HashMap<>();
	private T setAllValue = null;
	private boolean setAllStatus = false;

	public MyArray(int size) {
		array = new Object[size];
		this.size = size;
	}

	/**
	 * sets all array's elements with a given value
	 * 
	 * @param value
	 */
	public void setAll(T value) {
		setAllStatus = true;
		map = new HashMap<Integer, T>();
		setAllValue = value;
	}

	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		@SuppressWarnings("unchecked")
		T res = setAllStatus ? (map.get(index) == null ? setAllValue : map.get(index)) : (T) array[index];
		return res;
	}

	/**
	 * sets a given value at a given index throws IndexOutOfBoundsException in the
	 * case of wrong index
	 * 
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (setAllStatus) {
			map.put(index, value);
		}
		array[index] = value;
	}

}
