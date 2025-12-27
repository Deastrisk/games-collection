// import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayList<E> implements List<E> {
    private Object[] array;
    private int length;
    private int size;

    public MyArrayList() {
        this.length = 0;
        this.size = 2;
        this.array = new Object[this.size];
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        return new MyIterator();
    }

    private class MyIterator implements ListIterator<E> {
        private int cursor = 0;
        private int lastReturned = -1;

        public MyIterator() {
            this(0);
        }

        public MyIterator(int start) {
            cursor = start;
        }

        @Override
        public int previousIndex() {
            return lastReturned - 1;
        }

        @Override
        public void set(E data) {
            MyArrayList.this.array[lastReturned] = data;
            lastReturned = -1;
        }

        @Override
        public void add(E data) {
            if (data.equals(MyArrayList.this.))
            MyArrayList.this.add(lastReturned, data);
            lastReturned = -1;
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            lastReturned = cursor - 1;
            return (E) MyArrayList.this.array[cursor++];
        }

        @Override
        public boolean hasNext() {
            return cursor < MyArrayList.this.length;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = cursor;
            return (E) MyArrayList.this.array[cursor++];
        }

        @Override
        public void remove() {
            if (lastReturned < 0) {
                throw new NoSuchElementException();
            }

            MyArrayList.this.remove(lastReturned);
            cursor = lastReturned;
            lastReturned = -1;
        }
    }

    @Override
    public Object[] toArray() {
        return java.util.Arrays.copyOf(this.array, this.length);
    }

    // SuppressWarnings can be used on classes,
    // methods, fields, parameters, constructors,
    // and local variables to suppress warnings

    // converts ArrayList to a low-level array
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] container) {
        Objects.requireNonNull(container, "Array cannot be null");

        // container length is smaller than the needed size
        if (container.length < this.length) {
            // creates an array with contents of this.array
            // then changes the array type to T[]
            return (T[]) Arrays.copyOf(
                this.array, 
                this.length, 
                container.getClass()
            );
        }

        // copies this.array to container
        System.arraycopy(this.array, 0, container, 0, this.length);

        // adds null to mark the end of the array if the
        // container size is larger than the actual amount
        // of contents inside
        if (container.length > this.length) {
            container[this.length] = null;
        }
        return container;
    }

    @Override
    public int indexOf(Object data) {
        for (int i = 0; i < this.length; i++) {
            if (data.equals(this.array[i])) return i;
        }
        final int dataNotFound = -1;
        return dataNotFound;
    }

    @Override
    public int lastIndexOf(Object data) {
        int latest = -1;
        for (int i = 0; i < this.length; i++) {
            if (data.equals(this.array[i])) latest = i;
        }
        return latest;
    }

    // ?           : (wildcard) an unknown fixed type
    // ? extends E : an unknown type which is a subclass of E
    // ? super E   : an unknown type which is a superclass of E
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(this.length - 1, c);
    }
    
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Objects.requireNonNull(c, "Collection cannot be null");
        if (c.isEmpty()) {
            return false;
        }

        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }

        while (this.size < this.length + c.size()) {
            doubleArraySize();
        }

        shiftRight(index, this.length - 1, c.size());

        Object[] copy = c.toArray();
        System.arraycopy(copy, 0, this.array, index, copy.length);
        
        this.length += c.size();
        return true;
    }

    @Override
    public List<E> subList(int s, int e) {
        List<E> sub = new MyArrayList<>();
        return sub;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (int i = 0; i < this.length; i++) {
            if (!c.contains(this.array[i])) return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;
        for (int i = 0; i < this.length;) {
            if (collection.contains(this.array[i])) {
                remove(i);
                modified = true;
            } else {
                i++;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean modified = false;
        for (int i = 0; i < this.length;) {
            if (!collection.contains(this.array[i])) {
                remove(i);
                modified = true;
            } else {
                i++;
            }
        }

        return modified;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (isOutOfBounds(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    private void doubleArraySize() {
        Object[] copy = new Object[this.size];
        System.arraycopy(this.array, 0, copy, 0 , this.length);
        this.size *= 2;
        this.array = new Object[this.size];
        System.arraycopy(copy, 0, this.array, 0, this.length);
    }

    private void shiftRight(int index) {
        shiftRight(index, this.length - 1, 1);
    }

    // private void shiftRight(int start, int end) {
    //     shiftRight(start, end - 1, 1);
    // }

    private void shiftRight(int start, int end, int amount) {
        int length = end - start + 1;
        if (start < 0 || end >= this.length || start > end) {
            throw new IndexOutOfBoundsException();
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be more than 0");
        }

        if (start + amount + length > this.size) {
            throw new IndexOutOfBoundsException("Insufficient Capacity");
        }

        System.arraycopy(this.array, start, this.array, start + amount, length);
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.length; i++) {
            this.array[i] = this.array[i + 1];
        }
    }

    @Override
    public boolean add(Object data) {
        add(this.length, data);
        return true;
    }

    @Override
    public void add(int index, Object data) {
        this.length++;
        if (this.size == this.length) {
            doubleArraySize();
        }
        shiftRight(index);
        this.array[index] = data;
    }

    @Override
    public int size() {
        return this.length;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        if (isOutOfBounds(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E dataRemoved = (E) this.array[index];
        shiftLeft(index);
        this.length--;

        return dataRemoved;
    }

    @Override
    public boolean remove(Object data) {
        for (int i = 0; i < this.length; i++) {
            if (data.equals(this.array[i])) return true;
        }
        return false;
    }

    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= this.length;
    }

    @Override
    public E set(int index, E data) {
        if (isOutOfBounds(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }

        this.array[index] = data;

        return data;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public void clear() {
        this.size = 2;
        this.length = 0;
        this.array = new Object[this.size];
    }

    @Override
    public boolean contains(Object data) {
        for (int i = 0; i < this.length; i++) {
            if (this.array[i].equals(data)) return true;
        }
        return false;
    }
}
