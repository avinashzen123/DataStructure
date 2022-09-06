package com.avinash.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import lombok.AllArgsConstructor;

public class AverageOfLevel {
	@AllArgsConstructor
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int value) {
			this.val = value;
		}
	}
	
	public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        List<Double> result = new ArrayList<>();
        while (!level.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            long sum = 0;
            long count = 0;
            while(!level.isEmpty()) {
                TreeNode node = level.poll();
                sum += node.val;
                count++;
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            level = temp;
            result.add(sum * 1.0/count);
        }
        return result;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(averageOfLevels(root));
	}
}
