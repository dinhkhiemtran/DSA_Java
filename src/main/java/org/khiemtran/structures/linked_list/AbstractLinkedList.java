package org.khiemtran.structures.linked_list;

import org.khiemtran.structures.linked_list.model.Node;

public abstract class AbstractLinkedList<T> implements LinkedListOperations<T> {
  protected Node<T> head;
  protected Node<T> tail;
  protected int size;

  public AbstractLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  @Override
  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public Node<T> getHead() {
    return head;
  }

  @Override
  public Node<T> getTail() {
    return tail;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public String display() {
    StringBuilder sb = new StringBuilder();
    Node<T> current = head;
    while (current != null) {
      sb.append(current.getData()).append(" -> ");
      current = current.getNext();
    }
    sb.append("null");
    return sb.toString();
  }

  protected void incrementSize() {
    size++;
  }

  protected void decrementSize() {
    size--;
  }
}
