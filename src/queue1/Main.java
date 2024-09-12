package queue1;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
////        int n = in.nextInt();
//        int n = 6;
////        int m = in.nextInt();
//        int m = 5;
//
//        LinkQueue<Integer> q = new LinkQueue<Integer>();
////        Queue<Integer> queue = new LinkedList<>();
//
//
////        for (int i = 1; i <= n; i++) {
//////            queue.offer(i);
////            q.push(i);
////        }
//
//        q.push(2);
//        System.out.println(q.peek());
//        int count = 0;
//        while (!q.empty()) {
//            int person = q.pop();
//            count++;
//            if (count % m == 0) {
//                System.out.print(person + " ");
//            } else {
////                queue.offer(person);
//                q.push(person);
//            }
//        }
//    }
//}
//class LinkNode<E> {
//    E data;
//    LinkNode<E> next;
//
//    public LinkNode() {
//        next = null;
//    }
//
//    public LinkNode(E d) {
//        data = d;
//        next = null;
//    }
//}
//class LinkQueue<E>
//{
//    LinkNode <E>front;
//    LinkNode <E>rear;
//    public LinkQueue(){
//        front = null;
//        rear  = null;
//    }
//    public boolean empty(){
//        return front == rear;
//    }
//    public void push(E d){
//        LinkNode<E> s = new LinkNode<E>(d);
//        if(empty()){
//            front = rear = s;
//        }else{
//            rear.next = s;
//            rear = s;
//        }
//    }
//    public E pop(){
//        E d;
//       if(empty()){
//           throw new IllegalArgumentException("队列为空");
//       }
//       if(front == rear){
//           d=(E)front.data;
//           front = rear = null;
//       }
//       else{
//           d = (E)front.data;
//           front = front.next;
//       }
//        return d;
//
//    }
//    public E peek(){
//        E d;
//        if(empty()){
//            throw new IllegalArgumentException("队列为空");
//        }
//        d = (E)front.data;
//        return d;
//    }
//
//
//}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SqQueueClass<E>{
    final int MaxSize=100;
    private E[] data;
    private int front ,rear;
    public SqQueueClass(){
        data=(E [])new Object[MaxSize];
        front =0;
        rear=0;
    }
    public boolean empty(){
        return front ==rear;
    }
    public void push(E e){
        if((rear+1)%MaxSize==front)
            throw new IllegalArgumentException("对满");
        rear=(rear+1)%MaxSize;
        data[rear]=e;
    }
    public E pop(){
        if(empty())  throw new IllegalArgumentException("对空");
        front =(front+1)%MaxSize;
        return (E)data[front];
    }
    public E peek(){
        if(empty())   throw new IllegalArgumentException("对空");
        return (E)data[(front+1)%MaxSize];
    }
    public int size(){
        return ((rear-front+MaxSize)%MaxSize);
    }
}
public class Main{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        SqQueueClass<Integer> s=new SqQueueClass<Integer>();
        s.push(1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int d1=s.pop();
                System.out.print(d1+" ");
                int d2=s.peek();
                int d=d1+d2;
                s.push(d);
            }
            s.push(1);
            System.out.print("1\n");
        }

    }

}