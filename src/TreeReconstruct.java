/**
 * @author Chang
 * @description
 * @create 2021-03-21 22:17
 */
public class TreeReconstruct {


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // preOrder [1,2,4,7,3,5,6,8]
    // inOrder  [4,7,2,1,5,3,8,6]

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 找“儿子”子树

        // 根节点
        int rootVal = preorder[0];                  // 根节点 1
        TreeNode root = new TreeNode(rootVal);      // 创建节点

        // 根节点的位置
        int rootSite = 0;                           // 在3号索引
        for (int i = 0; ; i++) {
            if (inorder[i] == rootVal) {
                rootSite = i;
                break;
            }
        }

        // 左子树的范围
        int lengthLeft = rootSite - 0;              // 根节点左边的都是



        return null;
    }


}
