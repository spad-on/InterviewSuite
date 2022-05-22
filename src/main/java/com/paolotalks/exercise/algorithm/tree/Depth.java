package com.paolotalks.exercise.algorithm.tree;

import com.paolotalks.datastructure.tree.BinaryNode;
import com.paolotalks.datastructure.tree.TreeNode;
import com.paolotalks.exception.TestCaseNotImplementedException;
import com.paolotalks.utils.MathUtils;

/**
 * Exercise:
 *  Find the depth of a tree. The depth of a tree is the number of levels it has.
 *  The level starts at 0. Therefore a tree consisting of only a single node
 *  is consider as having depth 0.
 */
public class Depth {

    /**
     * Find the depth of the tree
     * @param root the root of the binary tree
     * @return the depth of the tree
     * Pre-condition: The tree is not null.
     */
    public int visit(BinaryNode root){
        return visitInternal(root);
    }

    private int visitInternal(BinaryNode node){
        if (node == null) return -1;
        int left = visitInternal(node.getLeft());
        int right = visitInternal(node.getRight());
        return 1 + MathUtils.max(left, right);
    }

    /**
     * Find the depth of the tree
     * @param root the root of the n-ary tree
     * @return the depth of the tree
     * Pre-condition: The tree is not null.
     */
    public int visit(TreeNode root){
        return visitInternal(root);
    }

    private int visitInternal(TreeNode node){
        if (node == null) return 0;
        int maxRecurse = node.getChildren().stream()
                .mapToInt(this::visitInternal).max().orElse(-1);
        return 1 + maxRecurse;
    }
}
