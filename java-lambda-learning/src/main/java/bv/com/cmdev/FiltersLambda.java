package bv.com.cmdev;

import bv.com.cmdev.domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiltersLambda {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "C++", "Angular", "JavaScript", "HTML");
        List<String> languageFiltered =  new ArrayList<>();
        for (String language :  languages) {
            if(language.length() > 3) {
                languageFiltered.add(language);
            }
        }
        System.out.println("Linguagens com mais de 3 letras sem lambda"+ languageFiltered);

        List<String> languageFilteredLambda = languages.stream().filter(language -> language.length() > 3).toList();
        System.out.println("Linguagens com mais de 3 letras com lambda"+ languageFilteredLambda);

        List<Person> personList = Arrays.asList(
                new Person(1, "Calixto", "Caio", "Rodrigues", "Macedo", 52),
                new Person(2, "Rosimeire", "Rosy", "Santos", "Cunegundes", 37),
                new Person(3, "Adrielly Thamyres", "Tatá", "Pimentel", "Macedo", 22),
                new Person(4, "Davi Lucca", "Lukinha", "Cunegundes", "Macedo", 2)
        );

        List<String> nomes = personList.stream().map( person -> person.getName()).toList();
        List<Integer> idades = personList.stream().map(Person::getAge).toList();

        System.out.println("Lista de nomes: "+ nomes +" e idades: "+ idades);

    }
}
