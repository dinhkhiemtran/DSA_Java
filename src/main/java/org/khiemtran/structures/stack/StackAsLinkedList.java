package org.khiemtran.structures.stack;

import java.util.NoSuchElementException;

public class StackAsLinkedList<T> {
  public static class StackNode<T> {
    private StackNode<T> previous;
    private final T data;

    public StackNode(T data) {
      this.previous = null;
      this.data = data;
    }

    public StackNode<T> getPrevious() {
      return previous;
    }

    public T getData() {
      return data;
    }

    public void setPrevious(StackNode<T> previous) {
      this.previous = previous;
    }
  }

  private StackNode<T> top;
  private int size;

  public StackAsLinkedList() {
    this.top = null;
    this.size = 0;
  }

  public StackNode<T> getPeek() {
    return top;
  }

  public int getSize() {
    return size;
  }

  public void push(T data) {
    StackNode<T> newNode = new StackNode<>(data);
    if (top != null && size != 0) {
      newNode.setPrevious(top);
    }
    top = newNode;
    this.size++;
  }

  public T pop() {
    T elememnt;
    if (isEmpty()) {
      throw new NoSuchElementException("Stack Underflow.");
    } else {
      elememnt = top.getData();
      top = top.getPrevious();
    }
    this.size--;
    return elememnt;
  }

  private boolean isEmpty() {
    return size == 0 || top == null;
  }

  public void display() {
    StackNode<T> current = top;
    while (current != null) {
      System.out.println(current.getData());
      current = current.getPrevious();
    }
  }
}
