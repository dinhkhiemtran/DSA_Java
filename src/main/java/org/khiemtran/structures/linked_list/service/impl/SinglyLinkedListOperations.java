package org.khiemtran.structures.linked_list.service.impl;

import org.khiemtran.structures.linked_list.model.Node;
import org.khiemtran.structures.linked_list.service.LinkedListOperations;

public class SinglyLinkedListOperations<T> implements LinkedListOperations<T> {
  private Node<T> head;

  @Override
  public Node<T> add(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      this.head = newNode;
    } else {
      Node<T> current = this.head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }
    return this.head;
  }

  @Override
  public Node<T> remove() {
    Node<T> removedNode;
    if (this.head == null) {
      throw new IndexOutOfBoundsException("Linked list empty.");
    }
    if (this.head.getNext() == null) {
      removedNode = this.head;
      this.head = null;
      return removedNode;
    } else {
      Node<T> current = this.head;
      while (current.getNext().getNext() != null) {
        current = current.getNext();
      }
      removedNode = current.getNext();
      current.setNext(null);
    }
    return removedNode;
  }

  @Override
  public String display() {
    StringBuilder stringBuilder = new StringBuilder();
    Node<T> current = this.head;
    while (current != null) {
      stringBuilder
          .append(current.getData());
      if (current.getNext() != null) {
        stringBuilder.append("->");
      }
      current = current.getNext();
    }
    return stringBuilder.toString();
  }

  @Override
  public void insert(T data, int index, int size) {
    if (index <= 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Size: " + size);
    } else {
      Node<T> current = this.head;
      int currentIndex = 0;
      while (currentIndex < index - 1) {
        current = current.getNext();
        currentIndex++;
      }
      Node<T> newNode = new Node<>(data);
      newNode.setNext(current.getNext());
      current.setNext(newNode);
    }
  }
}
