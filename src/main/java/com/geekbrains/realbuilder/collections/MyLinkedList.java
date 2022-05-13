package com.geekbrains.realbuilder.collections;

public class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList(){
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node( E data){
            this.data=data;
        }
    }

    public void add(T item, int index) {
        if( index<0 || index>size){
            throw new IndexOutOfBoundsException("" + index);
        }
        Node <T>  curr= head;
        Node<T> prev=null;
        int i=0;
        while(curr !=null && i!=index){
            prev=curr;
            curr=curr.next;
            i++;
        }
        Node <T> newNode= new Node<>(item);
        if(prev==null){
            newNode.next=head;
            head=newNode;
        } else{
            prev.next=newNode;
            newNode.next=curr;
        }
        size++;
    }

    public T remove(int index) {
        T removed;
        if (index == 0) {
            removed = head.data;
            head = head.next;
        } else {
            Node<T> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            removed =curr.next.data;
            curr.next = curr.next.next;
        }
        size--;
        return removed;
    }

    public int find(T keyitem) {
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.data == keyitem) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public T get ( int index){
        Node<T> current =head;
        for( int i=0; i<index; i++){
            current =current.next;
        }
        return current.data;
    }

    public int getSize() {
        return size;
    }

    public void reverse() {
        Node <T> prev = null;
        Node <T> current = head;
        Node <T> Next = null;
        while (current != null)
        {
            Next = current.next;
            current.next = prev;
            prev= current;
            current = Next;
        }
        head = prev;
    }
}
