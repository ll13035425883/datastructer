package tree;

import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.List;

public class MaxQueue {
    int max = -1;
    int i = 0;
    List<Integer> list = null;
    int subMax = -1;
    public MaxQueue() {
        list = new ArrayList<>();
    }

    public int max_value() {
        return this.max;
    }

    public void push_back(int value) {
        list.add(value);
        if(max == -1) {
            this.max = value;
        } else if(value >= max) {
            this.subMax = this.max;
            this.max = value;
        } else if(value < max) {
            if(value > this.subMax)
                this.subMax = value;
        }
    }

    public int pop_front() {
        if(list.size() == 0)
            return -1;
        else {
            Integer integer = list.get(i);
            if(integer == max) {
                this.max = this.subMax;
            }
            list.remove(i++);
            return integer;
        }
    }
}
