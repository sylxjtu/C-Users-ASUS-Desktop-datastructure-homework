// BoolEquationEvaluate.java 布尔表达式求值
package sylxjtu;
import java.util.Scanner;
public class BoolEquationEvaluate {
  String s;
  int cur;
  BoolEquationEvaluate(String str){
    s = str + "$";
  }
  public boolean eval(){
    boolean ret = expr();
    if(s.charAt(cur) != '$'){
      System.err.println("Error: Unexpected " + s.charAt(cur) + " at position " + cur);
      System.err.println(s);
      for (int i = 0; i < cur; i++) {
        System.err.print(" ");
      }
      System.err.println("^");
      throw new Error("Invalid expression");
    }
    return ret;
  }
  void gonext(){
    do {
      cur++;
    } while(s.charAt(cur) == ' ');
  }
  boolean expr(){
    return andexpr() | rexpr();
  }
  boolean rexpr(){
    if(s.charAt(cur) == '|') {
      gonext();
      return expr();
    } else {
      return false;
    }
  }
  boolean andexpr(){
    return notexpr() & randexpr();
  }
  boolean randexpr(){
    if(s.charAt(cur) == '&') {
      gonext();
      return andexpr();
    } else {
      return true;
    }
  }
  boolean notexpr(){
    if(s.charAt(cur) == '!') {
      gonext();
      return !notexpr();
    } else {
      return atom();
    }
  }
  boolean atom(){
    if(s.charAt(cur) == 'T') {
      gonext();
      return true;
    } else if(s.charAt(cur) == 'F') {
      gonext();
      return false;
    } else if(s.charAt(cur) == '(') {
      gonext();
      boolean ret = expr();
      if(s.charAt(cur) != ')'){
        System.err.println("Error: Missing right branket at position " + cur);
        System.err.println(s);
        for (int i = 0; i < cur; i++) {
          System.err.print(" ");
        }
        System.err.println("^");
        throw new Error("Invalid expression");
      }
      gonext();
      return ret;
    } else {
      System.err.println("Error: Unexpected " + s.charAt(cur) + " at position " + cur);
      System.err.println(s);
      for (int i = 0; i < cur; i++) {
        System.err.print(" ");
      }
      System.err.println("^");
      throw new Error("Invalid expression");
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      try {
        BoolEquationEvaluate x = new BoolEquationEvaluate(line);
        System.out.println(x.eval() ? 'V' : 'F');
      } catch (Error e) {}
      System.out.println();
    }
    scanner.close();
  }
}
