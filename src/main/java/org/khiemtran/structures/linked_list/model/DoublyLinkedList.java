package org.khiemtran.structures.linked_list.model;

import org.khiemtran.structures.linked_list.AbstractLinkedList;

public class DoublyLinkedList<T> extends AbstractLinkedList<T> {
  public DoublyLinkedList() {
    super();
  }

  @Override
  public void addLast(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
      super.head = newNode;
    } else {
      tail.setNext(newNode);
      newNode.setPrevious(tail);
    }
    incrementSize();
    super.tail = newNode;
  }

  @Override
  public Node<T> removeLast() {
    Node<T> removedNode;
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Doubly linked list is empty.");
    }
    if (head == tail) {
      removedNode = head;
      head = null;
      tail = null;
      setSize(0);
    } else {
      removedNode = tail;
      tail = tail.getPrevious();
      tail.setNext(null);
    }
    decrementSize();
    return removedNode;
  }

  @Override
  public void insert(T data, int index) {
  }

  @Override
  public void addFirst(T data) {
  }

  @Override
  public Node<T> removeFirst() {
    return null;
  }

  @Override
  public Node<T> removeIndex(int index) {
    return null;
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

  public boolean isEmpty() {
    return super.head == null;
  }
}
