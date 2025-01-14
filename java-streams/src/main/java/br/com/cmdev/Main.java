package br.com.cmdev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        var items = new ArrayList<String>();
        items.add("Apple");
        items.add("Banana");
        items.add("Orange");
        items.add("Avocado");

        // Streams de dados - Filtragem, Ordenação, Transformações
        items.stream()
                .filter(item -> item.toUpperCase().startsWith("a".toUpperCase())) // intermediárias
                .map(String::toUpperCase) // intermediárias
                .forEach(System.out::println); // terminais


        var listaModificada = items.stream()
                .filter(item -> item.toUpperCase().startsWith("a".toUpperCase())) // intermediárias
                .map(String::toUpperCase) // intermediárias
                .collect(Collectors.toList());
        System.out.println(listaModificada);

        var numbers = List.of(1, 2, 3, 4, 5);
        var sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        items.parallelStream()
                .forEach(item -> System.out.println(Thread.currentThread() +" - "+ item));
    }
}