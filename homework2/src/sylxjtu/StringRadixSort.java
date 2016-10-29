// StringRadixSort.java 字符串基数排序
package sylxjtu;
public class StringRadixSort {
  static void print(String[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  static void sort(String[] arr){
    LoopArrayQueueString[] qarr = new LoopArrayQueueString[26];
    for (int i = 0; i < qarr.length; i++) {
      qarr[i] = new LoopArrayQueueString();
    }
    if(arr.length == 0) return;
    int len = arr[0].length();
    for(int l = len - 1; l >= 0; l--){
      for(int i = 0; i < arr.length; i++){
        qarr[arr[i].charAt(l) - 'a'].push(arr[i]);
      }
      int j = 0;
      for(int i = 0; i < 26; i++){
        while(!qarr[i].empty()){
          arr[j] = qarr[i].front();
          j++;
          qarr[i].pop();
        }
      }
    }
  }
  public static void main(String[] args) {
    String[] arr = {"abc","bde","fad","abd","bef","fdd","abe"};
    print(arr);
    System.out.println("");
    sort(arr);
    print(arr);
  }
}
