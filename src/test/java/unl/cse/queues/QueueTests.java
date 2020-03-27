package unl.cse.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueTests {

	Queue<String> testQueue;

	@BeforeEach
	void stackSetup() {
		testQueue = new Queue<>();
	}

	@Test
	void queueTest() {
		// isEmpty - returning true
		assertTrue(testQueue.isEmpty());

		// Push
		testQueue.enqueue("Test");
		assertEquals(1, testQueue.size());

		testQueue.enqueue("CSCE");
		assertEquals(2, testQueue.size());

		testQueue.enqueue("156");
		assertEquals(3, testQueue.size());

		testQueue.enqueue("156");
		assertEquals(4, testQueue.size());

		// isEmpty - returning false
		assertFalse(testQueue.isEmpty());

		// Dequeue
		assertEquals("Test", testQueue.dequeue());
		assertEquals("CSCE", testQueue.dequeue());
		assertEquals("156", testQueue.dequeue());
		assertEquals("156", testQueue.dequeue());

		try {
			// Attempt to dequeue from an empty queue
			// This permits returning null or throwing an exception
			assertNull(testQueue.dequeue());
		} catch (Exception ignored) {
		}

		// isEmpty - returning true
		assertTrue(testQueue.isEmpty());
	}
}
