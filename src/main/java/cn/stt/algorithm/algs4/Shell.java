package cn.stt.algorithm.algs4;

/**
 * 希尔排序
 *
 * @Author shitt7
 * @Date 2021/2/9 15:13
 */
public class Shell {
    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        long startTime = System.nanoTime();
        sort(a);
        System.out.println("time:" + (System.nanoTime() - startTime));
        assert isSorted(a);
        show(a);
    }

    public static void sort(Comparable[] a) {
        //将a[]按升序排列
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            // 1, 4, 13, 40, 121, 364, 1093, ...
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < n; i++) {
                // 将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]... 之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    /**
     * 元素比较
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 元素交换位置
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印数组
     *
     * @param a
     */
    private static void show(Comparable[] a) {
        //在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 测试数组元素是否有序
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
