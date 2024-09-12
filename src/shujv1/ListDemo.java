package shujv1;

import java.util.Scanner;
public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------(1)创建空的线性表------");
		SeqList<String> L = new SeqList<String>();
		System.out.println("线性表长度="+L.getSize());

		System.out.println("------ (2)用指定数组创建线性表------");
		String a[]= {"x","c","u","f","d","u","c"};
		L.createList(a);
		System.out.println(L.toString());
		System.out.println("线性表长度="+L.getSize());

		System.out.println("------ (3)求指定序号元素------");
		try {
			System.out.println("序号3的元素是："+L.getElem(3));
			System.out.println("序号8的元素是："+L.getElem(8));
		}
		catch(Exception e) {
			System.out.println("! ! ! " + e.getMessage());
		}

		System.out.println("------ (4)设置指定序号元素------");
		try {
			L.setElem(3, "e");
			System.out.println("序号3的元素设置为："+L.getElem(3));
			L.setElem(8, "x");
			System.out.println("序号8的元素设置为："+L.getElem(8));
		}
		catch(Exception e) {
			System.out.println("! ! ! " + e.getMessage());
		}

		System.out.println("------ (5)求元素的序号------");
		System.out.println("字符c的位置："+ L.getNo("c"));
		System.out.println("字符n的位置："+ L.getNo("n"));
		L.add("n");
		System.out.println(L.toString());
		System.out.println("线性表长度="+L.getSize());

		System.out.println("------ (6)插入元素------");
		try {
			L.insert(3,".");
			L.insert(6,".");
			System.out.println(L.toString());
		}
		catch (Exception e) {
			System.out.println("! ! ! " + e.getMessage());
		}

		System.out.println("------ (7)删除元素------");
		try {
			L.delete(6);
			L.insert(7,".");
			System.out.println(L.toString());
		}
		catch (Exception e) {
			System.out.println("! ! ! " + e.getMessage());
		}

		System.out.println("------ (8)插入元素 异常------");
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

		System.out.println("------ (9)删除元素 异常------");
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

		System.out.println("------ (10)设置长度------");
		try {
			L.setSize(L.getSize()+1);
		}
		catch (Exception e) {
			System.out.println("! ! ! " + e.getMessage());
		}

		L.setSize(8);
		System.out.println("长度为8的线性表："+ L.toString());
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
		throw new IllegalArgumentException("nlen为非法参数");
	size=nlen;
}
public E getElem(int i) {
	if(i<0||i>size-1) {
		throw new IllegalArgumentException("i为非法参数");
	}
	return arr[i];
}
public void setElem(int i,E e) {
	if(i<0||i>size-1) {
		throw new IllegalArgumentException("i为非法参数");
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
		throw new IllegalArgumentException("i为非法参数");
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
		throw new IllegalArgumentException("i为非法参数");
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
