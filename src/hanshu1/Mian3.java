//import java.util.Scanner;
//
//class LinkNode {
//    int data;
//    LinkNode next;
//
//    public LinkNode() {
//        this.next = null;
//    }
//
//    public LinkNode(int e) {
//        this.data = e;
//        this.next = null;
//    }
//}
//
//class LinkList {
//    LinkNode head;
//
//    public LinkList(int d[]  ) {
//        //用数组d的元素，采用头插法，创建带头结点的单链表
//        //代码省略，不需要提交
//        。。。。
//    }
//}
//
//    public void display()  //显示线性表的所有元素
//    {
//        //代码省略，不需要提交
//        。。。。
//    }
//
//    void cam() {
//    caity
//
//    }
//    public void delete(int i) {
//    LinkNode p =head;
//    int count=0;
//    while(p.next!=null) {
//    p=p.next;
//    count++;
//    }
//    if(i<0||i>count-1){
//        throw new IllegalArgumentException("delete Error");
//    }
//    LinkNode s = head;
//    for (int j = 0; j < i; j++) {
//
//
//
//        }
//}
//    /*你提交的代码将嵌入这里 */
//
//}
//
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int data[] = new int[n];
//        for(int i=0;i<n;i++) {
//            data[i]= sc.nextInt();
//        }
//        LinkList L = new LinkList(data );
//        int i = sc.nextInt();//输入位置
//        try{
//            L.delete(i);
//            L.display( );
//        }
//        catch(IllegalArgumentException e ) {
//            System.out.println(e.getMessage());
//        }
//        sc.close();
//    }
//}