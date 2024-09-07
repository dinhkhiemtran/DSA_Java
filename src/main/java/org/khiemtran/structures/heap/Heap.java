package org.khiemtran.structures.heap;

/**
 * Represents a heap data structure, allowing the construction and display
 * of min-heaps and max-heaps.
 */
public class Heap {
  private final int[] elements;
  private final HeapOperations operations;

  /**
   * Constructs a Heap instance with the specified array and heap operations.
   *
   * @param elements The array to be used for the heap.
   * @param operations The heap operations implementation to perform.
   */
  public Heap(int[] elements, HeapOperations operations) {
    if (elements == null || operations == null) {
      throw new IllegalArgumentException("Elements array and HeapOperations cannot be null");
    }
    this.elements = elements.clone();
    this.operations = operations;
  }

  /**
   * Builds a min-heap from the array.
   */
  public void buildMinHeap() {
    operations.buildMinHeap(elements);
  }

  /**
   * Builds a max-heap from the array.
   */
  public void buildMaxHeap() {
    operations.buildMaxHeap(elements);
  }

  /**
   * Displays the elements of the heap.
   */
  public void display() {
    for (int i = 0; i < elements.length; i++) {
      System.out.print(elements[i]);
      if (i < elements.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println();
  }
}
