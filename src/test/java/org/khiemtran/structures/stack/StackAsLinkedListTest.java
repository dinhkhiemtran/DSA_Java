package org.khiemtran.structures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

class StackAsLinkedListTest {
  @Test
  public void addDataIntoStackAsLinkedList() {
    StackAsLinkedList<Object> stack = new StackAsLinkedList<>();
    stack.push(1);
    Assertions.assertEquals(1, stack.getPeek().getData());
    Assertions.assertEquals(1, stack.getSize());
    stack.push(2);
    Assertions.assertEquals(2, stack.getPeek().getData());
    Assertions.assertEquals(1, stack.getPeek().getPrevious().getData());
    stack.push(3);
    Assertions.assertEquals(3, stack.getPeek().getData());
    Assertions.assertEquals(2, stack.getPeek().getPrevious().getData());
    Assertions.assertEquals(3, stack.getSize());
    stack.display();
  }

  @Test
  public void popData() {
    StackAsLinkedList<Object> stack = new StackAsLinkedList<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    Assertions.assertEquals(3, stack.pop());
    Assertions.assertEquals(2, stack.getPeek().getData());
    Assertions.assertEquals(2, stack.getSize());
    Assertions.assertEquals(2, stack.pop());
    Assertions.assertEquals(1, stack.getPeek().getData());
    Assertions.assertEquals(1, stack.pop());
    Assertions.assertEquals(0, stack.getSize());
    Assertions.assertNull(stack.getPeek());
    NoSuchElementException noSuchElementException = Assertions.assertThrows(NoSuchElementException.class, stack::pop);
    Assertions.assertEquals("Stack Underflow.", noSuchElementException.getMessage());
  }

  @Test
  public void display() {
    StackAsLinkedList<Object> stack = new StackAsLinkedList<>();
    stack.push(1);
    stack.push("test");
    stack.push('t');
    stack.push(Arrays.asList(1,2,3));
    HashMap<Integer, String> map = new HashMap<>();
    map.put(1, "one");
    map.put(2, "two");
    map.put(3, "three");
    stack.push(map);
    stack.display();
  }
}