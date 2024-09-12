package queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int rowIndex=in.nextInt();
        CSqueueClass<Integer> queue = new CSqueueClass<Integer>();
        queue.push(1);
        for (int i = 1; i <= rowIndex; i++) {
            queue.push(1);
            int k = 0;
            int d1 = queue.pop();
            int d2;
            while (k<i-1){
                d2 = queue.peek();
                int d =d1+d2;
                queue.push(d);
                d1 = queue.pop();
                k++;
            }
            queue.push(1);
            while(!queue.empty()){
                System.out.print(queue.pop());
            }
        }
//        CSqueueClass<Integer> q = new CSqueueClass<Integer>();
//        q.push(1);
//        System.out.println(q.peek());
//        for (int i = 1; i <=rowIndex; i++) {
//
//            for (int j = 1; j <=i; j++) {
//                q.push(1);
//                System.out.print(1);
//                int d1=q.pop();
//                int d2=q.peek();
//                int d = d1+d2;
//                q.push(d);
//                d1 = q.pop();
//                while(!q.empty()){
//                System.out.print(q.pop());
//            }
//            }
////            System.out.println(1);

        }
    }


class CSqueueClass<E> {
    final int Maxsize=100;
    E[] data;
    int front,rear;
    public CSqueueClass(){
        data=(E[])new Object[Maxsize];
        front=0;
        rear=0;
    }


    public boolean empty() {
        return front == rear;
    }

    public void push(E e){
        if((rear+1)%Maxsize==front){
            throw new IllegalArgumentException("队列已满");
        }
        rear=(rear+1)%Maxsize;
        data[rear]=e;
    }
    public E pop() {
        if (empty()) {
            throw new IllegalArgumentException("队列为空");
        }
        front = (front + 1) % Maxsize;
        return (E) data[front];
    }
    public E peek(){
        if (empty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return (E)data[(front+1)%Maxsize];
    }
}
