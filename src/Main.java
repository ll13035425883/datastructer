import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String temp = line;
            int i = 1;
            while (!judge(line)) {
                line = temp;
                StringBuilder stringBuilder = new StringBuilder(line.substring(line.length() - i++));
                String sub = stringBuilder.reverse().toString();
                line = sub + line;
            }
            System.out.println(line);
        }
    }

    private static boolean judge(String s) {
        if(s.length() <= 1) {
            return true;
        }
        int j = s.length() - 1, i = 0;
        while (i < j) {
            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}