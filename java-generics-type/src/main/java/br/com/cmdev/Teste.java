package br.com.cmdev;

import br.com.cmdev.domain.Endereco;

import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        String cep = "06253-190";

        var endereco = localidarEndereco(cep);

        List<String> strings = new ArrayList<>();
        strings.add("UM");
        strings.add("Dois");

       strings.forEach(System.out::println);


    }

    private static Endereco localidarEndereco(String cep) {
        return null;
    }
}
