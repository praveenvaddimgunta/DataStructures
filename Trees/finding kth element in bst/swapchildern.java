public void swapChildren()
  {swapChildren(root);}
  private static void swapChildren(BinaryTreeNode t)
{// Swap the children of every node in the subtree t.
// Do a postorder traversal; swap left and right child
// pointers in the visit step.
  if (t != null)
  {
     // swap in the left subtree
     swapChildren(t.leftChild);

     // swap in the right subtree
     swapChildren(t.rightChild);

     // swap children of t
     BinaryTreeNode temp = t.rightChild;
     t.rightChild = t.leftChild;
     t.leftChild = temp;
  }
}