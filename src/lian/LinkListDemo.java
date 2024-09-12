package lian;

public class LinkListDemo {
    public static void main(String[] args) {
        System.out.println("----------�����յ����Ա�---------");
        LinkList<String> L = new LinkList<String>();
        System.out.println("���Ա���="+L.getSize());

        System.out.println("----------��ָ�����鴴�����Ա�---------");
        String a[]= {"x","c","u","f","d","u","c"};
        L.createList(a);	//ע��ͷ�巨��β�巨������
        System.out.println(L.toString());
        System.out.println("���Ա���="+L.getSize());

        System.out.println("----------��ָ�����Ԫ��---------");
        try {
            System.out.println("���3��Ԫ���ǣ�"+L.getElem(3));
            System.out.println("���8��Ԫ���ǣ�"+L.getElem(8));
        }
        catch(Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        System.out.println("----------����ָ�����Ԫ��---------");
        try {
            L.setElem(3, "e");
            System.out.println("���3��Ԫ������Ϊ��"+L.getElem(3));
            L.setElem(8, "x");
            System.out.println("���8��Ԫ������Ϊ��"+L.getElem(8));
        }
        catch(Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        System.out.println("----------��Ԫ�ص����---------");
        System.out.println("�ַ�c��λ�ã�"+ L.getNo("c"));
        System.out.println("�ַ�n��λ�ã�"+ L.getNo("n"));
        L.add("n");
        System.out.println(L.toString());
        System.out.println("���Ա���="+L.getSize());

        System.out.println("----------����Ԫ��---------");
        try {
            L.insert(3,".");
            L.insert(6,".");
            System.out.println(L.toString());
        }
        catch (Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        System.out.println("----------ɾ��Ԫ��---------");
        try {
            L.delete(6);
            L.insert(7,".");
            System.out.println(L.toString());
        }
        catch (Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        System.out.println("----------����Ԫ�� �쳣---------");
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

        System.out.println("----------ɾ��Ԫ�� �쳣---------");
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

        System.out.println("----------���ó���---------");
        try {
            L.setSize(L.getSize()+1);
        }
        catch (Exception e) {
            System.out.println("! ! ! " + e.getMessage());
        }

        L.setSize(8);
        System.out.println("����Ϊ8�����Ա�"+ L.toString());

        System.out.println("Test end. ");

    }
}

interface List <E> {
    void createList(E[] a); //��ָ�����ݴ������Ա�
    int getSize();  //�����Ա���
    void setSize(int nlen);  // ���ó���
    E getElem(int i) ; //��ȡ���Ա������Ϊi��Ԫ��
    void setElem(int i,E e)  ; //�����Ϊi��λ������ΪԪ��e
    int getNo(E e) ;// ��ȡ�� һ��ֵ Ϊe ��Ԫ�ص����
    void add(E e); //Ԫ��e����ڱ�β
    void insert(int i,E e)  ; //�����Ϊi��λ�������Ԫ��e
    void delete(int i )  ; //ɾ�����Ϊi ��Ԫ��
    String toString(); //���Ա�ת��Ϊ�ַ���
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
            throw new IllegalArgumentException("n������Ч��Χ֮��");
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
            throw new IllegalArgumentException("n������Ч��Χ֮��");
        }
        LinkNode<E> p =head;
        for (int j = 0; j <=i; j++) {
             p=p.next;
         }

        return p.data;
    }


    public void setElem(int i,E e){
        if(i<0|| i>getSize()-1){
            throw new IllegalArgumentException("n������Ч��Χ֮��");
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
            throw new IllegalArgumentException("n������Ч��Χ֮��");
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
            throw new IllegalArgumentException("n������Ч��Χ֮��");

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