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
    if (super.getFront() == -1) {
      super.setFront(0);
    }
    setRear((getRear() + 1) % getSize());
    super.items[getRear()] = data;
  }

  @Override
  protected T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Circular Queue is empty.");
    }
    T data = items[getFront()];
    if (getFront() == getRear()) {
      super.setFront(-1);
      super.setRear(-1);
    } else {
      super.setFront((getFront() + 1) % getSize());
    }
    return data;
  }

  private boolean isFull() {
    return (super.getFront() == 0 && super.getRear() == super.getSize() - 1)
        || (super.getRear() == (super.getFront() - 1) % (super.getSize() - 1));
  }

  private boolean isEmpty() {
    return super.getFront() == -1;
  }

  @Override
  public String display() {
    if (isEmpty()) {
      return "";
    }
    StringBuilder stringBuilder = new StringBuilder();
    int i = super.getFront();
    while (true) {
      stringBuilder.append(items[i]);
      if (i == super.getRear()) {
        break;
      }
      stringBuilder.append(" -> ");
      i = (i + 1) % super.getSize();
    }
    return stringBuilder.toString();
  }
}
