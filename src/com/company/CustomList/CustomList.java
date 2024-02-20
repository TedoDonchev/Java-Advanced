package com.company.CustomList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T> {

    private List<T> data;

    public CustomList () {
        this.data = new ArrayList<>();
    }

    public void add(T el) {
        this.data.add(el);
    }

    public T remove(int index) {
        if (index < this.data.size()) {
            T removedEl = this.data.get(index);
            this.data.remove(index);
            return removedEl;
        }
        return null;
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int index1, int index2) {
        if (index1 < this.data.size() && index2 < this.data.size()) {
            T temp = this.data.get(index1);
            this.data.set(index1, this.data.get(index2));
            this.data.set(index2, temp);
        }
    }

    public int countGreaterThan(T element) {
        List<T> sorted = this.data.stream().sorted().collect(Collectors.toList());
        int indx = sorted.indexOf(element);
        return sorted.size() - 1 - indx;
    }

    public T getMax() {
        List<T> sorted = this.data.stream().sorted().collect(Collectors.toList());
        return sorted.get(sorted.size() - 1);
    }

    public T getMin() {
        List<T> sorted = this.data.stream().sorted().collect(Collectors.toList());
        return sorted.get(0);
    }

    public void print() {
        for (T el : this.data) {
            System.out.println(el);
        }
    }
}
