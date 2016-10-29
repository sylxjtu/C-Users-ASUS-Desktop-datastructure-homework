// ListInterface.java 线性表接口
package sylxjtu;

interface List{
  boolean search(int x);    // 查询值为 x 的元素是否存在
  boolean insert(int x);    // 插入值为 x 的元素
  int delete(int x);        // 删除下标为 x 的元素
  int successor(int x);     // 获得该线性表中值为 x 的元素直接后继元素
  int predecessor(int x);   // 获得该线性表中值为 x 的元素的直接前驱元素
  int minimum();            // 获得该线性表的最小元素
  int maximum();            // 获得该线性表的最大元素
  int kthElement(int k);    // 获得线性表中第 k 大元素，参数为指定的 k 值的大小
}
