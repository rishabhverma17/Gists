import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxMin_PriorityQueue {
    int[] test = {4,5,3,76,34,87,97,23,64};
    public void maxPriorityQueue(){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((int) test.length), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i : test){
            maxHeap.add(i);
        }
        while (!maxHeap.isEmpty()){
            System.out.print(maxHeap.poll()+" ");
        }
    }

    public void minPriorityQueue(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(((int) test.length), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i : test){
            minHeap.add(i);
        }
        while (!minHeap.isEmpty()){
            System.out.print(minHeap.poll()+" ");
        }
    }
}
