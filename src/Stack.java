import java.util.*;

public class Stack {
    List<Integer> list = new ArrayList<>();

    public int pop() {
        if(list.size() == 0)
            return 9999;
        int p = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return p;
    }

    public void push(int n) {
        if(list.size() == 0) {
            list.add(n);
            return ;
        }
        for(int i = list.size() - 1;i >= 0;i--) {
            if(n < list.get(i)) {
                list.remove(i);
            } else {
                list.add(n);
                return;
            }
        }
        list.add(n);
    }

    public boolean isEmpty() {
        return list.size() == 0 ? true : false;
    }

}

