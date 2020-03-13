package test1;

import java.util.*;

public class Algorithm399 {
//    class Union{
//        double[] val;
//        int[] parent;
//        public Union(int size){
//            this.parent =new int[size];
//            this.val = new double[size];
//            Arrays.fill(val,1.0);
//            for (int i=0;i<size;i++){
//                parent[i]=i;
//            }
//        }
//
//        Deque<Double> que =new LinkedList<>();
//        double t=1;
//
//        public int find(int x){
//            que.offer(val[x]);
//
//            if (x !=parent[x]){
//                parent[x]=find(parent[x]);
//            }
//            //计算路径乘积
//            t*= que.pollLast();
//            val[x]=t;
//            return parent[x];
//        }
//        public void unionfind(int x,int y, double val){
//            t=1;
//            if (this.val[x] == 1)this.val[x] =val;
//            int px =find(x);
//            t=1;
//            int py =find(y);
//            t=1;
//            //union
//            if (px!=py){
//                if (px==x){
//                    parent[px] =y;
//                }
//                else {
//                    parent[py]=x;
//                    if (this.val[y]==1){
//                        this.val[y]=1/val;
//                    }
//                }
//            }
//        }
//
//    }
//
//
//
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        int size =equations.size();
//        Union u  =new Union(size*2);
//        //build map String <--> id
//        HashMap<String,Integer> map=new HashMap<>();
//        int id=0;
//        for (int i=0; i<size;i++){
//            List<String> equation =equations.get(i);
//            String a =equation.get(0);
//            String b =equation.get(1);
//            int ia=-1;
//            int ib=-1;
//            if (!map.containsKey(a)){
//                map.put(a,id);
//                ia=id;
//                id++;
//            }else {
//                ia=map.get(a);
//            }
//            if (!map.containsKey(b)){
//                map.put(b,id);
//                ib=id;
//                id++;
//            }else {
//                ib=map.get(b);
//            }
//            u.unionfind(ia,ib,values[i]);
//        }
//
//        //query
//        int len =queries.size();
//        List<Double> ans =new ArrayList<>();
//        for (int i=0;i<len;i++){
//            List<String> query =queries.get(i);
//            String a=query.get(0);
//            String b=query.get(1);
//
//            if (!map.containsKey(a) || !map.containsKey(b)){
//                ans.add(-1.0);
//                continue;
//            }
//            if (a.equals(b)){
//                ans.add(1.0);
//                continue;
//            }
//            int ia =map.get(a);
//            int ib =map.get(b);
//            int pa =u.find(ia);
//            u.t=1;
//            int pb =u.find(ib);
//            u.t=1;
//            double a_val=u.val[ia];
//            double b_val=u.val[ib];
//
//            if (pa!=pb)ans.add(-1.0);
//            else {
//                ans.add(a_val/b_val);
//            }
//        }
//        double[] fina=new double[ans.size()];
//        int i=0;
//        for (double d:ans){
//            fina[i]=d;
//            i++;
//        }
//        return fina;
//    }
    //----------------错误代码，原因不明
    class Node{
        double val=1.0;
        String name;
        Node parent;
        public Node(String name){
            this.name=name;
            this.parent=this;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public Node find(Node root){
    Node parent=root.parent;
    if (!root.parent.equals(root)){
        parent=find(root.parent);
    }
    return parent;
}

public double count(Node root){
    double res=root.val;
    if (!root.parent.equals(root)){
        res*=count(root.parent);
    }
    return res;
}
public void union(Node left,Node right,double val){
    if (left.val==1.0){
        left.val=val;
    }

    Node parentleft=find(left);
    Node parenright=find(right);

    if (parenright!=parentleft){
        if (parentleft==left){
            parentleft.parent=right;
        }else {
            parenright.parent=left;
            if (right.val==1.0){
                right.val=1/val;
            }
        }
    }

}
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Node> map=new HashMap<>();
        for (int i=0;i<equations.size();i++){
            List<String> temp=equations.get(i);
            String a=temp.get(0);
            String b=temp.get(1);

            Node anode=null;
            Node bnode=null;
            if (!map.containsKey(a)){
                anode=new Node(a);
                map.put(a,anode);
            }else {
                anode=map.get(a);
            }
            if (!map.containsKey(b)){
                bnode=new Node(b);
                map.put(b,bnode);
            }else {
                bnode=map.get(b);
            }
            union(anode,bnode,values[i]);
        }
        //query
        double[] res=new double[queries.size()];
        Arrays.fill(res,-1.0);

        for (int j=0;j<queries.size();j++){
            List<String> temp=queries.get(j);
            String a=temp.get(0);
            String b=temp.get(1);


            Node anode=null;
            Node bnode=null;
            if (!map.containsKey(a)){
                continue;
            }else {
                anode=map.get(a);
            }
            if (!map.containsKey(b)){
                continue;
            }else {
                bnode=map.get(b);
            }

            if (a.equals(b)){
                res[j]=1.0;
                continue;
            }

            String aparent=find(anode).name;

            String bparent=find(bnode).name;
            if (!aparent.equals(bparent))continue;
            else {
                res[j]=count(anode)/count(bnode);
            }
        }
        return res;
    }


}
