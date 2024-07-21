package org.khiemtran.structures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class CircleQueueTest {
  private CircleQueue<Object> circleQueue;

  @Test
  public void checkEmpty() {
    circleQueue = new CircleQueue<>(3);
    Assertions.assertThrows(NoSuchElementException.class, () -> circleQueue.deQueue());
  }

  @Test
  public void enQueue() {
    circleQueue = new CircleQueue<>(3);
    circleQueue.enQueue(1);
    Assertions.assertEquals(0, circleQueue.getFront());
    Assertions.assertEquals(0, circleQueue.getRear());
    Assertions.assertEquals(1, circleQueue.getFrontElement());
    Assertions.assertEquals(1, circleQueue.getRearElement());
    Assertions.assertEquals(3, circleQueue.getSize());
    circleQueue.enQueue(2);
    circleQueue.enQueue(3);
    Assertions.assertEquals(0, circleQueue.getFront());
    Assertions.assertEquals(2, circleQueue.getRear());
    Assertions.assertEquals(3, circleQueue.getRearElement());
    Assertions.assertEquals(3, circleQueue.getSize());
    circleQueue.display();
    IndexOutOfBoundsException indexOutOfBoundsException
        = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> circleQueue.enQueue(4));
    Assertions.assertEquals("Queue is full.", indexOutOfBoundsException.getMessage());
  }

  @Test
  public void deQueue() {
    circleQueue = new CircleQueue<>(5);
    circleQueue.enQueue(1);
    circleQueue.enQueue(2);
    circleQueue.enQueue(3);
    circleQueue.enQueue(4);
    circleQueue.enQueue(5);
    Assertions.assertEquals(5, circleQueue.getSize());
    Assertions.assertEquals(1, circleQueue.deQueue());
    Assertions.assertEquals(1, circleQueue.getFront());
    circleQueue.enQueue(6);
    Assertions.assertEquals(6, circleQueue.getRearElement());
    Assertions.assertEquals(2, circleQueue.deQueue());
    Assertions.assertEquals(3, circleQueue.deQueue());
    circleQueue.enQueue(7);
    circleQueue.enQueue(8);
    Assertions.assertEquals(8, circleQueue.getRearElement());
    circleQueue.deQueue();
    circleQueue.deQueue();
    circleQueue.deQueue();
    circleQueue.deQueue();
    circleQueue.deQueue();
    circleQueue.display();
  }
}