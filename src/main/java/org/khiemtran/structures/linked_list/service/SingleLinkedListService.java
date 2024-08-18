package org.khiemtran.structures.linked_list.service;

import org.khiemtran.structures.linked_list.model.Node;
import org.khiemtran.structures.linked_list.model.SinglyLinkedList;

public class SingleLinkedListService<T> {
  private final SinglyLinkedList<T> linkedList;
  private final LinkedListOperations<T> operations;

  public SingleLinkedListService(SinglyLinkedList<T> linkedList, LinkedListOperations<T> operations) {
    this.linkedList = linkedList;
    this.operations = operations;
  }

  public SinglyLinkedList<T> getSinglyLinkedList() {
    return linkedList;
  }

  public void add(T data) {
    Node<T> head = operations.add(data);
    linkedList.setHead(head);
    linkedList.setSize(linkedList.getSize() + 1);
  }

  public Node<T> remove() {
    Node<T> removedNode = operations.remove();
    linkedList.setSize(linkedList.getSize() - 1);
    return removedNode;
  }

  public void view() {
    String display = this.operations.display();
    System.out.println(display);
  }
}
