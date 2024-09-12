//import java.util.Scanner;
//
//class SeqList {
//    public int[] data; // 元素int类型
//    public int size;
//
//    public SeqList() {
//        this.data = new int[10];
//        this.size = 0;
//    }
//
//    public void createList(int[] a) {} // 用数组a创建顺序表，已实现，不需要提交
//    public String toString() {}// 线性表转换为字符串，已实现，不需要提交
//    public int getSize() {}// 求表长，已实现，不需要提交
//
//    /* 请在这里填写答案 */
//    public void deleteX(int x) {
//
//        for (int i = 0; i < getSize(); i++) {
//            if(x==data[i]){
//                for (int j = i; j < getSize()-1; j++) {
//                    data[j]=data[j+1];
//                }
//                size--;
//            }
//        }
//    }
//
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        SeqList L = new SeqList();
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        L.createList(a);
//        int x = sc.nextInt();
//        L.deleteX(x);
//        System.out.println("线性表长度=" + L.getSize());
//        System.out.println(L.toString());
//        sc.close();
//    }
//}