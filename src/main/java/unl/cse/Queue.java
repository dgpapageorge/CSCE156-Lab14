package unl.cse;

import java.util.LinkedList;

public class Queue<T> {

	private final LinkedList<T> list = new LinkedList<T>();
	
	public T dequeue() {
		return list.removeFirst();
	}
	
	public void enqueue(T item) {
		list.addLast(item);
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
