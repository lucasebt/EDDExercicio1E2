
package com.mycompany.exercicio2;
import java.util.ArrayList;
import java.util.List;

public class Exercicio2 {

    public static void main(String[] args) {
  List<Integer> numerosSorteados = List.of(1, 15, 16, 25, 32, 36);
        List<Integer> listaNumeros = new ArrayList<>();

        // Sortear aleatoriamente 51 milhões de números e inserir na lista
        for (int i = 1; i <= 51000000; i++) {
            listaNumeros.add(i);
        }

        int posicaoDireta = -1;
        int ocorrenciasDireta = 0;
        int posicaoInversa = -1;
        int ocorrenciasInversa = 0;

        // Percorrer a lista em ordem direta
        for (int i = 0; i <= listaNumeros.size() - numerosSorteados.size(); i++) {
            if (listaNumeros.get(i).equals(numerosSorteados.get(0))) {
                boolean encontrouSequencia = true;
                for (int j = 1; j < numerosSorteados.size(); j++) {
                    if (!listaNumeros.get(i + j).equals(numerosSorteados.get(j))) {
                        encontrouSequencia = false;
                        break;
                    }
                }
                if (encontrouSequencia) {
                    posicaoDireta = i;
                    ocorrenciasDireta++;
                }
            }
        }

        // Percorrer a lista em ordem inversa
        for (int i = listaNumeros.size() - 1; i >= numerosSorteados.size() - 1; i--) {
            if (listaNumeros.get(i).equals(numerosSorteados.get(numerosSorteados.size() - 1))) {
                boolean encontrouSequencia = true;
                for (int j = numerosSorteados.size() - 2; j >= 0; j--) {
                    if (!listaNumeros.get(i - (numerosSorteados.size() - 1 - j)).equals(numerosSorteados.get(j))) {
                        encontrouSequencia = false;
                        break;
                    }
                }
                if (encontrouSequencia) {
                    posicaoInversa = i - numerosSorteados.size() + 1;
                    ocorrenciasInversa++;
                }
            }
        }

        System.out.println("Posição da sequência (ordem direta): " + posicaoDireta);
        System.out.println("Ocorrências da sequência (ordem direta): " + ocorrenciasDireta);
        System.out.println("Posição da sequência (ordem inversa): " + posicaoInversa);
        System.out.println("Ocorrências da sequência (ordem inversa): " + ocorrenciasInversa);
    }
}