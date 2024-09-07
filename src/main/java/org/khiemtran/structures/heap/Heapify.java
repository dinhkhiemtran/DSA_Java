package org.khiemtran.structures.heap;

/**
 * Implementation of heap operations for building and maintaining heaps.
 */
public class Heapify implements HeapOperations {
  @Override
  public void buildMaxHeap(int[] array) {
    int size = array.length;
    for (int i = size / 2 - 1; i >= 0; i--) {
      heapify(array, size, i, true);
    }
  }

  @Override
  public void buildMinHeap(int[] array) {
    int n = array.length;
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(array, n, i, false);
    }
  }

  /**
   * Heapifies a subtree rooted at index i.
   *
   * @param array   The array representing the heap.
   * @param size    The size of the heap.
   * @param i       The index of the root of the subtree.
   * @param maxHeap Whether to perform max-heapification or min-heapification.
   */
  protected void heapify(int[] array, int size, int i, boolean maxHeap) {
    int extremum = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (maxHeap) {
      if (left < size && array[left] > array[extremum]) {
        extremum = left;
      }
      if (right < size && array[right] > array[extremum]) {
        extremum = right;
      }
    } else {
      if (left < size && array[left] < array[extremum]) {
        extremum = left;
      }
      if (right < size && array[right] < array[extremum]) {
        extremum = right;
      }
    }
    if (extremum != i) {
      int swap = array[i];
      array[i] = array[extremum];
      array[extremum] = swap;
      heapify(array, size, extremum, maxHeap);
    }
  }
}
