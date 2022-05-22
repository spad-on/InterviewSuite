package com.paolotalks.exercise.algorithm.tree;

import com.paolotalks.datastructure.tree.BinaryNode;
import com.paolotalks.exception.TestCaseNotImplementedException;
import com.paolotalks.utils.MathUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Exercise:
 *  Given a binary tree, implement an algorithm that print the left view of that tree.
 *  The left view is defined as what you would see if you were looking the tree from the left.
 *  E.g.
 *                            --- 4---
 *                           /         \
 *                         2            12
 *                          \         /   \
 *                            5     14     6
 *                           /             \
 *                          8               9
 *                                         /
 *                                        10
 *   output: [4 2 5 8 10]
 */
public class LeftView {

    /**
     * Find and return the list of element making up the "left view".
     * @param root the root of a binary tree
     * @return a list of elements making up the "left view".
     * Pre-condition: root is not null
     */
    public List<Integer> visit(BinaryNode root) {
        List<Integer> view = new LinkedList<>();
        visit(root, 1, 0, view);
        return view;
    }

    private int visit(BinaryNode node, int depth, int max, List<Integer> result){
        if (node == null) return max;
        if (max < depth){
            max = depth;
            result.add(node.getData());
        }
        int left = visit(node.getLeft(), depth + 1, max, result);
        max = MathUtils.max(left, max);
        int right = visit(node.getRight(), depth + 1, max, result);
        max = MathUtils.max(right, max);
        return max;
    }
}
