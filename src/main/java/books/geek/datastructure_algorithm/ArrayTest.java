package books.geek.datastructure_algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * user:sheng.chen
 * date:2021/4/15
 **/
public class ArrayTest {
    //数组元素
    int array[]={0,1,3};

    /***
     * java语言的特性是不允许数组中进行越界访问，越界访问会抛出ArrayIndexOutOfBoundsException错误。
     * 而C语言是可以进行访问的。如果存储的是其他内容，也可以正常获取到。
     */

    //获取数组的长度。
    @Test
    public void getArrayLength(){
        Assert.assertEquals(3,array.length);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void indexOutOfBoundsException(){
        array[array.length]++;
    }

    @Test
    public void insertDataInKPlace(){
        int k=2;
        int targetValue=4;
        int[] newArray = Arrays.copyOf(array, array.length + 1);
        if(k>array.length) {
            return;
        }else{
            //扩容array数组的大小
            for(int index=array.length-1;index>=k-1;index--){
                newArray[index+1] = newArray[index];
            }
            newArray[k-1]=targetValue;
        }
        //判断第k个元素是不是targetValue
        Assert.assertEquals(newArray[k-1],targetValue);
        //判断新数组的长度是不是原来长度+1
        Assert.assertEquals(array.length+1,newArray.length);
        //判断新数组的K+1的元素是不是原来的第K个元素
        Assert.assertEquals(array[k-1],newArray[k]);
        //判断新数组的最后一个元素是不是原来的最后一个元素
        Assert.assertEquals(array[array.length-1],newArray[newArray.length-1]);
    }
}
