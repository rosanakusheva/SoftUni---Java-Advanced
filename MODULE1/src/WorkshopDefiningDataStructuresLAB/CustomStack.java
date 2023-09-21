package WorkshopDefiningDataStructuresLAB;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private static final int initialCapacity = 4;

    private int[] data;
    private int size;
    private int capacity;

    public CustomStack() {
        this.data = new int[initialCapacity];
        this.capacity = initialCapacity;
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            resize();
        }
        this.data[this.size] = element;
        this.size++;
    }

    private void resize() {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];

        for (int i = 0; i < this.size; i++) {
            copy[i] = this.data[i];
        }
        this.data = copy;
    }

    public int pop() {
        checkIfEmpty();
        int element = this.data[this.size - 1];
        this.data[this.size - 1] = 0;
        this.size--;

        if (this.size <= this.capacity / 4) {
            shrink();
        }
        return element;
    }

    private void shrink() {
        this.capacity /= 2;
        int[] copyArr = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            copyArr[i] = this.data[i];
        }
        this.data = copyArr;
    }

    public int peek() {
        checkIfEmpty();
        return this.data[this.size - 1];
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    private void checkIfEmpty(){
        if (this.size == 0) {
            throw new NoSuchElementException("CustomStack is empty!");
        }
    }

}
