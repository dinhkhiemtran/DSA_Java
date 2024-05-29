package org.khiemtran.structures.linked_list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
  public static class Node<T> {
    private final T data;
    private Node<T> next;

    public Node(T data) {
      this.next = null;
      this.data = data;
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

  public boolean add(T data) {
    if (head == null || size == 0) {
      head = new Node<>(data);
    } else {
      Node<T> current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(new Node<>(data));
    }
    this.size++;
    return true;
  }

  public void addLast(T data) {
    if (head == null || size == 0) {
      head = new Node<>(data);
    } else {
      Node<T> current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(new Node<>(data));
    }
    this.size++;
  }

  public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);
    if (head != null || size != 0) {
      newNode.setNext(head);
    }
    head = newNode;
    this.size++;
  }

  public void add(int index, T data) {
    Node<T> newNode = new Node<>(data);
    if (index <= 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid position.");
    }
    Node<T> current = head;
    for (int i = 1; i < index; i++) {
      current = current.getNext();
    }
    newNode.setNext(current.getNext());
    current.setNext(newNode);
    this.size++;
  }

  public boolean remove() {
    if (head == null || size == 0) {
      return false;
    }
    if (size == 1) {
      head = null;
    } else {
      Node<T> current = head;
      while (current.getNext().getNext() != null) {
        current = current.getNext();
      }
      current.setNext(null);
    }
    this.size--;
    return true;
  }

  public T removeLast() {
    T data;
    if (head == null || size == 0)
      throw new NoSuchElementException("Linked list has no elements.");
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

  public T removeFirst() {
    T data;
    if (head == null || size == 0) {
      throw new NoSuchElementException("Linked list have no elements");
    }
    if (size == 1) {
      data = head.getData();
      head = null;
    } else {
      data = head.getData();
      head = head.getNext();
    }
    this.size--;
    return data;
  }

  public T remove(int index) {
    Node<T> current = head;
    T data;
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid position");
    }
    for (int i = 1; i < index; i++) {
      current = current.getNext();
    }
    data = current.getNext().getData();
    current.setNext(current.getNext().getNext());
    this.size--;
    return data;
  }

  public void display() {
    if (head == null)
      throw new NoSuchElementException("Linked list has no elements.");
    Node<T> current = head;
    while (current != null) {
      System.out.println(current.getData());
      current = current.getNext();
    }
  }
}
