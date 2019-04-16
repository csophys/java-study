package base.sort;

import java.util.Arrays;

/**
 * Created by csophys on 19/4/7.
 */
public class CompareSort {

    public static void main(String[] args) {
        int[] a1 = {11, 2, 21, 3, 1, 42};
        //冒泡排序
        CompareSort.bubbleSort(a1);
        System.out.print("冒泡排序结果:");
        for (int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        a1 = new int[]{11, 2, 21, 3, 1, 42};
        //选择排序
        CompareSort.selection(a1);
        System.out.print("选择排序结果:");
        for (int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        a1 = new int[]{11, 2, 21, 3, 1, 42};
        //插入排序
        CompareSort.insert(a1);
        System.out.print("插入排序结果:");
        for (int i : a1) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int a1[]) {
        //数组初始化的多种表示形式
        int a[] = a1;
        //int[] a1 = {1, 3, 4, 23};
        //int a2[] = new int[]{1, 3, 4, 23};
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void selection(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int index = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    index = j;
                }
            }
            //swap
            if (index != i) {
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
    }

    public static void insert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < a[j]) {
                    a[j + 1] = a[j];
                    if (j == 0) {
                        a[j] = temp;
                    }
                } else {
                    a[j + 1] = temp;
                    break;
                }
            }
        }
    }


    //合并排序，自上而下。
    public static void merge(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int mid = a.length / 2;
        int[] beforepart = Arrays.copyOfRange(a, 0, mid);
        int[] afterpart = Arrays.copyOfRange(a, mid, a.length);
        int i = 0, j = 0,index=0;
        int newArray[]=new int[a.length];
        for (; i < beforepart.length || j < afterpart.length;) {
            if(beforepart[i]<afterpart[j]){
                newArray[index]=beforepart[i];
                i++;
            }else {
                newArray[index]=afterpart[j];
                j++;
            }
            index++;
        }

        if(i==beforepart.length){
            //Arrays.copy
        }else {

        }

    }
}
