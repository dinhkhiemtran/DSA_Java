package org.khiemtran.structures.linked_list;

public class CircularSinglyLinkedList<T> {
  public static class Node<T> {
    private Node<T> next;
    private final T data;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }

    public T getData() {
      return data;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }
  }

  private Node<T> head;
  private int size;

  public Node<T> getHead() {
    return head;
  }

  public int getSize() {
    return size;
  }

  public void add(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      head = newNode;
    } else {
      Node<T> current = head;
      while (current.getNext() != head) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }
    newNode.setNext(head);
    this.size++;
  }

  public T remove() {
    T data;
    if (head == null) {
      throw new IllegalArgumentException("Linked List is empty");
    }
    if (size == 1) {
      data = head.getData();
      head = null;
    } else {
      Node<T> current = head;
      while (current.getNext() != head) {
        current = current.getNext();
      }
      data = current.getNext().getData();
      current.setNext(head.getNext());
      head = current.getNext();
    }
    this.size--;
    return data;
  }

  public void insert(T data, int index) {
    Node<T> newNode = new Node<>(data);
    Node<T> current = head;
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid position.");
    }
    if (index == 0) {
      while (current.getNext() != head) {
        current = current.getNext();
      }
      newNode.setNext(head);
      head = newNode;
      current.setNext(head);
    } else {
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
    if (head == null || size == 0) {
      throw new IllegalArgumentException("Invalid position.");
    }
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid position");
    }
    if (index == 0) {
      data = head.getData();
      if (size == 1) {
        head = null;
      } else {
        while (current.getNext() != head) {
          current = current.getNext();
        }
        current.setNext(head.getNext());
        head = head.getNext();
      }
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
    do {
      System.out.println(current.getData());
      current = current.getNext();
    } while (current != head);
  }
}
