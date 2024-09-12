package hanshu1;

import java.util.Scanner;
class SqList
{
    public  int[]  data ;
    public  int  size  ;


    public SqList( int a [])  {
        //用数组a的元素值创建顺序表
        //代码省略，不需要提交
    }

    public boolean isOrder() {
        for (int i = 0; i < size-1; i++) {
            if(data[i]>data[i+1]){
                return false;
            }
        }
        return true;
    }

    /*你提交的代码将嵌入这里 */
}

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        SqList L = new SqList(a);
        System.out.println(L.isOrder());
        sc.close();
    }
}