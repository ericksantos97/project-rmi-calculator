package calculator;

import javax.swing.*;
import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {

    public static void main(String[] args) {

        try {

            int valor1;
            int valor2;
            String operacao;

            Calculator c = (Calculator) Naming.lookup("//localhost:1020/CalculatorService");

            String opcao[] = new String[]{"+", "-", "*", "/"};

            valor1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o primeiro valor"));
            operacao = JOptionPane.showInputDialog(null, "Insira uma operação: + , - , / , *");
            valor2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o segundo valor"));

            switch (operacao) {
                case "+":
                    JOptionPane.showMessageDialog(null, "Resultado da soma: " + c.add(valor1, valor2));
                    break;

                case "-":
                    JOptionPane.showMessageDialog(null, "Resultado da subtracao: " + c.sub(valor1, valor2));
                    break;

                case "*":
                    JOptionPane.showMessageDialog(null, "Resultado da multiplicacao: " + c.mul(valor1, valor2));
                    break;

                case "/":
                    JOptionPane.showMessageDialog(null, "Resultado da divisao: " + " " + c.div(valor1, valor2));
                    break;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
