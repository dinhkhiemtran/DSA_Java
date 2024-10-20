package org.khiemtran.structures.linked_list;

import org.khiemtran.structures.linked_list.model.Node;

public interface RemoveOperations<T> {
  Node<T> removeLast();

  Node<T> removeIndex(int index);

  Node<T> removeFirst();
}
