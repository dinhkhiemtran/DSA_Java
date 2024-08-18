package org.khiemtran.structures.linked_list.model;

public class SinglyLinkedList<T> {
  private Node<T> head;
  private int size;

  public SinglyLinkedList() {
    this.head = null;
    this.size = 0;
  }

  public Node<T> getHead() {
    return head;
  }

  public int getSize() {
    return size;
  }

  public void setHead(Node<T> head) {
    this.head = head;
  }

  public void setSize(int size) {
    this.size = size;
  }
}