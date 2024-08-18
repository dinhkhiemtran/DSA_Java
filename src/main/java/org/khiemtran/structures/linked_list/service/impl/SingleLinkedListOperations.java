package org.khiemtran.structures.linked_list.service.impl;

import org.khiemtran.structures.linked_list.model.Node;
import org.khiemtran.structures.linked_list.service.LinkedListOperations;

public class SingleLinkedListOperations<T> implements LinkedListOperations<T> {
  private Node<T> head;

  @Override
  public Node<T> getHead() {
    return head;
  }

  @Override
  public Node<T> add(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      head = newNode;
    } else {
      Node<T> current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }
    return head;
  }

  @Override
  public Node<T> remove() {
    Node<T> removedNode;
    if (head == null) {
      throw new IndexOutOfBoundsException("Linked list empty.");
    }
    if (head.getNext() == null) {
      removedNode = head;
      this.head = null;
      return removedNode;
    } else {
      Node<T> current = head;
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
    Node<T> current = head;
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
}
