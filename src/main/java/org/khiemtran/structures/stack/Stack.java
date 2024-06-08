package org.khiemtran.structures.stack;

import java.util.NoSuchElementException;

public class Stack<T> {
  private final T[] array;
  private int top;
  private final int size;

  @SuppressWarnings("unchecked")
  public Stack(int capacity) {
    this.top = -1;
    this.size = capacity;
    this.array = (T[]) new Object[size];
  }

  public int getTop() {
    return top;
  }

  public int getSize() {
    return size;
  }

  public T getPeek() {
    if (top < 0)
      throw new NoSuchElementException("Stack Underflow.");
    return array[top];
  }

  public void push(T element) {
    if (isFull())
      throw new ArrayIndexOutOfBoundsException("Stack Overflow.");
    array[++top] = element;
  }

  private boolean isFull() {
    return top == size - 1;
  }

  public T pop() {
    T element;
    if (isEmpty())
      throw new NoSuchElementException("Stack Underflow.");
    element = array[top];
    top--;
    return element;
  }

  private boolean isEmpty() {
    return top == -1;
  }

  public void display() {
    for (int i = top; i > -1; i--) {
      System.out.println(array[i]);
    }
  }
}


