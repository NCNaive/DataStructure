//package ke_wai;
//
//import java.util.Scanner;
//class RecType {
//    int key;
//    String data;
//
//    public RecType(int key) {
//        super();
//        this.key = key;
//    }
//}
//
//class SortList1 {
//    RecType[] R;
//    int n;
//
//    SortList1(int[] r) {//用数组元素值，创建线性表
//        super();
//        R = new RecType[r.length+1];
//        for(int i=0;i<r.length;i++)
//            R[i] = new RecType(r[i]);  //
//        n = r.length;
//    }
//
//    void Disp() {//输出线性表的元素
//        for(int i=0;i<n;i++)
//            System.out.printf(R[i].key+" ");
//        System.out.println();
//    }
//
//    void QuickSort()
//    {
//        QuickSort1(0,n-1);//对0..n-1范围的元素使用快速排序算法
//    }
//    void QuickSort1(int s,int t)
//    {  //在一次以s为枢轴元素的划分后，对[s..i-1],[i+1..t]的元素继续使用快速排序
//        if (s<t)
//        {  int i = Partition(s,t);
//            QuickSort1(s,i-1);
//            QuickSort1(i+1,t);
//        }
//    }
//
//    private int Partition(int s, int t) {
//        int i=s,j=t,k;
//        k=R[s].key;
//        while(i<j){
//            while(i<j&&R[j].key>=k){
//                j--;
//            }
//            while(i<j&&R[i].key<=k){
//                i++;
//            }
//            if(i<j) {
//                int temp = R[j].key;
//                R[j].key = R[i].key;
//                R[i].key = temp;
//            }
//        }
//        int temp=R[i].key;
//        R[i].key=R[s].key;
//        R[s].key=temp;
//        return i;
//    }
//
//    /* 请在这里填写答案 ，实现 Partition(s,t)算法*/
//}
//public class QuickSort_Main {
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        Scanner sc = new Scanner(System.in);
//        int n  = sc.nextInt();
//        int a[]=new int[n];
//        for(int i=0;i<n;i++)
//            a[i] = sc.nextInt();
//        SortList1  ss = new SortList1(a);
//        ss.QuickSort();
//        ss.Disp();
//        sc.close();
//    }
//}
