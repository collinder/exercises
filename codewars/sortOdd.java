import java.util.stream.*; 
import java.util.*; 
import java.util.regex.*;


public class A {
  public static int[] sortArray(int[] array) {
    List<Integer> indexes = new ArrayList<Integer>();
    List<Integer> numbers = new ArrayList<Integer>();
    for (int i = 0; i < array.length; i++) {
      if (array[i] % 2 == 1) {
        indexes.add(i);
        numbers.add(array[i]);
      }
    }
    Collections.sort(numbers);
    ListIterator<Integer> iliterator = indexes.listIterator();
    ListIterator<Integer> nliterator = numbers.listIterator();
    while (nliterator.hasNext()) {
      array[iliterator.next()] = nliterator.next();
    }
    return array;
  }
  public static void main(String args[]) {
   System.out.println(Arrays.toString(sortArray(new int[]{ 5, 3, 2, 8, 1, 4 })));
     }
}