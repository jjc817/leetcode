package leetcode.dataStructure.priority;

import java.util.Comparator;

public class MaxPriorityQueue<T> {
    //存储队列中的元素
    private Object[] queue;
    //记录队列中元素的个数
    private int size;

    static final int DEFAULT_INITIAL_CAPACITY = 11;

    private final Comparator<? super T> comparator;

    public MaxPriorityQueue() {
        this(DEFAULT_INITIAL_CAPACITY, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return (Integer) o1 - (Integer) o2;
            }
        });
    }

    public MaxPriorityQueue(Comparator<? super T> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public MaxPriorityQueue(int capacity, Comparator<? super T> comparator) {
        if (capacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[capacity + 1];
        this.comparator = comparator;
    }

    public int size(){return size;}

    //判断队列是否为空
    public boolean isEmpty() {
        return size==0;
    }

    private void swap(int i, int j) {
        Object tmp = queue[i];
        queue[i] = queue[j];
        queue[j] = tmp;
    }

    private void resize() {
        int oldCapacity = queue.length;
        T[] newItems = (T[]) new Comparable[oldCapacity * 2];
        if (oldCapacity - 1 >= 0) System.arraycopy(queue, 1, newItems, 1, oldCapacity - 1);
        queue = newItems;
    }

    //往堆中插入一个元素
    public void insert(T t){
        if (size >= queue.length - 1){
            resize();
        }
        queue[++size] = t;
        siftUpUsingComparator(size,t,comparator);

    }
    //上浮

    private void siftUpUsingComparator(
            int k, T t,Comparator<? super T> cmp) {
        while (k > 1) {
            int parent = k / 2;
            Object e = queue[parent];
            if (cmp.compare(t, (T) e) >= 0){
                swap(k,parent);
            }
            k = k / 2;
        }
    }
    //返回最大元素,不刪除
    public T peek(){
        return  (T)queue[0];
    }

    //删除隊列中最大的元素,并返回这个最大元素
    public T pop(){
        Object max = queue[1];

        //交换最後的元素和首元素，让完全二叉树中最右侧的元素变为临时根结点
        swap(1,size);
        //最後的元素删除掉
        T t = (T) queue[size];
        queue[size]=null;
        //元素个数-1
        size--;
        //通过下沉调整,重新有序
        if (size > 0) {
            siftDownUsingComparator(1,comparator);
        }
        return (T)max;
    }

    //下沉
    private void siftDownUsingComparator(int k, Comparator<? super T> cmp) {
        while (2 * k <= size) {
            int max;

            if (2 * k + 1 <= size){
                int left = k * 2;
                int right = k * 2 + 1;

                if (cmp.compare((T)queue[left], (T)queue[right]) > 0)
                    max = left;
                else
                    max = right;
            }else
                max = 2 * k;

            if (cmp.compare((T)queue[k],(T) queue[max]) > 0)
                break;

            swap(max,k);
            k = max;
        }
    }
}
