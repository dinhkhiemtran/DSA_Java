package org.khiemtran.structures.linked_list.model;

import org.khiemtran.structures.linked_list.AbstractLinkedList;

public class CircularSinglyLinkedList<T> extends AbstractLinkedList<T> {
  @Override
  public void addLast(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      head = newNode;
      newNode.setNext(head);
    } else {
      Node<T> lastNode = getNodeAt(getSize() - 1);
      lastNode.setNext(newNode);
      newNode.setNext(head);
    }
    incrementSize();
  }

  @Override
  public Node<T> removeLast() {
    validateNonEmpty();
    Node<T> removedNode;
    if (head.getNext() == head) {
      removedNode = head;
      clearList();
      return removedNode;
    }
    Node<T> secondLastNode = getNodeAt(getSize() - 2);
    removedNode = secondLastNode.getNext();
    secondLastNode.setNext(head);
    removedNode.setNext(null);
    decrementSize();
    return removedNode;
  }

  @Override
  public void insert(T data, int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
    }
    if (index == 0) {
      addFirst(data);
      return;
    }
    if (index == getSize()) {
      addLast(data);
      return;
    }
    Node<T> newNode = new Node<>(data);
    Node<T> currentNode = getNodeAt(index - 1);
    if (currentNode != null) {
      newNode.setNext(currentNode.getNext());
      currentNode.setNext(newNode);
    }
    incrementSize();
  }

  @Override
  public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      head = newNode;
      newNode.setNext(head);
    } else {
      Node<T> lastNode = getNodeAt(getSize() - 1);
      newNode.setNext(head);
      head = newNode;
      lastNode.setNext(head);
    }
    incrementSize();
  }

  @Override
  public Node<T> removeFirst() {
    validateNonEmpty();
    Node<T> removedNode = head;
    if (head.getNext() == head) {
      clearList();
    } else {
      Node<T> lastNode = getNodeAt(getSize() - 1);
      head = head.getNext();
      lastNode.setNext(head);
      removedNode.setNext(null);
    }
    decrementSize();
    return removedNode;
  }

  @Override
  public Node<T> removeIndex(int index) {
    validateNonEmpty();
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
    }
    if (index == 0) {
      return removeFirst();
    }
    if (index == getSize() - 1) {
      return removeLast();
    }
    Node<T> previousNode = getNodeAt(index - 1);
    Node<T> removedNode = previousNode.getNext();
    previousNode.setNext(removedNode.getNext());
    removedNode.setNext(null);
    decrementSize();
    return removedNode;
  }

  @Override
  public Node<T> getNodeAt(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
    }
    Node<T> current = head;
    int currentIndex = 0;
    while (currentIndex < index) {
      current = current.getNext();
      currentIndex++;
    }
    return current;
  }

  private void validateNonEmpty() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Circular list is empty.");
    }
  }
  private void clearList() {
    head = null;
    setSize(0);
  }

  @Override
  public String display() {
    if (isEmpty()) {
      return "List is empty";
    }
    StringBuilder stringBuilder = new StringBuilder();
    Node<T> current = head;
    do {
      stringBuilder.append(current.getData()).append(" -> ");
      current = current.getNext();
    } while (current != head);
    stringBuilder.append("(head)");
    return stringBuilder.toString();
  }
}
