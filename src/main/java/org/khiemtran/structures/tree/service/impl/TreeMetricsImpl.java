package org.khiemtran.structures.tree.service.impl;

import org.khiemtran.structures.tree.Node;
import org.khiemtran.structures.tree.service.TreeMetrics;

public class TreeMetricsImpl<T> implements TreeMetrics<T> {
  public int getMaxDepth(Node<T> node) {
    if (node == null) {
      return 0;
    } else {
      return Math.max(getMaxDepth(node.getLeft()), getMaxDepth(node.getRight())) + 1;
    }
  }

  public int getMaxHeight(Node<T> node) {
    if (node == null) {
      return 0;
    } else {
      return Math.max(getMaxHeight(node.getLeft()), getMaxHeight(node.getRight())) + 1;
    }
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

  @Override
  public boolean isBalancedBinaryTree(Node<T> node) {
    return checkHeight(node) != -1;
  }

  private int checkHeight(Node<T> node) {
    if (node == null) {
      return 0;
    }
    int leftHeight = checkHeight(node.getLeft());
    if (leftHeight == -1) {
      return -1;
    }
    int rightHeight = checkHeight(node.getRight());
    if (rightHeight == -1) {
      return -1;
    }
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
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
