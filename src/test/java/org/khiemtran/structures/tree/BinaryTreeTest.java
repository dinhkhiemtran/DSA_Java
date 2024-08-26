package org.khiemtran.structures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.khiemtran.structures.tree.service.TraversalTree;
import org.khiemtran.structures.tree.service.TreeMetrics;
import org.khiemtran.structures.tree.service.impl.BinaryTreeTraversalImpl;
import org.khiemtran.structures.tree.service.impl.TreeMetricsImpl;

class BinaryTreeTest {
  private TraversalTree<Integer> traversalTree;
  private TreeMetrics<Integer> metrics;

  @BeforeEach
  public void setUp() {
    this.traversalTree = new BinaryTreeTraversalImpl<>();
    this.metrics = new TreeMetricsImpl<>();
  }

  @Test
  public void travelNodes() {
    Node<Integer> root = new Node<>(0);
    root.setLeft(new Node<>(1));
    root.setRight(new Node<>(2));
    BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
    Assertions.assertEquals(0, binaryTree.getRoot().getData());
    Assertions.assertEquals(1, binaryTree.getRoot().getLeft().getData());
    Assertions.assertEquals(2, binaryTree.getRoot().getRight().getData());
    traversalTree.preorder(binaryTree.getRoot());
    traversalTree.inorder(binaryTree.getRoot());
    traversalTree.postorder(binaryTree.getRoot());
  }

  @Test
  public void isNotFullBinaryTree() {
    Node<Integer> root = new Node<>(0);
    root.setLeft(new Node<>(1));
    root.setRight(new Node<>(2));
    root.getLeft().setLeft(new Node<>(3));
    root.getLeft().setRight(new Node<>(4));
    root.getRight().setLeft(new Node<>(5));
    BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
    Assertions.assertFalse(metrics.isFullBinaryTree(binaryTree.getRoot()));
  }

  @Test
  public void isFullBinaryTree() {
    Node<Integer> root = new Node<>(0);
    root.setLeft(new Node<>(1));
    root.setRight(new Node<>(2));
    root.getLeft().setLeft(new Node<>(3));
    root.getLeft().setRight(new Node<>(4));
    root.getRight().setLeft(new Node<>(5));
    root.getRight().setRight(new Node<>(6));
    BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
    Assertions.assertTrue(metrics.isFullBinaryTree(binaryTree.getRoot()));
  }

  @Test
  public void isNotPerfectBinaryTree() {
    Node<Integer> root = new Node<>(0);
    root.setLeft(new Node<>(1));
    root.setRight(new Node<>(2));
    root.getLeft().setLeft(new Node<>(3));
    root.getLeft().setRight(new Node<>(4));
    BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
    TreeMetrics<Integer> treeMetrics = new TreeMetricsImpl<>();
    boolean isPerfectBinaryTree = treeMetrics.isPerfectBinaryTree(binaryTree.getRoot());
    Assertions.assertFalse(isPerfectBinaryTree);
  }

  @Test
  public void isPerfectBinaryTreeAndFullBinaryTree() {
    Node<Integer> root = new Node<>(0);
    root.setLeft(new Node<>(1));
    root.setRight(new Node<>(2));
    root.getLeft().setLeft(new Node<>(3));
    root.getLeft().setRight(new Node<>(4));
    root.getRight().setLeft(new Node<>(5));
    root.getRight().setRight(new Node<>(6));
    BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
    boolean fullBinaryTree = metrics.isFullBinaryTree(binaryTree.getRoot());
    boolean perfectBinaryTree = metrics.isPerfectBinaryTree(binaryTree.getRoot());
    Assertions.assertTrue(fullBinaryTree);
    Assertions.assertTrue(perfectBinaryTree);
  }

  @Test
  public void isNotCompleteBinaryTree() {
    Node<Integer> root = new Node<>(1);
    root.setLeft(new Node<>(2));
    root.setRight(new Node<>(3));
    root.getLeft().setLeft(new Node<>(6));
    root.getLeft().setRight(new Node<>(4));
    root.getRight().setRight(new Node<>(5));
    BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
    boolean completeBinaryTree = metrics.isCompleteBinaryTree(binaryTree.getRoot());
    Assertions.assertFalse(completeBinaryTree);
  }

  @Test
  public void isFullButNotCompleteBinaryTree() {
    Node<Integer> root = new Node<>(1);
    root.setLeft(new Node<>(2));
    root.setRight(new Node<>(3));
    root.getRight().setLeft(new Node<>(6));
    root.getRight().setRight(new Node<>(4));
    BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
    boolean fullBinaryTree = metrics.isFullBinaryTree(binaryTree.getRoot());
    boolean completeBinaryTree = metrics.isCompleteBinaryTree(binaryTree.getRoot());
    Assertions.assertTrue(fullBinaryTree);
    Assertions.assertFalse(completeBinaryTree);
  }

  @Test
  public void isCompleteBinaryTreeNotFullBinaryTree() {
    Node<Integer> root = new Node<>(1);
    root.setLeft(new Node<>(2));
    root.getLeft().setLeft(new Node<>(6));
    root.setRight(new Node<>(3));
    BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
    boolean fullBinaryTree = metrics.isFullBinaryTree(binaryTree.getRoot());
    boolean completeBinaryTree = metrics.isCompleteBinaryTree(binaryTree.getRoot());
    Assertions.assertFalse(fullBinaryTree);
    Assertions.assertTrue(completeBinaryTree);
  }

  @Test
  public void isNotBalancedBinaryTree() {
    Node<Integer> root = new Node<>(1);
    root.setLeft(new Node<>(2));
    root.setRight(new Node<>(3));
    root.getLeft().setLeft(new Node<>(4));
    root.getLeft().setRight(new Node<>(5));
    root.getLeft().getRight().setRight(new Node<>(6));
    BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
    boolean balancedBinaryTree = metrics.isBalancedBinaryTree(binaryTree.getRoot());
    Assertions.assertFalse(balancedBinaryTree);
  }

  @Test
  public void isBalancedBinaryTree() {
    Node<Integer> root = new Node<>(1);
    root.setLeft(new Node<>(2));
    root.setRight(new Node<>(3));
    root.getLeft().setLeft(new Node<>(4));
    root.getLeft().setRight(new Node<>(5));
    BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
    boolean balancedBinaryTree = metrics.isBalancedBinaryTree(binaryTree.getRoot());
    Assertions.assertTrue(balancedBinaryTree);
  }
}