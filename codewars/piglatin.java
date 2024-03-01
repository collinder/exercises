import java.util.stream.*; 
import java.util.*; 
import java.util.regex.*;


public class A {
    public static String pigIt(String str) {
        return Stream.of(str.split(" ")).map(A::pigify).reduce("",(x,y) -> x + " " + y).substring(1); 
    }
    public static String pigify(String str) {
      Pattern p = Pattern.compile("(\\w)(\\w+)");
      Matcher m = p.matcher(str);
      if (m.find()) {
        return m.replaceFirst("$2$1ay");
      }
      else
        return str;
    }
public static void main(String args[]) {
        String test = pigIt("Hello World!");
        for (int te : test.toCharArray())
        {
          System.out.println(te);
        }
     }
}