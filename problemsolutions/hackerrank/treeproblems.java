
class Node {
  int data;
  Node left;
  Node right;
}

void Preorder(Node root) {
  if(root == null)
    return;
  System.out.print(root.data + " ");
  Preorder(root.left);
  Preorder(root.right);
}


void Inorder(Node root) {
  if(root == null)
    return;
  Inorder(root.left);
  System.out.print(root.data + " ");
  Inorder(root.right);
}

void Postorder(Node root) {
  if(root == null)
    return;
  Postorder(root.left);
  Postorder(root.right);
  System.out.print(root.data + " ");
}


int height(Node root) {
  if(root == null)
    return 0;
    
  return 1 + Math.max(height(root.left),height(root.right));
}
