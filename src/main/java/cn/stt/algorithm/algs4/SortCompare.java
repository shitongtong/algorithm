package cn.stt.algorithm.algs4;


import java.util.Random;

/**
 * 比较两种排序算法
 *
 * @Author shitt7
 * @Date 2021/2/18 9:34
 */
public class SortCompare {
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Selection";
        //数组长度
        int n = 1000;
        //重复排序次数
        int t = 100;
        // 算法1的总时间
        double t1 = timeRandomInput(alg1, n, t);
        // 算法2的总时间
        double t2 = timeRandomInput(alg2, n, t);
        System.out.print(String.format("For %d random Doubles %s is", n, alg1));
        System.out.print(String.format(" %.1f times faster than %s", t2 / t1, alg2));
    }

    public static double time(String alg, Double[] a) {
        long start = System.currentTimeMillis();
        if ("Insertion".equals(alg)) {
            Insertion.sort(a);
        }
        if ("Selection".equals(alg)) {
            Selection.sort(a);
        }
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static double timeRandomInput(String alg, int n, int t) {
        // 使用算法alg将t个长度为n的数组排序
        double total = 0.0;
        Double[] a = new Double[n];
        for (int i = 0; i < t; i++) {
            // 进行一次测试（生成一个数组并排序)
            for (int j = 0; j < n; j++) {
                a[j] = random.nextDouble();
            }
            total += time(alg, a);
        }
        return total;
    }


}
