package org.khiemtran.structures.linked_list;

import org.khiemtran.structures.linked_list.model.Node;

public interface LinkedListOperations<T> extends AddOperations<T>, RemoveOperations<T> {
  Node<T> getHead();

  Node<T> getTail();

  String display();

  Node<T> getNodeAt(int index);

  boolean isEmpty();
}