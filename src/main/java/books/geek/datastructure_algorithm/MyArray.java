package books.geek.datastructure_algorithm;

/**
 * user:sheng.chen
 * date:2021/4/15
 **/

import lombok.Data;

/**
 * 创建一个MyArray类，提供目前数组数据的量。并且提供在指定位置插入和从指定位置删除的功能。
 */
@Data
public class MyArray {

    private int size;
    private int count = 0;
    private int array[];

    MyArray(int size) {
        this.size = size;
        array = new int[size];
    }

    /**
     * 在指定索引下标插入数据
     *
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        //判断数组是否已经满了，如果满了，返回失败
        if (count >= size) {
            return false;
        }
        //判断数组未满，插入的下标是否合理，如果不合理，返回失败
        if (index < 0 || index > count) {
            return false;
        }
        //将数组下标是index到count-1的所有数据都往后移动一位
        for (int i = count - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        //把index位置处的数据设置为value,count加1
        array[index] = value;
        count++;
        return true;
    }

    /**
     * 删除第index的元素
     * @param index
     * @return
     */
    public boolean delete(int index){
        //判断index的位置是否合理
        if(index<0||index>=count){
            return false;
        }
        //将index到count-1下标的元素都向左移动一位
        for(int i=index;i<count-1;i++){
            array[i]=array[i+1];
        }
        //count减1
        count--;
        return true;
    }

}
