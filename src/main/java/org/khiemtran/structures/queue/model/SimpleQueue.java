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
    if (front == -1) {
      front = 0;
    }
    items[++rear] = data;
  }

  @Override
  protected T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty.");
    }
    T item = items[front];
    if (front == rear) {
      front = -1;
      rear = -1;
    } else {
      front++;
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
