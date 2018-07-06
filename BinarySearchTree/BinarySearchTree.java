package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        InorderTraversal(root,list);
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) >= list.get(i + 1)){
                return false;
            }
        }
        return true;
    }
    //中序遍历
    public void InorderTraversal(TreeNode root,List<Integer> list) {
        if(root == null){
            return ;
        }
        InorderTraversal(root.left,list);
        list.add(root.val);
        InorderTraversal(root.right,list);

    }

    public static void main(String[] args){
        TreeNode bt = new TreeNode(5);
        System.out.println(bt);
    }
}
