package ee.mtiidla.headfirst.templatemethod;

import java.util.Scanner;

class CoffeeWithHook extends Coffee {

    @Override
    boolean customerWantsCondiments() {

        String answer = getUserInput();
        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput() {
        Scanner input = new Scanner(System.in);

        System.out.println("Would you like milk and sugar with your coffe (y/n)?");
        String answer = input.next();
        input.close();
        return answer;
    }
}
