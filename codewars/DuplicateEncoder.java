import java.util.*; 

public class DuplicateEncoder {
	static String encode(String word){
    HashMap<Integer,Integer> encoed = new HashMap<Integer,Integer>();
    String lowchark= word.toLowerCase();
    lowchark.chars().forEach(x -> {Integer val = encoed.get(x); if (val == null) { encoed.put(x, 1);} else { encoed.put(x, val + 1); }});
    StringBuilder str = new StringBuilder();
    lowchark.chars().forEach(x -> {Integer val = encoed.get(x); if (val > 1) { str.append(")");} else { str.append("("); }});
    return str.toString();
  }
}
