package com.yuyy.collection;

/**
 * @author yuyy
 * @date 2019/10/12 18:12
 */
public class MyList<E> {
    private Object[] arr;
    private int size;
    public static final int DEFAULT_CAPACITY=10;
    public MyList(){
        arr=new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        arr=new Object[capacity];
    }
    public void add(E e){
        if(size>=arr.length){
            Object[] newArr=new Object[arr.length+(arr.length>>1)];
            System.arraycopy(arr,0,newArr,0,arr.length);
            arr=newArr;
        }
        arr[size++]=e;
    }

    public E get(E e){
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(e)){
                return get(i);
            }
        }
        throw new RuntimeException("not found");
    }

    public E get(int index){
        checkRange(index);
        return (E)arr[index];
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        for (int i = 0; i <size; i++) {
            System.out.println(arr[i].toString());
            sb.append(arr[i].toString()+',');
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public void set(int index,E e){
        checkRange(index);
        arr[index]=e;
    }

    public void remove(int index){
        checkRange(index);
        if (index<size){
            int numMoved=size-index-1;
            System.arraycopy(arr,index+1,arr,index,numMoved);
        }
        arr[--size]=null;
    }

    public void remove(E e){
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(e)){
                remove(i);
            }
        }
    }

    public void checkRange(int index){
        if(index<0||index>=arr.length){
            throw new RuntimeException("越界");
        }
    }

    public static void main(String[] args){
        if("string  ".trim()=="string"){
            System.out.println(222);
        }
        MyList<String> list=new MyList<>();
        for (int i = 0; i < 18; i++) {
            list.add("str"+i);
        }
        System.out.println(list);
        System.out.println(list.get(11));
        System.out.println(list.size);
        list.remove(3);
        System.out.println(list);
        list.remove("str0");
        list.remove("str17");
        System.out.println(list);
        //System.out.println(list.get(41));

    }
}
