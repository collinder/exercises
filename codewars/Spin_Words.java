import java.util.stream.*; 
public class SpinWords {
public String combineNreverse5(String x, String y) 
{
    if (y.length() > 4)
        y = new StringBuilder(y).reverse().toString();
    if (x != "")
        return x + " " + y;
    else 
        return y;
}
public String spinWords(String sentence) {
    String[] parts = sentence.split(" ");
    System.out.println(parts.getClass());
    Stream<String> stream_parts = Stream.of(parts); 
    String result = stream_parts.reduce("", (x, y) -> combineNreverse5(x, y));
    return result;
  }
}
