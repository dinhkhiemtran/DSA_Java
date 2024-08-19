package org.khiemtran.structures.linked_list.service;

import org.khiemtran.structures.linked_list.model.Node;
import org.khiemtran.structures.linked_list.model.SinglyLinkedList;

public class SinglyLinkedListService<T> {
  private final SinglyLinkedList<T> linkedList;
  private final LinkedListOperations<T> operations;

  public SinglyLinkedListService(SinglyLinkedList<T> linkedList, LinkedListOperations<T> operations) {
    this.linkedList = linkedList;
    this.operations = operations;
  }

  public SinglyLinkedList<T> getSinglyLinkedList() {
    return linkedList;
  }

  public void add(T data) {
    Node<T> head = operations.add(data);
    linkedList.setHead(head);
    updateSize(1);
  }

  public Node<T> removeLast() {
    Node<T> removedNode = operations.remove();
    updateSize(-1);
    return removedNode;
  }

  public void insert(T data, int index) {
    operations.insert(data, index, linkedList.getSize());
    updateSize(1);
  }

  public String view() {
    return operations.display();
  }

  private void updateSize(int delta) {
    linkedList.setSize(linkedList.getSize() + delta);
  }
}
