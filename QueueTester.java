package queue;

import static org.junit.Assert.*;
import org.junit.Test;


public class QueueTester {
	@Test
	public void test_default_ctor() {
		Queue<String> names 		= new Queue<>();
		
		assertEquals(0, names.get_size());
		assertEquals(10, names.get_capacity());
		assertEquals(null, names.dequeue());
		assertEquals(null, names.dequeue());
		
		assertEquals(null, names.dequeue());
		assertEquals(null, names.dequeue());
		assertEquals(null, names.dequeue());
		assertEquals(null, names.dequeue());
		
		assertEquals(null, names.get_front_element());
		assertEquals(null, names.get_rear_element());
	}
	
	@Test
	public void test_parameterize_ctor() {
		Queue<String> names 		= new Queue<>(5);
		
		assertEquals(0, names.get_size());
		assertEquals(5, names.get_capacity());
		assertEquals(true, names.is_empty());
		assertEquals(false, names.is_full());
		
		assertEquals(null, names.dequeue());
		assertEquals(null, names.dequeue());
		assertEquals(null, names.dequeue());
		assertEquals(null, names.dequeue());
		
		assertEquals(null, names.dequeue());
		assertEquals(null, names.dequeue());
		
		assertEquals(null, names.get_front_element());
		assertEquals(null, names.get_rear_element());
	}
	
	@Test
	public void first_enqueue() {
		Queue<String> names 		= new Queue<>(5);
		names.enqueue("Sam");
		names.print();
		
		assertEquals(false, names.is_empty());
		assertEquals(false, names.is_full());
		assertEquals(1, names.get_size());
		
		assertEquals("Sam", names.get_front_element());
		assertEquals("Sam", names.get_rear_element());
		assertEquals("Sam", names.dequeue());
		assertEquals(null, names.dequeue());
	}
	
	@Test
	public void multiple_enqueue() {
		Queue<String> names 		= new Queue<>(5);
		names.enqueue("Sam");
		names.enqueue("Dmitri");
		names.enqueue("Mark");
		names.print();
		
		
		assertEquals(3, names.get_size());
		assertEquals("Sam", names.get_front_element());
		assertEquals("Mark", names.get_rear_element());
		
		names.dequeue();
		assertEquals("Dmitri", names.get_front_element());
		
		names.enqueue("Stark");
		assertEquals("Stark", names.get_rear_element());
	}
	
	@Test
	public void front_equal_rear() {
		Queue<String> names 		= new Queue<>(5);
		names.enqueue("Sam");		//rear_index becomes 0
		names.enqueue("Dmitri");	//rear_index becomes 1
		names.enqueue("Mark");		//rear_index becomes 2
		
		names.dequeue();			//front_index becomes 1
		names.dequeue();			//front_index becomes 2
		
		assertEquals(1, names.get_size());
		assertEquals("Mark", names.dequeue());
		assertEquals(0, names.get_size());
	}
	
	@Test
	public void dequeue() {
		Queue<String> names 		= new Queue<>(5);
		names.enqueue("Sam");
		names.enqueue("Dmitri");
		names.enqueue("Mark");
		
		assertEquals(3, names.get_size());
		System.out.println("element dequed: "+names.dequeue());
		names.print();
		assertEquals(2, names.get_size());
		System.out.println("element dequed: "+names.dequeue());
		names.print();
		assertEquals(1, names.get_size());
		
	}
	
	@Test
	public void full_queue_dequeue_enqueue() {
		
		Queue<String> names 		= new Queue<>(5);
		names.enqueue("Sam");
		names.enqueue("Dmitri");
		names.enqueue("Mark");
		names.enqueue("John");
		names.enqueue("Stark");
		
		assertEquals(true, names.is_full());
		assertEquals(false, names.enqueue("Akshat"));
		
		names.print();
		
		names.dequeue();
		names.dequeue();
		names.dequeue();
		names.dequeue();
		names.dequeue();
		
		names.print();
		
		assertEquals(null, names.dequeue());
	}
}
