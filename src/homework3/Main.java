//package homework3;//package homework3;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//Scanner in =new Scanner(System.in);
//TupClass t1 =new TupClass();
//TupClass t2 =new TupClass();
//TupClass t3 =new TupClass();
//        int Row=in.nextInt();
//        int Col=in.nextInt();
//        int A[][]=new int[Row][Col];
//        int B[][]=new int[Row][Col];
//        int C[][]=new int[Row][Col];
//        int N1=in.nextInt();
//        for (int i = 0; i < N1; i++) {
//            A[in.nextInt()][in.nextInt()]=in.nextInt();
//
//        }
//        int N2=in.nextInt();
//        for (int i = 0; i < N2; i++) {
//            B[in.nextInt()][in.nextInt()]=in.nextInt();
//        }
//        t1.CreateTup(A,Row,Col);
//        t2.CreateTup(B,Row,Col);
//        t3.CreateTup(C,Row,Col);
//        for (int i = 0; i < Row; i++) {
//            for (int j = 0; j < Col; j++) {
//                C[i][j]=t1.data.get();
//            }
//        }
//        int N3=0;
//        for (int i = 0; i < Row; i++) {
//            for (int j = 0; j < Col; j++) {
//                if(Math.abs(C[i][j])>0.1){
//                    N3++;
//                }
//            }
//        }
//        System.out.println(N3);
//        for (int i = 0; i < Row; i++) {
//            for (int j = 0; j < Col; j++) {
//                if(C[i][j]>0){
//                    System.out.println(i+" "+j+" "+C[i][j]);
//                }
//            }
//        }
//    }
//}
//class TupElem<E> {
//    int r;
//    int c;
//    int d;
//    public TupElem(int r1, int c1, int d1){
//        r=r1;
//        c=c1;
//        d=d1;
//    }
//
//}
//class TupClass
//{
//    int Row;
//    int Col;
//    int N;
//    ArrayList <TupElem>data;
//
//    public TupClass() {
//        data=new  ArrayList<TupElem>();
//        N=0;
//    }
//    public void CreateTup(int [][]A,int m,int n){
//        Row = m;
//        Col = n;
//        for (int i = 0; i < Row; i++) {
//            for (int j = 0; j < Col; j++) {
//                if(A[i][j]!=0){
//                    data.add(new TupElem(Row,Col,A[i][j]));
//                    N++;
//                }
//            }
//        }
//    }
//
////    public bool
//
//}
