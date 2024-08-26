package org.khiemtran.structures.linked_list.model;

import org.khiemtran.structures.linked_list.AbstractLinkedList;

public class DoublyLinkedList<T> extends AbstractLinkedList<T> {
  public DoublyLinkedList() {
    super();
  }

  @Override
  public void addLast(T data) {
    Node<T> newNode = new Node<>(data);
    if (isEmpty()) {
      head = newNode;
    } else {
      tail.setNext(newNode);
      newNode.setPrevious(tail);
    }
    tail = newNode;
    incrementSize();
  }

  @Override
  public Node<T> removeLast() {
    validateNonEmpty();
    Node<T> removedNode = tail;
    if (head == tail) {
      clearList();
    } else {
      tail = tail.getPrevious();
      if (tail != null) {
        tail.setNext(null);
      }
    }
    clearNodeReferences(removedNode);
    decrementSize();
    return removedNode;
  }

  @Override
  public void insert(T data, int index) {
    validateIndexForInsert(index);
    if (index == 0) {
      addFirst(data);
    } else if (index == size) {
      addLast(data);
    } else {
      Node<T> newNode = new Node<>(data);
      Node<T> current = getNodeAt(index);
      Node<T> prev = current.getPrevious();
      prev.setNext(newNode);
      newNode.setPrevious(prev);
      newNode.setNext(current);
      current.setPrevious(newNode);
      incrementSize();
    }
  }

  @Override
  public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);
    if (isEmpty()) {
      tail = newNode;
    } else {
      newNode.setNext(head);
      head.setPrevious(newNode);
    }
    head = newNode;
    incrementSize();
  }

  @Override
  public Node<T> removeFirst() {
    validateNonEmpty();
    Node<T> removedNode = head;
    if (head == tail) {
      clearList();
    } else {
      head = head.getNext();
      if (head != null) {
        head.setPrevious(null);
      }
    }
    clearNodeReferences(removedNode);
    decrementSize();
    return removedNode;
  }

  @Override
  public Node<T> removeIndex(int index) {
    validateNonEmpty();
    validateIndex(index);
    if (index == 0) {
      return removeFirst();
    } else if (index == size - 1) {
      return removeLast();
    }
    Node<T> nodeToRemove = getNodeAt(index);
    Node<T> prev = nodeToRemove.getPrevious();
    Node<T> next = nodeToRemove.getNext();
    if (prev != null) {
      prev.setNext(next);
    }
    if (next != null) {
      next.setPrevious(prev);
    }
    clearNodeReferences(nodeToRemove);
    decrementSize();
    return nodeToRemove;
  }

  @Override
  public Node<T> getNodeAt(int index) {
    validateIndex(index);
    Node<T> current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current;
  }

  private void validateIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
    }
  }

  private void validateIndexForInsert(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
    }
  }

  private void validateNonEmpty() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Doubly linked list is empty.");
    }
  }

  private void clearList() {
    head = null;
    tail = null;
    setSize(0);
  }

  private void clearNodeReferences(Node<T> node) {
    node.setNext(null);
    node.setPrevious(null);
  }
}
