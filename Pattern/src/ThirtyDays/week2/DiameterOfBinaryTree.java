package ThirtyDays.week2;

public class DiameterOfBinaryTree {

    public static int diameterOfBinaryTree1(TreeNode root) {
        int maxLength = 0;
        if (root == null) return 0;
        int l = maxLengthOfTree(root.left);
        int r = maxLengthOfTree(root.right);
        return l + r;
    }

    //this path may or may not pass through the root.
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int l = maxLengthOfTree(root.left);
        int r = maxLengthOfTree(root.right);
        return l + r;
    }

    private static int maxLengthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxLengthOfTree(root.left) + 1;
        int r = maxLengthOfTree(root.right) + 1;
        return Math.max(l, r);
    }

    public static void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    public static void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.val + "->");
            inOrderTraverse(root.right);
        }
    }

    public static void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.val + "->");
        }
    }

    public static void main(String[] args) {
/*        TreeNode subTreeNode1 = new TreeNode(4);
        TreeNode subtreeNode2 = new TreeNode(5);
        TreeNode middleTreeNode2 = new TreeNode(2);
        middleTreeNode2.left = subTreeNode1;
        middleTreeNode2.right = subtreeNode2;
        //subtreeNode2.right = new TreeNode(6);

        TreeNode rootTreeNode = new TreeNode(1);
        rootTreeNode.left = middleTreeNode2;
        rootTreeNode.right = new TreeNode(3);*/
        TreeNode rootTreeNode = new TreeNode(1);
        System.out.println(diameterOfBinaryTree1(rootTreeNode));
/*        System.out.println();
        preOrderTraverse1(rootTreeNode);
        System.out.println();
        inOrderTraverse(rootTreeNode);
        System.out.println();
        postOrderTraverse(rootTreeNode);
        System.out.println();*/
    }
}
