package org.khiemtran.structures.tree.service;

import org.khiemtran.structures.tree.Node;

public interface TreeMetrics<T> {
  int getMaxDepth(Node<T> node);

  int getMaxHeight(Node<T> node);

  int countNodes(Node<T> node);

  boolean isFullBinaryTree(Node<T> node);

  boolean isPerfectBinaryTree(Node<T> node);

  boolean isCompleteBinaryTree(Node<T> node);

  boolean isBalancedBinaryTree(Node<T> node);
}
