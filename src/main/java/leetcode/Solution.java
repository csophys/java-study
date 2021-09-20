package leetcode;


public class Solution {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,2,3,2,2};
        System.out.println(new Solution().maxLength(arr));
    }
    /**
     * 
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        //穷举法，从第一个元素依次往后查找，直到有相同的元素出现，并且记录相同的元素出现的位置。并且优化往后继续查找的位置。
        //如果要跳转已经匹配过的元素。
        if(arr.length==0) return 0;
        int maxl=1;
        for(int i=0;i<arr.length-1;i++){
            int tempLength=1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]!=arr[i]){
                    tempLength++;
                    if(j==arr.length-1){
                        if(tempLength>maxl)
                            maxl=tempLength;
                        break;
                    }
                }else{
                    if(tempLength>maxl){
                        maxl=tempLength;
                    }
                    break;
                }
            }
        }
        return maxl;
    }
}