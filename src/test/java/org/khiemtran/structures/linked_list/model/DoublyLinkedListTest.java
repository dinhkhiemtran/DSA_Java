package org.khiemtran.structures.linked_list.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
  @Test
  void addLast() {
    DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
    doublyLinkedList.addLast(1);
    doublyLinkedList.addLast(2);
    doublyLinkedList.addLast(3);
    Assertions.assertEquals(1, doublyLinkedList.getHead().getData());
    Assertions.assertEquals(3, doublyLinkedList.getTail().getData());
  }

  @Test
  void removeLast() {
    DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
    doublyLinkedList.addLast(1);
    doublyLinkedList.addLast(2);
    doublyLinkedList.addLast(3);
    Assertions.assertEquals(3, doublyLinkedList.removeLast().getData());
    Assertions.assertEquals(2, doublyLinkedList.removeLast().getData());
    Assertions.assertEquals(1, doublyLinkedList.getSize());
    Assertions.assertEquals(1, doublyLinkedList.removeLast().getData());
    IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class,
        doublyLinkedList::removeLast);
    Assertions.assertEquals("Doubly linked list is empty.", indexOutOfBoundsException.getMessage());
  }

  @Test
  void insert() {
  }

  @Test
  void addFirst() {
  }

  @Test
  void removeFirst() {
  }

  @Test
  void removeIndex() {
  }

  @Test
  void getNodeAt() {
  }
}