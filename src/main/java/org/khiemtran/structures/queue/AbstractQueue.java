package org.khiemtran.structures.queue;

public abstract class AbstractQueue<T> {
  protected int front;
  protected int rear;
  protected int size;
  protected final T[] items;

  @SuppressWarnings("unchecked")
  public AbstractQueue(int capacity) {
    this.front = -1;
    this.rear = -1;
    this.size = capacity;
    this.items = (T[]) new Object[capacity];
  }

  public int getFront() {
    return front;
  }

  public int getRear() {
    return rear;
  }

  public int getSize() {
    return size;
  }

  public void setFront(int front) {
    this.front = front;
  }

  public void setRear(int rear) {
    this.rear = rear;
  }

  public void setSize(int size) {
    this.size = size;
  }

  protected abstract void enqueue(T data);

  protected abstract T dequeue();

  public String display() {
    if (front == -1 && rear == -1) {
      throw new IndexOutOfBoundsException("Queue is empty");
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = front; i <= rear; i++) {
      stringBuilder.append(items[i]);
      if (i != rear) {
        stringBuilder.append(" -> ");
      }
    }
    return stringBuilder.toString();
  }
}
