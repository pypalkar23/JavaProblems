package com;

import java.util.LinkedList;
import java.util.List;


class DepthFirstSearch{
    public static void main(String[] args) {
        
        int vertices=6;
        boolean visited[]=new boolean[vertices];
        List<Integer>[] graph=new LinkedList[vertices];
        for(int i=0;i<vertices;i++){
            graph[i]=new LinkedList<Integer>();
        }

        graph[0].add(1);
        graph[0].add(3);
        graph[1].add(2);
        graph[1].add(4);
        graph[3].add(5);
        dfs(0,graph,visited);     
    }


public static void dfs(int node,List<Integer>[] graph,boolean[] visited){
    if(visited[node]==false){
        visited[node]=true;
    }

    System.out.println(node);
    for(int i=0,n=graph[node].size();i<n;i++){
        dfs((graph[node].get(i)).intValue(),graph,visited);
    }
}
}