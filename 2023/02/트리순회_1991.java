package day0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_1991_트리순회_서울_20반_이연희 {
	
	static int N;
	static Node root = null;
	
	static Node findAl;
	
	static class Node{
		Node left;
		Node right;
		char alph;
		
		public Node(Node left, Node right, char alph){
			this.left = left;
			this.right = right;
			this.alph = alph;
		}
		
		public Node(char alph){
			this.left = null;
			this.right = null;
			this.alph = alph;
		}
	}
	
	static void findAlph(Node find, char alph) {
		
		if(find==null) return;
		
		if(find.alph == alph) {
			findAl = find;
			return;
		}

		findAlph(find.left, alph);
		findAlph(find.right, alph);
		
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        
        for(int i=0;i<N;i++) {
        	
        	st = new StringTokenizer(br.readLine());
        	
        	char pAlph = st.nextToken().charAt(0);
        	char lAlph = st.nextToken().charAt(0);
        	char rAlph = st.nextToken().charAt(0);

        	Node lNode=null, rNode=null;

        	if (lAlph!='.')
        		lNode = new Node(lAlph);
        	if (rAlph!='.')
        		rNode = new Node(rAlph);
        	
        	if(root==null)
        		root = new Node(lNode, rNode, pAlph);
        	else {
        		findAlph(root, pAlph);
        		findAl.left = lNode;
        		findAl.right = rNode;
        	}

        }
        
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        
	}
	
	static void preOrder(Node stand) {
		
		if(stand==null) return;
		System.out.print(stand.alph);
		preOrder(stand.left);
		preOrder(stand.right);
	}
	
	static void inOrder(Node stand) {
		
		if(stand==null) return;
		inOrder(stand.left);
		System.out.print(stand.alph);
		inOrder(stand.right);
	}
	
	static void postOrder(Node stand) {
		
		if(stand==null) return;
		postOrder(stand.left);
		postOrder(stand.right);
		System.out.print(stand.alph);
	}


}
