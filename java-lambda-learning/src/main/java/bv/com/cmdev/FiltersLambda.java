package bv.com.cmdev;

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

    }
}
