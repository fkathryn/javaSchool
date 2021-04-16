import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;
    private T[] array;

    public MyArrayList() {
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
        this.array = (T[]) new Object[capacity];
    }

    public MyArrayList(int size) {
        this.size = size;
        this.capacity = size * 2;
        this.array = (T[]) new Object[capacity];
    }

    public MyArrayList(T[] array) {
        this.size = array.length;
        this.capacity = array.length * 2;
        this.array = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            array[i] = this.array[i];
        }
    }

    public int getSize() {
        return this.size;
    }

    public T get(int index) {
        if (checkIndexOutOfBound(index)) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        return this.array[index];
    }

    public void set(int index, T element) {
        if (checkIndexOutOfBound(index)) {
            throw new IndexOutOfBoundsException("Index out of bound");
        } else {
            this.array[index] = element;
        }
    }

    public void delete(int index) {
        if (checkIndexOutOfBound(index)) {
            throw new IndexOutOfBoundsException("Index out of bound");
        } else {
            for (int i = index; i < size - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
        }
        this.size -= 1;
    }

    public void sort(Comparator comparator) {
        quickSortArrays(this.array, 0, size - 1, comparator);
    }

    private void quickSortArrays(T[] array, int begin, int end, Comparator comparator) {
        if (end <= begin) {
            return;
        }
        int position = partition(array, begin, end, comparator);
        quickSortArrays(array, begin, position - 1, comparator);
        quickSortArrays(array, position + 1, end, comparator);
    }

    private int partition(T[] array, int begin, int end, Comparator comparator) {
        int counter = begin;
        for (int i = begin; i <= end; i++) {
            if (comparator.compare(array[i], array[end]) <= 0) {
                T temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        return counter - 1;
    }

    public T[] toArray() {
        T[] newArray = (T[]) new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }
        return newArray;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MyArrayList) {
            MyArrayList array = (MyArrayList) obj;
            if (this.size != array.size) {
                return false;
            } else {
                for (int i = 0; i < this.size; i++) {
                    if (this.array[i] != array.array[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < size - 1;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return get(i++);
                } else {
                    throw new NoSuchElementException("No element" + size);
                }
            }
        };
    }
    private boolean checkIndexOutOfBound(int index) {
        return (index < 0 || index > size - 1);
    }
}
