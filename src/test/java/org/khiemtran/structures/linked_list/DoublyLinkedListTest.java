package org.khiemtran.structures.linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DoublyLinkedListTest {
  private DoublyLinkedList<Object> linkedList = new DoublyLinkedList<>();

  @Test
  public void addElementWhenEmpty() {
    linkedList.add(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getTail().getData());
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertNull(linkedList.getHead().getPrevious());
    Assertions.assertNull(linkedList.getTail().getPrevious());
    linkedList.display();
  }

  @Test
  public void addMultipleElements() {
    linkedList.add(1);
    linkedList.add("test");
    linkedList.add('t');
    List<Integer> list = Arrays.asList(1, 2, 3);
    linkedList.add(list);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "test");
    map.put(2, "test1");
    linkedList.add(map);
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals("test", linkedList.getHead().getNext().getData());
    Assertions.assertEquals(map, linkedList.getTail().getData());
    Assertions.assertEquals(list, linkedList.getTail().getPrevious().getData());
    linkedList.display();
  }

  @Test
  public void removeWhenLLEmpty() {
    Assertions.assertThrows(IllegalArgumentException.class, linkedList::remove, "Linked list is empty");
  }

  @Test
  public void removeOnlyElement() {
    linkedList.add(1);
    Assertions.assertEquals(1, linkedList.remove());
    Assertions.assertEquals(0, linkedList.getSize());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertNull(linkedList.getTail());
  }

  @Test
  public void removeMultipleElement() {
    linkedList.add(1);
    linkedList.add("test");
    List<Character> letters = Arrays.asList('a', 'b', 'c');
    linkedList.add(letters);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "some");
    map.put(2, "thing");
    linkedList.add(map);
    linkedList.add('t');
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals('t', linkedList.remove());
    Assertions.assertEquals(map, linkedList.getTail().getData());
    Assertions.assertEquals(4, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(map, linkedList.remove());
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(letters, linkedList.getTail().getData());
    Assertions.assertEquals("test", linkedList.getTail().getPrevious().getData());
    Assertions.assertEquals(letters, linkedList.remove());
    Assertions.assertEquals("test", linkedList.getTail().getData());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals("test", linkedList.remove());
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getTail().getData());
    linkedList.display();
  }

  @Test
  public void insertIndexNegative() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.insert(1, -1), "Invalid position");
  }

  @Test
  public void insertIndexZero() {
    linkedList.add(1);
    linkedList.insert(0, 0);
    Assertions.assertEquals(0, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getTail().getData());
    Assertions.assertEquals(2, linkedList.getSize());
    linkedList.insert(-1, 0);
    Assertions.assertEquals(-1, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getSize());
  }

  @Test
  public void insertIndexOne() {
    linkedList.add(1);
    linkedList.add(3);
    linkedList.insert(2, 1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(3, linkedList.getTail().getData());
    Assertions.assertEquals(3, linkedList.getSize());
  }

  @Test
  public void insertIndexTwo() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(4);
    linkedList.add(5);
    Assertions.assertEquals(4, linkedList.getSize());
    linkedList.insert(3, 2);
    Assertions.assertEquals(3, linkedList.getHead().getNext().getNext().getData());
    Assertions.assertEquals(5, linkedList.getTail().getData());
    Assertions.assertEquals(5, linkedList.getSize());
    linkedList.display();
  }

  @Test
  public void addIndexLastPosition() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.insert(3, 2);
    Assertions.assertEquals(3, linkedList.getTail().getData());
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(3, linkedList.getTail().getData());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
  }

  @Test
  public void removeWhenLinkedListEmpty() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.remove(1), "Invalid position");
  }

  @Test
  public void removeIndexZero() {
    linkedList.add(1);
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.remove(0));
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    Assertions.assertEquals(1, linkedList.remove(0));
    Assertions.assertEquals(2, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getTail().getData());
    Assertions.assertEquals(2, linkedList.getSize());
    linkedList.display();
  }

  @Test
  public void removeIndexLastElement() {
    linkedList.add(1);
    linkedList.add(2);
    Assertions.assertEquals(2, linkedList.remove(1));
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getTail().getData());
    Assertions.assertEquals(1, linkedList.getSize());
  }

  @Test
  public void removeIndexOne() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getTail().getData());
    Assertions.assertEquals(2, linkedList.remove(1));
    Assertions.assertEquals(2, linkedList.getSize());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getData());
  }

  @Test
  public void removeIndexTwo() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(5);
    Assertions.assertEquals(5, linkedList.getSize());
    Assertions.assertEquals(3, linkedList.remove(2));
    Assertions.assertEquals(4, linkedList.getHead().getNext().getNext().getData());
    Assertions.assertEquals(2, linkedList.getTail().getPrevious().getPrevious().getData());
    Assertions.assertEquals(4, linkedList.getSize());
  }
}