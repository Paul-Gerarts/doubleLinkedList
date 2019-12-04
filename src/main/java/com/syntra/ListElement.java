package com.syntra;

public class ListElement<E> {
    private E object;
    private ListElement<E> previous;
    private ListElement<E> next;

    public ListElement(E object) {
        this.object = object;
    }

    public ListElement(E object, ListElement<E> previous, ListElement<E> next) {
        this.object = object;
        this.previous = previous;
        this.next = next;
    }

    public E getObject() {
        return object;
    }

    public ListElement<E> getPrevious() {
        return previous;
    }

    public void setPrevious(ListElement<E> previous) {
        this.previous = previous;
    }

    public ListElement<E> getNext() {
        return next;
    }

    public void setNext(ListElement<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return object.toString();
    }
}
