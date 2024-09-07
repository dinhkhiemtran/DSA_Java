package org.khiemtran.structures.heap;

import org.junit.jupiter.api.Test;

class HeapTest {
  @Test
  public void testHeap() {
    int[] array = {3, 9, 2, 1, 4, 5};
    HeapOperations heapOperation = new Heapify();
    Heap heap = new Heap(array, heapOperation);
    heap.buildMinHeap();
    heap.display();
    heap.buildMaxHeap();
    heap.display();
  }
}