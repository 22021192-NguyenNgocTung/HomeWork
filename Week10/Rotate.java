/* Class node is defined as :
class Node
    int val;	//Value
    int ht;		//Height
    Node left;	//Left child
    Node right;	//Right child

*/

static Node insert(Node root,int val)
        {
        if ( root == null){
        Node tmp = new Node();
        tmp.ht = 0 ;
        tmp.val = val ;
        return tmp ;
        }
        else {
        if ( root.val < val ){
        root.right = insert(root.right, val) ;
        }
        else if ( root.val > val){
        root.left = insert(root.left , val) ;
        }
        else {
        return root ;
        }
        }
        root.ht = Math.max(height(root.left) , height(root.right)) + 1;
        int bl = height(root.left) - height(root.right) ;
        if ( bl < -1 ){
        if ( val < root.right.val){
        root.right = rightRotate(root.right) ;
        }
        return leftRotate(root);
        }
        else if ( bl > 1){
        if ( val > root.left.val){
        root.left = leftRotate(root.left);
        }
        return rightRotate(root);
        }
        return root ;
        }
static Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        return y;
        }
static Node rightRotate(Node x){
        Node y = x.left;
        Node T2 = y.right;

        y.right = x;
        x.left = T2;

        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        return y;
        }
static int height(Node node){
        if (node == null) return -1 ;
        else return node.ht;
        }