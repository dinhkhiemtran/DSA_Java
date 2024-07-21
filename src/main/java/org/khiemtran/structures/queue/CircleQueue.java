package org.khiemtran.structures.queue;

import java.util.NoSuchElementException;

public class CircleQueue<T> {
  private int front;
  private int rear;
  private final int size;
  private final T[] array;

  @SuppressWarnings("unchecked")
  public CircleQueue(int capacity) {
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

  public int getSize() {
    return size;
  }

  public T getFrontElement() {
    return array[front];
  }

  public T getRearElement() {
    return array[rear];
  }

  public void enQueue(T data) {
    if (isFull()) {
      throw new IndexOutOfBoundsException("Queue is full.");
    }
    if (front == -1) {
      this.front = 0;
    }
    rear = (rear + 1) % size;
    array[rear] = data;
  }

  public T deQueue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is full.");
    }
    T data = array[front];
    if (front == rear) {
      this.front = -1;
      this.rear = -1;
    } else {
      front = (front + 1) % size;
    }
    return data;
  }

  private boolean isEmpty() {
    return front == -1;
  }

  private boolean isFull() {
    return (front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1));
  }

  public void display() {
    if (isEmpty()) {
      System.out.println("Empty Queue");
    } else {
      System.out.println(array[rear]);
      for (int i = front; i != rear; i = (i + 1) % size) {
        System.out.println(array[i]);
      }
    }
  }
}
