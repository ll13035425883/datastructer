import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ll
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,1,2,3,3,3,5,6};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : arr) {
            hashMap.put(i, hashMap.get(i) == null ? 1 : hashMap.get(i) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entries, ((o1, o2) -> {
            if(o1.getValue().intValue() > o2.getValue().intValue()) {
                return 1;
            } else if(o1.getValue().intValue() < o2.getValue().intValue()) {
                return -1;
            } else {
                return o2.getKey().intValue() - o1.getKey().intValue();
            }
        }));
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey());
        }
    }
}
