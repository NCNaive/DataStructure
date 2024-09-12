package queue2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

       LinkQueue q = new LinkQueue();


        for (int i = 1; i <= n; i++) {
            q.push(i);
        }
        int count = 0;
        while (!q.empty()) {
            int person = q.pop();
            count++;
            if (count % m == 0) {
                System.out.print(person + " ");
            } else {
                q.push(person);
            }
        }
    }
}
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkQueue {
    Node rear;

    public LinkQueue() {
        rear = null;
    }

    public boolean empty() {
        return rear == null;
    }

    public void push(int data) {
        Node s = new Node(data);
        if (empty()) {
            s.next = s;
            rear = s;
        } else {
            s.next = rear.next;
            rear.next = s;
            rear = s;
        }
    }

    public int pop() {
        if (empty()) {
            throw new IllegalArgumentException("空");
        }
        int d = rear.next.data;
        if (rear.next == rear) {
            rear = null;
        } else {
            rear.next = rear.next.next;
        }
        return d;
    }
}
