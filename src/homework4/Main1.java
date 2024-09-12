package homework4;

import java.util.Scanner;
import java.util.Stack;

class BTNode  {
    char data;
    BTNode  lchild;
    BTNode  rchild;

    public BTNode(char e) {
        data = e;
        lchild = null;
        rchild = null;
    }
}

class BTTreeClass {
    public BTNode  root;

    public BTTreeClass() {
        root = null;
    }

    // 用括号表示法创建二叉树,方法内容省略，不需要填写
    public void CreateBTree(String str) {

    }

    public int getHeight() {
        return getHeight(this.root);
    }

    private int getHeight(BTNode root) {
        int lchildh,rchildh;
        if(root==null){
            return 0;
        }
        else{
            lchildh=getHeight(root.lchild);
            rchildh=getHeight(root.rchild);
            return Math.max(lchildh,rchildh)+1;
        }
    }

    /* 请在这里填写答案 */
}

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        BTTreeClass bt = new BTTreeClass();
        bt.CreateBTree(str);
        System.out.println(bt.getHeight());
        sc.close();
    }
}
