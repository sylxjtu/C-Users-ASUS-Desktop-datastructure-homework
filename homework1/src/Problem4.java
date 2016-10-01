// Problem4.java 第4题-选取主元素
import java.util.HashMap;
import java.util.Arrays;

// 第一种算法-排序求解
class SolutionSort{
  static int mainElem(int[] arr){
    // 长度为0，没有主元素
    if(arr.length == 0){
      throw new Error("No main element");
    }
    // 对数组进行排序
    Arrays.sort(arr);
    // 遍历数组找到每个元素出现次数
    int last = arr[0];
    int cnt = 1;
    for(int i = 1; i < arr.length; i++){
      if(cnt > arr.length / 2) return last;
      if(arr[i] == last) cnt++;
      else{
        cnt = 1;
        last = arr[i];
      }
    }
    if(cnt > arr.length / 2) return last;
    // 没有一个元素出现次数大于N/2，没有主元素
    else throw new Error("No main element");
  }
}

// 第二种算法-使用哈希表
class SolutionHash{
  static int mainElem(int[] arr){
    // 长度为0，没有主元素
    if(arr.length == 0){
      throw new Error("No main element");
    }
    // 建立一个int到int的哈希表
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    // 对每个元素计数
    for(int i = 0; i < arr.length; i++){
      hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
    }
    // 对每个元素的计数进行判断
    for(int i = 0; i < arr.length; i++){
      if(hm.get(arr[i]) > arr.length / 2) return arr[i];
    }
    // 没有找到主元素
    throw new Error("No main element");
  }
}

// 测试代码
public class Problem4{
  public static void main(String[] args) {
    System.out.println(SolutionSort.mainElem(
    new int[]{1, 1, 3, 3, 2, 2, 2, 2, 2})
    );
    System.out.println(SolutionHash.mainElem(
      new int[]{1, 1, 3, 3, 2, 2, 2, 2, 2})
    );
    DataGenerator ran = new RandomGenerator();
    int[] arr = ran.generate(1000000);
    long n1 = System.nanoTime(), n2;
    try{
      System.out.println(SolutionSort.mainElem(arr));
    }
    catch(Error e){
      System.out.println("没有主元素");
    }
    finally{
      n2 = System.nanoTime();
    }
    System.out.println(n2 - n1);
    long n3 = System.nanoTime(), n4;
    try{
      System.out.println(SolutionHash.mainElem(arr));
    }
    catch(Error e){
      System.out.println("没有主元素");
    }
    finally{
      n4 = System.nanoTime();
    }
    System.out.println(n4 - n3);
  }
}
