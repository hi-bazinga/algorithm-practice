package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DedupAndSort {

	public static void main(String[] args) throws FileNotFoundException {
		long t_start = System.currentTimeMillis();
		
//		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new File("data.txt"));
		int totalNum = sc.nextInt();
		
		int count = 0;
		TrieNode root = new TrieNode();
		for (int i = 0; i < totalNum; i++) {
			char[] cur = {'0', '0', '0','0', '0', '0','0', '0', '0','0'};
			char[] in;
			in = sc.next().toCharArray();
			for (int j = 0; j < in.length; j ++)
				cur[cur.length + j - in.length] = in[j];
			if (insertNode(root, cur))
				count ++;
		}
		
		System.out.println(count);
		inOrderTraversal(root, true, "");
		
		long t_end = System.currentTimeMillis();
		System.out.println("\n" + (t_end - t_start) + " ms");
	}
	
	private static boolean insertNode(TrieNode root, char[] numChar) {
		TrieNode node = root;
		for (int i = 0; i < numChar.length; i++) {
			char firstChar = numChar[i];
			int index = firstChar - '0';
			if ( node.child[index] == null ) {
				node.child[index] = new TrieNode(firstChar);
				node.hasChild = true;
			} else if (i + 1 == numChar.length) {
				return false;
			}
			node = node.child[index];
		}
		return true;
	}
	
	private static void inOrderTraversal(TrieNode node, boolean isPrefix, String path){
		if (!node.hasChild && node.value != '\0') {
			//System.out.print(path + " ");
			return;
		}
		
		for (int i = 0; i < node.child.length; i ++) {
			if (node.child[i] != null) {
				if (node.child[i].value != '0' || !isPrefix || !node.child[i].hasChild){
					inOrderTraversal(node.child[i], false, path + node.child[i].value);
				} else 
					inOrderTraversal(node.child[i], true, path);
			}
		}
	}

}

class TrieNode{
	TrieNode[] child;
	char value;
	boolean hasChild = false;
	
	TrieNode(){
		child = new TrieNode[10];
	}
	
	TrieNode(char c){
		value = c;
		child = new TrieNode[10];
	}
}
