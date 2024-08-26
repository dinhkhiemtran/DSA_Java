package org.khiemtran.structures.linked_list.model;

import org.khiemtran.structures.linked_list.AbstractLinkedList;

public class SinglyLinkedList<T> extends AbstractLinkedList<T> {
  public SinglyLinkedList() {
    super();
  }

  @Override
  public void addLast(T data) {
    Node<T> newNode = new Node<>(data);
    if (isEmpty()) {
      this.head = newNode;
    } else {
      Node<T> lastNode = getNodeAt(getSize() - 1);
      lastNode.setNext(newNode);
    }
    incrementSize();
  }

  @Override
  public Node<T> removeLast() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Linked list is empty.");
    }
    if (head.getNext() == null) {
      Node<T> removedNode = head;
      head = null;
      size = 0;
      return removedNode;
    } else {
      Node<T> secondLastNode = getNodeAt(size - 2);
      Node<T> removedNode = secondLastNode.getNext();
      secondLastNode.setNext(null);
      decrementSize();
      return removedNode;
    }
  }

  @Override
  public void insert(T data, int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Size: " + size);
    } else if (index == 0) {
      addFirst(data);
    } else if (index == size) {
      addLast(data);
    } else {
      Node<T> prevNode = getNodeAt(index - 1);
      Node<T> newNode = new Node<>(data);
      newNode.setNext(prevNode.getNext());
      prevNode.setNext(newNode);
    }
    incrementSize();
  }

  @Override
  public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);
    newNode.setNext(head);
    head = newNode;
    incrementSize();
  }

  @Override
  public Node<T> removeFirst() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Linked List empty.");
    }
    Node<T> removedNode = head;
    head = head.getNext();
    removedNode.setNext(null);
    decrementSize();
    return removedNode;
  }

  @Override
  public Node<T> removeIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Size: " + size);
    }
    if (index == 0) {
      return removeFirst();
    } else if (index == size - 1) {
      return removeLast();
    } else {
      Node<T> prevNode = getNodeAt(index - 1);
      Node<T> removedNode = prevNode.getNext();
      prevNode.setNext(removedNode.getNext());
      removedNode.setNext(null);
      decrementSize();
      return removedNode;
    }
  }

  @Override
  public Node<T> getNodeAt(int index) {
    Node<T> current = head;
    int currentIndex = 0;
    while (current != null && currentIndex < index) {
      current = current.getNext();
      currentIndex++;
    }
    return current;
  }
}