package lc;

/**
 * 水壶问题
 * @author ll
 */
public class Main365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0 || x + y == z) {
            return true;
        }
        if(x + y < z) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Main365 main365 = new Main365();
        System.out.println(main365.canMeasureWater(3, 5, 4));
    }
}
