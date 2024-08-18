package org.khiemtran.structures.linked_list.service;

import org.khiemtran.structures.linked_list.model.Node;

public interface LinkedListOperations<T> {
  Node<T> add(T data);

  Node<T> remove();

  Node<T> getHead();

  String display();
}
