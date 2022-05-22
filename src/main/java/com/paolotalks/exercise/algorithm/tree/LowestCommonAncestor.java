package com.paolotalks.exercise.algorithm.tree;

import com.paolotalks.datastructure.tree.BinaryNode;
import com.paolotalks.datastructure.tree.Tree;
import com.paolotalks.datastructure.tree.TreeNode;
import com.paolotalks.exception.TestCaseNotImplementedException;
import com.paolotalks.utils.Container;

import java.util.LinkedList;

/**
 * Exercise:
 *  Find the lowest common ancestor of two nodes in a tree.
 *
 *  According to Wikipedia (https://en.wikipedia.org/wiki/Lowest_common_ancestor):
 *  "[...] the LCA is the lowest (i.e. deepest) node that has both p and q as descendants,
 *   where we define each node to be a descendant of itself."
 */
public class LowestCommonAncestor {

    private static final boolean USE_LINKED_LIST = true;

    /**
     * Find and return the lowest common ancestor of nodes p and q
     * @param p a node of the binary tree
     * @param q another node of the binary tree
     * @param root the root of the binary tree
     * @return the lowest common ancestor of nodes p and q, null if there is none.
     */
    public BinaryNode visit(BinaryNode p, BinaryNode q, BinaryNode root){
        if (USE_LINKED_LIST){
            return listIntersectionMethod(p, q, root);
        } else {
            Container<BinaryNode> result = new Container<>();
            visit(p, q, root, result);
            return result.get();
        }
    }

    private BinaryNode listIntersectionMethod(BinaryNode p, BinaryNode q, BinaryNode root){
        LinkedList<BinaryNode> pP = getPath(root, p);
        LinkedList<BinaryNode> pQ = getPath(root, q);
        // make sure pP is the longer one
        if (pP.size() < pQ.size()){
            LinkedList<BinaryNode> tmp = pP;
            pP = pQ;
            pQ = tmp;
        }
        // trim longer pP to be same height as pQ
        while (pP.size() > pQ.size()){
            pP.pollFirst();
        }
        // Start polling elements until the two lists
        // have the same node.
        while (pP.peekFirst() != pQ.peekFirst()){
            pP.pollFirst();
            pQ.pollFirst();
        }
        // Return matching node (worst case is root)
        return pP.peek();
    }

    private boolean visit(BinaryNode p, BinaryNode q, BinaryNode node, Container<BinaryNode> result){
        if (node == null || result.get() != null) return false;
        boolean left = visit(p, q, node.getLeft(), result);
        boolean right = visit(p, q, node.getRight(), result);
        int fromChildren = (left ? 1 : 0) + (right ? 1 : 0);
        int current = (node == p ? 1 : 0) + (node == q ? 1 : 0);
        if (fromChildren + current > 1){
            result.set(node);
        }
        return fromChildren + current > 0;
    }

    private boolean getPath(BinaryNode node, BinaryNode p, LinkedList<BinaryNode> path){
        if (node == null) return false;
        if (node == p){
            path.add(node);
            return true;
        }
        if (getPath(node.getLeft(), p, path)){
            path.add(node);
            return true;
        } else if (getPath(node.getRight(), p, path)){
            path.add(node);
            return true;
        }
        return false;
    }

    private LinkedList<BinaryNode> getPath(BinaryNode node, BinaryNode p){
        LinkedList<BinaryNode> path = new LinkedList<>();
        getPath(node, p, path);
        return path;
    }

    /**
     * Find and return the lowest common ancestor of nodes p and q
     * @param p a node of the n-ary tree
     * @param q another node of the n-ary tree
     * @param root the root of the n-ary tree
     * @return the lowest common ancestor of nodes p and q, null if there is none.
     */
    public TreeNode visit(TreeNode p, TreeNode q, TreeNode root){
        Container<TreeNode> result = new Container<>();
        visit(p, q, root, result);
        return result.get();
    }

    private boolean visit(TreeNode p, TreeNode q, TreeNode node, Container<TreeNode> result){
        if (node == null || result.get() != null) return false;
        int fromChildren = (int)node.getChildren().stream()
                .filter(s -> visit(p, q, s, result))
                .count();
        int current = (node == p ? 1 : 0) + (node == q ? 1 : 0);
        if (fromChildren + current > 1){
            result.set(node);
        }
        return fromChildren + current > 0;
    }
}
