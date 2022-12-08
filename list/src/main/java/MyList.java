public interface MyList {
    int size();
    boolean isEmpty();
    boolean contains(int item);
    void addFront(int item);
    void delete(int item);
    int getElement(int i);
    void insertAfter( int index, int item );
}
