package leetbook.list;

import java.util.HashMap;

/**
 * @author: yh_wang
 * @date: 2023-03-29 16:12
 * @apiNote 用链表实现lru缓存
 **/
public class LruLinkedList<K,V> {

    //实现思路：
    // 1.维护单向有序链表，链表尾存放最近访问次数最小的元素
    //2. 每次从缓存中获取元素，如果在链表中，则将其插入到链表头，并删除原位置的元素
    //3. 如果缓存中没有，则直接插入链表头即可

    /**
     * 默认缓存容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头节点
     */
    private Node<K,V> headNode;

    /**
     * 尾结点
     */
    private Node<K,V> tailNode;

    private Integer length;

    private Integer capacity;

    private HashMap<K, Node<K,V>> table;


    public static class Node<K,V>{

        Node(){}

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        private K key;

        /**
         * 节点数据
         */
        private V value;

        /**
         * 前驱指针
         */
        private Node<K,V> prev;

        /**
         * 后继节点
         */
        private Node<K,V> next;
    }

    public LruLinkedList(int capacity){
        this.length = 0;
        this.capacity =capacity;

        headNode = new Node<>();
        tailNode = new Node<>();

        headNode.next = tailNode;
        tailNode.next = headNode;
    }

    public LruLinkedList(){this(DEFAULT_CAPACITY);}

    /**
     * 数据新增
     * @param value 缓存值
     */
    public void add(K key, V value){
        Node<K, V> kvNode = table.get(key);
        if(null == kvNode){
            Node<K, V> node = new Node<>(key, value);
            table.put(key, node);

            //添加到头结点
            addNode(node);

            //判断缓存是否超出容量
            if(++length > capacity){
                Node<K, V> tail = popTail();
                table.remove(tail.key);
                length --;
            }
        }else {
            kvNode.value = value;
            moveToHead(kvNode);
        }
    }

    public void addNode(Node<K,V> newNode){
        newNode.next = headNode.next;
        newNode.prev = headNode;


        headNode.next.prev = newNode;
        headNode.next = newNode;
    }

    public Node<K,V> popTail(){

        Node<K, V> prev = tailNode.prev;
        removeNode(prev);
        return prev;
    }

    public void moveToHead(Node<K,V> node){
        addNode(node);
        //删除原节点
        removeNode(node);
    }

    public void removeNode(Node<K,V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public V get(K key){
        Node<K, V> kvNode = table.get(key);
        if(null == kvNode){
            return null;
        }
        moveToHead(kvNode);
        return kvNode.value;
    }

    public void remove(K key){
        Node<K, V> kvNode = table.get(key);
        if(null == kvNode){
            return;
        }
        removeNode(kvNode);
        length--;
        table.remove(kvNode.key);
    }

    public void print(){
        Node<K, V> next = headNode.next;
        while(next.next != null){
            System.out.println(next.value);
            next = next.next;
        }
    }

}
