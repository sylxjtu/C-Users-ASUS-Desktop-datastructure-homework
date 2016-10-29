// ArrayUtil.java 数组工具
package sylxjtu;
class ArrayUtil{
  static void swap(int[] arr, int a, int b){
    int t = arr[a];
    arr[a] = arr[b];
    arr[b] = t;
  }
  static int findKthElement(int[] arr, int s, int e, int k){
    if(e - s == 1) return arr[s];
    int pivot = arr[s];
    int cur = s + 1;
    for(int i = s + 1; i < e; i++){
      if(arr[i] < pivot) ArrayUtil.swap(arr, i, cur++);
    }
    cur--;
    ArrayUtil.swap(arr, cur, s);
    if(s + k < cur) return findKthElement(arr, s, cur, k);
    else if(s + k == cur) return arr[s + k];
    else return findKthElement(arr, cur + 1, e, k - (cur - s) - 1);
  }
}
