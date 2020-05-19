package com.kangyl.test.queue.myqueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/5/16
 */
public class MyBlockingQueue<E> implements BlockingQueue<E> {

    static class Node<E> {
        E item;

        Node<E> next;

        Node(E item){
            this.item = item;
        }
    }

    private final ReentrantLock takeLock = new ReentrantLock();
    private final Condition notEmpty = takeLock.newCondition();
    private final ReentrantLock putLock = new ReentrantLock();
    private final Condition notFull = putLock.newCondition();

    private final int capacity;
    private final AtomicInteger currentCount = new AtomicInteger();
    transient Node<E> head;
    private transient Node<E> tail;

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
        head = tail = new Node<>(null);
    }

    public MyBlockingQueue(){
        this(Integer.MAX_VALUE);
    }

    @Override
    public boolean add(E e) {
        if(offer(e)){
            return true;
        }else{
            throw new IllegalStateException(" queue is full");
        }
    }

    private void enqueue(Node<E> node){
        tail = tail.next = node;
    }


    @Override
    public boolean offer(E e) {
        int count = currentCount.get();
        if (count == capacity) {
            return false;
        }
        putLock.lock();
        int c = -1;
        try{
            if(currentCount.get()<capacity){
                Node newNode = new Node<E>(e);
                enqueue(newNode);
                c = currentCount.getAndIncrement();
                if (c + 1 < capacity) {
                    notFull.signal();
                }
            }
        }finally {
            putLock.unlock();
        }

        if (c == 0) {
            takeLock.lock();
            try{
                notEmpty.signal();
            }finally {
                takeLock.unlock();
            }
        }

        return c >= 0;
    }

    @Override
    public void put(E e) throws InterruptedException {

    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public E take() throws InterruptedException {
        AtomicInteger count = this.currentCount;
        takeLock.lock();
        int num = -1;
        E item = null;
        try{
            while (count.get()==0){
                notEmpty.await();
            }
            item = dequeue();
            num = count.getAndDecrement();
            if (num > 1) {
                notEmpty.signal();
            }

        }finally {
            takeLock.unlock();
        }
        if (num ==capacity) {
            putLock.lock();
            try{
                notFull.signal();
            }finally {
                putLock.unlock();
            }
        }

        return item;
    }

    private E dequeue() {
        Node<E> h = this.head;
        Node<E> first = head.next;
        h.next = h;
        E x = first.item;
        first.item = null;
        head = first;
        return x;
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }
        fullLock();
        try{
            Node<E> h = this.head;

        }finally {
            fullLock();
        }
        return false;
    }



    private void fullLock() {
        takeLock.lock();
        putLock.lock();
    }

    private void fullUnlock() {
        takeLock.unlock();
        putLock.unlock();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
