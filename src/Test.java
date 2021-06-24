import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test {


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null);
        TreeNode node2_1 = new TreeNode(2, 1);
        TreeNode node3_2 = new TreeNode(3, 2);
        TreeNode node4_2 = new TreeNode(4, 2);
        TreeNode node5_1 = new TreeNode(5, 1);
        TreeNode node_solo = new TreeNode(12, null);
        TreeNode node_from_solo = new TreeNode(13, 12);
        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(node2_1);
        treeNodeList.add(node1);
        treeNodeList.add(node5_1);
        treeNodeList.add(node3_2);
        treeNodeList.add(node4_2);
        treeNodeList.add(node_solo);
        treeNodeList.add(node_from_solo);
        MakeHierarchy.sortByHier(treeNodeList);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.subList(2,list.size()).clear();
        list.forEach(System.out::println);

    }
}