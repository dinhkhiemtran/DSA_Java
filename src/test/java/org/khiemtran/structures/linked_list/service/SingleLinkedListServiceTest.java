package org.khiemtran.structures.linked_list.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.khiemtran.structures.linked_list.model.Node;
import org.khiemtran.structures.linked_list.model.SinglyLinkedList;
import org.khiemtran.structures.linked_list.service.impl.SinglyLinkedListOperations;

class SingleLinkedListServiceTest<T> {
  private SinglyLinkedListService<Object> service;
  private LinkedListOperations<Object> operations;
  private SinglyLinkedList<Object> singlyLinkedList;

  @BeforeEach
  public void init() {
    operations = new SinglyLinkedListOperations<>();
    singlyLinkedList = new SinglyLinkedList<>();
  }

  @Test
  public void addElement() {
    service = new SinglyLinkedListService<>(singlyLinkedList, operations);
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
    service = new SinglyLinkedListService<>(singlyLinkedList, operations);
    service.add(1);
    Node<Object> removedNode = service.removeLast();
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
    Assertions.assertEquals(5, service.removeLast().getData());
    Assertions.assertEquals(4, service.removeLast().getData());
    Assertions.assertEquals(3, head.getNext().getNext().getData());
    service.view();
  }

  @Test
  public void removeWhenLinkedListEmpty() {
    service = new SinglyLinkedListService<>(singlyLinkedList, operations);
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> service.removeLast());
    Assertions.assertEquals("Linked list empty.", indexOutOfBoundsException.getMessage());
  }

  @Test
  public void insert() {
    service = new SinglyLinkedListService<>(singlyLinkedList, operations);
    service.add(1);
    service.add(3);
    service.insert(2, 1);
    Node<Object> head = singlyLinkedList.getHead();
    Assertions.assertEquals(2, head.getNext().getData());
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> service.insert(0, 0));
    Assertions.assertEquals("Index " + 0 + " is out of bounds. Size: " + singlyLinkedList.getSize(), indexOutOfBoundsException.getMessage());
    IndexOutOfBoundsException ofBoundsExceptionLast = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> service.insert(4, 3));
    Assertions.assertEquals("Index " + 3 + " is out of bounds. Size: " + singlyLinkedList.getSize(), ofBoundsExceptionLast.getMessage());
    service.insert(0, 2);
    Assertions.assertEquals(0, head.getNext().getNext().getData());
    System.out.println(service.view());
  }
}