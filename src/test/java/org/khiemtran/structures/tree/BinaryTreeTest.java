package org.khiemtran.structures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.khiemtran.structures.tree.service.impl.BinaryTreeTraversalImpl;
import org.khiemtran.structures.tree.service.impl.TreeMetricsImpl;
import org.khiemtran.structures.tree.service.TraversalTree;
import org.khiemtran.structures.tree.service.TreeMetrics;

class BinaryTreeTest {
  private TraversalTree<Integer> traversalTree;

  @BeforeEach
  public void setUp() {
    this.traversalTree = new BinaryTreeTraversalImpl<>();
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
    TreeMetrics<Integer> treePropertiesChecker = new TreeMetricsImpl<>();
    Assertions.assertFalse(treePropertiesChecker.isFullBinaryTree(binaryTree.getRoot()));
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
    BinaryTreeTraversalImpl<Integer> treeTraversal = new BinaryTreeTraversalImpl<>();
    TreeMetrics<Integer> treePropertiesChecker = new TreeMetricsImpl<>();
    Assertions.assertTrue(treePropertiesChecker.isFullBinaryTree(binaryTree.getRoot()));
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
    TreeMetrics<Integer> treeMetrics = new TreeMetricsImpl<>();
    boolean fullBinaryTree = treeMetrics.isFullBinaryTree(binaryTree.getRoot());
    boolean perfectBinaryTree = treeMetrics.isPerfectBinaryTree(binaryTree.getRoot());
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
    TreeMetrics<Integer> treeMetrics = new TreeMetricsImpl<>();
    boolean completeBinaryTree = treeMetrics.isCompleteBinaryTree(binaryTree.getRoot());
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
    TreeMetrics<Integer> treeMetrics = new TreeMetricsImpl<>();
    boolean fullBinaryTree = treeMetrics.isFullBinaryTree(binaryTree.getRoot());
    boolean completeBinaryTree = treeMetrics.isCompleteBinaryTree(binaryTree.getRoot());
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
    TreeMetrics<Integer> treeMetrics = new TreeMetricsImpl<>();
    boolean fullBinaryTree = treeMetrics.isFullBinaryTree(binaryTree.getRoot());
    boolean completeBinaryTree = treeMetrics.isCompleteBinaryTree(binaryTree.getRoot());
    Assertions.assertFalse(fullBinaryTree);
    Assertions.assertTrue(completeBinaryTree);
  }
}