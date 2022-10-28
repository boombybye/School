public class tree {//doTheThings is setting all the nodes to the same numbers for some reason
    public TreeNode root;
    public TreeNode current;
    public int longest = 0;

    public static void main(String[] args) {
        tree myTree = new tree(new TreeNode(10));
        myTree.add(12);
        myTree.add(7);
        myTree.add(3);
        myTree.add(8);
        myTree.add(16);
        myTree.add(11);
        myTree.add(14);
        myTree.add(12);
        myTree.add(20);
        myTree.add(17);
        myTree.add(15);
        myTree.add(18);
        myTree.aString(myTree.root);
        System.out.println();
        System.out.println();
        myTree.root = myTree.doTheThings(myTree.root);
        myTree.aString(myTree.root);
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
                    current.left = new TreeNode(data);
                    placed = true;
                }
            } else if(data>current.data){
                if(current.right!=null){
                    current = current.right;
                } else {
                    current.right = new TreeNode(data);
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
        if(stuff.right != null || stuff.left!= null){}
        if(thing(stuff.right)>thing(stuff.left)+1){
            stuff = stuff.right;
            temp2 = stuff.left;
            stuff.left = temp1;
            stuff.left.right = temp2;


            //if(stuff.right.left!=null){
            //    fix(stuff.right, true);
            //}
        }
        if(thing(stuff.right)+1<thing(stuff.left)){
            stuff = stuff.left;
            temp2 = stuff.right;
            stuff.right = temp1;
            stuff.right.left = temp2;
        }
        return stuff;
    }

    public TreeNode doTheThings(TreeNode something){
        something = doSomeThings(something);
        if(something.left!=null){
            something.left = doTheThings(something.left);
        }
        if(something.right!=null){
            something.right = doTheThings(something.left);
        }
        return something;
    }

    public int thing(TreeNode parent){
        
        int length = 0;
        if(parent!=null){
            if(parent.left!=null){
                length++;
                length += thing(parent.left);
            }
            if(parent.right!=null){
                length++;
                length += thing(parent.right);
            }
        }
        return length;
    }

    public void aString(TreeNode toPrint){
        System.out.print(toPrint.data+ ": ");
        if(toPrint.left!=null){
            System.out.print(toPrint.left.data);
        }
        if(toPrint.right!=null){
            System.out.print(" , "+toPrint.right.data);
        }
        System.out.println();
        if(toPrint.left!=null){
            aString(toPrint.left);
        }
        if(toPrint.right!=null){
            aString(toPrint.right);
        }
    }
}
