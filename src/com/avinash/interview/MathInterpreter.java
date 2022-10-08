package com.avinash.interview;

import java.util.Stack;

public class MathInterpreter {
    public static int calculateExpression(String str) {
        Stack<Character> operand = new Stack<>();
        Stack<Integer> values = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                int secondValue = values.pop();
                int firstValue = values.pop();
                char opertor = operand.pop();
                switch (opertor){
                    case '+':
                        values.push(secondValue + firstValue);
                        break;
                    case '-':
                        values.push(firstValue-secondValue);
                        break;
                    case '*':
                        values.push(secondValue * firstValue);
                        break;
                    case '/':
                        values.push(firstValue/secondValue);
                        break;
                    default:
                        System.out.println("Invalid operand");
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                operand.push(c);
            } else if (Character.isDigit(c)) {
                values.push(Integer.valueOf( "" +c));
            }
        }
        return values.pop();
    }
    public static void main(String[] args) {
        System.out.println(calculateExpression("((2+2)-(1*2))"));
    }
    
}