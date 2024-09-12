package linkStack;

public class Main {
    public static void main(String[] args) {

        LinkStackClass p =new LinkStackClass();
        p.huiwen("TooooT");
        p.huiwen("1232");
    }
}
class LinkNode<E>{
    E data;
    LinkNode<E> next;
    public LinkNode(){
        next=null;
    }
    public LinkNode(E d){
        data = d;
        next=null;
    }
}
class LinkStackClass<E>{
    LinkNode <E> head;
    public LinkStackClass(){
        head = new LinkNode<>();
        head.next=null;
    }
    public boolean empty(){
        return head.next==null;
    }
    public  void push(E e){
        LinkNode<E> s=new LinkNode<>(e);
        s.next=head.next;
        head.next=s;
    }
    public E pop(){
        if(empty()){
            throw new IllegalArgumentException("错误，栈为空");
        }
        E e=(E) head.next.data;
        head.next=head.next.next;
        return e;
    }
    public E peek(){
        if(empty()){
            throw new IllegalArgumentException("栈为空");
        }
        E e=(E) head.next.data;
        return e;
    }
    public void huiwen(String a){
        LinkStackClass<Character> q1=new LinkStackClass<Character>();
        LinkStackClass<Character> q2=new LinkStackClass<Character>();
        LinkNode s;int i=0;
        for (char c:a.toCharArray()) {
            s=new LinkNode(c);
            q1.push(c);
            i++;
        }
        if(i%2!=0) {
            for (int j = 0; j < i / 2; j++) {
                q2.push((char)q1.pop());
            }
            q2.pop();
        }else{
            for (int j = 0; j < i / 2; j++) {
                q2.push((char)q1.pop());
            }
        }
        while(q1.head.next!=null){
         if(!q1.pop().equals(q2.pop())){
             System.out.println("No");
             return;
         }
        }
        System.out.println("Yes");
    }

}