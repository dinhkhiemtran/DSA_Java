package org.khiemtran.structures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class StackTest {
  @Test
  public void testPeekEmpty() {
    Stack<Integer> stack = new Stack<>();
    Assertions.assertThrows(EmptyStackException.class, stack::getPeek);
  }

  @Test
  public void getPeek() {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    Assertions.assertEquals(3, stack.getPeek());
    Assertions.assertEquals("1,2,3", stack.display());
  }

  @Test
  public void pushElement() {
    Stack<Integer> stack = new Stack<>();
    for (int i = 1; i <= 16; i++) {
      stack.push(i);
    }
    Assertions.assertEquals(16, stack.getPeek());
    Assertions.assertEquals(16, stack.getSize());
    for (int i = 17; i <= 20; i++) {
      stack.push(i);
    }
    Assertions.assertEquals(20, stack.getPeek());
    Assertions.assertEquals(20, stack.getSize());
  }

  @Test
  public void emptyStack() {
    Stack<Integer> stack = new Stack<>();
    Assertions.assertThrows(EmptyStackException.class, stack::pop);
  }

  @Test
  public void popElement() {
    Stack<Object> stack = new org.khiemtran.structures.stack.Stack<>();
    stack.push(1);
    stack.push("test");
    stack.push('t');
    List<Integer> numbers = Arrays.asList(1, 2, 3);
    stack.push(numbers);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "one");
    map.put(2, "two");
    map.put(3, "three");
    stack.push(map);
    Assertions.assertEquals(map, stack.pop());
    Assertions.assertEquals(3, stack.getTop());
    Assertions.assertEquals(numbers, stack.pop());
    Assertions.assertEquals('t', stack.pop());
    Assertions.assertEquals("test", stack.pop());
    Assertions.assertEquals(1, stack.pop());
    Assertions.assertEquals(-1, stack.getTop());
    Assertions.assertThrows(EmptyStackException.class, stack::pop);
  }

  @Test
  public void testPushAll() {
    Stack<Object> stack = new Stack<>();
    List<Object> list = new LinkedList<>();
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "one");
    map.put(2, "two");
    map.put(3, "three");
    list.add(1);
    list.add("test");
    list.add(map);
    list.add('t');
    stack.pushAll(list);
    Assertions.assertEquals('t', stack.getPeek());
    Assertions.assertEquals(4, stack.getSize());
  }

  @Test
  public void testPopAll() {
    Stack<Integer> stack = new Stack<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 1; i <= 5; i++) {
      stack.push(i);
    }
    List<Integer> reverseNumbers = new ArrayList<>();
    stack.popAll(reverseNumbers);
    for (Integer number : reverseNumbers) {
      stringBuilder.append(number);
    }
    Assertions.assertEquals("54321", stringBuilder.toString());
    Assertions.assertThrows(EmptyStackException.class, stack::pop);
    Assertions.assertEquals(0, stack.getSize());
  }
}