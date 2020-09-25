import java.io.*;
import java.util.*;


public class ArraysAndSimpleQueries {

    public class Node {
        int val;
        int priority;
        int key;
        int size; //size of left & right children + this node
        Node left;
        Node right;
        Random rdm = new Random();

        public Node(int key, int val, int priority, Node left, Node right, int size) {
            this.key = key;
            this.val = val;
            this.priority = priority;
            this.left = left;
            this.right = right;
            this.size = size;
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.priority = rdm.nextInt(100000001);
            this.right = null;
            this.size = 1;
        }

        public Node() { //default values
            this(0, 0);
        }

        private Node left_rotate(Node root) {
            Node right_tree = root.right;
            root.right = right_tree.left;
            right_tree.left = root;

            root.update_size();
            right_tree.update_size();

            return right_tree;
        }

        private Node right_rotate(Node root) {
            Node left_tree = root.left;
            root.left = left_tree.right;
            left_tree.right = root;

            root.update_size();
            left_tree.update_size();

            return left_tree;
        }

        public void update_size(){
            int left_size = this.left.size;
            int right_size = this.right.size;

            this.size = left_size + right_size + 1;
        }

        public Node merge(Node left, Node right) {
            
        }


    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

    }
}

//See this: https://www.quora.com/q/threadsiiithyderabad/Treaps-One-Tree-to-Rule-em-all-Part-2
typedef struct node{ 
    int prior,size; 
    int val;//value stored in the array 
    int sum;//whatever info you want to maintain in segtree for each node 
    int lazy;//whatever lazy update you want to do 
    struct node *l,*r; 
}node; 
typedef node* pnode; 
int sz(pnode t){ 
    return t?t->size:0; 
} 
void upd_sz(pnode t){ 
    if(t)t->size=sz(t->l)+1+sz(t->r); 
} 
void lazy(pnode t){ 
    if(!t || !t->lazy)return; 
    t->val+=t->lazy;//operation of lazy 
    t->sum+=t->lazy*sz(t); 
    if(t->l)t->l->lazy+=t->lazy;//propagate lazy 
    if(t->r)t->r->lazy+=t->lazy; 
    t->lazy=0; 
} 
void reset(pnode t){ 
    if(t)t->sum = t->val;//no need to reset lazy coz when we call this lazy would itself be propagated 
} 
void combine(pnode& t,pnode l,pnode r){//combining two ranges of segtree 
    if(!l || !r)return void(t = l?l:r); 
    t->sum = l->sum + r->sum; 
} 
void operation(pnode t){//operation of segtree 
    if(!t)return; 
    reset(t);//reset the value of current node assuming it now represents a single element of the array 
    lazy(t->l);lazy(t->r);//imp:propagate lazy before combining t->l,t->r; 
    combine(t,t->l,t); 
    combine(t,t,t->r); 
} 
void split(pnode t,pnode &l,pnode &r,int pos,int add=0){ 
    if(!t)return void(l=r=NULL); 
    lazy(t); 
    int curr_pos = add + sz(t->l); 
    if(curr_pos<=pos)//element at pos goes to left subtree(l) 
        split(t->r,t->r,r,pos,curr_pos+1),l=t; 
    else  
        split(t->l,l,t->l,pos,add),r=t; 
    upd_sz(t); 
    operation(t); 
} 
void merge(pnode &t,pnode l,pnode r){ //l->leftarray,r->rightarray,t->resulting array 
    lazy(l);lazy(r); 
    if(!l || !r) t = l?l:r; 
    else if(l->prior>r->prior)merge(l->r,l->r,r),t=l; 
    else    merge(r->l,l,r->l),t=r; 
    upd_sz(t); 
    operation(t); 
} 
pnode init(int val){ 
    pnode ret = (pnode)malloc(sizeof(node)); 
    ret->prior=rand();ret->size=1; 
    ret->val=val; 
    ret->sum=val;ret->lazy=0; 
    return ret; 
} 
int range_query(pnode t,int l,int r){//[l,r] 
    pnode L,mid,R; 
    split(t,L,mid,l-1); 
    split(mid,t,R,r-l);//note: r-l!! 
    int ans = t->sum; 
    merge(mid,L,t); 
    merge(t,mid,R); 
    return ans; 
} 
void range_update(pnode t,int l,int r,int val){//[l,r] 
    pnode L,mid,R; 
    split(t,L,mid,l-1); 
    split(mid,t,R,r-l);//note: r-l!! 
    t->lazy+=val; //lazy_update 
    merge(mid,L,t); 
    merge(t,mid,R); 
} 