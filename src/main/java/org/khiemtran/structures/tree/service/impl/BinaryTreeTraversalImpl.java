package org.khiemtran.structures.tree.service.impl;

import org.khiemtran.structures.tree.Node;
import org.khiemtran.structures.tree.service.TraversalTree;

public class BinaryTreeTraversalImpl<T> implements TraversalTree<T> {
  @Override
  public void preorder(Node<T> node) {
    if (node == null) {
      return;
    }
    System.out.println(node.getData());
    preorder(node.getLeft());
    preorder(node.getRight());
  }

  @Override
  public void inorder(Node<T> node) {
    if (node == null) {
      return;
    }
    inorder(node.getLeft());
    System.out.println(node.getData());
    inorder(node.getRight());
  }

  @Override
  public void postorder(Node<T> node) {
    if (node == null) {
      return;
    }
    postorder(node.getRight());
    postorder(node.getLeft());
    System.out.println(node.getData());
  }
}
