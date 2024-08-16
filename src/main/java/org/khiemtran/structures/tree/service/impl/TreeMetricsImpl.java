package org.khiemtran.structures.tree.service.impl;

import org.khiemtran.structures.tree.Node;
import org.khiemtran.structures.tree.service.TreeMetrics;

public class TreeMetricsImpl<T> implements TreeMetrics<T> {
  @Override
  public int getMaxDepth(Node<T> node) {
    if (node == null) {
      return 0;
    } else {
      int leftDepth = getMaxDepth(node.getLeft());
      int rightDepth = getMaxDepth(node.getRight());
      return Math.max(leftDepth, rightDepth) + 1;
    }
  }

  @Override
  public int getMaxHeight(Node<T> node) {
    return 0;
  }

  @Override
  public int countNodes(Node<T> node) {
    if (node == null) {
      return 0;
    }
    return countNodes(node.getLeft()) + countNodes(node.getRight()) + 1;
  }

  @Override
  public boolean isFullBinaryTree(Node<T> node) {
    if (node == null) {
      return true;
    }
    if (node.getLeft() == null && node.getRight() == null) {
      return true;
    }
    if (node.getLeft() != null && node.getRight() != null) {
      return isFullBinaryTree(node.getLeft()) && isFullBinaryTree(node.getRight());
    }
    return false;
  }

  @Override
  public boolean isPerfectBinaryTree(Node<T> node) {
    int depth = getMaxDepth(node);
    return checkPerfectTree(node, depth, 0);
  }

  @Override
  public boolean isCompleteBinaryTree(Node<T> node) {
    int numNodes = countNodes(node);
    return checkCompleteTree(node, 0, numNodes);
  }

  private boolean checkCompleteTree(Node<T> node, int index, int numNodes) {
    if (node == null) {
      return true;
    }
    if (index >= numNodes) {
      return false;
    }
    return checkCompleteTree(node.getLeft(), 2 * index + 1, numNodes)
        && checkCompleteTree(node.getRight(), 2 * index + 2, numNodes);
  }

  private boolean checkPerfectTree(Node<T> root, int depth, int level) {
    if (root == null)
      return true;
    if (root.getLeft() == null && root.getRight() == null)
      return depth == level + 1;
    if (root.getLeft() == null || root.getRight() == null)
      return false;
    return checkPerfectTree(root.getLeft(), depth, level + 1) && checkPerfectTree(root.getRight(), depth, level + 1);
  }
}
