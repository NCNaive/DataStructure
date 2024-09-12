import java.util.Scanner;
import java.util.Stack;

class BTNode <E>{
    E data;
    BTNode<E> lchild;
    BTNode<E> rchild;

    public BTNode(E e)    {
        data=e;
        lchild=null;
        rchild=null;
    }
}

class BTTreeClass {
    public BTNode<Character> root;

    public BTTreeClass()    {
        root=null;
    }

    void CreatBTTree(String s)    {      //用 括号表示法的字符串创建二叉链，内容省略，不需要补充提交。
//      。。。
    }

    public void PreOrder1( )   {
        PreOrder11(this.root);
    }




    public void InOrder1( )   {
        InOrder11(this.root);
    }



    public void PostOrder1( )    {
        PostOrder11(this.root);
    }


//    private void PreOrder11(BTNode<Character> ro) {
//        if(ro!=null)
//        {
//            System.out.print(ro.data+" ");
//            PreOrder11(ro.lchild);
//            PreOrder11(ro.rchild);
//        }
//    }
//    private void InOrder11(BTNode<Character> root) {
//        if(root!=null){
//            PreOrder11(root.lchild);
//            System.out.print(root.data+" ");
//            PreOrder11(root.rchild);
//        }
//    }
//    private void PostOrder11(BTNode<Character> root) {
//        if(root!=null)
//        {
//            PreOrder11(root.lchild);
//            PreOrder11(root.rchild);
//            System.out.print(root.data+" ");
//        }
//    }
private void PreOrder11(BTNode<Character> root) {
    if (root == null) {
        return;
    }

    System.out.print(root.data + " ");
    PreOrder11(root.lchild);
    PreOrder11(root.rchild);
}

    private void InOrder11(BTNode<Character> root) {
        if (root == null) {
            return;
        }

        InOrder11(root.lchild);
        System.out.print(root.data + " ");
        InOrder11(root.rchild);
    }

    private void PostOrder11(BTNode<Character> root) {
        if (root == null) {
            return;
        }

        PostOrder11(root.lchild);
        PostOrder11(root.rchild);
        System.out.print(root.data + " ");
    }
    /*你的代码将嵌入这里*/

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTTreeClass  bt = new BTTreeClass();
        String s= sc.next();
        bt.CreatBTTree(s);
        bt.PreOrder1( );
        System.out.println();
        bt.InOrder1( );
        System.out.println();
        bt.PostOrder1( );
        System.out.println();
        sc.close();
    }
}