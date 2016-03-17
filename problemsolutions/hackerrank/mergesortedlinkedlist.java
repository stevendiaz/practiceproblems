
 linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

Node MergeLists(Node headA, Node headB) {
     // This is a "method-only" submission. 
     // You only need to complete this method 
    if(headA == null && headB == null)
        return null;
    else if(headA == null)
        return headB;
    else if(headB == null)
        return headA;
    
    Node smaller;
    if(headA.data > headB.data) {
        smaller = headB;
        smaller.next = MergeLists(headA, headB.next);
    }
    else {
        smaller = headA;
        smaller.next = MergeLists(headA.next, headB);
    }
    
    return smaller;
}
