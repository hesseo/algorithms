package dataStructure.stack;

import java.util.ArrayList;
import java.util.Scanner;

// stack 배열로 구현
class StackArray {
    ArrayList<Integer> stack=new ArrayList<>();
    public void push(int data) {
        stack.add(data);
    }
    public int pop() {
        return stack.remove(stack.size()-1);
    }
    public int sum(){
        int s=0;
        for (int i=0;i<stack.size();i++){
            s+=stack.get(i);
        }
        return s;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }

}
public class Q10773 {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 1; i <= k; i++) {
            int x = sc.nextInt();
            if(x==0 && !stackArray.isEmpty()){
                stackArray.pop();
            }else if(x!=0){
                stackArray.push(x);
            }
        }
        System.out.println(stackArray.sum());
    }
}
