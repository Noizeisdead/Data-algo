package com.noize.Datastructures;

public interface Datastructure {


    void sort() throws Exception;
    Object search(int value);

    void insert(int value);

    String print();

    String getBigOSearch();

    String getBigOSort();
}
