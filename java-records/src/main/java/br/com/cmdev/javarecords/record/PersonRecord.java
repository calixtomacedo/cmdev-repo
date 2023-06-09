package br.com.cmdev.javarecords.record;

public record PersonRecord(String name, int age) {

    public static final String DEFAULT_MESSAGE = "Hello World";

    public void printNome(){
        System.out.println("Nome: "+name);
    }

    public static void printMessage(){
        System.out.println(DEFAULT_MESSAGE);
    }
}
