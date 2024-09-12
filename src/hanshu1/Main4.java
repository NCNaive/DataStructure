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
//    public void createList(int[] a) {。。。} // 用数组a创建顺序表，已实现，不需要提交
//    public String toString() {。。。}// 线性表转换为字符串，已实现，不需要提交
//    public int getSize() { 。。。}// 求表长，已实现，不需要提交
//，
//    /* 请在这里填写答案 */
//    public static SeqList merge(SeqList LA, SeqList LB) {
//        // TODO Auto-generated method stub
//        SeqList LC = new SeqList();
////        int a=0;int b=0;int c=0;
////        int i;
////        for(i = 0;i<LA.size&&i<LB.size;i++) {
////
////            if(LA.data[a]<LB.data[b]) {
////                LC.data[LC.size++]=LA.data[a];
////                a++;
////            }else {
////                LC.data[LC.size++]=LB.data[b];
////                b++;
////            }
////
////        }
//        int i=0;int j=0;
//        while(i < LA.size && i < LB.size){
//            if(LA.data[i]<=LB.data[j]){
//                LC.data[LC.size++]=LA.data[i++];
//            }else{
//                LC.data[LC.size++]=LB.data[j++];
//            }
//        }
//
//        if(i<LA.size){
//
//           while(i<LA.size){
//               LC.data[LC.size++]=LA.data[i++];
//           }
//
//        }
//
//        if(j<LB.size){
//
//            while(i<LB.size){
//                LC.data[LC.size++]=LB.data[j++];
//            }
//        }
//
////        if(i<LA.size-1) {
////            for(int j=0;j<LA.size;j++) {
////                LC.data[LC.size++]=LA.data[a];
////                a++;
////            }
////        }
////        if(i<LB.size-1) {
////            for(int j=0;j<LB.size;j++) {
////                LC.data[LC.size++]=LB.data[b];
////                b++;
////            }
////        }
//
//        return LC;
//    }
//
//
//
//}
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        SeqList LA = new SeqList();
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        LA.createList(a);
//
//        SeqList LB = new SeqList();
//        n = sc.nextInt();
//        a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        LB.createList(a);
//
//        SeqList LC = SeqList.merge(LA,LB);
//
//        System.out.println("线性表长度=" + LC.getSize());
//        System.out.println(LC.toString());
//        sc.close();
//    }
//}
//
