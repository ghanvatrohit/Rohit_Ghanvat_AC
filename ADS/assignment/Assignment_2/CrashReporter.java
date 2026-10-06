class MethodStack {
    private String[] data = new String[10];
    private int top = -1;

    // push method
    boolean push(String m) {
        if (top == 9) {
            return false; // stack full
        }

        top++;
        data[top] = m;
        return true;
    }

    // pop method
    String pop() {
        if (top == -1) {
            return null;
        }

        String value = data[top];
        data[top] = null;
        top--;

        return value;
    }

    // peek method
    String peek() {
        if (top == -1) {
            return null;
        }

        return data[top];
    }

    //size
    int size(){
        return top +1;
    }

    //print stack from top to bottom
    void printTrace(){
        for(int i=top; i>=0; i--){
            System.out.println("  at" + data[i]);
        }
    }
}

public class CrashReporter {
    public static void main(String[] args) {
        String[] log = {
                "ENTER main",
                "ENTER placeOrder",
                "ENTER validateCart",
                "EXIT validateCart",
                "ENTER processPayment",
                "ENTER connectBank",
                "CRASH"
        };

        MethodStack stack = new MethodStack();

        int maxDepth = 0;

        for (int i = 0; i < log.length; i++) {
            String line = log[i];

            // split line
            String[] parts = line.split(" ");
            String command = parts[0];

            // Enter
            if (command.equals("ENTER")) {
                String method = parts[1];
                boolean success = stack.push(method);

                if (!success) {
                    System.out.println("StackOverflowError: call depth exceeded 10");
                    System.out.println("Invalid at line " + (i + 1));
                    return;
                }

                if (stack.size() > maxDepth) {
                    maxDepth = stack.size();
                }
            }

            // Exit
            else if (command.equals("EXIT")) {
                String method = parts[1];

                // Checck whether top method is correct
                if (stack.peek() != null &&
                        stack.peek().equals(method)) {
                    stack.pop();
                } else {
                    System.out.println("Invalid EXIT at line " + (i + 1));
                    return;
                }
            }

            // crash
            else if (command.equals("CRASH")) {
                System.out.println("Application crashed at line " + (i + 1) + ". Stack trace:");

                stack.printTrace();

                System.out.println("Maximum call depth reached: " + maxDepth);
                return;
            }
        }
        // if no CRASH
        System.out.println("Program finished normally");
    }
}
