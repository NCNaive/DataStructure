package homework31;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int Row=in.nextInt(),Col=in.nextInt(),N1=in.nextInt();
        int A[][]=new int [Row][Col];
        int B[][]=new int [Row][Col];
        for (int i = 0; i < N1; i++) {
            int a=in.nextInt(),b=in.nextInt();
            A[a][b]=in.nextInt();
        }
        int N2=in.nextInt();
        for (int i = 0; i < N2; i++) {
            int a=in.nextInt(),b=in.nextInt();
            B[a][b]=in.nextInt();
        }
        TupClass t=new TupClass();
        t.add(Row,Col,A,B);
        t.DispTup();
    }
}
class TupElem<E> {
    int r;
    int c;
    int d;
    public TupElem(int r1,int c1,int d1){
        r=r1;
        c=c1;
        d=d1;
    }
}
class TupClass{
    int rows;
    int cols;
    int nums;
    ArrayList <TupElem> data;

    public TupClass() {
        this.nums = 0;
        data=new ArrayList<TupElem>();
    }
    public void add(int r,int c,int A[][],int B[][]){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(A[i][j]+B[i][j]!=0){
                    data.add(new TupElem(i,j,A[i][j]+B[i][j]));
                    nums++;
                }
            }
        }
    }

    public  void DispTup(){
        if(nums<=0){
            return;
        }
        System.out.println(nums);
        for (int i = 0; i < nums; i++) {
            System.out.printf("%d%5d%5d\n",data.get(i).r,data.get(i).c,data.get(i).d);
        }
    }
}



