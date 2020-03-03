package test1;
interface Merger<E>{
    E merge(E a,E b);
}
public class Algorithm307 {

    public class SegmentTree<E> {
        private E[] tree;
        private E[] data;
        private Merger<E> merger;
        public SegmentTree(E[] arr,Merger<E> merger){
//        data=arr.clone();
            data=(E[])new Object[arr.length];
            this.merger=merger;
            for (int i=0;i<arr.length;i++){
                data[i]=arr[i];
            }
            tree =(E[])new Object[4*arr.length];
            buildSegmentTree(0,0,arr.length-1);
        }
        private void buildSegmentTree(int treeIndex,int l,int r){
            if (treeIndex>tree.length)return;
            if (l==r){
                tree[treeIndex]=data[l];
                return;
            }
            int leftTreeIndex=leftChild(treeIndex);
            int rightTreeIndex=rightChild(treeIndex);

            int mid=l+(r-l)/2;
            buildSegmentTree(leftTreeIndex,l,mid);
            buildSegmentTree(rightTreeIndex,mid+1,r);

            tree[treeIndex]=merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);

        }

        public E query(int queryl,int queryr){
            if (queryl<0||queryl>=data.length||queryr>=data.length||queryr<queryl||queryr<0)throw new IllegalArgumentException();
            return query(0,0,data.length-1,queryl,queryr);

        }
        //在以treeIndex为根的线段树中[l,r]的范围里，查询[queryl,queryr]的值
        private E query(int treeIndex,int l,int r,int queryl,int queryr){

            if(queryl==l&&queryr==r)return tree[treeIndex];

            int mid=l+(r-l)/2;
            int leftTreeIndex=leftChild(treeIndex);
            int rightTreeIndex=rightChild(treeIndex);


            if (queryl>=mid+1)return query(rightTreeIndex,mid+1,r,queryl,queryr);
            else if (queryr<=mid)return query(leftTreeIndex,l,mid,queryl,queryr);
            E left=query(leftTreeIndex,l,mid,queryl,mid);
            E right=query(rightTreeIndex,mid+1,r,mid+1,queryr);
            return merger.merge(left,right);
        }
        public int size(){
            return data.length;
        }

        public E get(int index){
            if (index<0||index>=data.length){
                throw new IllegalArgumentException("illegal argument");
            }
            return data[index];
        }

        private int leftChild(int index){
            int res=2*index+1;

            return  2*index+1;
        }

        private int rightChild(int index){
            return  2*index+2;
        }

        public void set(int index,E e){
            if (index<0||index>=data.length)
                throw new IllegalArgumentException("Index is illegal");
            data[index] = e;
            set(0,0,data.length-1,index,e);
        }

        private void set(int treeIndex, int l,int r,int index,E e){
            if (l==r){
                tree[treeIndex]=e;
                return;
            }

            int mid=l+(r-l)/2;
            int leftTreeIndex=leftChild(treeIndex);
            int rightTreeIndex=rightChild(treeIndex);

            if (index>=mid+1){
                set(rightTreeIndex,mid+1,r,index,e);
            }else {
                set(leftTreeIndex,l,mid,index,e);
            }

            tree[treeIndex]=merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
        }

        @Override
        public String toString() {
            StringBuffer sb=new StringBuffer();
            sb.append("[");
            for (E e:tree){
                sb.append(e);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("]");
            return sb.toString();
        }


    }

    class NumArray {
        private SegmentTree<Integer> segmentTree;
        public NumArray(int[] nums) {
            if (nums.length>0){
                Integer[] data=new Integer[nums.length];
                for(int i=0;i<nums.length;i++)data[i]=nums[i];
                segmentTree=new SegmentTree<>(data,(a,b)->a+b);
            }
        }

        public void update(int i, int val) {
            if (segmentTree==null){
                throw new IllegalArgumentException();
            }
            segmentTree.set(i,val);
        }

        public int sumRange(int i, int j) {
        if (segmentTree==null){
            throw new IllegalArgumentException();
        }
        return segmentTree.query(i,j);
        }
    }
//    class NumArray {
//        //前n个数字的和,sum[0]=0;
//        private int[] sum;
//        //存数据
//        private int[] data;
//
//        public NumArray(int[] nums) {
//            data=nums.clone();
//            sum =new int[nums.length+1];
//            sum[0]=0;
//            for (int i=1;i<sum.length;i++){
//                sum[i]=sum[i-1]+nums[i-1];
//            }
//        }
//        public void update(int i, int val) {
//            data[i]=val;
//            for (int j=i+1;j<sum.length;j++){
//                sum[j]=sum[j-1]+data[j-1];
//            }
//        }
//        public int sumRange(int i, int j) {
//            return sum[j+1]-sum[i];
//        }
//    }
}
