package org.khiemtran.structures.stack;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class Stack<E> {
  private static final int DEFAULT_INIT_CAPACITY = 16;
  private E[] elements;
  private int top;
  private int size;

  @SuppressWarnings("unchecked")
  public Stack() {
    this.top = -1;
    this.size = 0;
    this.elements = (E[]) new Object[DEFAULT_INIT_CAPACITY];
  }

  public int getTop() {
    return top;
  }

  public int getSize() {
    return size;
  }

  public E getPeek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return elements[top];
  }

  public void push(E element) {
    ensureCapacity();
    elements[++top] = element;
    size++;
  }

  public void pushAll(Iterable<? extends E> src) {
    for (E e : src) {
      push(e);
    }
  }

  public E pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    E element = elements[top];
    elements[top--] = null;
    size--;
    return element;
  }

  public Collection<? super E> popAll(Collection<? super E> dst) {
    while (!isEmpty()) {
      dst.add(this.pop());
    }
    return dst;
  }

  private boolean isEmpty() {
    return size == 0;
  }

  private void ensureCapacity() {
    if (elements.length == size) {
      elements = Arrays.copyOf(elements, 2 * size + 1);
    }
  }

  public String display() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i <= top; i++) {
      stringBuilder.append(elements[i]);
      if (i != top) {
        stringBuilder.append(",");
      }
    }
    return stringBuilder.toString();
  }
}