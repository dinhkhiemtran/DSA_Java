package org.khiemtran.structures.linked_list.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.khiemtran.structures.linked_list.model.Node;
import org.khiemtran.structures.linked_list.model.SinglyLinkedList;
import org.khiemtran.structures.linked_list.service.impl.SingleLinkedListOperations;

class SingleLinkedListServiceTest<T> {
  private SingleLinkedListService<Object> service;
  private LinkedListOperations<Object> operations;
  private SinglyLinkedList<Object> singlyLinkedList;

  @BeforeEach
  public void init() {
    operations = new SingleLinkedListOperations<>();
    singlyLinkedList = new SinglyLinkedList<>();
  }

  @Test
  public void addElement() {
    service = new SingleLinkedListService<>(singlyLinkedList, operations);
    service.add(1);
    service.add(2);
    service.add(3);
    Node<Object> head = service.getSinglyLinkedList().getHead();
    Assertions.assertEquals(3, singlyLinkedList.getSize());
    Assertions.assertEquals(1, head.getData());
    Assertions.assertEquals(2, head.getNext().getData());
    Assertions.assertEquals(3, head.getNext().getNext().getData());
  }

  @Test
  public void removeElement() {
    service = new SingleLinkedListService<>(singlyLinkedList, operations);
    service.add(1);
    Node<Object> removedNode = service.remove();
    Assertions.assertEquals(1, removedNode.getData());
    service.add(1);
    service.add(2);
    service.add(3);
    service.add(4);
    service.add(5);
    Node<Object> head = singlyLinkedList.getHead();
    int size = singlyLinkedList.getSize();
    Assertions.assertEquals(5, size);
    Assertions.assertEquals(1, head.getData());
    Assertions.assertEquals(2, head.getNext().getData());
    Assertions.assertEquals(5, service.remove().getData());
    Assertions.assertEquals(4, service.remove().getData());
    Assertions.assertEquals(3, head.getNext().getNext().getData());
    service.view();
  }

  @Test
  public void removeWhenLinkedListEmpty() {
    service = new SingleLinkedListService<>(singlyLinkedList, operations);
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> service.remove());
    Assertions.assertEquals("Linked list empty.", indexOutOfBoundsException.getMessage());
  }
}