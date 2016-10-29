// QueueString.java 字符串队列接口
package sylxjtu;
interface QueueString {
  boolean empty();
  String front();
  void pop();
  void push(String elem);
}
