public class CSArrayList<E> implements SimpleList<E> {

    private static final int DEFAULT_CAPACITY = 4;

    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public CSArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(E value) {
        // TODO: student implementation
        if (size == data.length) {
            grow();
        }

        data[size] = value;
        size++;
    }

    @Override
    public void add(int index, E value) {
        // TODO: student implementation
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (size == data.length) {
            grow();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        size++;

    }

    @Override
    public E get(int index) {
        // TODO: student implementation
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index");
        }

        return data[index];
    }

    @Override
    public E remove(int index) {
        // TODO: student implementation
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        E removedValue = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i +1];
        }

        data[size - 1] = null;
        size--;

        return removedValue;
    }

    @Override
    public int size() {
        // TODO: student implementation
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO: student implementation
        return size == 0;
    }

    /**
     * Returns a simple view of every backing-array slot for debugging.
     */
    public String debugView() {
        StringBuilder view = new StringBuilder();
        view.append("size: ").append(size).append(System.lineSeparator());
        view.append("capacity: ").append(data.length).append(System.lineSeparator());

        for (int index = 0; index < data.length; index++) {
            view.append(index).append(": ").append(data[index]);
            if (index < data.length - 1) {
                view.append(System.lineSeparator());
            }
        }

        return view.toString();
    }

    // Private helper methods may be added by students.
    @SuppressWarnings("unchecked")
    private void grow() {
        E[] newData = (E[]) new Object[data.length * 2];

        for (int i = 0; i < size; i++) {
            newData [i] = data [i];
        }

        data = newData;
    }
}