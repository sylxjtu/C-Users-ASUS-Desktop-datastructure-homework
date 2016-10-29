// SortedArray.java 排序数组实现线性表
package sylxjtu;

public class SortedArray implements sylxjtu.List{
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
    int l = 0, r = size, mid = (r + l) / 2;
    while(x != data[mid] && l < r - 1){
      if(data[mid] < x) l = mid;
      else r = mid;
      mid = (r + l) / 2;
    }
    return x == data[mid] ? mid : -1;
  }

  @Override
  public boolean search(int x){
    if(find(x) != -1) return true;
    return false;
  }

  @Override
  public boolean insert(int x){
    if(size == capacity) extend();
    if(size == 0 || x >= data[size - 1]) {
      data[size] = x;
    } else if(x <= data[0]) {
      for(int i = size; i > 0; i--){
        data[i] = data[i - 1];
      }
      data[0] = x;
    } else {
      for(int i = 0; i < size - 1; i++){
        if(data[i] < x && x <= data[i + 1]){
          for(int j = size; j > i + 1; j--){
            data[j] = data[j - 1];
          }
          data[i + 1] = x;
          break;
        }
      }
    }
    size++;
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
    return data[0];
  }

  @Override
  public int maximum(){
    assert size > 0 : "List is empty";
    return data[size - 1];
  }

  @Override
  public int kthElement(int k){
    assert k > 0 && k <= size : "Invalid k";
    return data[k - 1];
  }

  public static void main(String[] args) {
    SortedArray a = new SortedArray();
    a.insert(1);
    a.insert(3);
    a.insert(2);
    assert a.search(1);
    assert !a.search(4);
    assert a.delete(0) == 1;
    assert !a.search(1);
    a.insert(1);
    assert a.size == 3;
    assert a.successor(2) == 3;
    assert a.predecessor(2) == 1;
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
