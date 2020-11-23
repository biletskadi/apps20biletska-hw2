package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    private  Queue queue;
    @Before
    public void setUp() {
        queue = new Queue();
        queue.enqueue("red");
        queue.enqueue("blue");
        queue.enqueue(5);
        queue.enqueue(7.0);
    }

    @Test
    public void testPeek() {
        assertEquals(queue.peek(), "red");
    }

    @Test
    public void testDequeue() {
        assertEquals(queue.dequeue(), "red");
    }

    @Test
    public void testDequeue2() {
        queue.dequeue();
        queue.dequeue();
        assertEquals(queue.dequeue(), 5);
    }
}
