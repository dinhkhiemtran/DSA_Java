package org.khiemtran.structures.queue.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CircularQueueTest {
  @Test
  public void enqueue() {
    CircularQueue<Integer> circularQueue = new CircularQueue<>(5);
    for (int i = 1; i <= circularQueue.getSize(); i++) {
      circularQueue.enqueue(i);
    }
    Assertions.assertEquals("1 -> 2 -> 3 -> 4 -> 5", circularQueue.display());
    IllegalStateException illegalStateException = Assertions.assertThrows(IllegalStateException.class,
        () -> circularQueue.enqueue(6));
    Assertions.assertEquals("Circular Queue is full.", illegalStateException.getMessage());
  }

  @Test
  public void dequeue() {
    CircularQueue<Integer> circularQueue = new CircularQueue<>(5);
    for (int i = 1; i <= circularQueue.getSize(); i++) {
      circularQueue.enqueue(i);
    }
    for (int i = 1; i <= 5; i++) {
      Assertions.assertEquals(i, circularQueue.dequeue());
    }
    IllegalStateException illegalStateException = Assertions.assertThrows(IllegalStateException.class, circularQueue::dequeue);
    Assertions.assertEquals("Circular Queue is empty.", illegalStateException.getMessage());
    Assertions.assertEquals("", circularQueue.display());
  }
}