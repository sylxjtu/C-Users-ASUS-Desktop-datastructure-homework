// LoopArrayQueueString.java 循环数组实现字符串队列
package sylxjtu;
class LoopArrayQueueString implements QueueString{
  int capacity = 1;
  int size = 0;
  String[] arr;
  int fp, lp;
  LoopArrayQueueString(){
    arr = new String[capacity];
  }
  void extend(){
    String[] tmp = new String[capacity * 2];
    System.arraycopy(arr, 0, tmp, 0, lp);
    System.arraycopy(arr, fp, tmp, fp + capacity, capacity - fp);
    fp += capacity;
    arr = tmp;
    capacity *= 2;
  }

  @Override
  public boolean empty(){
    return size == 0;
  }

  @Override
  public String front(){
    return arr[fp];
  }

  @Override
  public void pop(){
    assert size > 0 : "Queue is empty";
    fp++;
    fp %= capacity;
    size--;
  }

  @Override
  public void push(String elem){
    if(size == capacity) extend();
    arr[lp++] = elem;
    lp %= capacity;
    size++;
  }
}
