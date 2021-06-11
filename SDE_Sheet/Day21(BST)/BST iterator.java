Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

 

Example 1:


Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False
 

Constraints:

The number of nodes in the tree is in the range [1, 105].
0 <= Node.val <= 106
At most 105 calls will be made to hasNext, and next.
 

Follow up:

Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?
class BSTIterator {
    ArrayList<Integer> values;
    Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        values = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()){
            while (curr!=null){
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            values.add(curr.val);
            curr = curr.right;
        }
        iterator = values.iterator();
        

    }

    public int next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}
//OTHER METHOD

class BSTIterator {
    List<Integer> res = new ArrayList<>();
    int i = -1;
    public BSTIterator(TreeNode root) {
        visit(root);
    }
    
    public int next() {
        ++i;
        return res.get(i);
    }
    
    public boolean hasNext() {
        if(i < res.size()-1){
            return true;
        }
        return false;
    }
    
    public void visit(TreeNode node){
        if(node == null){
            return;
        }
        visit(node.left);
        res.add(node.val);
        visit(node.right);
    }
}
