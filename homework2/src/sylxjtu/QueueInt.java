// QueueInt.java 整形队列接口
package sylxjtu;
interface QueueInt {
  boolean empty();
  Pair front();
  void pop();
  void push(Pair elem);
}
