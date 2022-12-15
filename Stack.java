public class Stack<T> {

    private final LinkedList<T> data;

    public Stack() {
        this.data = new LinkedList<>();
    }

    public int size() {
        return this.data.size();
    }

    public T pop() {
        return this.data.pop();
    }

    public void push(T val) {
        this.data.push(val);
    }

    public T peek() {
        return this.data.peek();
    }

    public boolean ex4(String bracket) {
        Stack<Character> characterStack = new Stack<>();
        char[] arr = bracket.toCharArray();
        for (char current : arr) {
            if (current == '(') {
                characterStack.push(current);
                continue;
            }
            if (characterStack.peek() == null) return false;
            characterStack.pop();
        }
        return characterStack.size() == 0;
    }

    //String[] ex = new String[]{"8", "2", "+","5","*","9","+","="};
    public int ex5(String[] ex) {
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        int result = 0;

        for (int i = ex.length - 1; i >= 0; i--) {
            s1.push(ex[i]);
        }

        while (s1.peek() != null) {
            String current = s1.pop();
            switch (current) {
                case "+" -> {
                    int op1 = Integer.parseInt(s2.pop());
                    int op2 = Integer.parseInt(s2.pop());
                    s2.push(Integer.toString((op1 + op2)));
                }
                case "*" -> {
                    int op3 = Integer.parseInt(s2.pop());
                    int op4 = Integer.parseInt(s2.pop());
                    s2.push(Integer.toString((op3 * op4)));
                }
                case "=" -> result = Integer.parseInt(s2.pop());
                default -> s2.push(current);
            }
        }

        return result;
    }
}
