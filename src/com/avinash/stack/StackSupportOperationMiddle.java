package com.avinash.stack;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class DLLNode {
    private final Integer data;
    private DLLNode next, prev;
}

public class StackSupportOperationMiddle {
    private DLLNode head, middle;
    private int size;

    public void push(Integer data) {
        DLLNode newNode = new DLLNode(data);
        if (size == 0) {
            this.head = this.middle = newNode;
        } else {
            head.setNext(newNode);
            newNode.setPrev(this.head);
            this.head = this.head.getNext();
            if (this.size % 2 == 0) {
                this.middle = this.middle.getNext();
            }
        }
        this.size++;
    }

    public Integer pop() {
        Integer data = -1;

        if (this.size == 0) {
            System.out.println("Stack is empty");
        } else {
            data = this.head.getData();
            if (this.size == 1) {
                this.head = null;
                this.middle = null;
            } else {
                this.head = this.head.getPrev();
                this.head.setNext(null);
                if (this.size % 2 == 0) {
                    this.middle = this.middle.getPrev();
                }
            }
        }
        return data;
    }

    int findMiddle() {
        if (size == 0) {
            System.out.println("Stack is empty now");
            return -1;
        }
        return middle.getData();
    }

    void deleteMiddleElement() {
        if (size != 0) {
            if (size == 1) {
                head = null;
                middle = null;
            } else if (size == 2) {
                head = head.getPrev();
                middle = middle.getPrev();
                head.setNext(null);
            } else {
                middle.getNext().setPrev(middle.getPrev());
                middle.getPrev().setNext(middle.getNext());
                if (size % 2 == 0) {
                    middle = middle.getPrev();
                } else {
                    middle = middle.getNext();
                }
            }
            size--;
        }
    }

    public static void main(String args[]) {
        StackSupportOperationMiddle ms = new StackSupportOperationMiddle();
        ms.push(11);
        ms.push(22);
        ms.push(33);
        ms.push(44);
        ms.push(55);
        ms.push(66);
        ms.push(77);
        ms.push(88);
        ms.push(99);

        System.out.println("Popped : " + ms.pop());
        System.out.println("Popped : " + ms.pop());
        System.out.println("Middle Element : "
                + ms.findMiddle());
        ms.deleteMiddleElement();
        System.out.println("New Middle Element : "
                + ms.findMiddle());
    }
}
