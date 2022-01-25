package com.yan.tuling.juc.forkjoin;

import java.util.Arrays;

/**
 * Created by huyan on 2021/12/4.
 * TIME: 16:22
 * DESC:
 */
public class MergeSort {

    /**
     * 归并排序：假设最小数组长度为2
     *      对数组从中部进行分割，判断分割后的两个数组长度是否小于2，如果不是，继续分割子数组，直接所有的子数组长度均小于2
     *      对所有的子数组元素进行排序
     *      对相邻两子数组进行合并，同时进行排序
     *      直到所有子数组合并完成，最终得到的结果就是有序数组
     * @param args
     */
    public static void main(String[] args) {
        Integer[] needSortArray = new Integer[]{3, 1, 5, 75, 2, 52, 63, 6, 37, 3, 6, 23 , 723, 423, 6, 23};

        System.out.println(Arrays.asList(mergeSort(needSortArray)));


    }

    /**
     * 从大到小排序
     * @param array
     * @return
     */
    private static Integer[] mergeSort(Integer[] array) {
        if (array.length < 2) {
            return sort(array);
        } else {
            int mid = array.length / 2;
            Integer[] leftArr = Arrays.copyOfRange(array, 0, mid);
            Integer[] rightArr = Arrays.copyOfRange(array, mid, array.length);
            return merge(mergeSort(leftArr), mergeSort(rightArr));
        }
    }

    /**
     * 对数组进行排序，从大到小
     * @param array
     * @return
     */
    private static Integer[] sort(Integer[] array) {
        if (array.length == 1) {
        } else {
            if (array[0] < array[1]) {
                int value = array[0];
                array[0] = array[1];
                array[1] = value;
            }
        }
        return array;
    }

    /**
     * 将两个数组合并到一起，从大到小
     * @param leftArr
     * @param rightArr
     * @return
     */
    private static Integer[] merge(Integer[] leftArr, Integer[] rightArr) {
        Integer[] mergeArray = new Integer[leftArr.length + rightArr.length];

        for (int index = 0, leftIndex = 0, rightIndex = 0; index < mergeArray.length; index++) {
            //防止数组越界
            if (leftIndex >= leftArr.length) {
                mergeArray[index] = rightArr[rightIndex++];
            } else if (rightIndex >= rightArr.length) {
                mergeArray[index] = leftArr[leftIndex++];
            }
            //正常的，左右数组比较大小（两值相等，取哪边都可以）
            else if (leftArr[leftIndex] >= rightArr[rightIndex]) {
                mergeArray[index] = leftArr[leftIndex++];
            } else {
                mergeArray[index] = rightArr[rightIndex++];
            }
        }
        return mergeArray;
    }

}
