package org.khiemtran.structures.linked_list.model;

import java.util.NoSuchElementException;

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

  public boolean add(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null || size == 0) {
      head = newNode;
      head.setNext(head);
    } else {
      Node<T> current = head;
      while (current.getNext() != head) {
        current = current.getNext();
      }
      current.setNext(newNode);
      current = newNode;
      current.setNext(head);
    }
    this.size++;
    return true;
  }

  public void addLast(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null || size == 0) {
      head = newNode;
      head.setNext(head);
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

  public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);
    Node<T> current = head;
    if (head == null || size == 0) {
      head = newNode;
      head.setNext(head);
    } else {
      while (current.getNext() != head) {
        current = current.getNext();
      }
      newNode.setNext(head);
      head = newNode;
      current.setNext(newNode);
    }
    this.size++;
  }

  public void add(int index, T data) {
    Node<T> newNode = new Node<>(data);
    Node<T> current = head;
    if (index <= 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid position.");
    }
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
    } else {
      Node<T> current = head;
      while (current.getNext().getNext() != head) {
        current = current.getNext();
      }
      current.setNext(head);
    }
    this.size--;
    return true;
  }

  public T removeLast() {
    T data;
    if (head == null) {
      throw new NoSuchElementException("Linked list has no elements.");
    }
    if (head.getNext() == null || size == 1) {
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

  public T removeFirst() {
    Node<T> current = head;
    T data;
    if (head == null || size == 0) {
      throw new NoSuchElementException("Linked list has no elements.");
    }
    if (head.getNext() == null || size == 1) {
      data = head.getData();
      head = null;
    } else {
      while (current.getNext() != head) {
        current = current.getNext();
      }
      data = head.getData();
      head = head.getNext();
      current.setNext(head);
    }
    this.size--;
    return data;
  }

  public T remove(int index) {
    Node<T> current = head;
    T data;
    if (head == null || size == 0) {
      throw new IllegalArgumentException("Invalid position.");
    }
    if (index <= 0 || index >= size) {
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
    Node<T> current = head;
    try {
      do {
        System.out.println(current.getData());
        current = current.getNext();
      } while (current != head);
    } catch (NullPointerException e) {
      throw new NoSuchElementException("Linked list has no element");
    }
  }
}
