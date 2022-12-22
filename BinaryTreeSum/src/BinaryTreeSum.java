import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
@SuppressWarnings("unchecked")
class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode() {
        this.info = null;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}
@SuppressWarnings("unchecked")
class BTree<E extends Comparable<E>> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode<E>(elem);
    }

    public void makeRootNode(BNode<E> node) {
        root = node;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

}


@SuppressWarnings("unchecked")
public class BinaryTreeSum {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<Integer> nodes[] = new BNode[N];
        BTree<Integer> tree = new BTree<Integer>();

        for (i=0;i<N;i++)
            nodes[i] = new BNode<Integer>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = Integer.parseInt(st.nextToken());
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }

        int baranaVrednost=Integer.parseInt(br.readLine());

        br.close();

        // vasiot kod ovde
        int smallSum = leftSum(locateNode(tree.root, baranaVrednost).left, baranaVrednost);
        int bigSum = rightSum(locateNode(tree.root, baranaVrednost).right, baranaVrednost);

        System.out.printf("%d %d", smallSum, bigSum);
    }

    @SuppressWarnings("unchecked")
    public static BNode<Integer> locateNode(BNode<Integer> node, int value){

        if (node == null) {
            return null;
        }

        if (node.info == value) {
            return node;
        }

        if (locateNode(node.left, value) != null) {
            return node;
        }else{
            return locateNode(node.right, value);
        }
    }

    @SuppressWarnings("unchecked")
    public static int leftSum(BNode<Integer> node, int value){

        if (node != null) {
            return 0;
        }

        if (node.info < value) {
            return leftSum(node.left, value) + node.info + leftSum(node.right, value);
        }else {
            return leftSum(node.left, value) + leftSum(node.right, value);
        }
    }

    @SuppressWarnings("unchecked")
    public static int rightSum(BNode<Integer> node, int value){

        if (node == null) {
            return 0;
        }

        if (node.info > value) {
            return rightSum(node.left, value) + node.info + rightSum(node.right, value);
        }else {
            return rightSum(node.right, value) + rightSum(node.left, value);
        }
    }


}



//        int sumLeft = 0;
//        int sumRight = 0;
//
//        BNode<Integer> tmpNode = new BNode<Integer>();
//        tmpNode.info = baranaVrednost;
//
//
//        if(tmpNode.left != null){
//            if (tmpNode.left.info < tmpNode.info){
//                sumLeft += tmpNode.left.info;
//            }
//        }
//
//        if (tmpNode.right != null) {
//            if (tmpNode.right.info > tmpNode.info) {
//                sumRight += tmpNode.right.info;
//            }
//        }
//
//        System.out.printf("%d %d", sumLeft, sumRight);


//        int sumL = 0;
//        int sumR = 0;
//
//        BNode<Integer> tmpNode = new BNode<Integer>();
//        tmpNode.info = baranaVrednost;
//
//        sumL = sumLeft(tmpNode);
//        sumR = sumRight(tmpNode);
//
//        System.out.printf("%d %d", sumL,sumR);


//    @SuppressWarnings("unchecked")
//    static int sumLeft(BNode<Integer> node) {
//        if (node == null) {
//            return 0;
//        }
//        if (node.left != null) {
//            if (node.left.info < node.info) {
//                return sumRight(node.left) + node.info;
//            }
//        }
//        return 0;
//    }
//    @SuppressWarnings("unchecked")
//    static int sumRight(BNode<Integer> node) {
//        if (node == null) {
//            return 0;
//        }
//        if (node.right != null) {
//            if (node.right.info > node.info) {
//                return sumRight(node.right) + node.info;
//            }
//        }
//        return 0;
//    }

//        BNode<Integer> tmpNode = new BNode<Integer>();
//        tmpNode.info = baranaVrednost;
//
//        sumTree(tmpNode);

//        @SuppressWarnings("unchecked")
//        static int isLeaf(BNode<Integer> node) {
//            if (node == null){
//                return 0;
//            }
//
//            if (node.left == null && node.right == null){
//                return 1;
//            }
//
//            return 0;
//        }
//        @SuppressWarnings("unchecked")
//        static void sumTree(BNode<Integer> node) {
//            int leftS = 0;
//            int rightS = 0;
//
//            /* If node is NULL or it's a leaf node then
//             return true */
//            if (node == null || isLeaf(node) == 1){
//                return 1;
//            }
//
//            if (sumTree(node.left) != 0 && sumTree(node.right) != 0) {
//                // Get the sum of nodes in left subtree
//                if (node.left == null){
//                    leftS = 0;
//                }else if (isLeaf(node.left) != 0){
//                    leftS = node.left.info;
//                }else{
//                    leftS = 2 * (node.left.info);
//                }
//
//                // Get the sum of nodes in right subtree
//                if (node.right == null){
//                    rightS = 0;
//                }else if (isLeaf(node.right) != 0){
//                    rightS = node.right.info;
//                }else{
//                    rightS = 2 * (node.right.info);
//                }
//                System.out.printf("%d %d", leftS,rightS);
//            }
//            return 0;
//        }
