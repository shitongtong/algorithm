package cn.stt.algorithm.algs4;

/**
 * 选择排序
 *
 * @Author shitt7
 * @Date 2021/2/9 15:13
 */
public class Selection {
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
        for (int i = 0; i < n; i++) {
            //将a[i]和a[i+1..n]中最小元素交换
            //最小元素的索引
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
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
