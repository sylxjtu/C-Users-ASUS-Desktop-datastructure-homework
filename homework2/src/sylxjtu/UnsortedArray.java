// UnsortedArray.java 未排序数组实现线性表
package sylxjtu;

public class UnsortedArray implements sylxjtu.List{
  int[] data = new int[1];
  int capacity = 1;
  int size = 0;

  void extend(){
    int[] tmp = new int[capacity * 2];
    System.arraycopy(data, 0, tmp, 0, capacity);
    capacity *= 2;
    data = tmp;
  }

  int find(int x){
    for(int i = 0; i < size; i++){
      if(data[i] == x) return i;
    }
    return -1;
  }

  @Override
  public boolean search(int x){
    if(find(x) != -1) return true;
    return false;
  }

  @Override
  public boolean insert(int x){
    if(size == capacity) extend();
    data[size++] = x;
    return true;
  }

  @Override
  public int delete(int x){
    assert x >= 0 && x < size : "Invalid Index";
    int ret = data[x];
    for (int i = x; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    size--;
    return ret;
  }

  @Override
  public int successor(int x){
    int ind = find(x);
    assert ind >= 0 && ind < size - 1 : "No successor";
    return data[ind + 1];
  }

  @Override
  public int predecessor(int x){
    int ind = find(x);
    assert ind > 0 && ind < size : "No predecessor";
    return data[ind - 1];
  }

  @Override
  public int minimum(){
    assert size > 0 : "List is empty";
    int ret = data[0];
    for (int i = 1; i < size; i++) {
      ret = data[i] < ret ? data[i] : ret;
    }
    return ret;
  }

  @Override
  public int maximum(){
    assert size > 0 : "List is empty";
    int ret = data[0];
    for (int i = 1; i < size; i++) {
      ret = data[i] > ret ? data[i] : ret;
    }
    return ret;
  }

  @Override
  public int kthElement(int k){
    assert k > 0 && k <= size : "Invalid k";
    int[] tmp = data.clone();
    return ArrayUtil.findKthElement(tmp, 0, size, k - 1);
  }

  public static void main(String[] args) {
    UnsortedArray a = new UnsortedArray();
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
