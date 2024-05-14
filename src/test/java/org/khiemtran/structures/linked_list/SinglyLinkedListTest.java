package org.khiemtran.structures.linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class SinglyLinkedListTest {
  private final SinglyLinkedList<Object> linkedList = new SinglyLinkedList<>();

  @Test
  public void checkHeadNullAndSizeZero() {
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void addAllTypes() {
    linkedList.add(1);
    linkedList.add("Test");
    linkedList.add('t');
    linkedList.add(Arrays.asList(1, 2, 3));
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "1");
    map.put(2, "2");
    linkedList.add(map);
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
  public void removeEmptyElement() {
    Assertions.assertThrows(IllegalArgumentException.class, linkedList::remove,
        "Linked list is empty");
  }

  @Test
  public void removeOneElement() {
    linkedList.add(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.remove());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertEquals(0, linkedList.getSize());
  }

  @Test
  public void removeMultipleElement() {
    linkedList.add(1);
    linkedList.add("Test");
    linkedList.add('t');
    List<Integer> list = Arrays.asList(1, 2, 3);
    linkedList.add(list);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "1");
    map.put(2, "2");
    linkedList.add(map);
    Assertions.assertEquals(map, linkedList.remove());
    Assertions.assertEquals(list, linkedList.remove());
    Assertions.assertEquals('t', linkedList.remove());
    Assertions.assertEquals("Test", linkedList.remove());
    Assertions.assertEquals(1, linkedList.remove());
    Assertions.assertEquals(0, linkedList.getSize());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertThrows(IllegalArgumentException.class, linkedList::remove, "Linked list is empty");
  }

  @Test
  public void insertPositionNegative() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.insert(1, -1),
        "Invalid position.");
  }

  @Test
  public void insertIndexZero() {
    linkedList.insert("test", 0);
    Assertions.assertEquals("test", linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertNull(linkedList.getHead().getNext());
    linkedList.insert(1, 0);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals("test", linkedList.getHead().getNext().getData());
    Assertions.assertEquals(2, linkedList.getSize());
  }

  @Test
  public void insertIndexOne() {
    linkedList.add(1);
    linkedList.add(3);
    linkedList.insert(2, 1);
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getNext().getData());
  }

  @Test
  public void insertIndexTwo() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(4);
    linkedList.add(5);
    linkedList.insert(3, 2);
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
  public void removeIndexNegativeAndOutOfBound() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.remove(-1),
        "Invalid position");
    linkedList.add(1);
    Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.remove(2),
        "Invalid position");
  }

  @Test
  public void removeIndexWhenLinkedListEmpty() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> linkedList.remove(0), "Linked list is empty");
  }

  @Test
  public void removeIndexZero() {
    linkedList.add(1);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(1, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.remove(0));
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertEquals(0, linkedList.getSize());
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.remove(0));
    Assertions.assertEquals(2, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(2, linkedList.getSize());
  }

  @Test
  public void removeIndexOne() {
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(3, linkedList.getSize());
    Assertions.assertEquals(2, linkedList.remove(1));
    Assertions.assertEquals(2, linkedList.getSize());
    Assertions.assertEquals(1, linkedList.getHead().getData());
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
    Assertions.assertEquals(1, linkedList.getHead().getData());
    Assertions.assertEquals(2, linkedList.getHead().getNext().getData());
    Assertions.assertEquals(4, linkedList.getHead().getNext().getNext().getData());
    Assertions.assertEquals(5, linkedList.getHead().getNext().getNext().getNext().getData());
    Assertions.assertEquals(4, linkedList.getSize());
  }
}