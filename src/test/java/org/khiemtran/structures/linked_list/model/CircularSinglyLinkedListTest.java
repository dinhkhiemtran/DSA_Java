package org.khiemtran.structures.linked_list.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.khiemtran.structures.linked_list.model.CircularSinglyLinkedList;
import org.khiemtran.structures.linked_list.model.Node;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class CircularSinglyLinkedListTest {
  private CircularSinglyLinkedList<Integer> list;

  @BeforeEach
  public void setUp() {
    list = new CircularSinglyLinkedList<>();
  }

  @Test
  public void addLast() {
    CircularSinglyLinkedList<Integer> circularSinglyLinkedList = new CircularSinglyLinkedList<>();
    for (int i = 0; i < 2; i++) {
      circularSinglyLinkedList.addLast(i);
    }
    System.out.println(circularSinglyLinkedList.display());
  }

  @Test
  public void removeLast() {
    CircularSinglyLinkedList<Integer> circularSinglyLinkedList = new CircularSinglyLinkedList<>();
    AtomicInteger atomicInteger = new AtomicInteger(1);
    circularSinglyLinkedList.addLast(atomicInteger.getAndIncrement());
    circularSinglyLinkedList.addLast(atomicInteger.getAndIncrement());
    circularSinglyLinkedList.addLast(atomicInteger.getAndIncrement());
    circularSinglyLinkedList.addLast(atomicInteger.getAndIncrement());
    circularSinglyLinkedList.addLast(atomicInteger.getAndIncrement());
    assertEquals(atomicInteger.decrementAndGet(), circularSinglyLinkedList.removeLast().getData());
    assertEquals(atomicInteger.decrementAndGet(), circularSinglyLinkedList.removeLast().getData());
    assertEquals(atomicInteger.decrementAndGet(), circularSinglyLinkedList.removeLast().getData());
    assertEquals(atomicInteger.decrementAndGet(), circularSinglyLinkedList.removeLast().getData());
    assertEquals(atomicInteger.decrementAndGet(), circularSinglyLinkedList.removeLast().getData());
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, circularSinglyLinkedList::removeLast);
    assertEquals("Circular list is empty.", indexOutOfBoundsException.getMessage());
  }

  @Test
  public void insert() {
    CircularSinglyLinkedList<Integer> circularSinglyLinkedList = new CircularSinglyLinkedList<>();
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> circularSinglyLinkedList.insert(1, -1));
    assertEquals("Index " + -1 + " out of bounds for size " + circularSinglyLinkedList.getSize(), indexOutOfBoundsException.getMessage());
    IndexOutOfBoundsException indexOutOfBoundsException1 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> circularSinglyLinkedList.insert(1, 1));
    assertEquals("Index " + 1 + " out of bounds for size " + circularSinglyLinkedList.getSize(), indexOutOfBoundsException1.getMessage());
    circularSinglyLinkedList.insert(1, 0);
    circularSinglyLinkedList.insert(2, 1);
    assertEquals(1, circularSinglyLinkedList.getHead().getData());
    assertEquals(2, circularSinglyLinkedList.getNodeAt(circularSinglyLinkedList.getSize() - 1).getData());
    circularSinglyLinkedList.addLast(4);
    circularSinglyLinkedList.addLast(5);
    circularSinglyLinkedList.insert(3, 2);
    assertEquals(3, circularSinglyLinkedList.getNodeAt(2).getData());
    assertEquals(4, circularSinglyLinkedList.getNodeAt(3).getData());
  }

  @Test
  public void addFirst() {
    CircularSinglyLinkedList<Integer> circularSinglyLinkedList = getIntegerCircularSinglyLinkedList();
    assertEquals(1, circularSinglyLinkedList.getHead().getData());
    assertEquals(1,
        circularSinglyLinkedList.getNodeAt(circularSinglyLinkedList.getSize() - 1).getNext().getData());
    assertEquals(5, circularSinglyLinkedList.getNodeAt(circularSinglyLinkedList.getSize() - 1).getData());
    assertEquals(5, circularSinglyLinkedList.getSize());
  }

  private static CircularSinglyLinkedList<Integer> getIntegerCircularSinglyLinkedList() {
    CircularSinglyLinkedList<Integer> circularSinglyLinkedList = new CircularSinglyLinkedList<>();
    AtomicInteger atomicInteger = new AtomicInteger(5);
    circularSinglyLinkedList.addFirst(atomicInteger.getAndDecrement());
    circularSinglyLinkedList.addFirst(atomicInteger.getAndDecrement());
    circularSinglyLinkedList.addFirst(atomicInteger.getAndDecrement());
    circularSinglyLinkedList.addFirst(atomicInteger.getAndDecrement());
    circularSinglyLinkedList.addFirst(atomicInteger.getAndDecrement());
    return circularSinglyLinkedList;
  }

  @Test
  public void removeFirst() {
    CircularSinglyLinkedList<Integer> circularSinglyLinkedList = new CircularSinglyLinkedList<>();
    for (int i = 1; i < 6; i++) {
      circularSinglyLinkedList.addLast(i);
    }
    for (int i = 1; i <= 4; i++) {
      assertEquals(i, circularSinglyLinkedList.removeFirst().getData());
    }
    assertEquals(5, circularSinglyLinkedList.removeFirst().getData());
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class, circularSinglyLinkedList::removeFirst);
    assertEquals("Circular list is empty.", indexOutOfBoundsException.getMessage());
  }

  @Test
  public void removeIndex() {
    CircularSinglyLinkedList<Integer> circularSinglyLinkedList = new CircularSinglyLinkedList<>();
    IndexOutOfBoundsException circularSinglyLinkedListEmpty = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> circularSinglyLinkedList.removeIndex(1));
    assertEquals("Circular list is empty.", circularSinglyLinkedListEmpty.getMessage());
    circularSinglyLinkedList.addLast(1);
    IndexOutOfBoundsException indexOutOfBoundsException = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> circularSinglyLinkedList.removeIndex(-1));
    assertEquals("Index " + -1 + " out of bounds for size " + circularSinglyLinkedList.getSize()
        , indexOutOfBoundsException.getMessage());
    IndexOutOfBoundsException indexOutOfBoundsException1 = Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> circularSinglyLinkedList.removeIndex(10));
    assertEquals("Index " + 10 + " out of bounds for size " + circularSinglyLinkedList.getSize(),
        indexOutOfBoundsException1.getMessage());
    circularSinglyLinkedList.addLast(2);
    circularSinglyLinkedList.addLast(4);
    circularSinglyLinkedList.addLast(5);
    circularSinglyLinkedList.insert(3, 2);
    assertEquals(3, circularSinglyLinkedList.getNodeAt(2).getData());
    assertEquals(3, circularSinglyLinkedList.removeIndex(2).getData());
    System.out.println(circularSinglyLinkedList.display());
  }

  @Test
  public void testAddLastOnEmptyList() {
    list.addLast(1);
    assertEquals("1 -> (head)", list.display());
  }

  @Test
  public void testAddLastOnNonEmptyList() {
    list.addLast(1);
    list.addLast(2);
    assertEquals("1 -> 2 -> (head)", list.display());
  }

  @Test
  public void testAddFirstOnEmptyList() {
    list.addFirst(1);
    assertEquals("1 -> (head)", list.display());
  }

  @Test
  public void testAddFirstOnNonEmptyList() {
    list.addLast(1);
    list.addFirst(2);
    assertEquals("2 -> 1 -> (head)", list.display());
  }

  @Test
  public void testRemoveLastFromSingleElementList() {
    list.addLast(1);
    Node<Integer> removedNode = list.removeLast();
    assertNotNull(removedNode);
    assertEquals(1, removedNode.getData());
    assertTrue(list.isEmpty());
  }

  @Test
  public void testRemoveLastFromMultipleElementsList() {
    list.addLast(1);
    list.addLast(2);
    Node<Integer> removedNode = list.removeLast();
    assertNotNull(removedNode);
    assertEquals(2, removedNode.getData());
    assertEquals("1 -> (head)", list.display());
  }

  @Test
  public void testRemoveFirstFromSingleElementList() {
    list.addLast(1);
    Node<Integer> removedNode = list.removeFirst();
    assertNotNull(removedNode);
    assertEquals(1, removedNode.getData());
    assertTrue(list.isEmpty());
  }

  @Test
  public void testRemoveFirstFromMultipleElementsList() {
    list.addLast(1);
    list.addLast(2);
    Node<Integer> removedNode = list.removeFirst();
    assertNotNull(removedNode);
    assertEquals(1, removedNode.getData());
    assertEquals("2 -> (head)", list.display());
  }

  @Test
  public void testInsertAtBeginning() {
    list.addLast(2);
    list.insert(1, 0);
    assertEquals("1 -> 2 -> (head)", list.display());
  }

  @Test
  public void testInsertAtEnd() {
    list.addLast(1);
    list.insert(2, 1);
    assertEquals("1 -> 2 -> (head)", list.display());
  }

  @Test
  public void testInsertAtMiddle() {
    list.addLast(1);
    list.addLast(3);
    list.insert(2, 1);
    assertEquals("1 -> 2 -> 3 -> (head)", list.display());
  }

  @Test
  public void testRemoveIndexFromStart() {
    list.addLast(1);
    list.addLast(2);
    Node<Integer> removedNode = list.removeIndex(0);
    assertNotNull(removedNode);
    assertEquals(1, removedNode.getData());
    assertEquals("2 -> (head)", list.display());
  }

  @Test
  public void testRemoveIndexFromEnd() {
    list.addLast(1);
    list.addLast(2);
    Node<Integer> removedNode = list.removeIndex(1);
    assertNotNull(removedNode);
    assertEquals(2, removedNode.getData());
    assertEquals("1 -> (head)", list.display());
  }

  @Test
  public void testRemoveIndexFromMiddle() {
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    Node<Integer> removedNode = list.removeIndex(1);
    assertNotNull(removedNode);
    assertEquals(2, removedNode.getData());
    assertEquals("1 -> 3 -> (head)", list.display());
  }

  @Test
  public void testGetNodeAt() {
    list.addLast(1);
    list.addLast(2);
    Node<Integer> node = list.getNodeAt(1);
    assertNotNull(node);
    assertEquals(2, node.getData());
  }

  @Test
  public void testDisplayEmptyList() {
    assertEquals("List is empty", list.display());
  }

  @Test
  public void testDisplayNonEmptyList() {
    list.addLast(1);
    list.addLast(2);
    assertEquals("1 -> 2 -> (head)", list.display());
  }
}