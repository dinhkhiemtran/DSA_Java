package org.khiemtran.structures.queue.model;

import org.khiemtran.structures.queue.AbstractQueue;

public class SimpleQueue<T> extends AbstractQueue<T> {
  public SimpleQueue(int capacity) {
    super(capacity);
  }

  @Override
  protected void enqueue(T data) {
    if (isFull()) {
      throw new IllegalStateException("Queue is full.");
    }
    if (super.getFront() == -1) {
      super.setFront(0);
    }
    super.setRear(getRear() + 1);
    items[super.getRear()] = data;
  }

  @Override
  protected T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty.");
    }
    T item = items[front];
    if (super.getFront() == super.getRear()) {
      super.setFront(-1);
      super.setRear(-1);
    } else {
      super.setFront(getFront() + 1);
    }
    return item;
  }

  public boolean isFull() {
    return rear == items.length - 1;
  }

  public boolean isEmpty() {
    return front == -1 && rear == -1;
  }
}
