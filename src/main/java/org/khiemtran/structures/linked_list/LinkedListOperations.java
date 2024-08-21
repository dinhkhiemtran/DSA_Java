package org.khiemtran.structures.linked_list;

import org.khiemtran.structures.linked_list.model.Node;

public interface LinkedListOperations<T> {
  Node<T> getHead();

  Node<T> getTail();

  void addLast(T data);

  int getSize();

  void setSize(int size);

  Node<T> removeLast();

  String display();

  void insert(T data, int index);

  void addFirst(T data);

  Node<T> removeFirst();

  Node<T> removeIndex(int index);

  Node<T> getNodeAt(int index);
}