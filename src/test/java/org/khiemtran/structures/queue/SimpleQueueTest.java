package org.khiemtran.structures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class SimpleQueueTest {
  @Test
  public void enqueue() {
    SimpleQueue<Object> queue = new SimpleQueue<>(3);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    Assertions.assertEquals(3, queue.getSize());
    Assertions.assertEquals(0, queue.getFront());
    Assertions.assertEquals(2, queue.getRear());
    Assertions.assertEquals(1, queue.getFrontElement());
    Assertions.assertEquals(3, queue.getRearElement());
    ArrayIndexOutOfBoundsException exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.enqueue(4));
    Assertions.assertEquals("Queue is full.", exception.getMessage());
  }

  @Test
  public void dequeue() {
    SimpleQueue<Object> queue = new SimpleQueue<>(3);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    Assertions.assertEquals(1, queue.dequeue());
    Assertions.assertEquals(2, queue.getFrontElement());
    Assertions.assertEquals(1, queue.getFront());
    Assertions.assertEquals(3, queue.getRearElement());
    Assertions.assertEquals(2, queue.dequeue());
    Assertions.assertEquals(3, queue.dequeue());
    Assertions.assertEquals(-1, queue.getRear());
    Assertions.assertEquals(-1, queue.getFront());
    NoSuchElementException noSuchElementException = Assertions.assertThrows(NoSuchElementException.class, queue::dequeue);
    Assertions.assertEquals("Queue is empty.", noSuchElementException.getMessage());
    NoSuchElementException noSuchElementExceptionFront = Assertions.assertThrows(NoSuchElementException.class, queue::getFrontElement);
    Assertions.assertEquals("Queue is empty.", noSuchElementExceptionFront.getMessage());
    NoSuchElementException noSuchElementExceptionRear = Assertions.assertThrows(NoSuchElementException.class, queue::getRearElement);
    Assertions.assertEquals("Queue is empty.", noSuchElementExceptionRear.getMessage());
  }

  @Test
  public void display() {
    SimpleQueue<Object> queue = new SimpleQueue<>(5);
    queue.enqueue(1);
    queue.enqueue("test");
    queue.enqueue('t');
    List<Integer> numbers = Arrays.asList(1, 2, 3);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "one");
    map.put(2, "two");
    map.put(3, "three");
    queue.enqueue(numbers);
    queue.enqueue(map);
    Assertions.assertEquals(1, queue.dequeue());
    Assertions.assertEquals("test", queue.dequeue());
    Assertions.assertEquals('t', queue.dequeue());
    queue.display();
  }
}