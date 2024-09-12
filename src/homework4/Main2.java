//package homework4;
//
//
//import java.util.Scanner;
//import java.util.Stack;
//
//class BTNode {
//    char data;
//    BTNode lchild;
//    BTNode rchild;
//
//    public BTNode(char e) {
//        data = e;
//        lchild = null;
//        rchild = null;
//    }
//}
//
//class BTTreeClass {
//    public BTNode root;
//
//    public BTTreeClass() {
//        root = null;
//    }
//
//    // 用括号表示法创建二叉树,代码省略，不需要补充
//    public void CreateBTree(String str) {
//
//    }
//}
//
//    public int getNodeCount() {
//        return getNodeCount(this.root);
//    }
//
//    private int getNodeCount(BTNode root) {
//        int m, n, k;
//        if (root == null) {
//            return 0;
//        }
//        k=1;
//        m=getNodeCount(root.lchild);
//        n=getNodeCount(root.rchild);
//        return k+m+n;
//    }
//    /* 请在这里填写答案 */
//}
//
//public class Main2{
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        BTTreeClass bt = new BTTreeClass();
//        bt.CreateBTree(str);
//        System.out.println(bt.getNodeCount());
//        sc.close();
//    }
//}