package graphRelated;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SortItemsGroupsRespectingDependencies {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, Integer> indegreeMap = new HashMap();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        Map<Integer, Integer> grpIndegreeMap = new HashMap();
        Map<Integer, List<Integer>> grpGraph = new HashMap<>();


        for (int i = 0; i < n; i++) {
            indegreeMap.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        int nextGrpId = m;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = nextGrpId;
                nextGrpId++;
            }
            if (groupMap.get(group[i]) == null) {
                groupMap.put(group[i], new ArrayList<>());
            }
            groupMap.get(group[i]).add(i);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> beforeList = beforeItems.get(i);
            if (beforeList != null) {
                for (Integer id : beforeList) {
                    if (group[i] == group[id]) {
                        indegreeMap.put(i, indegreeMap.get(i) + 1);
                        graph.get(id).add(i);
                    }
                }
            }
        }

        Map<Integer, List<Integer>> sortedGroupItemMap = new HashMap<>();
        for (int grpId : groupMap.keySet()) {
            List<Integer> sortedGroupItem = topoLogicSort(groupMap.get(grpId), indegreeMap, graph);
            if (sortedGroupItem.size() == 0) {
                return new int[0];
            }
            sortedGroupItemMap.put(grpId, sortedGroupItem);
        }

        for (int grpId : group) {
            grpIndegreeMap.put(grpId, 0);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> beforeList = beforeItems.get(i);
            if (beforeList != null) {
                for (Integer id : beforeList) {
                    if (group[i] != group[id]) {
                        grpIndegreeMap.put(group[i], grpIndegreeMap.getOrDefault(group[i], 0) + 1);
                        if (grpGraph.get(group[id]) == null) {
                            grpGraph.put(group[id], new ArrayList<>());
                        }
                        grpGraph.get(group[id]).add(group[i]);
                    }
                }
            }
        }
        List<Integer> grpIDs = new ArrayList<>(grpIndegreeMap.keySet());
        List<Integer> sortedGrp = topoLogicSort(grpIDs, grpIndegreeMap, grpGraph);
        List<Integer> tempList = new ArrayList<>();
        for (int grpId : sortedGrp) {
            tempList.addAll(sortedGroupItemMap.get(grpId));
        }
        int[] res = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            res[i] = tempList.get(i);
        }
        return res;
    }

    private List<Integer> topoLogicSort(List<Integer> items, Map<Integer, Integer> indegreeMap, Map<Integer, List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        for (int id : items) {
            if (indegreeMap.get(id) == 0) {
                q.add(id);
            }
        }
        List<Integer> tempList = new ArrayList<>();

        while (!q.isEmpty()) {
            int curId = q.poll();
            tempList.add(curId);
            List<Integer> nextIDs = graph.get(curId);
            if (nextIDs != null) {
                for (Integer nextID : nextIDs) {
                    indegreeMap.put(nextID, indegreeMap.get(nextID) - 1);
                    if (indegreeMap.get(nextID) == 0) {
                        q.add(nextID);
                    }
                }
            }
        }
        if (tempList.size() != items.size()) {
            return new ArrayList<>();
        }
        return tempList;
    }


    @Test
    public void test() {
        int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
        List<List<Integer>> beforeItems = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        List<Integer> list4 = new ArrayList<>();
        list4.add(6);
        List<Integer> list5 = new ArrayList<>();
        list5.add(3);
        list5.add(6);
        List<Integer> list6 = new ArrayList<>();
        List<Integer> list7 = new ArrayList<>();
        List<Integer> list8 = new ArrayList<>();
        beforeItems.add(list1);
        beforeItems.add(list2);
        beforeItems.add(list3);
        beforeItems.add(list4);
        beforeItems.add(list5);
        beforeItems.add(list6);
        beforeItems.add(list7);
        beforeItems.add(list8);

        System.out.println(sortItems(8, 2, group, beforeItems));
    }


}
