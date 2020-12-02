package base.sort;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = {2, 8, 4, 5, 1, 7, 9, 6};
        //sort(arr);
        bubble(arr);
        for (Integer i : arr) {
            System.out.print(i);
        }
    }

    public static void sort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void bubble(Integer[] arr){
        for(int i=0;i<arr.length;i++)
            for(int j=arr.length-1;j>i;j--){
                if(arr[j]<arr[j-1]){
                    int temp= arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
    }


}

