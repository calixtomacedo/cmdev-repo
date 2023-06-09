package br.com.cmdev.javarecords;

import br.com.cmdev.javarecords.dto.Person;
import br.com.cmdev.javarecords.record.PersonRecord;

public class Main {

    public static void main(String[] args) {

        var person = new Person("Caio Macedo", 51);
        System.out.println("Nome:"+ person.toString());

        var personRecord = new PersonRecord("Calixto Macedo", 52);
        System.out.println("Nome:"+ personRecord.toString());

        personRecord.printNome();

        personRecord.printMessage();

    }
}
