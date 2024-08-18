package org.khiemtran.structures.linked_list.model;

public class Node<T> {
  private Node<T> next;
  private T data;

  public Node(T data) {
    this.next = null;
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public Node<T> getNext() {
    return this.next;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }
}
