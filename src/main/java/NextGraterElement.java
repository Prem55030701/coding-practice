import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGraterElement {
    public static void main(String[] args) {

        //int arr[]={4 , 5 , 2 , 25 };
        int arr[] = { 13 , 7, 6 , 12};
        // int arr[] = {3, 8, 4, 1, 2, 6, 7, 2};
        //printNGEBruteForce(arr);
        //printStack(arr);
        printOptimal(arr);
    }

  static void printOptimal(int[] arr){
       int i;
       List<Integer> list=new ArrayList<>(Collections.nCopies(arr.length, -1));
       int max=arr[arr.length-1];
       for(i=arr.length-2;i>=0;i--)
       {
          /* if(arr[i+1]>arr[i])
           {
              list.set(i,arr[i+1]);
           }
          else {
              // We do not need this , This condition is already covered in max logic
               if (list.get(i+1)>arr[i])
                   list.set(i,list.get(i+1)); */
               //else
           if (max>arr[i])
               {
                   int k=i+1;
                   while (arr[k]<=arr[i])
                       k++;
                   list.set(i,arr[k]);
               }
          // }

           max=Math.max(max,arr[i]);
       }

      for (int l = 0; l < arr.length; l++) {
          System.out.println(arr[l]+"----->"+list.get(l));
      }
}

    static void printStack(int[] arr){
        Stack<Integer> stack=new Stack<>();
        int i=0;
        stack.push(arr[0]);
        for(i=1;i<arr.length;i++)
        {
            while(!stack.isEmpty() && arr[i]>stack.peek())
                System.out.println(stack.pop() +"-----> "+ arr[i]);

            stack.push(arr[i]);
        }

        while (!stack.isEmpty())
            System.out.println(stack.pop() +"-----> -1");
    }

    static void printNGEBruteForce(int[] arr){
        int i;
        int j;
        int length= arr.length;
        int next=-1;
        for(i=0;i<length;i++){
            next=-1;
            for(j=i+1;j<length;j++)
            {
                if(arr[j]>arr[i]){
                    next=arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + "------>"+next);
        }
    }
}

