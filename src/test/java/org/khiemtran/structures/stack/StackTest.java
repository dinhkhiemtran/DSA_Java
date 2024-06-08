package org.khiemtran.structures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khiemtran.structures.stack.Stack;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class StackTest {
  @Test
  public void getPeek() {
    org.khiemtran.structures.stack.Stack<Object> stack = new org.khiemtran.structures.stack.Stack<>(3);
    NoSuchElementException noSuchElementException = Assertions.assertThrows(NoSuchElementException.class, stack::getPeek);
    Assertions.assertEquals("Stack Underflow.", noSuchElementException.getMessage());
    stack.push(1);
    Assertions.assertEquals(1, stack.getPeek());
    stack.push(2);
    Assertions.assertEquals(2, stack.getPeek());
    stack.push(3);
    Assertions.assertEquals(3, stack.getPeek());
  }

  @Test
  public void addElements() {
    org.khiemtran.structures.stack.Stack<Object> stack = new org.khiemtran.structures.stack.Stack<>(3);
    Assertions.assertEquals(-1, stack.getTop());
    stack.push(1);
    Assertions.assertEquals(0, stack.getTop());
    Assertions.assertEquals(3, stack.getSize());
    stack.push("test");
    Assertions.assertEquals(1, stack.getTop());
    stack.push('t');
    Assertions.assertEquals(2, stack.getTop());
    ArrayIndexOutOfBoundsException exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
        () -> stack.push(2));
    Assertions.assertEquals("Stack Overflow.", exception.getMessage());
    Assertions.assertEquals('t', stack.getPeek());
  }

  @Test
  public void popElement() {
    org.khiemtran.structures.stack.Stack<Object> stack = new org.khiemtran.structures.stack.Stack<>(5);
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
    Assertions.assertEquals(5, stack.getSize());
    Assertions.assertEquals(numbers, stack.pop());
    Assertions.assertEquals('t', stack.pop());
    Assertions.assertEquals("test", stack.pop());
    Assertions.assertEquals(1, stack.pop());
    Assertions.assertEquals(-1, stack.getTop());
    Assertions.assertEquals(5, stack.getSize());
    NoSuchElementException noSuchElementException = Assertions.assertThrows(NoSuchElementException.class, stack::pop);
    Assertions.assertEquals("Stack Underflow.", noSuchElementException.getMessage());
  }

  @Test
  public void display() {
    org.khiemtran.structures.stack.Stack<Object> stack = new Stack<>(5);
    AtomicInteger atomicInteger = new AtomicInteger(1);
    stack.push(atomicInteger.getAndIncrement());
    stack.push(atomicInteger.getAndIncrement());
    stack.push(atomicInteger.getAndIncrement());
    stack.push(atomicInteger.getAndIncrement());
    stack.push(atomicInteger.getAndIncrement());
    stack.display();
  }
}