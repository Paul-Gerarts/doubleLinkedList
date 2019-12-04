package com.syntra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


class DoubleLinkedListTest {

    DoubleLinkedList doubleLinkedList = Mockito.mock(DoubleLinkedList.class);

    @BeforeEach
    public void setUp(){
        doubleLinkedList = new DoubleLinkedList();
    }

    @Test
    public void testAddFunction(){
        //given

        //when
        doubleLinkedList.add("first test");

        //then
        assertThat(doubleLinkedList.getSize()).isEqualTo(1);
    }

    @Test
    public void testAddByPosition() throws Exception {
        //given
        int index = 1;
        doubleLinkedList.add("second test");
        String secondObjectToAdd = "(second test; second element)";

        //when
        doubleLinkedList.add(secondObjectToAdd, index);

        //then
        System.out.println(doubleLinkedList);
        assertThat(doubleLinkedList.get(index)).isEqualTo(secondObjectToAdd);
    }

    @Test
    public void testAddAll(){
        //given
        String firstObject = "1";
        String secondObject = "2";
        String thirdObject = "3";

        //when
        doubleLinkedList.addAll(firstObject, secondObject, thirdObject);

        //then
        assertThat(doubleLinkedList.getSize()).isEqualTo(3);
    }

    @Test
    public void testGetMyObject() throws Exception {
        //given
        Object testObject = "fourth test";

        //when
        doubleLinkedList.add(testObject);

        //then
        assertThat(doubleLinkedList.get(0)).isEqualTo(testObject);
    }

    @Test
    public void deleteMyObject(){
        //given
        Object testObject = "fifth test";

        //when
        doubleLinkedList.addAll(testObject, testObject, testObject);
        doubleLinkedList.delete(testObject);

        //then
        assertThat(doubleLinkedList.getSize()).isEqualTo(0);
    }
}