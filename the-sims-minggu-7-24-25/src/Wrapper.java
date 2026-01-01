public class Wrapper<T> {
    T wrapped;

    public Wrapper(T wrapped) {
        this.wrapped = wrapped;
    }

    public Wrapper() {
        this.wrapped = null;
    }

    public void set(T newWrapped) {
        this.wrapped = newWrapped;
    }

    public T get() {
        return this.wrapped;
    }
}
