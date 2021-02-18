package cn.stt.algorithm.algs4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Dijkstra 的双栈算术表达式求值算法
 *
 * @Author shitt7
 * @Date 2021/2/7 16:52
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty()) {
            //读取字符,如果是运算符则压入栈
            String s = StdIn.readString();
            if ("(".equals(s)) {

            } else if ("+".equals(s)) {
                ops.push(s);
            } else if ("-".equals(s)) {
                ops.push(s);
            } else if ("*".equals(s)) {
                ops.push(s);
            } else if ("/".equals(s)) {
                ops.push(s);
            } else if ("sqrt".equals(s)) {
                ops.push(s);
            } else if (")".equals(s)) {
                // 如果字符为")"，弹出运算符和操作数，计算结果并压入栈
                String op = ops.pop();
                Double v = vals.pop();
                if ("+".equals(op)) {
                    v = vals.pop() + v;
                } else if ("-".equals(op)) {
                    v = vals.pop() - v;
                } else if ("*".equals(op)) {
                    v = vals.pop() * v;
                } else if ("/".equals(op)) {
                    v = vals.pop() / v;
                } else if ("sqrt".equals(op)) {
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } else {
                // 如果字符既非运算符也不是括号，将它作为double 值压入栈
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
