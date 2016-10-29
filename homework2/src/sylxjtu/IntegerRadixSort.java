// IntegerRadixSort.java 正整数基数排序
// 考虑到模运算、除运算的速度，设置基数为16，以便将其转化为位运算
// x % 16 -> x & 0xF
// x / 16 -> x >> 4
// StringRadixSort.java 字符串基数排序
package sylxjtu;

public class IntegerRadixSort {
  static void print(int[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  static void sort(int[] arr){
    LoopArrayQueueInt[] qarr = new LoopArrayQueueInt[16];
    Pair[] tarr = new Pair[arr.length];
    for (int i = 0; i < arr.length; i++) {
      tarr[i] = new Pair(arr[i], arr[i]);
    }
    for (int i = 0; i < qarr.length; i++) {
      qarr[i] = new LoopArrayQueueInt();
    }
    if(arr.length == 0) return;
    for(int l = 1; ; l++){
      boolean flag = false;
      for(int i = 0; i < arr.length; i++){
        if((tarr[i].curWeight & 0xF) != 0) flag = true;
        qarr[(tarr[i].curWeight & 0xF)].push(tarr[i]);
        tarr[i].curWeight >>= 4;
      }
      if(!flag) break;
      int j = 0;
      for(int i = 0; i < 16; i++){
        while(!qarr[i].empty()){
          tarr[j] = qarr[i].front();
          j++;
          qarr[i].pop();
        }
      }
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = tarr[i].value;
    }
  }
  public static void main(String[] args) {
    int[] arr = {1, 21, 12, 322, 4, 123, 2312, 765, 56};
    print(arr);
    System.out.println("");
    sort(arr);
    print(arr);
  }
}
