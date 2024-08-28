package org.khiemtran.structures.linked_list.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khiemtran.structures.linked_list.AbstractLinkedList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DoublyLinkedListTest {
  @Test
  void addLast() {
    AbstractLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
    for (int i = 1; i < 4; i++) {
      doublyLinkedList.addLast(i);
    }
    Assertions.assertEquals(1, doublyLinkedList.getHead().getData());
    Assertions.assertEquals(3, doublyLinkedList.getTail().getData());
  }

  @Test
  void removeLast() {
    AbstractLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
    for (int i = 1; i < 4; i++) {
      doublyLinkedList.addLast(i);
    }
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
    AbstractLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
    IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class,
        () -> doublyLinkedList.insert(1, -1));
    Assertions.assertEquals("Index " + -1 + " out of bounds for size " + doublyLinkedList.getSize(),
        indexOutOfBoundsException.getMessage());
    IndexOutOfBoundsException indexOutOfBoundsException1 = assertThrows(IndexOutOfBoundsException.class,
        () -> doublyLinkedList.insert(1, 1));
    Assertions.assertEquals("Index " + 1 + " out of bounds for size " + doublyLinkedList.getSize(),
        indexOutOfBoundsException1.getMessage());
    doublyLinkedList.insert(1, 0);
    Assertions.assertEquals(1, doublyLinkedList.getHead().getData());
    doublyLinkedList.insert(2, 1);
    Assertions.assertEquals(2, doublyLinkedList.getHead().getNext().getData());
    doublyLinkedList.addLast(4);
    doublyLinkedList.addLast(5);
    doublyLinkedList.insert(3, 2);
    Assertions.assertEquals(3, doublyLinkedList.getHead().getNext().getNext().getData());
  }

  @Test
  void addFirst() {
    AbstractLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
    for (int i = 5; i > 0; i--) {
      doublyLinkedList.addFirst(i);
    }
    Assertions.assertEquals(1, doublyLinkedList.getHead().getData());
  }

  @Test
  void removeFirst() {
    AbstractLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
    for (int i = 1; i < 4; i++) {
      doublyLinkedList.addLast(i);
    }
    doublyLinkedList.addLast(4);
    Assertions.assertEquals(1, doublyLinkedList.removeFirst().getData());
    Assertions.assertEquals(2, doublyLinkedList.removeFirst().getData());
    Assertions.assertEquals(3, doublyLinkedList.removeFirst().getData());
    Assertions.assertEquals(4, doublyLinkedList.removeFirst().getData());
    IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class,
        doublyLinkedList::removeFirst);
    Assertions.assertEquals("Doubly linked list is empty.", indexOutOfBoundsException.getMessage());
  }

  @Test
  void removeIndex() {
    AbstractLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
    IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class,
        () -> doublyLinkedList.removeIndex(0));
    Assertions.assertEquals("Doubly linked list is empty.", indexOutOfBoundsException.getMessage());
    doublyLinkedList.addLast(1);
    IndexOutOfBoundsException outOfBoundsExceptionNegativeIndex = assertThrows(IndexOutOfBoundsException.class,
        () -> doublyLinkedList.removeIndex(-1));
    Assertions.assertEquals("Index " + -1 + " out of bounds for size " + doublyLinkedList.getSize(),
        outOfBoundsExceptionNegativeIndex.getMessage());
    IndexOutOfBoundsException indexOutOfBoundsException1 = assertThrows(IndexOutOfBoundsException.class,
        () -> doublyLinkedList.removeIndex(1));
    Assertions.assertEquals("Index " + 1 + " out of bounds for size " + doublyLinkedList.getSize(),
        indexOutOfBoundsException1.getMessage());
    doublyLinkedList.addLast(2);
    doublyLinkedList.addLast(3);
    doublyLinkedList.addLast(4);
    doublyLinkedList.addLast(5);
    System.out.println(doublyLinkedList.display());
    Assertions.assertEquals(3, doublyLinkedList.removeIndex(2).getData());
    Assertions.assertEquals(1, doublyLinkedList.removeIndex(0).getData());
    Assertions.assertEquals(5, doublyLinkedList.removeIndex(doublyLinkedList.getSize() - 1).getData());
  }

  @Test
  void getNodeAt() {
    AbstractLinkedList<Integer> linkedList = new DoublyLinkedList<>();
    for (int i = 1; i < 6; i++) {
      linkedList.addLast(i);
    }
    Assertions.assertEquals(1, linkedList.getNodeAt(0).getData());
    Assertions.assertEquals(2, linkedList.getNodeAt(1).getData());
    Assertions.assertEquals(5, linkedList.getNodeAt(linkedList.getSize() - 1).getData());
  }
}