package shujv1;

import java.util.Scanner;
public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------(1)�����յ����Ա�------");
		SeqList<String> L = new SeqList<String>();
		System.out.println("���Ա���="+L.getSize());

		System.out.println("------ (2)��ָ�����鴴�����Ա�------");
		String a[]= {"x","c","u","f","d","u","c"};
		L.createList(a);
		System.out.println(L.toString());
		System.out.println("���Ա���="+L.getSize());

		System.out.println("------ (3)��ָ�����Ԫ��------");
		try {
			System.out.println("���3��Ԫ���ǣ�"+L.getElem(3));
			System.out.println("���8��Ԫ���ǣ�"+L.getElem(8));
		}
		catch(Exception e) {
			System.out.println("! ! ! " + e.getMessage());
		}

		System.out.println("------ (4)����ָ�����Ԫ��------");
		try {
			L.setElem(3, "e");
			System.out.println("���3��Ԫ������Ϊ��"+L.getElem(3));
			L.setElem(8, "x");
			System.out.println("���8��Ԫ������Ϊ��"+L.getElem(8));
		}
		catch(Exception e) {
			System.out.println("! ! ! " + e.getMessage());
		}

		System.out.println("------ (5)��Ԫ�ص����------");
		System.out.println("�ַ�c��λ�ã�"+ L.getNo("c"));
		System.out.println("�ַ�n��λ�ã�"+ L.getNo("n"));
		L.add("n");
		System.out.println(L.toString());
		System.out.println("���Ա���="+L.getSize());

		System.out.println("------ (6)����Ԫ��------");
		try {
			L.insert(3,".");
			L.insert(6,".");
			System.out.println(L.toString());
		}
		catch (Exception e) {
			System.out.println("! ! ! " + e.getMessage());
		}

		System.out.println("------ (7)ɾ��Ԫ��------");
		try {
			L.delete(6);
			L.insert(7,".");
			System.out.println(L.toString());
		}
		catch (Exception e) {
			System.out.println("! ! ! " + e.getMessage());
		}

		System.out.println("------ (8)����Ԫ�� �쳣------");
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

		System.out.println("------ (9)ɾ��Ԫ�� �쳣------");
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

		System.out.println("------ (10)���ó���------");
		try {
			L.setSize(L.getSize()+1);
		}
		catch (Exception e) {
			System.out.println("! ! ! " + e.getMessage());
		}

		L.setSize(8);
		System.out.println("����Ϊ8�����Ա�"+ L.toString());
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

class SeqList<E> implements List<E>{
	final int initca = 10;
	E[] arr;
	int size;
	int ca ;
	public SeqList() {
	arr = (E[])new  Object [initca];
	ca=initca;
	size=0;
	}
public void update(int newca) {
	E[] newarr=(E[])new Object[newca];
	for(int i=0;i<size;i++) {
		newarr[i]=arr[i];
	}
	ca=newca;
	arr = newarr;
}
public void createList(E[] a) {
	size=0;
	for(int i=0;i<a.length;i++) {
		if(size==ca) {
			update(size*2);
		}
		arr[size]=a[i];
		size++;
	}
	
}
public void add(E e) {
	if(size==ca) {
		update(size*2);
	}
	arr[size]=e;
	size++;
}
public int getSize() {
	
	return size;
}
public void setSize(int nlen) {
	if(nlen<0||nlen>size)
		throw new IllegalArgumentException("nlenΪ�Ƿ�����");
	size=nlen;
}
public E getElem(int i) {
	if(i<0||i>size-1) {
		throw new IllegalArgumentException("iΪ�Ƿ�����");
	}
	return arr[i];
}
public void setElem(int i,E e) {
	if(i<0||i>size-1) {
		throw new IllegalArgumentException("iΪ�Ƿ�����");
	}
	arr[i]=e;
}
public int getNo(E e) {
	for(int j=0;j<size;j++) {
		if(arr[j].equals(e))
			return j;
	}
	return -1;
}
public void swap(int i,int j) {
	E change;
	change=arr[i];
	arr[i]=arr[j];
	arr[j]=change;
}
public void insert(int i,E e) {
	if(i<0||i>size) {
		throw new IllegalArgumentException("iΪ�Ƿ�����");
	}
	if(size==ca) {
		update(2*size);
	}
	for(int j=size-1;j>i;j--) {
		arr[j+1]=arr[j];
	}
	arr[i]=e;
	size++;
}
public void delete(int i) {
	if(i<0||i>size-1) {
		throw new IllegalArgumentException("iΪ�Ƿ�����");
	}
	for(int j=i;j<size-1;j++) {
		arr[j]=arr[j+1];
	}
	size--;
}
public String toString() {
	String a="";
	for(int i=0;i<size;i++) {
		a+=arr[i].toString()+" ";
	}
	return a;
}
}
