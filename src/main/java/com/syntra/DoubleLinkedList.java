package com.syntra;

public class DoubleLinkedList<E> {
    private ListElement<E> currentListElement;
    private ListElement<E> firstListElement;
    private ListElement<E> lastListElement;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(E object) {
        ListElement<E> newListElement = new ListElement<>(object);
        if (size == 0) {
            firstListElement = newListElement;
        } else {
            lastListElement.setNext(newListElement);
            newListElement.setPrevious(lastListElement);
        }
        lastListElement = newListElement;
        currentListElement = newListElement;
        size++;
    }

    public void add(E object, int positie) {
        ListElement<E> element = new ListElement<>(object);
        try {
            element = getListElement(positie);
        } catch (Exception e) {
            add(object);
        }
        ListElement<E> newElement = new ListElement<>(object);
        newElement.setNext(element);
        newElement.setPrevious(element.getPrevious());
        if (element.getPrevious() != null) {
            element.getPrevious().setNext(newElement);

        }
        element.setPrevious(newElement);
        if (positie == 0) {
            firstListElement = newElement;
        }
        currentListElement = newElement;
        size++;
    }

    public E get(int positie) throws Exception {
        return getListElement(positie).getObject();
    }

    public ListElement<E> getListElement(int positie) throws Exception {
        currentListElement = firstListElement;
        for (int i = 0; i < positie; i++) {
            currentListElement = currentListElement.getNext();
            if (currentListElement == null) {
                throw new Exception("Positie bestaat niet");
            }
        }
        return currentListElement;
    }

    public E next() {
        ListElement<E> newCurrentListElement = currentListElement;
        if (currentListElement.getNext() != null) {
            currentListElement = currentListElement.getNext();
        }
        return newCurrentListElement.getNext() != null && newCurrentListElement.getNext().getObject() != null ? newCurrentListElement.getNext().getObject() : (E) "There is no next Object";
    }

    public E previous() {
        ListElement<E> newCurrentListElement = currentListElement;
        if (currentListElement.getPrevious() != null) {
            currentListElement = currentListElement.getPrevious();
        }
        return newCurrentListElement.getPrevious() != null && newCurrentListElement.getPrevious().getObject() != null ? newCurrentListElement.getPrevious().getObject() : (E) "There is no previous Object";
    }

    @SafeVarargs
    public final void addAll(E... objects) {
        for (E o : objects) {
            add(o);
        }
    }

    public void delete(E object) {
        ListElement<E> element = firstListElement;
        while (element != null) {
            if (element.getObject().equals(object)) {
                if (element.getNext() != null) {
                    element.getNext().setPrevious(element.getPrevious());
                }
                if (element.getPrevious() != null) {
                    element.getPrevious().setNext(element.getNext());
                }
                size--;
            }
            element = element.getNext();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoubleLinkedList [");
        ListElement<E> element = firstListElement;
        while (element != null) {
            sb.append(element.getObject());
            element = element.getNext();
            if (element != null) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}