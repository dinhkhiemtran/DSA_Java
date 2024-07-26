package org.khiemtran.structures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {
  @Test
  public void addNode() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>();
    binaryTree.setRoot(new Node<>(0));
    binaryTree.getRoot().setLeft(new Node<>(1));
    binaryTree.getRoot().setRight(new Node<>(2));
    Assertions.assertEquals(0, binaryTree.getRoot().getData());
    Assertions.assertEquals(1, binaryTree.getRoot().getLeft().getData());
    Assertions.assertEquals(2, binaryTree.getRoot().getRight().getData());
    binaryTree.preorder(binaryTree.getRoot());
    binaryTree.inorder(binaryTree.getRoot());
    binaryTree.postorder(binaryTree.getRoot());
  }

  @Test
  public void notFullBinaryTree() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>();
    binaryTree.setRoot(new Node<>(0));
    binaryTree.getRoot().setLeft(new Node<>(1));
    binaryTree.getRoot().setRight(new Node<>(2));
    binaryTree.getRoot().getLeft().setLeft(new Node<>(3));
    binaryTree.getRoot().getLeft().setRight(new Node<>(4));
    binaryTree.getRoot().getRight().setLeft(new Node<>(5));
    Assertions.assertFalse(binaryTree.isFullBinaryTree(binaryTree.getRoot()));
  }

  @Test
  public void isFullBinaryTree() {
    BinaryTree<Integer> binaryTree = new BinaryTree<>();
    binaryTree.setRoot(new Node<>(1));
    Assertions.assertTrue(binaryTree.isFullBinaryTree(binaryTree.getRoot()));
    binaryTree.getRoot().setLeft(new Node<>(2));
    binaryTree.getRoot().getLeft().setLeft(new Node<>(4));
    binaryTree.getRoot().getLeft().setRight(new Node<>(5));
    binaryTree.getRoot().getLeft().getRight().setLeft(new Node<>(6));
    binaryTree.getRoot().getLeft().getRight().setRight(new Node<>(7));
    binaryTree.getRoot().setRight(new Node<>(3));
    binaryTree.preorder(binaryTree.getRoot());
    Assertions.assertTrue(binaryTree.isFullBinaryTree(binaryTree.getRoot()));
    Assertions.assertEquals(4, binaryTree.getMaxDepth(binaryTree.getRoot()));
  }
}