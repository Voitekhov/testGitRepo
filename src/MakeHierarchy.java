import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MakeHierarchy {
    private ConcurrentHashMap<Integer, List<TreeNode>> nodesMap;
    private TreeNode root;


    public List<TreeNode> getHierarchyList(List<TreeNode> list) {
        populateMap(list);
        return hierarchyList(root, new LinkedList<TreeNode>(), list);
    }

    private void populateMap(List<TreeNode> list) {
        nodesMap = new ConcurrentHashMap<>();
        for (TreeNode node : list) {
            if (node.getParentId() == null) {
                root = node;
            } else {
                nodesMap.put(node.getId(), getChildren(list, node.getId()));
            }
        }
    }

    // implement
    /*private TreeNode getParent(int childId) {

    }*/

    private List<TreeNode> getChildren(List<TreeNode> list, int parentId) {
        List<TreeNode> children = new ArrayList<>();
        for (TreeNode node : list) {
            if (node.getParentId() == parentId) {
                children.add(node);
            }
        }
        return children;
    }

    private List<TreeNode> hierarchyList(TreeNode currentNode, List<TreeNode> hierarchyList,
                                         List<TreeNode> listToFindParent) {
        hierarchyList.add(currentNode);
        if (!nodesMap.get(currentNode.getId()).isEmpty()) {
            List<TreeNode> list = nodesMap.get(currentNode.getId());
            for (TreeNode node : list) {
                return hierarchyList(currentNode, hierarchyList, listToFindParent);
            }
        }
        nodesMap.get(currentNode.getParentId()).remove(currentNode);
            return hierarchyList(listToFindParent.get(currentNode.getParentId()), hierarchyList,
                    listToFindParent);
    }

    public static List<TreeNode> sortByHier(List<TreeNode> startList) {
        List<TreeNode> rootList = new ArrayList<>();

        Map<Integer, List<TreeNode>> map = new HashMap<>();
        for (TreeNode node : startList) {
            Integer parentId = node.getParentId();
            if (parentId == null) {
                rootList.add(node);
            } else {
                if (map.containsKey(parentId)) {
                    map.get(parentId).add(node);
                } else {
                    ArrayList<TreeNode> children = new ArrayList<>();
                    children.add(node);
                    map.put(parentId, children);
                }
            }
        }

        ArrayList<TreeNode> result = new ArrayList<>();
        sortByHier(map, rootList, result);
        return result;
    }

    private static void sortByHier(Map<Integer, List<TreeNode >> map, List<TreeNode> currentList,
                                  List<TreeNode> finalList) {
        for (TreeNode node : currentList) {
            finalList.add(node);
            List<TreeNode> children = map.get(node.getId());
            if (children != null) {
                sortByHier(map, children, finalList);
            }
        }
    }
}
