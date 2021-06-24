public class TreeNode {
   private int id;
   public Integer parentId;

    public int getId() {
        return id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public TreeNode(int id, Integer parentId) {
        this.id = id;
        this.parentId = parentId;
    }
}
