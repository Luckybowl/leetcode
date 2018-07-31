package Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Btree {
    TreeNode root;

    public Btree(int data) {
        root = new TreeNode(data);
    }

    //添加加节点
    public void addNode(int data) {
        TreeNode node = new TreeNode(data);
        TreeNode p = root;
        while (true) {
            if (p.val > data) {
                if (p.left == null) {
                    p.left = node;
                    break;
                } else {
                    p = p.left;
                }

            } else {
                if (p.right == null) {
                    p.right = node;
                    break;
                } else {
                    p = p.right;
                }
            }
        }
    }
    @Deprecated
    public boolean isValidBST(TreeNode root) {
        //空数也是查询二叉树
        if(root == null){
           return true;
        }
        TreeNode p = root;

        if (p.left.val != 0) {
            if (p.left.val < p.val) {
                isValidBST(p.left);
            } else {
                return false;
            }
        }
        if (p.right.val != 0) {
            if (p.right.val > p.val) {
                isValidBST(p.right);
            } else {
                return false;
            }
        }
        return true;
    }
    @Deprecated
    public List<Integer> display(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
       /* //先跟遍历4,1,2,7,6,5,8
        System.out.println(p.val);*/
        if (p.left != null) {
            display(p.left);
        }
        /*
         * 中跟遍历1,2，4,5,6,7,8
         * */
        System.out.println(p.val);
        if (p.right != null) {
            display(p.right);
        }
        //  后跟遍历：1 2 4 5 6 7 8
        //System.out.println(p.val);
        return list;
    }


    public static void main(String[] args) {
        Btree tree = new Btree(5);
        tree.addNode(1);
        tree.addNode(4);
//        tree.addNode(Integer.parseInt(null));
//        tree.addNode(Integer.parseInt(null));
        tree.addNode(3);
        tree.addNode(6);
        tree.display(tree.root);


    }
}
