package org.khiemtran.structures.linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class SinglyLinkedListTest {
  private final SinglyLinkedList<Object> linkedList = new SinglyLinkedList<>();

  @Test
  public void checkHeadNullAndSizeZero() {
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void checkAddElements() {
    Assertions.assertTrue(linkedList.add(1));
    Assertions.assertTrue(linkedList.add("test"));
    Assertions.assertTrue(linkedList.add('t'));
    Assertions.assertTrue(linkedList.add(Arrays.asList(1, 2, 3)));
    Assertions.assertEquals(4, linkedList.getSize());
  }

  @Test
  public void addLastAllTypes() {
    linkedList.addLast(1);
    linkedList.addLast("Test");
    linkedList.addLast('t');
    linkedList.addLast(Arrays.asList(1, 2, 3));
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "1");
    map.put(2, "2");
    linkedList.addLast(map);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    SinglyLinkedList.Node<Object> current = linkedList.getHead();
    while (current.getNext() != null) {
      current = current.getNext();
    }
    Assertions.assertEquals(map, current.getData());
    Assertions.assertEquals("Test", linkedList.getHead().getNext().getData());
    Assertions.assertEquals(Optional.of('t').get(), linkedList.getHead().getNext().getNext().getData());
    Assertions.assertEquals(5, linkedList.getSize());
    linkedList.display();
  }

  @Test
  public void addFirstOnlyElement() {
    linkedList.addFirst(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void addFirstElements() {
    linkedList.addLast(5);
    linkedList.addFirst(4);
    linkedList.addFirst(3);
    linkedList.addFirst(2);
    linkedList.addFirst(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    SinglyLinkedList.Node<Object> current = linkedList.getHead();
    while (current.getNext() != null) {
      current = current.getNext();
    }
    Assertions.assertEquals(5, current.getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(5, linkedList.getSize());
  }

  @Test
  public void removeLastEmptyElement() {
    Assertions.assertThrows(NoSuchElementException.class, linkedList::removeLast,
        "Linked list has no elements.");
  }

  @Test
  public void removeLastOneElement() {
    linkedList.addLast(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.removeLast());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void checkRemoveElements() {
    AtomicInteger atomicInteger = new AtomicInteger(1);
    linkedList.add(atomicInteger.getAndIncrement());
    linkedList.add(atomicInteger.getAndIncrement());
    linkedList.add(atomicInteger.getAndIncrement());
    linkedList.add(atomicInteger.getAndIncrement());
    linkedList.add(atomicInteger.getAndIncrement());
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertFalse(linkedList.remove());
  }

  @Test
  public void removeLastMultipleElement() {
    linkedList.addLast(1);
    linkedList.addLast("Test");
    linkedList.addLast('t');
    List<Integer> list = Arrays.asList(1, 2, 3);
    linkedList.addLast(list);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "1");
    map.put(2, "2");
    linkedList.addLast(map);
    Assertions.assertEquals(map, linkedList.removeLast());
    Assertions.assertEquals(list, linkedList.removeLast());
    Assertions.assertEquals('t', linkedList.removeLast());
    Assertions.assertEquals("Test", linkedList.removeLast());
    Assertions.assertEquals(1, linkedList.removeLast());
    Assertions.assertEquals(0, linkedList.getSize());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertThrows(NoSuchElementException.class, linkedList::removeLast, "Linked list has no elements.");
  }

  @Test
  public void removeFirstNoSuchElementException() {
    Assertions.assertThrows(NoSuchElementException.class, linkedList::removeFirst, "Linked list have no elements");
  }

  @Test
  public void removeFirstOnlyElement() {
    linkedList.addLast(1);
    Assertions.assertEquals(1, linkedList.removeFirst());
    Assertions.assertNull(linkedList.getHead());
  }

  @Test
  public void removeFirstElements() {
    AtomicInteger atomicIntegerInit = new AtomicInteger(1);
    linkedList.addLast(atomicIntegerInit.getAndIncrement());
    linkedList.addLast(atomicIntegerInit.getAndIncrement());
    linkedList.addLast(atomicIntegerInit.getAndIncrement());
    linkedList.addLast(atomicIntegerInit.getAndIncrement());
    linkedList.addLast(atomicIntegerInit.getAndIncrement());
    AtomicInteger atomicInteger = new AtomicInteger(1);
    Assertions.assertEquals(atomicInteger.getAndIncrement(), linkedList.removeFirst());
    Assertions.assertEquals(atomicInteger.getAndIncrement(), linkedList.removeFirst());
    Assertions.assertEquals(atomicInteger.getAndIncrement(), linkedList.removeFirst());
    Assertions.assertEquals(atomicInteger.getAndIncrement(), linkedList.getHead().getData());
    Assertions.assertEquals(atomicInteger.getAndIncrement(), linkedList.getHead().getNext().getData());
    Assertions.assertEquals(2, linkedList.getSize());
    Assertions.assertEquals(4, linkedList.removeFirst());
    Assertions.assertEquals(5, linkedList.removeFirst());
    Assertions.assertThrows(NoSuchElementException.class, linkedList::removeFirst);
  }

  @Test
  public void displayNullPointerException() {
    Assertions.assertThrows(NoSuchElementException.class, linkedList::display, "Linked list has no elements.");
  }

  @Test
  public void insertPositionNegative() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-1, 1),
        "Invalid position.");
  }

  @Test
  public void insertIndexOne() {
    linkedList.addLast(1);
    linkedList.addLast(3);
    linkedList.add(1, 2);
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getNext().getData());
  }

  @Test
  public void insertIndexTwo() {
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(4);
    linkedList.addLast(5);
    linkedList.add(2, 3);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getNext().getData());
    Assertions.assertEquals(4, linkedList.getHead().getNext().getNext().getNext().getData());
    SinglyLinkedList.Node<Object> current = linkedList.getHead();
    while (current.getNext() != null) {
      current = current.getNext();
    }
    Assertions.assertEquals(5, current.getData());
    Assertions.assertEquals(5, linkedList.getSize());
  }

  @Test
  public void removeLastIndexNegativeAndOutOfBound() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(-1),
        "Invalid position");
    linkedList.addLast(1);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(2),
        "Invalid position");
  }

  @Test
  public void removeLastIndexWhenLinkedListEmpty() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(0), "Linked list has no elements.");
  }

  @Test
  public void removeLastIndexOne() {
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(2, linkedList.remove(1));
    Assertions.assertEquals(2, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getData());
  }

  @Test
  public void removeLastIndexTwo() {
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addLast(5);
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals(3, linkedList.remove(2));
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(4, linkedList.getHead().getNext().getNext().getData());
    Assertions.assertEquals(5, linkedList.getHead().getNext().getNext().getNext().getData());
    Assertions.assertEquals(4, linkedList.getSize());
  }
}