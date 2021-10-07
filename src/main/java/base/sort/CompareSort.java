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
        //快速排序
        System.out.println("\n");
        a1 = new int[]{11, 2, 21, 3, 1, 42};
        CompareSort.quick(a1);
        System.out.print("快速排序结果:");
        for (int i : a1) {
            System.out.print(i + " ");
        }

        //合并排序
        System.out.println("\n");
        a1 = new int[]{11, 2, 21, 3, 1, 42};
        CompareSort.merge(a1);
        System.out.print("合并排序结果:");
        for (int i : a1) {
            System.out.print(i + " ");
        }
        a1 = new int[]{121,3};
        quickSort(a1,0,a1.length-1);
        System.out.println("\n");
        System.out.print("Another快速排序结果:");
        for (int i : a1) {
            System.out.print(i + " ");
        }
    }

    static void quickSort(int[] arr,int start,int end){
        //递归出口
        if(start>=end) return;

        //设定枢纽值
        int pivot=arr[start];
        int i=start,j=end;int temp=0;
        while(i<j){
            //先从数组尾部向前找到一个比枢纽值小的值，并且进行交换
            while(i<j&&arr[j]>=pivot) j--;
            if(arr[j]<pivot){
                temp=arr[j];arr[j]=arr[i];arr[i]=temp;
            }
            while(i<j&&arr[i]<pivot) i++;
            if(arr[i]>=pivot){
                temp=arr[j];arr[j]=arr[i];arr[i]=temp;
            }
        }
        arr[i]=pivot;
        //对于左边和右边分别递归进行排序
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);
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

    public static void quick(int[] a) {
        if (a.length <= 1) {
            return;
        }

        int length = a.length;
        int temp = a[0];
        int i = 0, j = length - 1;
        int direction = 0;
        while(i<j){
            if(direction==0){
                if(a[j]>=temp){
                    j--;
                }else {
                    a[i]=a[j];
                    direction=1;
                }
            }else {
                if(a[i]<=temp){
                    i++;
                }else {
                    a[j]=a[i];
                    direction=0;
                }
            }
        }
        a[i]=temp;
        //0，i的子数组递归处理
        quick(Arrays.copyOfRange(a,0,i));
        //i,length-1的子数组递归处理
        quick(Arrays.copyOfRange(a,i+1,length));
    }


    public static void merge(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int mid = a.length / 2;
        int[] beforepart = Arrays.copyOfRange(a, 0, mid);
        int[] afterpart = Arrays.copyOfRange(a, mid, a.length);
        merge(beforepart);
        merge(afterpart);
        int i = 0, j = 0,index=0;
        for (; i < beforepart.length && j < afterpart.length;) {
            if(beforepart[i]<afterpart[j]){
                a[index]=beforepart[i];
                i++;
            }else {
                a[index]=afterpart[j];
                j++;
            }
            index++;
        }

        if(i==beforepart.length){
            while(j<afterpart.length){
                a[index]=afterpart[j];
                j++;index++;
            }
        }else {
            while(i<beforepart.length){
                a[index]=beforepart[i];
                i++;index++;
            }
        }
    }
}
