package org.khiemtran.structures.linked_list;

public class SinglyLinkedList<T> {
  public static class Node<T> {
    private T data;
    private Node<T> next;

    public Node() {
      this.next = null;
      this.data = null;
    }

    public T getData() {
      return data;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setData(T data) {
      this.data = data;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }
  }

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

  public void add(T data) {
    Node<T> newNode = new Node<>();
    newNode.setData(data);
    if (getHead() == null) {
      this.head = newNode;
      this.head.setNext(null);
    } else {
      Node<T> current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }
    this.size++;
  }

  public T remove() {
    T data;
    if (head == null || size == 0) {
      throw new IllegalArgumentException("Linked list is empty");
    }
    if (size == 1 && head.getNext() == null) {
      data = head.getData();
      head = null;
    } else {
      Node<T> current = head;
      while (current.getNext().getNext() != null) {
        current = current.getNext();
      }
      data = current.getNext().getData();
      current.setNext(null);
    }
    this.size--;
    return data;
  }

  public void insert(T data, int index) {
    Node<T> newNode = new Node<>();
    newNode.setData(data);
    if (index < 0) {
      throw new IllegalArgumentException("Invalid position.");
    }
    if (index == 0) {
      newNode.setNext(head);
      head = newNode;
    } else {
      Node<T> current = head;
      for (int i = 1; i < index; i++) {
        current = current.getNext();
      }
      newNode.setNext(current.getNext());
      current.setNext(newNode);
    }
    this.size++;
  }

  public T remove(int index) {
    Node<T> current = head;
    T data;
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Invalid position");
    }
    if (index == 0) {
      data = current.getData();
      head = current.getNext();
    } else {
      for (int i = 1; i < index; i++) {
        current = current.getNext();
      }
      data = current.getNext().getData();
      current.setNext(current.getNext().getNext());
    }
    this.size--;
    return data;
  }

  public void display() {
    Node<T> current = head;
    while (current != null) {
      System.out.println(current.getData());
      current = current.getNext();
    }
  }
}
