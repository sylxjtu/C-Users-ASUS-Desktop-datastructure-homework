// UnsortedLinkedList.java 未排序链表实现线性表
package sylxjtu;

public class UnsortedLinkedList implements sylxjtu.List{
  Node head;
  Node tail;
  int size = 0;

  Node find(int x){
    if(size == 0) return null;
    if(head.value == x) return head;
    Node cur = head.next;
    while(cur.value != x && cur != head){
      cur = cur.next;
    }
    if(cur == head) return null;
    else return cur;
  }

  @Override
  public boolean search(int x){
    if(find(x) != null) return true;
    return false;
  }

  @Override
  public boolean insert(int x){
    if(size == 0){
      head = tail = new Node(x);
      head.next = head;
    } else {
      tail.next = new Node(head, x);
      tail = tail.next;
    }
    size++;
    return true;
  }

  @Override
  public int delete(int x){
    assert x >= 0 && x < size : "Invalid Index";

    Node cur = head;
    for(int i = 0; i < x; i++){
      cur = cur.next;
    }
    int ret = cur.value;

    if(x == 0) head = tail.next = head.next;
    else {
      cur = head;
      for(int i = 0; i < x - 1; i++){
        cur = cur.next;
      }
      cur.next = cur.next.next;
    }

    size--;
    return ret;
  }

  @Override
  public int successor(int x){
    Node ind = find(x);
    assert ind != null && ind != tail : "No successor";
    return ind.next.value;
  }

  @Override
  public int predecessor(int x){
    Node ind = find(x);
    assert ind != null && ind != head : "No predecessor";
    Node cur = ind.next;
    while(cur.next != ind){
      cur = cur.next;
    }
    return cur.value;
  }

  @Override
  public int minimum(){
    int ret = head.value;
    for(Node cur = head.next; cur != head; cur = cur.next){
      ret = cur.next.value < ret ? cur.next.value : ret;
    }
    return ret;
  }

  @Override
  public int maximum(){
    int ret = head.value;
    for(Node cur = head.next; cur != head; cur = cur.next){
      ret = cur.next.value > ret ? cur.next.value : ret;
    }
    return ret;
  }

  @Override
  public int kthElement(int k){
    assert k > 0 && k <= size : "Invalid k";
    int[] arr = new int[size];
    Node cur = head;
    for(int i = 0; i < size; i++, cur = cur.next){
      arr[i] = cur.value;
    }
    return ArrayUtil.findKthElement(arr, 0, size, k - 1);
  }

  public static void main(String[] args) {
    UnsortedLinkedList a = new UnsortedLinkedList();
    a.insert(1);
    a.insert(3);
    a.insert(2);
    assert a.search(1);
    assert !a.search(4);
    assert a.delete(0) == 1;
    assert !a.search(1);
    a.insert(1);
    assert a.size == 3;
    assert a.successor(2) == 1;
    assert a.predecessor(2) == 3;
    assert a.minimum() == 1;
    assert a.maximum() == 3;
    assert a.kthElement(2) == 2;
    try {
      assert false;
    } catch (AssertionError e) {
      System.out.println("Test passed");
      return;
    }
    throw new Error("Please enable assertions");
  }
}
