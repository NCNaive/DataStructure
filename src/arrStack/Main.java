package arrStack;

public class Main {
    public static void main(String[] args) {
        SqStackClass p =new SqStackClass();
        p.valid("(())()");
        p.valid(")(");
        p.valid("()))((");
    }

}
class SqStackClass<E>{
    final int ini=10;
    private int capacity;
    private E[] data;
    private int top;
    public SqStackClass(){
        data=(E[])new Object[ini];
        capacity = ini;
        top=-1;
    }
    private void up(int newca){
        E[] newdata = (E[]) new Object[newca];
        for (int i = 0; i < top; i++) {
            newdata[i]=data[i];
            capacity=newca;
            data=newdata;
        }
    }
    public boolean empty(){
        return top==-1;
    }
    public void push(E e){
        if(top==capacity-1){
            up(2*(top+1));
        }
        top++;
        data[top]=e;
    }
    public E pop(){
        if(empty()){
            throw new IllegalArgumentException("栈为空");
        }
        E e=data[top];
        top--;
        if(capacity>ini&&top+1==capacity/4){
            up(capacity/2);
        }
        return e;
    }
    public void valid(String s){
        SqStackClass<Character> stack=new SqStackClass<Character>();

        for (char c:s.toCharArray()) {
            if(c=='('){
                stack.push(c);
            }
            else{
             if(stack.empty()){
                 System.out.println("NoMatch");
                 return;
             }else{
                 stack.pop();
             }
            }
        }
        System.out.println("Match");

    }

}