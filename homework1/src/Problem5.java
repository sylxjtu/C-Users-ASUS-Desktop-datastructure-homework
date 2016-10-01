// Problem5.java 第5题-选择问题
import java.util.Random;

class Problem5{
  // 求解函数
  static int kthElement(int[] arr, int k){
    // 验证k的合法性
    if(k > arr.length || k < 1) throw new Error("k must in [1, arr.length]");
    // 调用递归求解方法
    return kthElement_r(arr, 0, arr.length, k);
  }
  static int kthElement_r(int[] arr, int l, int r, int k){
    // 当数组只有一个元素时，答案即此元素
    if(r - l == 1){
      return arr[l];
    }
    // 随机选取轴值并与第一个元素交换
    Random ran = new Random();
    int pivot = ran.nextInt(r - l);
    int t = arr[l + pivot];
    arr[l + pivot] = arr[l];
    arr[l] = t;
    int cur = l;
    // 选取所有小于轴值的元素放到数组左半部分
    for (int i = l + 1; i < r; i++) {
      if(arr[i] < arr[l]){
        cur++;
        t = arr[cur];
        arr[cur] = arr[i];
        arr[i] = t;
      }
    }
    // 将轴值放到数组中间
    t = arr[cur];
    arr[cur] = arr[l];
    arr[l] = t;
    // 分类讨论所求元素所在位置
    if(k - 1 < cur - l){
      return kthElement_r(arr, l, cur, k);
    }
    else if(k - 1 == cur - l){
      return arr[cur];
    }
    else{
      return kthElement_r(arr, cur + 1, r, k - (cur - l + 1));
    }
  }
  // 测试代码
  public static void main(String[] args) {
    Random r = new Random();
    DataGenerator dg = new RandomGenerator();
    int[] arr = dg.generate(1000000);
    long s = System.nanoTime();
    for(int i = 1; i <= 100; i++){
      kthElement(arr, r.nextInt(1000000) + 1);
    }
    long e = System.nanoTime();
    System.out.println(e - s);
  }
}
