package ee.mtiidla.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class InterviewTax {

    /*

        Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
        determine if the input string is valid.
        The brackets must close in the correct order,
        "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

        ([)] -> incorrect

        }}} -> incorrect, edge case, stack never filled

        Follow up task 1:
        Extend support from () [] {} to any pair of characters

        Follow up task 2:
        Add support for same character to start and close the pair

        || ->

        {||} -> correct
        {}|| -> correct
        {}|||| -> correct
        |{||}| => correct

        {}||| -> incorrect

 */

    public static void main(String args[]) {

        System.out.println("---START---");
        System.out.println(isValid2("") == true);
        System.out.println(isValid2("()") == true);
        System.out.println(isValid2("(") == false);

        System.out.println(isValid2("()[]{}") == true);
        System.out.println(isValid2("({()[()]{}})") == true);

        System.out.println(isValid2("([)]") == false);
        System.out.println(isValid2("((") == false);
        System.out.println(isValid2("}}") == false);

        System.out.println(isValid2("||") == true);
        System.out.println(isValid2("||||") == true);
        System.out.println(isValid2("|[|(||)|]|") == true);
        System.out.println(isValid2("{}||(||)") == true);
        System.out.println(isValid2("|{||}|") == true);
    }

    // my solution, does not support ||
    private static boolean isValid(String input) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        map.put('|', '|');

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            Character s = map.get(c);
            if (s == null) {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                char opening = stack.pop();
                if (opening != s) {
                    return false;
                }
            }
        }

        if (stack.size() != 0) {
            return false;
        }

        return true;
    }

    // my solution, extended to support ||
    private static boolean isValid2(String input) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        map.put('|', '|');

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (!map.containsKey(c) // not closing
                    || c == map.get(c) // c can be both opening or closing
                    && (stack.isEmpty() || stack.peek() != c)) {
                // c is opening char
                stack.push(c);
            } else {

                // c is closing char
                if (stack.size() == 0) return false;
                char opening = stack.pop();
                if (opening != map.get(c)) {
                    return false;
                }
            }
        }

        if (stack.size() != 0) {
            return false;
        }

        return true;
    }
}

/* Extra question, Big O for the following data structures and their interactions
                            array   linkedList      tree    hashtable
        access              O(1)        O(N)        O(ln)       O(1)
        append              O(1)        O(1)        O(ln)       O(1)
        insert/delete       O(N)        O(1)        O(ln)       O(1)
 */
