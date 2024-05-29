package org.khiemtran.structures.linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class CircularSinglyLinkedListTest {
  private final CircularSinglyLinkedList<Object> linkedList = new CircularSinglyLinkedList<>();

  @Test
  public void addOnlyOneElement() {
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertEquals(0, linkedList.getSize());
    linkedList.addLast(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void checkAddElements() {
    Assertions.assertTrue(linkedList.add(1));
    Assertions.assertTrue(linkedList.add("test"));
    Assertions.assertTrue(linkedList.add(Arrays.asList(1, 2, 3)));
  }

  @Test
  public void addElements() {
    linkedList.addLast(1);
    linkedList.addLast("test");
    linkedList.addLast('t');
    linkedList.addLast(Arrays.asList(1, 2, 3));
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "1");
    map.put(2, "2");
    map.put(3, "3");
    linkedList.addLast(map);
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    CircularSinglyLinkedList.Node<Object> current = linkedList.getHead();
    while (current.getNext() != linkedList.getHead()) {
      current = current.getNext();
    }
    Assertions.assertEquals(map, current.getData());
    linkedList.display();
  }

  @Test
  public void addFirstOnlyElement() {
    linkedList.addFirst(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void addElementsFirst() {
    linkedList.addLast(3);
    linkedList.addFirst(2);
    linkedList.addFirst(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(3, linkedList.getSize());
    linkedList.display();
  }

  @Test
  public void checkRemoveWhenLinkedListNoElement() {
    Assertions.assertFalse(linkedList.remove());
  }

  @Test
  public void checkRemoveOnlyElement() {
    linkedList.add(1);
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertThrows(NoSuchElementException.class, linkedList::display, "Linked list has no element");
  }

  @Test
  public void checkRemoveElements() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(5);
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertTrue(linkedList.remove());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(2, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getNext().getNext().getData());
  }

  @Test
  public void removeWhenLinkedListEmpty() {
    Assertions.assertThrows(NoSuchElementException.class, linkedList::removeLast, "Linked list has no elements");
  }

  @Test
  public void removeOnlyOneElement() {
    linkedList.addLast(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.removeLast());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void removeElements() {
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
    Assertions.assertEquals(1, linkedList.removeLast());
    Assertions.assertEquals(4, linkedList.getSize());
    Assertions.assertEquals("test", linkedList.removeLast());
    Assertions.assertEquals('t', linkedList.removeLast());
    Assertions.assertEquals(numbers, linkedList.removeLast());
    Assertions.assertEquals(map, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void removeFirstWhenLinkedListHasNoElement() {
    Assertions.assertThrows(NoSuchElementException.class, linkedList::removeFirst, "Linked list has no elements.");
  }

  @Test
  public void removeFirstOnyElement() {
    linkedList.add(1);
    Assertions.assertEquals(1, linkedList.removeFirst());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void removeFirstElements() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(5);
    Assertions.assertEquals(1, linkedList.removeFirst());
    Assertions.assertEquals(2, linkedList.removeFirst());
    Assertions.assertEquals(3, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getSize());
  }

  @Test
  public void insertOutOfSizeLinkedList() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-1, -1), "Invalid position.");
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(0, 1), "Invalid position.");
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(1, 1), "Invalid position.");
  }

  @Test
  public void insertIndexOne() {
    linkedList.addLast(1);
    linkedList.addLast(3);
    linkedList.add(1, 2);
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(3, 4), "Invalid position.");
  }

  @Test
  public void insertElements() {
    linkedList.addLast(1);
    linkedList.addLast(5);
    linkedList.add(1, 2);
    linkedList.add(2, 3);
    linkedList.add(3, 4);
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getNext().getData());
    Assertions.assertEquals(4, linkedList.getHead().getNext().getNext().getNext().getData());
  }

  @Test
  public void removeIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.remove(0), "Invalid position.");
    Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.remove(-1), "Invalid position.");
    linkedList.addLast(1);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(-1), "Invalid position");
  }

  @Test
  public void removeIndexOne() {
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    Assertions.assertEquals(2, linkedList.remove(1));
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getData());
    linkedList.display();
  }

  @Test
  public void removeIndexTwo() {
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addLast(5);
    Assertions.assertEquals(3, linkedList.remove(2));
    Assertions.assertEquals(4, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(4, linkedList.getHead().getNext().getNext().getData());
  }
}