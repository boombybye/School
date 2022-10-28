public class TreeNode{
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode stem = null;
    public int data;

    public TreeNode(int d, TreeNode s){
        data = d;
        stem = s;
    }

    public TreeNode(int d){
        data = d;
    }
}