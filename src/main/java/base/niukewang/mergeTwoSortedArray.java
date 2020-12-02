package base.niukewang;

public class mergeTwoSortedArray {

    public static void main(String[] args) {
        int a[] = new int[6];
        a[0]=1;a[1]=4;a[2]=5;
        int b[] = {3,4};
        //sortArray(a,b,3,2);
        //sortArrayWithTmpArray(a,b,3,2);
        sortArrayWithRemove(a,b,3,2);

        for (int i : a) {
            System.out.println(i+" ");
        }
    }

    static void  sortArray(int[] a,int[] b,int m,int n){
        //a数组比较大，需要把b数据的内容放到a数组里面
        //如果从前面往后排，会设计到移动数据，复杂度较高，考虑从后面忘前面来算。
        int tmp_m=m,tmp_n=n;
        while(tmp_m>0&&tmp_n>0){
            if(a[tmp_m-1]>b[tmp_n-1]){
                a[tmp_m+tmp_n-1]=a[tmp_m-1];
                tmp_m--;
            }else{
                a[tmp_m+tmp_n-1]=b[tmp_n-1];
                tmp_n--;
            }
        }
        int i=0;
        while(tmp_n>0){
            a[i] = b[0];
            n--;
        }
    }

    //比较过程中移动元素会比较麻烦
    static void  sortArrayWithTmpArray(int[] a,int[] b,int m,int n) {
        //设置一个一个临时数组存放a和b合并后的元素
        //设置游标aIndex和bIndex,分别指向a数组和b数组的首位元素。
        //如果a的元素和b的元素存在，比较aIndex和bIndex所在的数组元素大小。
        //如果a[aIndex]的大小小于bIndex，然后aIndex++,继续和bIndex比较。tmp存储a[aIndex]的元素
        //如果a[aIndex]的大小大于bIndex,然后bIndex++，继续和aIndex比较。tmp存储b[bIndex]的元素
        //如果aIndex等于a数组的元素大小，那么把bIndex剩下的放到tmp
        int tmp[] = new int[m+n];
        int aIndex=0,bIndex=0,tmp_index=0;
        while (aIndex<m&&bIndex<n){
            if(a[aIndex]<b[bIndex]){
                tmp[tmp_index]=a[aIndex];
                aIndex++;
            }else {
                tmp[tmp_index]=b[bIndex];
                bIndex++;
            }
            tmp_index++;
        }
        if(aIndex==m){
            while (bIndex<n){
                tmp[tmp_index]=b[bIndex];
                tmp_index++;bIndex++;
            }
        }else {
            while (aIndex<m){
                tmp[tmp_index]=a[aIndex];
                tmp_index++;aIndex++;
            }
        }
        for(int i=0;i<tmp.length;i++){
            a[i]=tmp[i];
        }
    }

    static void sortArrayWithRemove(int a[],int b[],int m, int n){
        //先将a数组中的元素向后移动n个位置。
        for(int i=m-1;i>=0;i--){
            a[n+i]=a[i];
        }
        //设置a数组的游标aIndex=n，b数组的游标bIndex=0,当前合并后元素要存放的位置index。
        int aIndex=n,bIndex=0,index=0;
        //如果aIndex<m+n && bIndex<n，对比a[aIndex]和b[bIndex]的大小。设置a[index]的大小为小的元素。
        while (aIndex<m+n&&bIndex<n){
            if(a[aIndex]<b[bIndex]){
                a[index]=a[aIndex];
                aIndex++;
            }else {
                a[index]=b[bIndex];
                bIndex++;
            }
            index++;
        }
        //如果aIndex=m+n，那么设置index后面的数据为b数组的剩余元素，否则就结束。
        if(aIndex>=m+n){
            while (index<m+n&&bIndex<n){
                a[index]=b[bIndex];
                bIndex++;index++;
            }
        }
    }
}
