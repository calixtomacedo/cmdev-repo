package bv.com.cmdev;

import bv.com.cmdev.interfaces.OperacaoMatematica;

public class CalculadoraLambda {

    public static void main(String[] args) {

        OperacaoMatematica multiplicacao = new OperacaoMatematica() {
            @Override
            public int calcular(int x, int y) {
                return x * y;
            }
        };
        System.out.println(multiplicacao.calcular(5, 5));

        OperacaoMatematica soma = (x, y) -> x + y;
        System.out.println(soma.calcular(10, 80));
    }

}
