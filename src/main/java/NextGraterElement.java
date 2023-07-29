import java.util.Stack;

public class NextGraterElement {
    public static void main(String[] args) {
        int arr[] = {13,7,6,12};
        //printNGEBruteForce(arr);
        printStack(arr);
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

