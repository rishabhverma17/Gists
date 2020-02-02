package com.java.practice;

import java.util.*;

public class BreadthFirstSearch {
    public Set<Integer> BFS (GraphAdjacencyList graph, int root){
        Set<Integer> visited = new LinkedHashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            if(!visited.contains(vertex)){
                visited.add(vertex);
                for(Integer temp : graph.getEdge(vertex)){
                    queue.offer(temp);
                }
            }
        }
        return visited;
    }
}
