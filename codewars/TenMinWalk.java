public class TenMinWalk {
public static boolean isValid(char[] walk) {
    int vertical = 0;
    int horizontal = 0;
    if (walk.length != 10) 
        return false; 
    for (char i : walk) {
        switch (i) {
            case 'n':
                vertical++;
                break;
            case 's':
                vertical--;
                break;
            case 'w':
                horizontal++;
                break;
            case 'e':
                horizontal--;
                break;
        }
    }
    return (horizontal == 0) && (vertical == 0);
  }
}
