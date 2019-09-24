package com.avinash.tree;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    @Override
    public Node<T> insert(T data) {
        Node<T> currentNode = this.root;
        Node<T> parentNode = null;
        while (currentNode != null) {
            parentNode = currentNode;
            currentNode = currentNode.compareTo(data) < 0 ? currentNode.getRightNode() : currentNode.getLeftNode();
        }
        currentNode = new Node<>(data);
        currentNode.setParentNode(parentNode);
        if(this.root == null) {
            this.root = currentNode;
        } else if(parentNode.compareTo(data) > 0) {
            parentNode.setLeftNode(currentNode);
        } else if(parentNode.compareTo(data) < 0) {
            parentNode.setRightNode(currentNode);
        }
        splay(currentNode);
        return this.root;
    }

    private void splay(Node<T> node) {
        while (node.getParentNode() != null) {
            if(node.getParentNode().getParentNode() == null) {
                if(node.getParentNode().getLeftNode() == node) {
                    rightRotate(node.getParentNode());
                } else {
                    leftRotate(node.getParentNode());
                }
            } else if(node.getParentNode().getParentNode().getLeftNode() == node.getParentNode()) {
                if(node.getParentNode().getLeftNode() == node) {
                    rightRotate(node.getParentNode().getParentNode());
                } else {
                    leftRotate(node.getParentNode());
                }
                rightRotate(node.getParentNode());
            } else {
                if(node.getParentNode().getRightNode() == node) {
                    leftRotate(node.getParentNode().getParentNode());
                } else {
                    rightRotate(node.getParentNode());
                }
                leftRotate(node.getParentNode());
            }
        }
    }

    private void leftRotate(Node<T> node) {
        final Node<T> rightNode = node.getRightNode();
        node.setRightNode(rightNode.getLeftNode());
        if(node.getRightNode() != null) {
            node.getRightNode().setParentNode(node);
        }
        rightNode.setLeftNode(node);
        setParent(node, rightNode);
    }

    private void rightRotate(Node node) {
        final Node leftNode = node.getLeftNode();
        node.setLeftNode(leftNode.getRightNode());
        if(node.getLeftNode() != null) {
            node.getLeftNode().setParentNode(node);
        }
        leftNode.setRightNode(node);
        setParent(node, leftNode);
    }

    private void setParent(Node<T> node, Node<T> movingNode) {
        movingNode.setParentNode(node.getParentNode());
        if(node.getParentNode() == null) {
            this.root = movingNode;
        } else if(node.getParentNode().getLeftNode() == node) {
            node.getParentNode().setLeftNode(movingNode);
        } else if(node.getParentNode().getRightNode() == node) {
            node.getParentNode().setRightNode(movingNode);
        }
        node.setParentNode(movingNode);
    }

    @Override
    public void delete(T data) {

    }

    @Override
    public void traverse() {

    }

    @Override
    public Node<T> getRoot() {
        return this.root;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new SplayTree<>();
        System.out.println(tree.insert(22));
        System.out.println(tree.insert(11));
        System.out.println(tree.insert(10));
        System.out.println(tree.insert(9));
        System.out.println(tree.insert(12));
        BTreePrinter.printNode(tree.getRoot());
        System.out.println(tree.insert(15));
        BTreePrinter.printNode(tree.getRoot());
        System.out.println(tree.insert(13));
//		BTreePrinter.printNode(tree.getRoot());
        System.out.println(tree.insert(14));
//		BTreePrinter.printNode(tree.getRoot());
        System.out.println(tree.insert(25));
//		BTreePrinter.printNode(tree.getRoot());
        System.out.println(tree.insert(23));
        BTreePrinter.printNode(tree.getRoot());
        System.out.println(tree.insert(10));
        System.out.println("-----------------------");
        BTreePrinter.printNode(tree.getRoot());
    }
    
    /**
    22
11
10
9
12
   12       
  / \   
 /   \  
 10   22   
/ \     
9 11     
                
15
       15               
      / \       
     /   \      
    /     \     
   /       \    
   12       22       
  /             
 /              
 10               
/ \             
9 11             
                                
13
14
25
23
                                                               23                                                                                                                               
                                                              / \                                                               
                                                             /   \                                                              
                                                            /     \                                                             
                                                           /       \                                                            
                                                          /         \                                                           
                                                         /           \                                                          
                                                        /             \                                                         
                                                       /               \                                                        
                                                      /                 \                                                       
                                                     /                   \                                                      
                                                    /                     \                                                     
                                                   /                       \                                                    
                                                  /                         \                                                   
                                                 /                           \                                                  
                                                /                             \                                                 
                                               /                               \                                                
                                              /                                 \                                               
                                             /                                   \                                              
                                            /                                     \                                             
                                           /                                       \                                            
                                          /                                         \                                           
                                         /                                           \                                          
                                        /                                             \                                         
                                       /                                               \                                        
                                      /                                                 \                                       
                                     /                                                   \                                      
                                    /                                                     \                                     
                                   /                                                       \                                    
                                  /                                                         \                                   
                                 /                                                           \                                  
                                /                                                             \                                 
                               /                                                               \                                
                               22                                                               25                                                               
                              /                                                                                                 
                             /                                                                                                  
                            /                                                                                                   
                           /                                                                                                    
                          /                                                                                                     
                         /                                                                                                      
                        /                                                                                                       
                       /                                                                                                        
                      /                                                                                                         
                     /                                                                                                          
                    /                                                                                                           
                   /                                                                                                            
                  /                                                                                                             
                 /                                                                                                              
                /                                                                                                               
               /                                                                                                                
               14                                                                                                                               
              / \                                                                                                               
             /   \                                                                                                              
            /     \                                                                                                             
           /       \                                                                                                            
          /         \                                                                                                           
         /           \                                                                                                          
        /             \                                                                                                         
       /               \                                                                                                        
       13               15                                                                                                               
      /                                                                                                                         
     /                                                                                                                          
    /                                                                                                                           
   /                                                                                                                            
   12                                                                                                                               
  /                                                                                                                             
 /                                                                                                                              
 10                                                                                                                               
/ \                                                                                                                             
9 11                                                                                                                             
                                                                                                                                                                                                                                                                
10
-----------------------
                               10                                                               
                              / \                               
                             /   \                              
                            /     \                             
                           /       \                            
                          /         \                           
                         /           \                          
                        /             \                         
                       /               \                        
                      /                 \                       
                     /                   \                      
                    /                     \                     
                   /                       \                    
                  /                         \                   
                 /                           \                  
                /                             \                 
               /                               \                
               9                               23                               
                                              / \               
                                             /   \              
                                            /     \             
                                           /       \            
                                          /         \           
                                         /           \          
                                        /             \         
                                       /               \        
                                       14               25               
                                      / \                       
                                     /   \                      
                                    /     \                     
                                   /       \                    
                                   12       22                       
                                  / \     /                     
                                 /   \   /                      
                                 10   13   15                       
                                  \                             
                                  11                             
                                                                                                                                

    **/
}
