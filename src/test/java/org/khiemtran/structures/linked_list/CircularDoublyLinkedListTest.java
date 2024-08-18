package org.khiemtran.structures.linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khiemtran.structures.linked_list.model.CircularDoublyLinkedList;

import java.util.*;

class CircularDoublyLinkedListTest {
  private final CircularDoublyLinkedList<Object> linkedList = new CircularDoublyLinkedList<>();

  @Test
  public void displayNullPointerException() {
    Assertions.assertThrows(NoSuchElementException.class, linkedList::display, "Linked list has no elements");
  }

  @Test
  public void checkAddOnlyElement() {
    Assertions.assertTrue(linkedList.add(1));
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void checkAddElements() {
    Assertions.assertTrue(linkedList.add(1));
    Assertions.assertTrue(linkedList.add("test"));
    Assertions.assertTrue(linkedList.add('t'));
    Assertions.assertTrue(linkedList.add(Arrays.asList(1, 2, 3)));
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "1");
    map.put(2, "2");
    map.put(3, "3");
    Assertions.assertTrue(linkedList.add(map));
    Assertions.assertEquals(5, linkedList.getSize());
  }

  @Test
  public void addOnlyElement() {
    Assertions.assertEquals(0, linkedList.getSize());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertNull(linkedList.getTail());
    linkedList.addLast(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void addLastOnlyElement() {
    Assertions.assertEquals(0, linkedList.getSize());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertNull(linkedList.getTail());
    linkedList.addFirst(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void addElements() {
    linkedList.addLast(1);
    linkedList.addLast("test");
    linkedList.addLast('t');
    List<Integer> numbers = Arrays.asList(1, 2, 3);
    linkedList.addLast(numbers);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "1");
    map.put(2, "2");
    map.put(3, "3");
    linkedList.addLast(map);
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(map, linkedList.getTail().getData());
    Assertions.assertEquals(numbers, linkedList.getTail().getPrevious().getData());
    Assertions.assertEquals("test", linkedList.getHead().getNext().getData());
    Assertions.assertEquals('t', linkedList.getTail().getPrevious().getPrevious().getData());
    linkedList.display();
  }

  @Test
  public void addFirstElements() {
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
    linkedList.display();
  }

  @Test
  public void insertIndexOUtOfBoundException() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(0, 1), "Invalid position");
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-1, 1), "Invalid position");
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(1, 1), "Invalid position");
  }

  @Test
  public void insertElement() {
    linkedList.addFirst(1);
    linkedList.addLast(5);
    linkedList.add(1, 2);
    linkedList.add(2, 3);
    linkedList.add(3, 4);
    linkedList.display();
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(5, linkedList.getTail().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(4, linkedList.getTail().getPrevious().getData());
    Assertions.assertEquals(5, linkedList.getSize());
  }

  @Test
  public void checkRemoveWhenLinkedListEmpty() {
    Assertions.assertFalse(linkedList.remove());
  }

  @Test
  public void checkRemoveOnlyElement() {
    linkedList.add(1);
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertFalse(linkedList.remove());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertNull(linkedList.getTail());
  }

  @Test
  public void checkRemoveElements() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getTail().getData());
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void removeLastElementWhenLinkedListEmpty() {
    Assertions.assertThrows(NoSuchElementException.class, linkedList::removeLast, "Linked list empty.");
  }

  @Test
  public void removeLastOnlyElement() {
    linkedList.addLast(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getTail().getData());
    Assertions.assertEquals(1, linkedList.removeLast());
    Assertions.assertEquals(0, linkedList.getSize());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertNull(linkedList.getTail());
  }

  @Test
  public void removeLastElements() {
    linkedList.addLast(1);
    linkedList.addLast("test");
    linkedList.addLast('t');
    List<Integer> numbers = Arrays.asList(1, 2, 3);
    linkedList.addLast(numbers);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "1");
    map.put(2, "2");
    map.put(3, "3");
    linkedList.addLast(map);
    Assertions.assertEquals(map, linkedList.removeLast());
    Assertions.assertEquals(numbers, linkedList.getTail().getData());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(4, linkedList.getSize());
    Assertions.assertEquals(numbers, linkedList.removeLast());
    Assertions.assertEquals('t', linkedList.removeLast());
  }

  @Test
  public void removeFirstWhenLinkedListEmpty() {
    Assertions.assertThrows(NoSuchElementException.class, linkedList::removeHead, "Linked List is empty.");
  }

  @Test
  public void removeFirstOnlyElement() {
    linkedList.addLast(1);
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.removeHead());
    Assertions.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void removeFirstElements() {
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.removeHead());
    Assertions.assertEquals(2, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(3, linkedList.getTail().getData());
    Assertions.assertEquals(2, linkedList.getTail().getPrevious().getData());
    Assertions.assertEquals(2, linkedList.getSize());
    Assertions.assertEquals(2, linkedList.removeHead());
    Assertions.assertEquals(3, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getTail().getData());
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void removeIndexOutOfBound() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(-1), "Invalid position");
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(0), "Invalid position");
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(1), "Invalid position");
  }

  @Test
  public void removeIndexElements() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(5);
    Assertions.assertEquals(2, linkedList.remove(1));
    Assertions.assertEquals(4, linkedList.remove(2));
    Assertions.assertEquals(3, linkedList.remove(1));
    Assertions.assertEquals(5, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(1, linkedList.getTail().getPrevious().getData());
    Assertions.assertEquals(2, linkedList.getSize());
  }
}