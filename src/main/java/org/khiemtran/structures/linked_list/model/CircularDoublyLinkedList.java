package org.khiemtran.structures.linked_list.model;

import org.khiemtran.structures.linked_list.AbstractLinkedList;

public class CircularDoublyLinkedList<T> extends AbstractLinkedList<T> {
  @Override
  public void addLast(T data) {
    Node<T> newNode = new Node<>(data);
    if (isEmpty()) {
      super.head = newNode;
      super.tail = newNode;
      newNode.setNext(newNode);
      newNode.setPrevious(newNode);
    } else {
      newNode.setPrevious(super.tail);
      super.tail.setNext(newNode);
      super.tail = newNode;
      super.tail.setNext(super.head);
      super.head.setPrevious(super.tail);
    }
    incrementSize();
  }

  @Override
  public Node<T> removeLast() {
    validateEmpty();
    Node<T> removedNode = super.tail;
    if (super.head == super.tail) {
      clearCircularDoublyLinkedList();
      return removedNode;
    }
    super.tail = super.tail.getPrevious();
    clearNodeReferences(removedNode);
    super.tail.setNext(super.head);
    super.head.setPrevious(super.tail);
    decrementSize();
    return removedNode;
  }

  @Override
  public void insert(T data, int index) {
    int size = getSize();
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
    }
    if (index == 0) {
      addFirst(data);
      return;
    }
    if (index == size) {
      addLast(data);
      return;
    }
    Node<T> newNode = new Node<>(data);
    Node<T> previousNode = getNodeAt(index - 1);
    Node<T> nextNode = previousNode.getNext();
    newNode.setNext(nextNode);
    newNode.setPrevious(previousNode);
    previousNode.setNext(newNode);
    if (nextNode != null) {
      nextNode.setPrevious(newNode);
    }
    incrementSize();
    if (index == size - 1) {
      tail.setNext(head);
      head.setPrevious(tail);
    }
  }

  @Override
  public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);
    if (isEmpty()) {
      super.tail = newNode;
      super.head = newNode;
      newNode.setNext(newNode);
      newNode.setPrevious(newNode);
    } else {
      newNode.setNext(super.head);
      newNode.setPrevious(super.tail);
      super.head.setPrevious(newNode);
      super.tail.setNext(newNode);
      super.head = newNode;
    }
    incrementSize();
  }

  @Override
  public Node<T> removeFirst() {
    validateEmpty();
    Node<T> removedNode = head;
    if (head == tail) {
      clearCircularDoublyLinkedList();
    } else {
      head = head.getNext();
      clearNodeReferences(removedNode);
      head.setPrevious(tail);
      tail.setNext(head);
    }
    decrementSize();
    return removedNode;
  }

  @Override
  public Node<T> removeIndex(int index) {
    validateEmpty();
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
    }
    if (index == 0)
      return removeFirst();
    if (index == size - 1)
      return removeLast();
    Node<T> current = getNodeAt(index);
    Node<T> previousNode = current.getPrevious();
    Node<T> nextNode = current.getNext();
    previousNode.setNext(nextNode);
    nextNode.setPrevious(previousNode);
    clearNodeReferences(current);
    decrementSize();
    return current;
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

  public void validateEmpty() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Circular doubly linked list is empty.");
    }
  }

  private void clearCircularDoublyLinkedList() {
    super.head = null;
    super.tail = null;
    setSize(0);
  }

  private void clearNodeReferences(Node<T> node) {
    if (node != null) {
      node.setNext(null);
      node.setPrevious(null);
    }
  }

  @Override
  public String display() {
    Node<T> current = super.head;
    StringBuilder stringBuilder = new StringBuilder();
    do {
      stringBuilder.append(current.getData())
          .append(" -> ");
      current = current.getNext();
    } while (current != super.head);
    return stringBuilder.append("(head)").toString();
  }
}
