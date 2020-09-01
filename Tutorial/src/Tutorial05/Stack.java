/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial05;

/**
 *
 * @author muham
 */
public class Stack<T> {
    private ListNode head;

    public Stack() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int getSize() {
        int count = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }

    public void push(T a) {
        head = new ListNode(a, head);
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        T temp = (T) head.getData();
        head = head.getLink();
        return temp;
    }

    public T peek() {
        if (head == null) {
            return null;
        } 
        else {
            return (T) head.getData();
        }
    }

    public void showStack() {
        if (isEmpty()) {
            System.out.println("Empty Stack");
        } 
        else {
            ListNode currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.toString());
                currentNode = currentNode.getLink();
            }
        }
    }

    //expression evaluation
    public String infixToPostfix(String a) {
        String str = "";
        char c = ' ';
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            if (Character.isLetterOrDigit(a.charAt(i))) {
                str += a.charAt(i);
            } 
            else if (a.charAt(i) == '(') {
                stack.push(a.charAt(i));
            } 
            else if (a.charAt(i) == ')') {
                c = stack.pop();
                while (c != '(') {
                    str += c;
                    c = stack.pop();
                }
            } 
            else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.push(a.charAt(i));
                    }
                    else {
                        c = stack.peek();
                        while (getPriority(a.charAt(i)) <= getPriority(c)) {
                            str += stack.pop();
                            if (!stack.isEmpty()) {
                                c = stack.peek();
                                if (c == '(') {
                                    break;
                                }
                            } 
                            else {
                                break;
                            }                          
                        }
                        stack.push(a.charAt(i));
                    }
                } 
                else {
                    stack.push(a.charAt(i));
                }
            }

        }
        while (!stack.isEmpty()) {
            str += stack.pop();
        }
        return str;
    }
    
    public String infixToPrefix(String a){
        String rev="", str="";
        Stack<Character> stack = new Stack<>();
        for (int i = a.length()-1; i >= 0; i--) {
            if(a.charAt(i)=='('){
                rev+=')';
            }
            else if(a.charAt(i)==')'){
                rev+='(';
            }
            else{
                rev+=a.charAt(i);
            }
        }
        rev = infixToPostfix(rev);
        for (int i = rev.length()-1; i >= 0; i--) {
            str += rev.charAt(i);
        }
        return str;
    }
    
    public int getPriority(char a){
        switch(a){
            case '*' :
            case '/' :
            case '%' :
                return 2;
            case '+' :
            case '-' :
                return 1;
            default:
                return 0;
            
        }
    }
    
    public int postfixEvaluation(String a){
        Stack<String> stack = new Stack<>();
        String temp;
        int num1=0, num2=0, result=0;
        for (int i = 0; i < a.length(); i++) {
            if(Character.isLetterOrDigit(a.charAt(i))){
                temp = a.substring(i, i+1);
                stack.push(temp);
            }
            else{
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                result = getResult(num1, num2, a.charAt(i));
                stack.push(result+"");
            }
        }
        result = Integer.parseInt(stack.pop());
        return result;
    }
    
    public boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    public int getResult(int a, int b, char c){
        switch(c){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            case '%':
                return a%b;
        }
        return 0;
    }
    
    public int prefixEvaluation(String a){
        Stack<String> stack = new Stack<>();
        String temp;
        int num1=0, num2=0, result=0;
        temp = a.substring(0, 1);
        stack.push(temp);
        if(!Character.isLetterOrDigit(a.charAt(0))){
            stack.push("#");
        }
        for (int i = 0; i < a.length(); i++) {
            if(Character.isLetterOrDigit(a.charAt(i))){
                if(stack.peek().equals("#")){
                    temp = a.substring(i, i+1);
                    stack.push(temp);
                }
                else{
                    boolean first = true;
                    while(isInteger(stack.peek()) && !stack.isEmpty()){
                        num1 = Integer.parseInt(stack.pop());
                        if(first){
                            num2 = Integer.parseInt(a.substring(i, i+1));
                        }
                        else{
                            num2=result;
                        }
                        stack.pop();
                        result = getResult(num1, num2, stack.pop().charAt(0));
                        first=false;
                    }
                    stack.push(result+"");
                }
            }
            else{
                temp = a.substring(i, i+1);
                stack.push(temp);
                stack.push("#");
            }
        }
        result = Integer.parseInt(stack.pop());
        return result;
    }
}
