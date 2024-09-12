package lian;

public class LinkListDemo {
    public static void main(String[] args) {
        System.out.println("----------创建空的线性表---------");
        LinkList<String> L = new LinkList<String>();
        System.out.println("线性表长度="+L.getSize());

        System.out.println("----------用指定数组创建线性表---------");
        String a[]= {"x","c","u","f","d","u","c"};
        L.createList(a);	//注意头插法和尾插法的区别
        System.out.println(L.toString());
        System.out.println("线性表长度="+L.getSize());

        System.out.println("----------求指定序号元素---------");
        try {
            System.out.println("序号3的元素是："+L.getElem(3));
            System.out.println("序号8的元素是："+L.getElem(8));
        }
        catch(Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        System.out.println("----------设置指定序号元素---------");
        try {
            L.setElem(3, "e");
            System.out.println("序号3的元素设置为："+L.getElem(3));
            L.setElem(8, "x");
            System.out.println("序号8的元素设置为："+L.getElem(8));
        }
        catch(Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        System.out.println("----------求元素的序号---------");
        System.out.println("字符c的位置："+ L.getNo("c"));
        System.out.println("字符n的位置："+ L.getNo("n"));
        L.add("n");
        System.out.println(L.toString());
        System.out.println("线性表长度="+L.getSize());

        System.out.println("----------插入元素---------");
        try {
            L.insert(3,".");
            L.insert(6,".");
            System.out.println(L.toString());
        }
        catch (Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        System.out.println("----------删除元素---------");
        try {
            L.delete(6);
            L.insert(7,".");
            System.out.println(L.toString());
        }
        catch (Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        System.out.println("----------插入元素 异常---------");
        try {
            L.insert(L.getSize()+1,"\\");
            System.out.println(L.toString());
        }
        catch (Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        try {
            L.insert(-1,"www.");
            System.out.println(L.toString());
        }
        catch (Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        L.insert(0,"www.");
        System.out.println(L.toString());

        System.out.println("----------删除元素 异常---------");
        try {
            L.delete(-1);
            System.out.println(L.toString());
        }
        catch (Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        try {
            L.delete(L.getSize());
            System.out.println(L.toString());
        }
        catch (Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        L.delete(0);
        System.out.println(L.toString());

        System.out.println("----------设置长度---------");
        try {
            L.setSize(L.getSize()+1);
        }
        catch (Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        L.setSize(8);
        System.out.println("长度为8的线性表："+ L.toString());

        System.out.println("Test end. ");

    }
}

interface List <E> {
    void createList(E[] a); //用指定内容创建线性表
    int getSize();  //求线性表长度
    void setSize(int nlen);  // 设置长度
    E getElem(int i) ; //获取线性表中序号为i的元素
    void setElem(int i,E e)  ; //将序号为i的位置设置为元素e
    int getNo(E e) ;// 获取第 一个值 为e 的元素的序号
    void add(E e); //元素e添加在表尾
    void insert(int i,E e)  ; //在序号为i的位置上添加元素e
    void delete(int i )  ; //删除序号为i 的元素
    String toString(); //线性表转换为字符串
}

class LinkNode<E>{
    E data;
    LinkNode<E>next;
    public LinkNode(){
        next=null;
    }
    public LinkNode(E a){
        data = a;
        next=null;
    }

}
class LinkList<E>  implements List<E> {
    LinkNode<E> head;

    public LinkList() {
        head = new LinkNode<>();
        head.next = null;
    }
    public void createList(E[] a){
        LinkNode<E> s;
        for (int i = 0; i <  a.length; i++) {
            s=new LinkNode<E>(a[i]);
            s.next=head.next;
            head.next=s;
        }

    }
    LinkNode<E> geti(int i){
        LinkNode p =head;
        for (int j = 0; j <=i; j++) {
            p=p.next;
        }
        return p;
    }
    public void add(E e){
        LinkNode<E>s=new LinkNode<>(e);
        LinkNode<E>p=head;
        while(p.next!=null)
            p=p.next;
        p.next=s;

    }



    public int getSize(){
        LinkNode<E> p =head;
        int count=0;
        while(p.next!=null){
            count++;
            p=p.next;
        }
        return count;
    }
    public void setSize(int nlen){

        int length=getSize();
        if(length<0||nlen>length){
            throw new IllegalArgumentException("n不在有效范围之内");
        }
        if(nlen==length)
            return;
        LinkNode<E> p1 =head;
        int j=-1;

        while(j<nlen-1){
            j++;
            p1=p1.next;
        }
        LinkNode<E> p =p1;
        p.next=null;
    }
    public E getElem(int i){
        if(i<0||i>getSize()-1) {
            throw new IllegalArgumentException("n不在有效范围之内");
        }
        LinkNode<E> p =head;
        for (int j = 0; j <=i; j++) {
             p=p.next;
         }

        return p.data;
    }


    public void setElem(int i,E e){
        if(i<0|| i>getSize()-1){
            throw new IllegalArgumentException("n不在有效范围之内");
        }
        LinkNode<E> p = head;
        for (int j = 0; j <=i; j++) {
            p=p.next;
        }
        p.data=e;
    }
    public int getNo(E e){
        LinkNode<E> p =head;
        for (int i = 0; i < getSize(); i++) {
            p=p.next;
            if(p.data.equals(e)){
                return i;
            }
        }
        return -1;
    }
    public void swap(int i,int j){
        LinkNode<E> p1 = geti(i);
        LinkNode<E> p2 = geti(j);
        E tmp = p1.data;
        p1.data=p2.data;
        p2.data=tmp;
    }
    public void insert(int i, E e){
        if(i<0||i>getSize()){
            throw new IllegalArgumentException("n不在有效范围之内");
        }
        LinkNode<E> p=head;
        LinkNode<E> s=new LinkNode<E>(e);
        for (int j = 0; j < i; j++) {
            p=p.next;
        }
        s.next=p.next;
        p.next=s;
    }
    public void delete(int i){
        if(i<0||i>getSize()-1)
            throw new IllegalArgumentException("n不在有效范围之内");

        LinkNode<E> p =head;
        for (int j = 0; j < i; j++) {
            p=p.next;
        }
        p.next=p.next.next;
    }

    public String toString(){
        String ans="";
        LinkNode<E> p =head.next;
        while(p!=null){
            ans+=p.data+" ";
            p=p.next;
        }
        return ans;
    }


}