import model.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Task1 {

    static HashMap<String, Node> nodesMap = new HashMap<String, Node>();

    public static void main(String[] args) {
        setupNodes();
        ArrayList<String> traversedNodes = new ArrayList<>();
        ArrayList<ArrayList<String>> allPossibleRoutes = findRoute("A", "H", traversedNodes);
        System.out.println("===All possible routes===");
        for(int i = 0; i < allPossibleRoutes.size(); i++) {
            String[] arr2 = new String[allPossibleRoutes.get(i).size()];
            arr2 = allPossibleRoutes.get(i).toArray(arr2);
            System.out.println(String.join("->", arr2));
        }
        System.out.println("===Minimum distance route===");
        int index = 0;
        int minStep2 = allPossibleRoutes.get(index).size();
        for(int i = 0; i < allPossibleRoutes.size(); i++) {
            if (allPossibleRoutes.get(i).size() < minStep2) {
                index = i;
                minStep2 = allPossibleRoutes.get(i).size();
            }
        }
        String[] arr3 = new String[allPossibleRoutes.get(index).size()];
        arr3 = allPossibleRoutes.get(index).toArray(arr3);
        System.out.println(String.join("->", arr3));
    }

    public static ArrayList<ArrayList<String>> findRoute(String from, String to, ArrayList<String> traversedNodes) {
        if (from.equals(to)) {
            ArrayList<ArrayList<String>> result = new ArrayList<>();
            ArrayList<String> traversedNodesClone = new ArrayList(traversedNodes);
            traversedNodesClone.add(to);
            result.add(traversedNodesClone);
            return result;
        }
        Node currentNode = nodesMap.get(from);
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < currentNode.connectedNodes.size(); i++) {
            Node connectedNodeN = nodesMap.get(currentNode.connectedNodes.get(i));
            if (traversedNodes.contains(connectedNodeN.name)) {
                //Avoid re-travel the same node
                continue;
            }
            ArrayList<String> traversedNodesClone = new ArrayList(traversedNodes);
            traversedNodesClone.add(currentNode.name);
            result.addAll(findRoute(connectedNodeN.name, to, traversedNodesClone));
        }
        return result;
    }


    public static void setupNodes() {
        createNodeAndPutHashMap("A", new String[]{"B", "D", "H"});
        createNodeAndPutHashMap("B", new String[]{"A", "C", "D"});
        createNodeAndPutHashMap("C", new String[]{"B", "D", "F"});
        createNodeAndPutHashMap("D", new String[]{"A", "B", "C", "E"});
        createNodeAndPutHashMap("E", new String[]{"D", "F", "H"});
        createNodeAndPutHashMap("F", new String[]{"C", "E", "G"});
        createNodeAndPutHashMap("G", new String[]{"F", "H"});
        createNodeAndPutHashMap("H", new String[]{"A", "E", "G"});
    }

    private static void createNodeAndPutHashMap(String nodeName, String[] connectedNodes) {

        Node node = new Node(nodeName, new ArrayList<String>(Arrays.asList(connectedNodes)));
        nodesMap.put(nodeName, node);
    }

}
