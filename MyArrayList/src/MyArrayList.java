import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyArrayList<type> implements List<type> {
    private Object[] array;
    private int length;
    private int size;

    public MyArrayList() {
        this.length = 0;
        this.size = 2;
        this.array = new Object[this.size];
    }

    @Override
    public <T> T[] toArray(T[] container) {

        System.arraycopy(this.array, 0, container, 0, this.length);
        if (container.length > 0) {
            
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

    @Override
    public boolean addAll(Collection<? extends type> c) {
        return addAll(this.length - 1, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends type> c) {
        if (c.isEmpty()) {
            return false;
        }
        while (this.size < c.size()) {
            doubleArraySize();
        }
        shiftRight(index, this.length - 1, c.size());
        System.arraycopy(c, 0, this.array, index, c.size());

        return true;
    }

    @Override
    public List<type> subList(int s, int e) {
        List<type> sub = new ArrayList<>();
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
    public type get(int index) {
        if (isOutOfBounds(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (type) array[index];
    }

    private void doubleArraySize() {
        Object[] copy = new Object[this.size];
        System.arraycopy(this.array, 0, copy, 0 , this.length);
        this.size *= 2;
        this.array = new Object[this.size];
        System.arraycopy(copy, 0, this.array, 0, this.length);
    }

    public void shiftRight(int index) {
        shiftRight(index, this.length - 1, 1);
    }

    public void shiftRight(int start, int end) {
        shiftRight(start, end - 1, 1);
    }

    public void shiftRight(int start, int end, int amount) {
        int length = end - start + 1;
        if (start < 0 || end > length || start >= end) {
            throw new IndexOutOfBoundsException();
        }

        if (amount < 0) {
            throw new IllegalArgumentException();
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
    public type remove(int index) {
        if (isOutOfBounds(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        type dataRemoved = (type) this.array[index];
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
    public type set(int index, type data) {
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
