package org.khiemtran.structures.linked_list.model;

public class Node<T> {
  private Node<T> next;
  private Node<T> previous;
  private T data;

  public Node(T data) {
    this.next = null;
    this.previous = null;
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public Node<T> getNext() {
    return this.next;
  }

  public Node<T> getPrevious() {
    return previous;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  public void setPrevious(Node<T> previous) {
    this.previous = previous;
  }
}
