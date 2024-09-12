package work6_7_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
//        int a[]= new int[in.nextInt()];
        ArrayList<Integer> arrayList =new ArrayList();
        int arr[]=new int[5];
        int n=in.nextInt();
        for (int i = 0; i < n; i++) {
            arrayList.add(in.nextInt());
        }
        Collections.sort(arrayList);
            int low=0,high=arrayList.size()-1,mid=0;
            while(low<high){
                int i=0;
                mid=(low+high)/2;
                if(90==arrayList.get(i))
                    arr[0]=arrayList.size()-i;
                if(90<arrayList.get(i))
                    high=mid-1;
                else
                    low=mid+1;

                i++;
            }
            if(arr[0]==0)
                arr[0]=arrayList.size()-high;


            low=0;high=arrayList.size()-1;mid=0;
        while(low<high){
            int i=0;
            mid=(low+high)/2;
            if(80==arrayList.get(i))
                arr[1]=arrayList.size()-i-arr[0];
            if(80<arrayList.get(i))
                high=mid-1;
            else
                low=mid+1;

            i++;
        }
        if(arr[1]==0)
            arr[1]=arrayList.size()-high-arr[0];

        low=0;high=arrayList.size()-1;mid=0;
        while(low<high){
            int i=0;
            mid=(low+high)/2;
            if(70==arrayList.get(i))
                arr[2]=arrayList.size()-i-arr[0]-arr[1];
            if(70<arrayList.get(i))
                high=mid-1;
            else
                low=mid+1;

            i++;
        }
        if(arr[2]==0)
            arr[2]=arrayList.size()-high-arr[0]-arr[1];
        System.out.println(high);
        System.out.println(low);
        System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
    }

}
//class RecType{
//    int key;
//    String data;
//    public RecType(int d){
//        key=d;
//    }
//}
//class SqListSearchClass{
//    final int MAXN=100;
//    RecType[]R;
//    int n;
//    public void CreateR(int[] a){
//        R=new RecType[MAXN];
//        for (int i = 0; i <a.length; i++) {
//            R[i]=new RecType(a[i]);
//            n=a.length;
//        }
//
//    }
//    public int BinSearch(int k){
//        int low=0,high=n-1,mid;
//        while(low<high){
//            mid=(low+high)/2;
//            if(k==R[mid].key){
//                return mid;
//            }
//            if(k<R[mid].key){
//                high=mid-1;
//            }
//            else{
//                low=mid-1;
//            }
//        }
//        return -1;
//    }
//}
