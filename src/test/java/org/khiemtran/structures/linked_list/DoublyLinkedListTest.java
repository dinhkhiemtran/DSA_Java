package org.khiemtran.structures.linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class DoublyLinkedListTest {
  private final DoublyLinkedList<Object> linkedList = new DoublyLinkedList<>();

  @Test
  public void checkAddElements() {
    AtomicInteger atomicInteger = new AtomicInteger(1);
    Assertions.assertTrue(linkedList.add(atomicInteger.getAndIncrement()));
    Assertions.assertTrue(linkedList.add(atomicInteger.getAndIncrement()));
    Assertions.assertTrue(linkedList.add(atomicInteger.getAndIncrement()));
    Assertions.assertTrue(linkedList.add(atomicInteger.getAndIncrement()));
    Assertions.assertTrue(linkedList.add(atomicInteger.getAndIncrement()));
    Assertions.assertEquals(5, linkedList.getTail().getData());
    Assertions.assertEquals(4, linkedList.getTail().getPrevious().getData());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(5, linkedList.getSize());
  }

  @Test
  public void addElementWhenEmpty() {
    linkedList.addLast(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getTail().getData());
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertNull(linkedList.getHead().getPrevious());
    Assertions.assertNull(linkedList.getTail().getPrevious());
    linkedList.display();
  }

  @Test
  public void addMultipleElements() {
    linkedList.addLast(1);
    linkedList.addLast("test");
    linkedList.addLast('t');
    List<Integer> list = Arrays.asList(1, 2, 3);
    linkedList.addLast(list);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "test");
    map.put(2, "test1");
    linkedList.addLast(map);
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals("test", linkedList.getHead().getNext().getData());
    Assertions.assertEquals(map, linkedList.getTail().getData());
    Assertions.assertEquals(list, linkedList.getTail().getPrevious().getData());
    linkedList.display();
  }

  @Test
  public void addElementsFirst() {
    linkedList.addFirst(5);
    linkedList.addFirst(4);
    linkedList.addFirst(3);
    linkedList.addFirst(2);
    linkedList.addFirst(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(5, linkedList.getTail().getData());
    Assertions.assertEquals(4, linkedList.getTail().getPrevious().getData());
    Assertions.assertEquals(5, linkedList.getSize());
  }

  @Test
  public void checkRemoveElement() {
    Assertions.assertFalse(linkedList.remove());
    Assertions.assertTrue(linkedList.add(1));
    Assertions.assertTrue(linkedList.add(2));
    Assertions.assertTrue(linkedList.add(3));
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(2, linkedList.getTail().getData());
    Assertions.assertEquals(1, linkedList.getTail().getPrevious().getData());
    Assertions.assertEquals(2, linkedList.getSize());
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertNull(linkedList.getTail());
    Assertions.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void removeWhenLLEmpty() {
    Assertions.assertThrows(NoSuchElementException.class, linkedList::removeLast, "Linked list is empty");
  }

  @Test
  public void removeOnlyElement() {
    linkedList.addLast(1);
    Assertions.assertEquals(1, linkedList.removeLast());
    Assertions.assertEquals(0, linkedList.getSize());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertNull(linkedList.getTail());
  }

  @Test
  public void removeMultipleElement() {
    linkedList.addLast(1);
    linkedList.addLast("test");
    List<Character> letters = Arrays.asList('a', 'b', 'c');
    linkedList.addLast(letters);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "some");
    map.put(2, "thing");
    linkedList.addLast(map);
    linkedList.addLast('t');
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals('t', linkedList.removeLast());
    Assertions.assertEquals(map, linkedList.getTail().getData());
    Assertions.assertEquals(4, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(map, linkedList.removeLast());
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(letters, linkedList.getTail().getData());
    Assertions.assertEquals("test", linkedList.getTail().getPrevious().getData());
    Assertions.assertEquals(letters, linkedList.removeLast());
    Assertions.assertEquals("test", linkedList.getTail().getData());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals("test", linkedList.removeLast());
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getTail().getData());
    linkedList.display();
  }

  @Test
  public void removeFirstWhenLinkedListEmpty() {
    Assertions.assertThrows(NoSuchElementException.class, linkedList::removeFirst, "Linked list is empty");
  }

  @Test
  public void removeFirstOnlyElement() {
    linkedList.addLast(1);
    Assertions.assertEquals(1, linkedList.removeFirst());
    Assertions.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void removeElementsFirst() {
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addLast(5);
    Assertions.assertEquals(1, linkedList.removeFirst());
    Assertions.assertEquals(2, linkedList.removeFirst());
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(3, linkedList.getHead().getData());
    Assertions.assertEquals(4, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(5, linkedList.getTail().getData());
    Assertions.assertEquals(4, linkedList.getTail().getPrevious().getData());
  }

  @Test
  public void insertIndexNegative() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.add(-1, 1), "Invalid position");
  }

  @Test
  public void insertIndexOne() {
    linkedList.addLast(1);
    linkedList.addLast(3);
    linkedList.add(1, 2);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(3, linkedList.getTail().getData());
    Assertions.assertEquals(3, linkedList.getSize());
  }

  @Test
  public void insertIndexTwo() {
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(4);
    linkedList.addLast(5);
    Assertions.assertEquals(4, linkedList.getSize());
    linkedList.add(2, 3);
    Assertions.assertEquals(3, linkedList.getHead().getNext().getNext().getData());
    Assertions.assertEquals(5, linkedList.getTail().getData());
    Assertions.assertEquals(5, linkedList.getSize());
    linkedList.display();
  }

  @Test
  public void removeWhenLinkedListEmpty() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(1), "Invalid position");
  }

  @Test
  public void removeIndexOne() {
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getTail().getData());
    Assertions.assertEquals(2, linkedList.remove(1));
    Assertions.assertEquals(2, linkedList.getSize());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getData());
  }

  @Test
  public void removeIndexTwo() {
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addLast(5);
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals(3, linkedList.remove(2));
    Assertions.assertEquals(4, linkedList.getHead().getNext().getNext().getData());
    Assertions.assertEquals(2, linkedList.getTail().getPrevious().getPrevious().getData());
    Assertions.assertEquals(4, linkedList.getSize());
  }
}