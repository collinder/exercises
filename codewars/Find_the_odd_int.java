import java.util.*; 
public class FindOdd {
	public static int findIt(int[] a) {
    HashSet<Integer> ha = new HashSet<Integer>();
    int result = -1;
    for (int e : a) 
    {
    if (ha.contains(e))
        ha.remove(e); 
    else ha.add(e);
}
    for (int e : ha)
{
    result = e;
    break;
}

    return result;
  }

}
