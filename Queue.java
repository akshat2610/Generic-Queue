package queue;

import java.util.ArrayList;

public class Queue<T>{
	private ArrayList<T> 		queue;
	private int 				front_index;
	private int 				rear_index;
	private int 				capacity;
	private final static int 	default_capacity = 10;	

	public Queue() {
		capacity				= default_capacity;
		queue					= new ArrayList<>(capacity);
		front_index				= 0;
		rear_index				= -1;
	}

	public Queue(int initial_capacity) {
		capacity				= initial_capacity;
		queue					= new ArrayList<>(capacity);
		front_index				= 0;
		rear_index				= -1;
	}

	public int get_size() {
		return rear_index - front_index + 1;
	}

	public int get_capacity() {
		return capacity;
	}
	public boolean is_full() {
		return get_size() == capacity;
	}
	public boolean is_empty() {
		return get_size() == 0;
	}

	public T get_front_element() {
		if (get_size() < 1)
			return null;

		return queue.get(front_index);
	}

	public T get_rear_element() {
		if (get_size() < 1)
			return null;

		return queue.get(rear_index);
	}

	/**
	 * Adds data to the end of the queue and returns true if data successfully appended.
	 * @param data
	 * @return false if queue is full
	 */
	public boolean enqueue(T data) {
		if (is_full())
			return false;

		//rear index must take values only in the range -1 to capacity-1. 
		if (rear_index < capacity - 1)
			rear_index++;
		else
			rear_index 			= 0;		

		queue.add(rear_index, data);
		return true;
	}

	/**
	 * removes the first element of the queue and returns it. If queue is empty, returns null
	 * @return first element in the queue or null (if queue is empty)
	 */
	public T dequeue() {
		if (is_empty())
			return null;
			
		//if there is only one element left in the queue
		if (front_index == rear_index) {
			int temp			= rear_index;		//save the position of the last element. 
			front_index			= 0;				//reset front_index
			rear_index			= -1;				//reset rear_index
			return queue.get(temp);					//return the last element
		}
		
		//else if there are more than 1 elements in the queue
		else 
			front_index++;

		return queue.get(front_index-1);
	}

	public void print() {
		System.out.println("**********");

		for(int i = front_index; i <= rear_index; i++)
			System.out.println(queue.get(i));

		System.out.println("__________");
	}
}
