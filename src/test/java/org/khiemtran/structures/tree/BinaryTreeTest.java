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
}