package work7_6_2;


import java.util.Scanner;
class RecType {
    int key;
    String data;

    public RecType(int key) {
        super();
        this.key = key;
    }
}

class SortList {
    RecType[] R;
    int n;

    public SortList(int[] r) { //用数组元素值，创建线性表
        super();
        R = new RecType[r.length + 1];
        for (int i = 0; i < r.length; i++)
            R[i] = new RecType(r[i]); //
        n = r.length;
    }

    public void Disp() {//输出线性表的元素
        for (int i = 0; i < n; i++)
            System.out.printf(R[i].key + " ");
        System.out.println();
    }

    public void BubbleSort() {
        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j < n-i-1; j++) {
                if(R[j].key>R[j+1].key){
                        RecType temp=R[j];
                        R[j]=R[j+1];
                        R[j+1]=temp;
                }
            }
            Disp();
        }

    }
    /* 请在这里填写答案 */
}

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        SortList ss = new SortList(a);
        ss.BubbleSort();
        sc.close();
    }
}


