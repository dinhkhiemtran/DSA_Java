package org.khiemtran.structures.tree.service;

import org.khiemtran.structures.tree.Node;

public interface TraversalTree<T> {
  void preorder(Node<T> node);

  void inorder(Node<T> node);

  void postorder(Node<T> node);
}
