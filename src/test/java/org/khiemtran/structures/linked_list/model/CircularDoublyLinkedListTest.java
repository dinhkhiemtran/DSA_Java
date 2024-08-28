package org.khiemtran.structures.linked_list.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khiemtran.structures.linked_list.AbstractLinkedList;

class CircularDoublyLinkedListTest {
  @Test
  public void addLast() {
    AbstractLinkedList<Integer> circularDoublyLinkedList = new CircularDoublyLinkedList<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 1; i < 6; i++) {
      circularDoublyLinkedList.addLast(i);
      stringBuilder.append(i).append(" -> ");
    }
    Assertions.assertEquals(stringBuilder.append("(head)").toString(), circularDoublyLinkedList.display());
    Assertions.assertEquals(5, circularDoublyLinkedList.getSize());
    Assertions.assertEquals(5, circularDoublyLinkedList.getNodeAt(circularDoublyLinkedList.getSize() - 1).getData());
    Assertions.assertEquals(1, circularDoublyLinkedList.getHead().getData());
  }

  @Test
  public void removeLast() {
    AbstractLinkedList<Integer> circularDoublyLinkedList = new CircularDoublyLinkedList<>();
    for (int i = 1; i < 6; i++) {
      circularDoublyLinkedList.addLast(i);
    }
    for (int i = 5; i > 2; i--) {
      Assertions.assertEquals(i, circularDoublyLinkedList.removeLast().getData());
    }
    Assertions.assertEquals("1 -> 2 -> (head)", circularDoublyLinkedList.display());
    Assertions.assertEquals(2, circularDoublyLinkedList.getSize());
    Assertions.assertEquals(1, circularDoublyLinkedList.getTail().getNext().getData());
    Assertions.assertEquals(2, circularDoublyLinkedList.removeLast().getData());
    Assertions.assertEquals(1, circularDoublyLinkedList.getHead().getNext().getData());
    Assertions.assertEquals(1, circularDoublyLinkedList.removeLast().getData());
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        circularDoublyLinkedList::removeLast);
    Assertions.assertEquals("Circular doubly linked list is empty.", indexOutOfBoundsException.getMessage());
  }

  @Test
  public void insert() {
    AbstractLinkedList<Integer> circularDoublyLinkedList = new CircularDoublyLinkedList<>();
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> circularDoublyLinkedList.insert(1, -1));
    Assertions.assertEquals("Index " + -1 + " out of bounds for size " + circularDoublyLinkedList.getSize(), indexOutOfBoundsException.getMessage());
    IndexOutOfBoundsException indexOutOfBoundsException1 = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> circularDoublyLinkedList.insert(1, 10));
    Assertions.assertEquals("Index " + 10 + " out of bounds for size " + circularDoublyLinkedList.getSize(), indexOutOfBoundsException1.getMessage());
    circularDoublyLinkedList.insert(1, 0);
    circularDoublyLinkedList.addLast(2);
    circularDoublyLinkedList.insert(5, circularDoublyLinkedList.getSize());
    Assertions.assertEquals("1 -> 2 -> 5 -> (head)", circularDoublyLinkedList.display());
    Assertions.assertEquals(1, circularDoublyLinkedList.getTail().getNext().getData());
    Assertions.assertEquals(5, circularDoublyLinkedList.getHead().getPrevious().getData());
    circularDoublyLinkedList.insert(3, 2);
    circularDoublyLinkedList.insert(4, 3);
    Assertions.assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> (head)", circularDoublyLinkedList.display());
    Assertions.assertEquals(5, circularDoublyLinkedList.getSize());
  }

  @Test
  public void removeFirst() {
    AbstractLinkedList<Integer> circularDoublyLinkedList = new CircularDoublyLinkedList<>();
    for (int i = 1; i < 6; i++) {
      circularDoublyLinkedList.addLast(i);
    }
    for (int i = 1; i < 5; i++) {
      Assertions.assertEquals(i, circularDoublyLinkedList.removeFirst().getData());
    }
    Assertions.assertEquals("5 -> (head)", circularDoublyLinkedList.display());
    Assertions.assertEquals(5, circularDoublyLinkedList.removeFirst().getData());
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        circularDoublyLinkedList::removeFirst);
    Assertions.assertEquals("Circular doubly linked list is empty.", indexOutOfBoundsException.getMessage());
  }

  @Test
  public void removeIndex() {
    AbstractLinkedList<Integer> circularDoublyLinkedList = new CircularDoublyLinkedList<>();
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> circularDoublyLinkedList.removeIndex(1));
    Assertions.assertEquals("Circular doubly linked list is empty.", indexOutOfBoundsException.getMessage());
    for (int i = 1; i < 6; i++) {
      circularDoublyLinkedList.addLast(i);
    }
    IndexOutOfBoundsException indexOutOfBoundsException1 = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> circularDoublyLinkedList.removeIndex(-1));
    Assertions.assertEquals("Index " + -1 + " out of bounds for size " + circularDoublyLinkedList.getSize()
        , indexOutOfBoundsException1.getMessage());
    IndexOutOfBoundsException indexOutOfBoundsException2 = Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
        circularDoublyLinkedList.removeIndex(10));
    Assertions.assertEquals("Index " + 10 + " out of bounds for size " + circularDoublyLinkedList.getSize(),
        indexOutOfBoundsException2.getMessage());
    Assertions.assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> (head)", circularDoublyLinkedList.display());
    Assertions.assertEquals(1, circularDoublyLinkedList.removeIndex(0).getData());
    Assertions.assertEquals(2, circularDoublyLinkedList.getTail().getNext().getData());
    Assertions.assertEquals(5, circularDoublyLinkedList.removeIndex(circularDoublyLinkedList.getSize() - 1).getData());
    Assertions.assertEquals("2 -> 3 -> 4 -> (head)", circularDoublyLinkedList.display());
    Assertions.assertEquals(2, circularDoublyLinkedList.getTail().getNext().getData());
    Assertions.assertEquals(4, circularDoublyLinkedList.getHead().getPrevious().getData());
    circularDoublyLinkedList.addFirst(1);
    circularDoublyLinkedList.addLast(5);
    Assertions.assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> (head)", circularDoublyLinkedList.display());
    Node<Integer> integerNode = circularDoublyLinkedList.removeIndex(2);
    Assertions.assertEquals(3, integerNode.getData());
    Assertions.assertEquals("1 -> 2 -> 4 -> 5 -> (head)", circularDoublyLinkedList.display());
    Assertions.assertEquals(1, circularDoublyLinkedList.getTail().getNext().getData());
    Assertions.assertEquals(5, circularDoublyLinkedList.getHead().getPrevious().getData());
  }
}
