package com.company.StacksAndQueues;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Character> stack = new ArrayDeque();

        String input = sc.nextLine();

        boolean isBalanced = false;

        for (int i = 0; i < input.length(); i++) {

            if (stack.isEmpty()) {
                stack.push(input.charAt(i));
                continue;
            }

            if (input.charAt(i) == '}' || input.charAt(i) == ']' || input.charAt(i) == ')') {
                isBalanced = checkBalance(stack, input.charAt(i));
                if (!isBalanced) {
                    break;
                }
            } else {
                stack.push(input.charAt(i));
            }
        }

        String output = null;
        output = isBalanced ? "YES" : "NO";
        System.out.println(output);

    }

    private static boolean checkBalance(ArrayDeque<Character> stack, char closingBracket) {
        List<Character> openingBrackets = Arrays.asList('(', '{', '[');
        List<Character> closingBrackets = Arrays.asList(')', '}', ']');

        char top = stack.peek();

        if (openingBrackets.indexOf(top) == closingBrackets.indexOf(closingBracket)) {
            stack.pop();
            return true;
        }

        stack.push(closingBracket);
        return false;
    }
}
