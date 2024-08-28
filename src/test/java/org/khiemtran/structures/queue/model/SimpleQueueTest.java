package org.khiemtran.structures.queue.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleQueueTest {
  @Test
  public void enqueue() {
    SimpleQueue<Integer> integerSimpleQueue = new SimpleQueue<>(5);
    for (int i = 1; i < 6; i++) {
      integerSimpleQueue.enqueue(i);
    }
    Assertions.assertEquals("1 -> 2 -> 3 -> 4 -> 5", integerSimpleQueue.display());
    IllegalStateException illegalStateException = Assertions.assertThrows(IllegalStateException.class,
        () -> integerSimpleQueue.enqueue(6));
    Assertions.assertEquals("Queue is full.", illegalStateException.getMessage());
  }

  @Test
  public void dequeue() {
    SimpleQueue<Integer> integerSimpleQueue = new SimpleQueue<>(5);
    for (int i = 1; i <= 5; i++) {
      integerSimpleQueue.enqueue(i);
    }
    Assertions.assertEquals("1 -> 2 -> 3 -> 4 -> 5", integerSimpleQueue.display());
    for (int i = 0; i < 3; i++) {
      integerSimpleQueue.dequeue();
    }
    Assertions.assertEquals("4 -> 5", integerSimpleQueue.display());
    Assertions.assertEquals(4, integerSimpleQueue.dequeue());
    Assertions.assertEquals(5, integerSimpleQueue.dequeue());
    IllegalStateException illegalStateException = Assertions.assertThrows(IllegalStateException.class, integerSimpleQueue::dequeue);
    Assertions.assertEquals("Queue is empty.", illegalStateException.getMessage());
  }
}
