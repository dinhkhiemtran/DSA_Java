package org.khiemtran.structures.queue.model;

import org.khiemtran.structures.queue.AbstractQueue;

public class CircularQueue<T> extends AbstractQueue<T> {
  public CircularQueue(int capacity) {
    super(capacity);
  }

  @Override
  protected void enqueue(T data) {
    if (isFull()) {
      throw new IllegalStateException("Circular Queue is full.");
    }
    if (front == -1) {
      front = 0;
    }
    rear = (rear + 1) % size;
    items[rear] = data;
  }

  @Override
  protected T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Circular Queue is empty.");
    }
    T data = items[front];
    if (front == rear) {
      front = -1;
      rear = -1;
    } else {
      front = (front + 1) % size;
    }
    return data;
  }

  private boolean isFull() {
    return (front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1));
  }

  private boolean isEmpty() {
    return front == -1;
  }

  @Override
  public String display() {
    if (isEmpty()) {
      return "Queue is empty";
    }
    StringBuilder stringBuilder = new StringBuilder();
    int i = front;
    while (true) {
      stringBuilder.append(items[i]);
      if (i == rear) {
        break;
      }
      stringBuilder.append(" -> ");
      i = (i + 1) % size;
    }
    return stringBuilder.toString();
  }
}
