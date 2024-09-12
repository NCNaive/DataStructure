package homework32;//package homework32;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in =new Scanner(System.in);
//        int m=in.nextInt();
//        int n=in.nextInt();
//        int N=in.nextInt();
//        TupClass t1=new TupClass();
//        TupClass t2=new TupClass();
//        int A[][]=new int[m][n];
//        for (int i = 0; i < N; i++) {
//                    int a1=in.nextInt(); int a2=in.nextInt();
//                    A[a1][a2]=in.nextInt();
//
//        }
//
//
//
//        t1.CreateTup(A,m,n);
//        t1.Transpose(t1);
//        t1.DispTue();
//    }
//
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
//    ArrayList<TupElem> data;
//
//    public TupClass() {
//        data=new  ArrayList<TupElem>();
//        N=0;
//    }
//    public void CreateTup(int [][]A,int m,int n) {
//        Row = m;
//        Col = n;
//        for (int i = 0; i < Row; i++) {
//            for (int j = 0; j < Col; j++) {
//                if (A[i][j] != 0) {
//                    data.add(new TupElem(Row, Col, A[i][j]));
//                    N++;
//                }
//            }
//        }
//    }
//    public void DispTue(){
//        if(N<=0){
//            return;
//        }
//        System.out.printf("行数=%d,列数=%d，非零元素个数=%d\n",Row,Col,N);
//        for (int i = 0; i < N; i++) {
//            System.out.printf("%5d%5d%5d\n",data.get(i).r,data.get(i).c,data.get(i).d);
//        }
//    }
//    TupClass Transpose(TupClass a){
//        TupClass b= new TupClass();
//        if(a.N==0){
//            return b;
//        }
//        b.Row=a.Col;
//        b.Col=a.Row;
//        b.N=a.N;
//        for (int i = 0; i <a.Col; i++) {
//            for (int j = 0; j < a.N; j++) {
//                if(a.data.get(j).c==i){
//                    TupElem p =new TupElem(a.data.get(j).c,a.data.get(j).r,a.data.get(j).d);
//                    b.data.add(p);
//                }
//
//            }
//        }
//        return b;
//    }
//
//}
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // 读取词典
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }

            String[] words = line.split(" ");
            String foreignWord = words[1];
            String englishWord = words[0];
            dictionary.put(foreignWord, englishWord);
        }

        // 翻译外语单词
        while (scanner.hasNextLine()) {
            String foreignWord = scanner.nextLine();
            String translation = dictionary.getOrDefault(foreignWord, "eh");
            System.out.println(translation);
        }
    }
}
