package org.khiemtran.structures.linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CircularSinglyLinkedListTest {
  private final CircularSinglyLinkedList<Object> linkedList = new CircularSinglyLinkedList<>();

  @Test
  public void addOnlyOneElement() {
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertEquals(0, linkedList.getSize());
    linkedList.add(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void addElements() {
    linkedList.add(1);
    linkedList.add("test");
    linkedList.add('t');
    linkedList.add(Arrays.asList(1, 2, 3));
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "1");
    map.put(2, "2");
    map.put(3, "3");
    linkedList.add(map);
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
  public void removeWhenLinkedListEmpty() {
    Assertions.assertThrows(IllegalArgumentException.class, linkedList::remove, "Linked List is empty");
  }

  @Test
  public void removeOnlyOneElement() {
    linkedList.add(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.remove());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void removeElements() {
    linkedList.add(1);
    linkedList.add("test");
    linkedList.add('t');
    List<Integer> numbers = Arrays.asList(1, 2, 3);
    linkedList.add(numbers);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "1");
    map.put(2, "2");
    map.put(3, "3");
    linkedList.add(map);
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.remove());
    Assertions.assertEquals(4, linkedList.getSize());
    Assertions.assertEquals("test", linkedList.remove());
    Assertions.assertEquals('t', linkedList.remove());
    Assertions.assertEquals(numbers, linkedList.remove());
    Assertions.assertEquals(map, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void insertOutOfSizeLinkedList() {
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.insert(1, -1), "Invalid position.");
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.insert(1, 0), "Invalid position.");
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.insert(1, 1), "Invalid position.");
  }

  @Test
  public void insertIndexZero() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.insert(0, 0);
    Assertions.assertEquals(0, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getSize());
  }

  @Test
  public void insertIndexOne() {
    linkedList.add(1);
    linkedList.add(3);
    linkedList.insert(2, 1);
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.insert(4, 3), "Invalid position.");
  }

  @Test
  public void insertElements() {
    linkedList.add(1);
    linkedList.add(5);
    linkedList.insert(2, 1);
    linkedList.insert(3, 2);
    linkedList.insert(4, 3);
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getNext().getData());
    Assertions.assertEquals(4, linkedList.getHead().getNext().getNext().getNext().getData());
  }

  @Test
  public void removeIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.remove(0), "Invalid position.");
    Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.remove(-1), "Invalid position.");
    linkedList.add(1);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(-1), "Invalid position");
  }

  @Test
  public void removeIndexZeroOnlyElement() {
    linkedList.add(1);
    Assertions.assertEquals(1, linkedList.remove(0));
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void removeIndexZero() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    Assertions.assertEquals(1, linkedList.remove(0));
    Assertions.assertEquals(2, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getSize());
    linkedList.display();
  }

  @Test
  public void removeIndexOne() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    Assertions.assertEquals(2, linkedList.remove(1));
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getData());
    linkedList.display();
  }

  @Test
  public void removeIndexTwo() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(5);
    Assertions.assertEquals(3, linkedList.remove(2));
    Assertions.assertEquals(4, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(4, linkedList.getHead().getNext().getNext().getData());
  }
}