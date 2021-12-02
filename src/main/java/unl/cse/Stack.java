package unl.cse;

import java.util.LinkedList;

public class Stack<T> {

	private final LinkedList<T> list = new LinkedList<T>();
	
	public T pop() {
		return list.removeFirst();
	}
	
	public void push(T item) {
		list.addFirst(item);
	}

	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		return false;
	}
	
}
