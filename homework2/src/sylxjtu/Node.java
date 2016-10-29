package sylxjtu;
class Node{
  int value;
  Node next;
  Node(Node n, int v){
    value = v;
    next = n;
  }
  Node(int v){
    value = v;
    next = null;
  }
}
