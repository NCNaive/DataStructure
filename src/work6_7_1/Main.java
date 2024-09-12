package work6_7_1;

import java.util.Scanner;

class RecType
{
    int key;      //关键字
    String data;      //其他数据

    public RecType(int d)
    {  key=d;  }
}

class SqListSearchClass {
    RecType[] R; // R[0..n-1]表示查找表
    int n; // 实际元素个数

    public SqListSearchClass(int a[])
    {
        R = new RecType[1000];
        for (int i = 0; i < a.length; i++)
            R[i] = new RecType(a[i]);
        n = a.length;
    }

    public void binSearch(int k)     //折半查找法
    //  参数k表示待查找的关键字值。查找成功时，方法返回编号0..n-1，查找失败时，方法返回 -1。
    {
        int sum=0;
        int low=0,high=n-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(k==R[mid].key){
                sum++;
                System.out.print(mid+"\n"+sum);
                return;
            }
            if(k<R[mid].key){
                sum++;
                high=mid-1;
            }else {
                sum++;
                low=mid+1;
            }
        }
        System.out.print(-1+"\n"+sum);

    }

}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++) {
            a[i]=sc.nextInt();
        }
        SqListSearchClass ss = new SqListSearchClass(a);
        int k = sc.nextInt();
//        System.out.println(ss.binSearch(k));
        ss.binSearch(k);
        sc.close();

    }
}