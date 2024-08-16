package org.khiemtran.structures.tree;

public class BinaryTree<T> {
  private final Node<T> root;

  public BinaryTree(Node<T> root) {
    this.root = root;
  }

  public Node<T> getRoot() {
    return root;
  }
}
