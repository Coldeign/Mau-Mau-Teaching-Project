package maumau.deck;

public class LinkedStack<T> {
    private LinkedStackElement<T> head;

    public LinkedStack() {
        head = null;
    }

    public LinkedStack(T input) {
        this.head = new LinkedStackElement<>(input);
    }

    public void add (T toAdd) {
        head = new LinkedStackElement<>(toAdd, head);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T temp = head.getData();
        head = head.getNext();
        return temp;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

class LinkedStackElement<T> {
    private final T data;
    private LinkedStackElement<T> next;
    //private LinkedStackElement<T> prev;

    LinkedStackElement(T data) {
        this.data = data;
        this.next = null;
        //this.prev = null;
    }

    LinkedStackElement(T data, LinkedStackElement<T> next) {
        this.data = data;
        this.next = next;
        //this.prev = null;
    }

    /*
    public LinkedStackElement(T data, LinkedStackElement<T> next, LinkedStackElement<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
     */

    public T getData() {
        return data;
    }

    public LinkedStackElement<T> getNext() {
        return next;
    }

    public void setNext(LinkedStackElement<T> next) {
        this.next = next;
    }

    /*
    public LinkedStackElement<T> getPrev() {
        return prev;
    }

    public void setPrev(LinkedStackElement<T> prev) {
        this.prev = prev;
    }
     */
}
