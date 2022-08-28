package com.avinash.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfNodes {
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	
	private TreeNode root;
	
	public static void main(String[] args) {
//		DiameterOfNodes diameterOfNodes = new DiameterOfNodes();
//		diameterOfNodes.root = new TreeNode(1, new TreeNode(2, new TreeNode(4),new TreeNode(5)), new TreeNode(3));
		
		int[] arr = {2,1,5,7};
		Arrays.sort(arr);
		int[] array = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

		System.out.println(Arrays.toString(array));
	
	}

}
