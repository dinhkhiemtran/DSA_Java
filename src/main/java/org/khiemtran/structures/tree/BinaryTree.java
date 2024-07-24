package org.khiemtran.structures.tree;

public class BinaryTree<T> {
  private Node<T> root;

  public BinaryTree() {
    this.root = null;
  }

  public Node<T> getRoot() {
    return root;
  }

  public void setRoot(Node<T> root) {
    this.root = root;
  }

  //preorder (rlr)
  public void preorder(Node<T> node) {
    if (node == null) {
      return;
    }
    System.out.println(node.getData());
    preorder(node.getLeft());
    preorder(node.getRight());
  }

  //inorder (lrr)
  public void inorder(Node<T> node) {
    if (node == null) {
      return;
    }
    inorder(node.getLeft());
    System.out.println(node.getData());
    inorder(node.getRight());
  }

  //postorder rlr
  public void postorder(Node<T> node) {
    if (node == null) {
      return;
    }
    postorder(node.getRight());
    postorder(node.getLeft());
    System.out.println(node.getData());
  }
}
