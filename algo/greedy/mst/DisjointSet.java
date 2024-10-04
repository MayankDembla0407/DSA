package greedy.mst;

public class DisjointSet {

    int[] parent , rank ;

    public DisjointSet(int n){
        this.parent = new int[n] ;
        this.rank = new int[n] ;

        for(int i = 0 ; i < n ; i++){
            parent[i] = i ;  // Initially, every element is its own parent (i.e., each element is a separate set).
            rank[i] = 0 ;  // array keeps track of the depth of trees formed by the sets to optimize the merging process , It helps keep the sets balanced by always attaching the shorter tree under the taller tree.
        }
    }

    // Find the root node with the path compression
    public int find(int i ){
        if(parent[i] != i){
            parent[i] = find(parent[i]);
        }
        return parent[i] ;
    }

    public void union(int u, int v){
        int rootX = find(u) ;
        int rootY = find(v) ;

        if(rootX != rootY){
            if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY ;
            } else if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX ;
            } else {
                parent[rootY] = rootX ;
                rank[rootX] ++ ;
            }
        }
    }
}
