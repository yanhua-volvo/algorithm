package leetbook.heap;

import lombok.Data;

/**
 * @author: yh_wang
 * @date: 2023-05-08 11:37
 **/
@Data
public class Heap {

    /**
     * 堆数据存储
     */
    private int[] container;

    /**
     * 堆容量
     */
    private int capacity;

    /**
     * 存储的数据数量
     */
    private int count;

    public Heap(int capacity) {
        container = new int[capacity];
        count = 0;
    }

    /**
     * 插入
     *
     * @param num 元素
     */
    public void insert(int num) {
        if (count >= capacity) {
            //堆满
            return;
        }
        ++count;
        container[count] = num;
        int index = count;

        //index/2 表示当前节点的父节点
        while (index / 2 > 0 && container[index] > container[index / 2]) {
            //swap
            swap(container, index, index / 2);
            index = index / 2;
        }
    }

    /**
     * 删除大根堆堆顶元素
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        //把最后一个元素移到堆顶，也就是删除了堆顶元素，然后堆化即可
        container[1] = container[count];
        --count;
        heapify(container, count, 1);
    }

    /**
     * 堆化
     *
     * @param source 源
     * @param count 堆size
     * @param index  当前堆化起始索引
     */
    public void heapify(int[] source, int count, int index) {
        while (true) {
            int maxPos = index;

            //求当前节点index和其子节点的最大节点索引
            if (index * 2 <= capacity && source[index * 2] > source[index]) {
                maxPos = index * 2;
            }
            if (index * 2 + 1 <= capacity && source[index * 2 + 1] > source[index]) {
                maxPos = index * 2 + 1;
            }

            //当前索引已经是最大索引，则堆化结束
            if (maxPos == index) {
                break;
            }

            swap(source, index, maxPos);
            index = maxPos;
        }
    }

    /**
     * 堆排序
     *
     * @param source 原数据
     */
    public void sort(int[] source){

        //建堆
        buildHeap(source);

        //排序(此时堆顶元素已经是最大值)
        int n = source.length;
        int k = n;
        while(k>1){
            swap(source,k,1);
            --k;
            heapify(source, k, 1);
        }
    }

    /**
     * 建堆
     *
     * @param source 源
     */
    public void buildHeap(int[] source){
      //从最后一个非叶子节点开始构建
      int n = source.length;
      for(int i = n/2; i>=1;i--){
          heapify(source,n,i);
      }
    }


    public void swap(int[] source, int index1, int index2) {
        int temp = source[index1];
        source[index1] = source[index2];
        source[index2] = temp;
    }
}
