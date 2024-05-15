package org.khiemtran.structures.linked_list;

public class DoublyLinkedList<T> {
  public static class Node<T> {
    private Node<T> next;
    private Node<T> previous;
    private T data;

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

    public void setData(T data) {
      this.data = data;
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

  public void add(T data) {
    Node<T> newNode = new Node<>();
    newNode.setData(data);
    if (head == null) {
      head = newNode;
    } else {
      tail.setNext(newNode);
      newNode.setPrevious(tail);
    }
    tail = newNode;
    this.size++;
  }

  public T remove() {
    T data;
    if (head == null || size == 0) {
      throw new IllegalArgumentException("Linked list is empty");
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

  public void insert(T data, int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Invalid position");
    }
    Node<T> newNode = new Node<>();
    newNode.setData(data);
    if (index == size) {
      add(data);
      return; // Exit as `add` already increments size
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
    T data;
    Node<T> current = head;
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Invalid position");
    }
    if (index == size -1) {
      return remove();
    }
    if (index == 0) {
      data = current.getData();
      head = current.getNext();
    } else {
      for (int i = 1; i < index; i++) {
        current = current.getNext();
      }
      data = current.getNext().getData();
      current.getNext().getNext().setPrevious(current);
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
