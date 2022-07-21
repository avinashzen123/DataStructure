package com.avinash.queue;

class Item {
    int value;
    int priority;
}

// https://www.geeksforgeeks.org/priority-queue-set-1-introduction/
public class PriorityQueue {
    static Item[] pr = new Item[1000];
    static int size = -1;

    static void enqueue(int value, int priority) {
        size++;
        pr[size] = new Item();
        pr[size].value = value;
        pr[size].priority = priority;
    }

    static int peek() {
        int highestPriority = Integer.MIN_VALUE;
        int ind = -1;

        for (int i = 0; i <= size; i++) {
            if (highestPriority == pr[i].priority && ind > -1 && pr[ind].value < pr[i].value) {
                highestPriority = pr[i].priority;
                ind = i;
            } else if (highestPriority < pr[i].priority) {
                highestPriority = pr[i].priority;
                ind = i;
            }
        }
        return ind;
    }

    static void dequeue() {
        int ind = peek();

        // Shift the element one index before
        // from the position of the element
        // with highest priority is found
        for (int i = ind; i < size; i++) {
            pr[i] = pr[i + 1];
        }
        size--;
    }

    public static void main(String[] args) {
        enqueue(10, 2);
        enqueue(14, 4);
        enqueue(16, 4);
        enqueue(12, 3);

        // Stores the top element
        // at the moment
        int ind = peek();

        System.out.println(pr[ind].value);

        // Dequeue the top element
        dequeue();

        // Check the top element
        ind = peek();
        System.out.println(pr[ind].value);

        // Dequeue the top element
        dequeue();

        // Check the top element
        ind = peek();
        System.out.println(pr[ind].value);

    }
}
