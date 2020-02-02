import java.util.PriorityQueue;

public class SortAnAlmostSortedArray {
    public void sortNearlySortedArray(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int arrayLength = arr.length;
        // Fill the minHeap from 0th Index till K-1 element
        for(int i=0; i<k && k<arrayLength; i++){
            minHeap.add(arr[i]);
        }

        int iterationIdx = k;
        int placementIdx = 0;
        while(iterationIdx < arrayLength){
            // add next(starting from K+1th element) element to minHeap
            minHeap.add(arr[iterationIdx]);
            iterationIdx++;

            // Place the root of min heap at starting index of window in array.
            arr[placementIdx] = minHeap.poll();
            placementIdx++;
        }

        // place all the remaining elements in minHeap
        while(!minHeap.isEmpty()){
            arr[placementIdx] = minHeap.poll();
            placementIdx++;
        }
    }
}
