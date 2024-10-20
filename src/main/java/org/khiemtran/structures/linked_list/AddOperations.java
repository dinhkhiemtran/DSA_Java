package org.khiemtran.structures.linked_list;

public interface AddOperations<T> {
  void addLast(T data);

  void addFirst(T data);

  void add(T data, int index);

  void addAll(Iterable<? extends T> src);
}
