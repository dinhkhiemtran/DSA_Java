package org.khiemtran.structures.linked_list.model;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
  public static class Node<T> {
    private Node<T> next;
    private Node<T> previous;
    private final T data;

    public Node(T data) {
      this.data = data;
      this.next = null;
      this.previous = null;
    }

    public Node<T> getNext() {
      return next;
    }

    public Node<T> getPrevious() {
      return previous;
    }

    public T getData() {
      return data;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }

    public void setPrevious(Node<T> previous) {
      this.previous = previous;
    }
  }

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public Node<T> getHead() {
    return head;
  }

  public Node<T> getTail() {
    return tail;
  }

  public int getSize() {
    return size;
  }

  public boolean add(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null || size == 0) {
      head = newNode;
    } else {
      tail.setNext(newNode);
      newNode.setPrevious(tail);
    }
    tail = newNode;
    this.size++;
    return true;
  }

  public void addLast(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null || size == 0) {
      head = newNode;
    } else {
      tail.setNext(newNode);
      newNode.setPrevious(tail);
    }
    tail = newNode;
    this.size++;
  }

  public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null || size == 0) {
      tail = newNode;
    } else {
      newNode.setNext(head);
      head.setPrevious(newNode);
    }
    head = newNode;
    this.size++;
  }

  public void add(int index, T data) {
    if (index <= 0 || index >= size) {
      throw new IllegalArgumentException("Invalid position");
    }
    Node<T> newNode = new Node<>(data);
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
    if (head.getNext() == null || size == 1) {
      head = null;
      tail = null;
    } else {
      tail = tail.getPrevious();
      tail.setNext(null);
    }
    this.size--;
    return true;
  }

  public T removeLast() {
    T data;
    if (head == null || size == 0) {
      throw new NoSuchElementException("Linked list has no elements.");
    }
    if (head.getNext() == null || size == 1) {
      data = head.getData();
      head = null;
      tail = null;
    } else {
      data = tail.getData();
      tail = tail.getPrevious();
      tail.setNext(null);
    }
    this.size--;
    return data;
  }

  public T removeFirst() {
    T data;
    if (head == null || size == 0) {
      throw new NoSuchElementException("Linked list has no elements.");
    }
    if (head.getNext() == null || size == 1) {
      data = head.getData();
      head = null;
      tail = null;
    } else {
      data = head.getData();
      head = head.getNext();
      head.setPrevious(null);
    }
    this.size--;
    return data;
  }

  public T remove(int index) {
    T data;
    Node<T> current = head;
    if (index <= 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid position");
    }
    for (int i = 1; i < index; i++) {
      current = current.getNext();
    }
    data = current.getNext().getData();
    current.getNext().getNext().setPrevious(current);
    current.setNext(current.getNext().getNext());
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
