package leetcode.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

public class CBTInserter919 {
//    方法一：队列
//对于一棵完全二叉树而言，其除了最后一层之外都是完全填充的，并且最后一层的节点全部在最左侧。
//那么，只有倒数第二层（如果存在）最右侧的若干个节点，以及最后一层的全部节点可以再添加子节点，其余的节点都已经拥有两个子节点。
//因此，我们可以使用一个队列存储上述提到的这些可以添加子节点的节点。队列中的存储顺序为：
// 首先「从左往右」存储倒数第二层最右侧的节点，再「从左往右」存储最后一层的全部节点。
// 这一步可以使用广度优先搜索来完成，因为广度优先搜索就是按照层优先进行遍历的。
// 随后，当我们每次调用insert(val) 时，我们就创建出一个节点 child，
// 并将它最为队列的队首节点的子节点。在这之后，我们需要把 child 加入队尾，并且如果对队首节点已经有两个子节点，我们需要将其从队列中移除。
    Queue<TreeNode> candidate;
    TreeNode root;

    public CBTInserter919(TreeNode root) {
        this.candidate = new ArrayDeque<TreeNode>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (!(node.left != null && node.right != null)) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }
//    方法二：二进制表示
//如果我们将完全二叉树的每个节点进行编号，其中：
//根节点的编号为 1；
//如果某个节点的编号为 x，那么其左子节点的编号为 2x，右子节点的编号为 2x+1。
//么我们可以发现，按照广度优先搜索的顺序，完全二叉树中的所有节点的编号是连续的。这
// 可以用二进制表示看出：完全二叉树的第 i(i≥1) 层有 2^{i-1}个节点，它们的编号恰好对应着i位的二进制表示，
// 共有 2^{i-1}个（最高位必须为 1）。当某个节点编号为 xx 时，左子节点的编号 2x
// 即为将 xx 的二进制表示左移一位后在最低位补 00，右子节点的编号即为将 xx 的二进制表示右移一位后在最低位补 11。
//因此，在初始化时，我们只需要使用深度优先搜索或者广度优先搜索，得到初始完全二叉树中的节点个数。
// 在调用 insert(v) 时，我们可以知道它的编号 x，那么就可以从高到低遍历 x 的每一个二进制位（忽略最高位的 11），
// 如果为 0 就往左子节点移动，否则往右子节点移动，这样就可以到达节点需要被插入的位置。
}
/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */