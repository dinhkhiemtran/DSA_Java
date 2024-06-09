package org.khiemtran.structures.queue;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
  private int front;
  private int rear;
  private final int size;
  private final T[] array;

  @SuppressWarnings("unchecked")
  public SimpleQueue(int capacity) {
    this.front = -1;
    this.rear = -1;
    this.size = capacity;
    this.array = (T[]) new Object[size];
  }

  public int getFront() {
    return front;
  }

  public int getRear() {
    return rear;
  }

  public T getFrontElement() {
    if (front == -1) {
      throw new NoSuchElementException("Queue is empty.");
    }
    return array[front];
  }

  public T getRearElement() {
    if (rear == -1) {
      throw new NoSuchElementException("Queue is empty.");
    }
    return array[rear];
  }

  public int getSize() {
    return size;
  }

  public void enqueue(T element) {
    if (isFull()) {
      throw new ArrayIndexOutOfBoundsException("Queue is full.");
    } else {
      if (front == -1) {
        front = 0;
      }
      array[++rear] = element;
    }
  }

  private boolean isFull() {
    return rear == size - 1;
  }

  public T dequeue() {
    T element;
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty.");
    }
    element = array[front];
    if (front == rear) {
      front = -1;
      rear = -1;
    } else {
      front++;
    }
    return element;
  }

  private boolean isEmpty() {
    return front == -1;
  }

  public void display() {
    for (int i = front; i <= rear; i++) {
      System.out.println(array[i]);
    }
  }
}
