
package com.mycompany.exercicio1;

import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        Random random = new Random();
        int[] vetor = new int[1000];

        for (int i = 0; i < 1000; i++) {
            vetor[i] = random.nextInt(19999) - 9999;
        }

        PosicaoLista lista = new PosicaoLista();

        for (int i = 0; i < 1000; i++) {
            lista.inserir(vetor[i]);
            lista.RemoverNum();
        }

        System.out.println("\nLista em ordem crescente:");
        lista.RemoverNum();

        System.out.println("\nLista em ordem decrescente:");
        lista.ImprimirDecrescente();

        lista.removerPrimos();

        System.out.println("\nLista após remover os números primos:");
        lista.RemoverNum();
    }
}
