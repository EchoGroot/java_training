package com.yuyy.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuyy
 * @date 20-3-29 上午9:52
 */
public class 地图分析 {
    private int[][] arr;
    private int[][] grid;

    public int maxDistance(int[][] grid) {
        ArrayList<ArrayList<Integer>> arrOceans=new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrLands=new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(i);
                integers.add(j);
                if(grid[i][j] ==0){
                    arrOceans.add(integers);
                }else{
                    arrLands.add(integers);
                }
            }
        }
        if(arrOceans.size()==0||arrLands.size()==0){
            return -1;
        }
        int lengthMax=0;
        int lengthMin=200;
        int length=0;
        for (ArrayList<Integer> ocean:arrOceans) {
            lengthMin=200;
            for (ArrayList<Integer> land:arrLands) {
                length=Math.abs(ocean.get(0)-land.get(0))+Math.abs(ocean.get(1)-land.get(1));
                if(lengthMin>length){
                    lengthMin=length;
                }
            }
            if (lengthMin > lengthMax) {
                lengthMax = lengthMin;
            }
        }
        return lengthMax;
    }

    public int[] bfs(int x,int y){
        this.arr=new int[101][101];
        this.arr[x][y]=1;
        Queue<int[]>queue=new LinkedList<>();
        int[] t=new int[2];
        t[0]=x;
        t[1]=y;
        queue.add(t);
        while(queue.size()>0){
            t=queue.poll();
            if (t[0] - 1 >= 0 ) {                       //2
                if (arr[t[0] - 1][t[1]] == 0) {
                    arr[t[0] - 1][t[1]] = 1;
                    int[] result = new int[2];
                    result[0] = t[0] - 1;
                    result[1] = t[1];
                    if (this.grid[t[0] - 1][t[1]] == 1) {
                        return result;
                    }else{
                        queue.add(result);
                    }
                }
                if(t[1] - 1 >= 0){                                 //1
                    if (arr[t[0] - 1][t[1] - 1] == 0) {
                        arr[t[0] - 1][t[1] - 1] = 1;
                        int[] result = new int[2];
                        result[0] = t[0] - 1;
                        result[1] = t[1] - 1;
                        if (this.grid[t[0] - 1][t[1] - 1] == 1) {
                            return result;
                        }else{
                            queue.add(result);
                        }
                    }
                }
                if(t[1] + 1 < this.grid.length){                                 //3
                    if (arr[t[0] - 1][t[1] + 1] == 0) {
                        arr[t[0] - 1][t[1] + 1] = 1;
                        int[] result = new int[2];
                        result[0] = t[0] - 1;
                        result[1] = t[1] + 1;
                        if (this.grid[t[0] - 1][t[1] + 1] == 1) {
                            return result;
                        }else{
                            queue.add(result);
                        }
                    }
                }
            }
            if (t[1] - 1 >= 0) {                //4
                if (arr[t[0]][t[1] - 1] == 0) {
                    arr[t[0]][t[1] - 1] = 1;
                    int[] result = new int[2];
                    result[0] = t[0];
                    result[1] = t[1] - 1;
                    if (this.grid[t[0]][t[1] - 1] == 1) {
                        return result;
                    }else{
                        queue.add(result);
                    }
                }
            }
            if (t[1] + 1 < this.grid.length) {                //5
                if (arr[t[0]][t[1] + 1] == 0) {
                    arr[t[0]][t[1] + 1] = 1;
                    int[] result = new int[2];
                    result[0] = t[0];
                    result[1] = t[1] + 1;
                    if (this.grid[t[0]][t[1] + 1] == 1) {
                        return result;
                    }else{
                        queue.add(result);
                    }
                }
            }
            if (t[0] + 1 < this.grid.length ) {                       //7
                if (arr[t[0] + 1][t[1]] == 0) {
                    arr[t[0] + 1][t[1]] = 1;
                    int[] result = new int[2];
                    result[0] = t[0] + 1;
                    result[1] = t[1];
                    if (this.grid[t[0] + 1][t[1]] == 1) {
                        return result;
                    }else{
                        queue.add(result);
                    }
                }
                if(t[1] - 1 >= 0){                                 //6
                    if (arr[t[0] + 1][t[1] - 1] == 0) {
                        arr[t[0] + 1][t[1] - 1] = 1;
                        int[] result = new int[2];
                        result[0] = t[0] + 1;
                        result[1] = t[1] - 1;
                        if (this.grid[t[0] + 1][t[1] - 1] == 1) {
                            return result;
                        }else{
                            queue.add(result);
                        }
                    }
                }
                if(t[1] + 1 < this.grid.length){                                 //8
                    if (arr[t[0] + 1][t[1] + 1] == 0) {
                        arr[t[0] + 1][t[1] + 1] = 1;
                        int[] result = new int[2];
                        result[0] = t[0] + 1;
                        result[1] = t[1] + 1;
                        if (this.grid[t[0] + 1][t[1] + 1] == 1) {
                            return result;
                        }else{
                            queue.add(result);
                        }
                    }
                }
            }
        }
        return null;
    }

    public int maxDistance1(int[][] grid){
        this.grid=grid;

        ArrayList<ArrayList<Integer>> arrOceans=new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrLands=new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(i);
                integers.add(j);
                if(grid[i][j] ==0){
                    arrOceans.add(integers);
                }else{
                    arrLands.add(integers);
                }
            }
        }
        if(arrOceans.size()==0||arrLands.size()==0){
            return -1;
        }
        int lengthMax=0;
        for (ArrayList<Integer> ocean:arrOceans) {
            int[] bfs = bfs(ocean.get(0), ocean.get(1));
            int length = Math.abs(ocean.get(0) - bfs[0]) + Math.abs(ocean.get(1) - bfs[1]);
            if(length>lengthMax){
                lengthMax=length;
            }
        }
        return lengthMax;
    }

    public int maxDistance2(int[][] grid){
        Queue<int[]> queue=new LinkedList<>();
        int[] arr=null;
        boolean hasOcean=false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                }else{
                    hasOcean=true;
                }
            }
        }
        if(!hasOcean||queue.isEmpty()){
            return -1;
        }
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        while (!queue.isEmpty()){
            arr=queue.poll();
            for (int i = 0; i < 4; i++) {
                int y=arr[0]+dy[i];
                int x=arr[1]+dx[i];
                if(y<0||y>=grid.length||x<0||x>=grid.length||grid[y][x]!=0){
                    continue;
                }
                grid[y][x]=grid[arr[0]][arr[1]]+1;
                queue.offer(new int[]{y,x});
            }
        }
        return grid[arr[0]][arr[1]]-1;
    }

    public static void main(String[] args){
        int[][] arr={{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(new 地图分析().maxDistance2(arr));
    }
}
