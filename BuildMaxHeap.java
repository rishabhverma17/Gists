public class BuildMaxHeap {
    MaxHeapify h = new MaxHeapify();
    public void build(int[] arr,int len){
        // Optimization : Index of parent of last leaf Node.
        int startIdx = (len/2)-1;
        for(int i=startIdx; i>=0;i--){
            h.heapify(arr,len,i);
        }
        System.out.println("Array representation of Max-Heap is:");
        for (int i = 0; i < len; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

        /*      Heap Sort       */
        for (int i=len-1; i>=0; i--)
        {   //Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            h.heapify(arr, i, 0);
        }
        System.out.println("Array representation after applying Heap Sort:");
        for (int i = 0; i < len; ++i)
            System.out.print(arr[i] + " ");
    }
}
