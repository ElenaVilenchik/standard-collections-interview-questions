package telran.util;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackInt<T> {
	private LinkedList<Node> list = new LinkedList<>();

	class Node {
		int value;
		int max;

		public Node(int value, int max) {
			this.value = value;
			this.max = max;
		}
	}

	public void push(int number) throws Exception {
		try {
			int maxNumber = list.isEmpty() ? number : Math.max(list.peek().max, number);
			list.addFirst(new Node(number, maxNumber));
		} catch (NumberFormatException e) {
			throw new Exception("item should be a number");
		}
	}

	public int pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return list.removeFirst().value;
	}

	public Node peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return list.getFirst();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int getMaxNumber() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return list.peek().max;
	}
}
