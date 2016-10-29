// LoopArrayQueueString.java 循环数组实现字符串队列
package sylxjtu;
class LoopArrayQueueInt implements QueueInt{
  int capacity = 1;
  int size = 0;
  Pair[] arr;
  int fp, lp;
  LoopArrayQueueInt(){
    arr = new Pair[capacity];
  }
  void extend(){
    Pair[] tmp = new Pair[capacity * 2];
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
  public Pair front(){
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
  public void push(Pair elem){
    if(size == capacity) extend();
    arr[lp++] = elem;
    lp %= capacity;
    size++;
  }
}
