package com.coding.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q841_keysandRooms {
    public static void main(String[] args) {
        Q841_keysandRooms q841 = new Q841_keysandRooms();
        List<List<Integer>> rooms;

        rooms = new ArrayList<>();
        rooms.add(new ArrayList<Integer>(Arrays.asList(1,3)));
        rooms.add(new ArrayList<Integer>(Arrays.asList(3,0,1)));
        rooms.add(new ArrayList<Integer>(Arrays.asList(2)));
        rooms.add(new ArrayList<Integer>(Arrays.asList(0)));
        System.out.println(q841.canVisitAllRooms(rooms));

        rooms = new ArrayList<>();
        rooms.add(new ArrayList<Integer>(Arrays.asList(1)));
        rooms.add(new ArrayList<Integer>(Arrays.asList(2)));
        rooms.add(new ArrayList<Integer>(Arrays.asList(3)));
        rooms.add(new ArrayList<Integer>());
        System.out.println(q841.canVisitAllRooms(rooms));

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVisited = new boolean[rooms.size()];
        travelGraph(rooms, isVisited, 0);
        for(boolean b : isVisited){
            if(!b)
                return false;
        }
        return true;
    }

    private void travelGraph(List<List<Integer>> rooms, boolean[] isVisited, int key) {
        if(isVisited[key])
            return;

        isVisited[key] = true;
        for(Integer i : rooms.get(key)){
            travelGraph(rooms, isVisited, i);
        }
    }
}
