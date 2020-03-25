import java.util.Stack; //Importo la biblioteca std de Java para pilas.

public class BalancedBrackets {

    /**
     * Indica si una cadena de puros paréntesis es bien balanceada.
     * La cadena no debe contener algo que no sean caractereres (), {}, []
     * @return <code>True</code> en caso de ser una cadena bien balanceada
     * <code>False</code> en otro caso.
     */
    // (){}[] regresa true;
    // ((){) regresa false;
    // (((((((
    public static boolean balanced(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if(c == ')' && stack.peek() != '(')
                    return false;
                else if(c == '}' && stack.peek() != '{')
                    return false;
                else if(c == ']' && stack.peek() != '[')
                    return false;
                stack.pop();
            }
        }
        /*Necesitamos cerciorarnos de que la pila es vacía.
         * Ya que si no es vacía, entonces metimos más paréntesis, llaves o corchetes, es igual,  de los que abren que de los que cierran.*/
        return stack.isEmpty();
    }

    public static void main(String [] args) {
        System.out.println(balanced("()()()"));
        System.out.println(balanced("{(){}}"));
    }
}
