
package com.mycompany.exercicio1;

public class PosicaoLista {
    Exercicio1 head;
    Exercicio1 tail;

    public void inserir(int data) {
        Exercicio1 newNode = new Exercicio1(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (data <= head.data) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else if (data >= tail.data) {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Exercicio1 current = head;

            while (current.next != null && current.next.data < data) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.previous = current;
            current.next.previous = newNode;
            current.next = newNode;
        }
    }

    public void RemoverNum() {
        Exercicio1 current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public void ImprimirDecrescente() {
        Exercicio1 current = tail;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.previous;
        }

        System.out.println();
    }

    public void removerPrimos() {
        Exercicio1 current = head;

        while (current != null) {
            if (isPrimos(current.data)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.previous = null;
                    }
                } else if (current == tail) {
                    tail = current.previous;
                    tail.next = null;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
            }

            current = current.next;
        }
    }

    private boolean isPrimos(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

