package org.khiemtran.structures.linked_list.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khiemtran.structures.linked_list.AbstractLinkedList;
import org.khiemtran.structures.linked_list.model.Node;
import org.khiemtran.structures.linked_list.model.SinglyLinkedList;

class SinglyLinkedListTest {
  @Test
  public void addElement() {
    AbstractLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
    for (int i = 1; i < 4; i++) {
      singlyLinkedList.addLast(i);
    }
    Assertions.assertEquals(3, singlyLinkedList.getSize());
    Assertions.assertEquals(1, singlyLinkedList.getHead().getData());
    Assertions.assertEquals(2, singlyLinkedList.getHead().getNext().getData());
    Assertions.assertEquals(3, singlyLinkedList.getNodeAt(singlyLinkedList.getSize() -1).getData());
  }

  @Test
  public void removeElement() {
    AbstractLinkedList<Object> singlyLinkedList = new SinglyLinkedList<>();
    singlyLinkedList.addLast(1);
    Node<Object> removedNode = singlyLinkedList.removeLast();
    Assertions.assertEquals(1, removedNode.getData());
    singlyLinkedList.addLast(1);
    singlyLinkedList.addLast(2);
    singlyLinkedList.addLast(3);
    singlyLinkedList.addLast(4);
    singlyLinkedList.addLast(5);
    Node<Object> head = singlyLinkedList.getHead();
    int size = singlyLinkedList.getSize();
    Assertions.assertEquals(5, size);
    Assertions.assertEquals(1, head.getData());
    Assertions.assertEquals(2, head.getNext().getData());
    Assertions.assertEquals(5, singlyLinkedList.removeLast().getData());
    Assertions.assertEquals(4, singlyLinkedList.removeLast().getData());
    Assertions.assertEquals(3, head.getNext().getNext().getData());
    System.out.println(singlyLinkedList.display());
  }

  @Test
  public void removeWhenLinkedListEmpty() {
    AbstractLinkedList<Object> singlyLinkedList = new SinglyLinkedList<>();
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        singlyLinkedList::removeLast);
    Assertions.assertEquals("Linked list is empty.", indexOutOfBoundsException.getMessage());
  }

  @Test
  public void insert() {
    AbstractLinkedList<Object> singlyLinkedList = new SinglyLinkedList<>();
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> singlyLinkedList.add(1, -1));
    Assertions.assertEquals("Index -1 is out of bounds. Size: 0", indexOutOfBoundsException.getMessage());
    singlyLinkedList.addLast(1);
    singlyLinkedList.addLast(3);
    singlyLinkedList.add(2, 1);
    Node<Object> head = singlyLinkedList.getHead();
    Assertions.assertEquals(2, head.getNext().getData());
    singlyLinkedList.add(0, 0);
    Assertions.assertEquals(0, singlyLinkedList.getHead().getData());
    singlyLinkedList.add(4, 4);
    Node<Object> currentNode = head;
    while (currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
    }
    Assertions.assertEquals(4, currentNode.getData());
    System.out.println(singlyLinkedList.display());
    singlyLinkedList.add(5, 3);
    Node<Object> currentNode1 = head;
    while (currentNode1.getNext() != null) {
      if (currentNode1.getData().equals(5)) {
        break;
      }
      currentNode1 = currentNode1.getNext();
    }
    Assertions.assertEquals(5, currentNode1.getData());
    IndexOutOfBoundsException indexOutOfBoundsException1 = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> singlyLinkedList.add(10, 10));
    Assertions.assertEquals("Index 10 is out of bounds. Size: 7", indexOutOfBoundsException1.getMessage());
  }

  @Test
  public void addFirst() {
    AbstractLinkedList<Object> singlyLinkedList = new SinglyLinkedList<>();
    singlyLinkedList.addLast(1);
    singlyLinkedList.addLast(2);
    Assertions.assertEquals(2, singlyLinkedList.getSize());
    Assertions.assertEquals(1, singlyLinkedList.getHead().getData());
    singlyLinkedList.addFirst(0);
    Assertions.assertEquals(0, singlyLinkedList.getHead().getData());
    Assertions.assertEquals(1, singlyLinkedList.getHead().getNext().getData());
  }

  @Test
  public void addFirstWhenLinkedListNull() {
    AbstractLinkedList<Object> singlyLinkedList = new SinglyLinkedList<>();
    singlyLinkedList.addFirst(1);
    Assertions.assertEquals(1, singlyLinkedList.getHead().getData());
    singlyLinkedList.addLast(2);
    Assertions.assertEquals(2, singlyLinkedList.getHead().getNext().getData());
    Assertions.assertEquals(2, singlyLinkedList.getSize());
  }

  @Test
  public void removeFirst() {
    AbstractLinkedList<Object> singlyLinkedList = new SinglyLinkedList<>();
    for (int i = 0; i < 4; i++) {
      singlyLinkedList.addLast(i);
    }
    Assertions.assertEquals(0, singlyLinkedList.getHead().getData());
    Assertions.assertEquals(4, singlyLinkedList.getSize());
    Node<Object> firstNode = singlyLinkedList.removeFirst();
    Assertions.assertEquals(0, firstNode.getData());
    Assertions.assertEquals(1, singlyLinkedList.getHead().getData());
    Node<Object> secondNode = singlyLinkedList.removeFirst();
    Assertions.assertEquals(1, secondNode.getData());
    Assertions.assertEquals(2, singlyLinkedList.getSize());
    singlyLinkedList.removeFirst();
    singlyLinkedList.removeFirst();
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        singlyLinkedList::removeFirst);
    Assertions.assertEquals("Linked List empty.", indexOutOfBoundsException.getMessage());
  }

  @Test
  public void removeIndex() {
    AbstractLinkedList<Object> singlyLinkedList = new SinglyLinkedList<>();
    for (int i = 1; i < 4; i++) {
      singlyLinkedList.addLast(i);
    }
    Node<Object> removedIndex = singlyLinkedList.removeIndex(1);
    Assertions.assertEquals(2, removedIndex.getData());
    Assertions.assertEquals(2, singlyLinkedList.getSize());
    Node<Object> objectNode = singlyLinkedList.removeIndex(0);
    Assertions.assertEquals(1, objectNode.getData());
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> singlyLinkedList.removeIndex(1));
    Assertions.assertEquals("Index 1 is out of bounds. Size: 1", indexOutOfBoundsException.getMessage());
    singlyLinkedList.addLast(1);
    singlyLinkedList.addLast(2);
    singlyLinkedList.addLast(3);
    Node<Object> objectNode1 = singlyLinkedList.removeIndex(3);
    Assertions.assertEquals(3, objectNode1.getData());
    singlyLinkedList.addLast(4);
    singlyLinkedList.addLast(5);
    Node<Object> objectNode2 = singlyLinkedList.removeIndex(2);
    Assertions.assertEquals(2, objectNode2.getData());
    System.out.println(singlyLinkedList.display());
  }
}