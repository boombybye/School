import javax.swing.tree.TreeNode;

public class tree {
    TreeNode root;
    TreeNode current;
    int longest = 0;

    public static void main(String[] args) {
    
    }

    public tree(TreeNode seed){
        root = seed;
    }

    public void add(int data){
        current = root;
        boolean placed = false;
        while(!placed){
            if(data<current.data){
                if(current.left!=null){
                    current = current.left;
                } else {
                    current.left = new treeNode(data);
                    placed = true;
                }
            } else if(data>current.data){
                if(data.right!=null){
                    current = current.right;
                } else {
                    current.right = new treeNode(data);
                    placed = true;
                }
            } else {
                System.out.println("input value already exists in this tree");
                return;
            }
        }
    }

    public TreeNode doSomeThings(TreeNode stuff){
        TreeNode temp1 = stuff;
        TreeNode temp2;
        if(thing(stuff.right)>thing(stuff.left+1)){
            stuff = stuff.right;
            temp2 = stuff.left;
            stuff.left = temp1;
            stuff.left.right = temp2;


            //if(stuff.right.left!=null){
            //    fix(stuff.right, true);
            //}
        }
        if(thing(stuff.right+1)<thing(stuff.left)){
            stuff = stuff.left;
            temp2 = stuff.right;
            stuff.right = temp1;
            stuff.right.left = temp2;
        }
    }

    public void doTheThings(TreeNode something){
        something = doSomeThings(something);
        if(something.left!=null){
            something.left = doTheThings(something.left);
        }
        if(something.right!=null){
            something.right = doTheThings(something.left);
        }
    }

    public int thing(TreeNode parent){
        int length;
        if(parent.left!=null){
            length++;
            length += thing(parent.left);
        }
        if(parent.right!=null){
            length++;
            length += thing(parent.right);
        }
        return length;
    }
}
