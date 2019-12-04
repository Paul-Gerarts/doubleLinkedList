package com.syntra;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add("first");
        doubleLinkedList.add("second");
        doubleLinkedList.add("third");
        try {
            doubleLinkedList.add("(fourth, becoming third)",2);
            System.out.println(doubleLinkedList);

            System.out.println(doubleLinkedList.previous());
            System.out.println(doubleLinkedList.previous());
            System.out.println(doubleLinkedList.previous());
            System.out.println(doubleLinkedList.previous());
            System.out.println(doubleLinkedList.previous());
            System.out.println(doubleLinkedList.previous());
            doubleLinkedList.addAll("1", "2", "3", "4");
            System.out.println(doubleLinkedList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(doubleLinkedList.getSize());
            doubleLinkedList.delete("iets");
            System.out.println(doubleLinkedList.getSize());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
