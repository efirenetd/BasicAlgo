package org.efire.net;

import java.util.Arrays;

public class Algo2QuickUnionWeighted {

    private static int[] id;
    // a tree size array to maintain count
    private static int[] sz;

    public Algo2QuickUnionWeighted(int n) {
        id = new int[n];
        sz = new int[n];
        // set id of each object to itself
        for (int i = 0; i < n; i++) {
            id[i] = i;
            // to count number of objects in the tree rooted at i
            sz[i] = 1;
        }
        System.out.println("initial - "+String.join(",", Arrays.toString(id)));
    }

    // chase parent pointer until it reaches the root
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    // check if p and q have the same root
    public boolean connected (int p, int q) {
        return root(id[p]) == root(id[q]);
    }

    // change root of p to point to root of q
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        /*
        for weighted algorithm
        we check the tree sizes and link the root of the smaller tree to the root
        of the larger tree in each case
        */
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public static void main(String[] args) {
        Algo2QuickUnionWeighted algo = new Algo2QuickUnionWeighted(10);
        doUnion(algo, 4, 3);
        doUnion(algo, 3, 8);
        doUnion(algo, 6, 5);
        doUnion(algo, 9, 4);
        doUnion(algo, 2, 1);
        isConnected(algo, 8, 9);
        isConnected(algo, 5, 4);
        doUnion(algo, 5, 0);
        doUnion(algo, 7, 2);
        doUnion(algo, 6, 1);
        doUnion(algo, 7, 3);
    }

    private static void isConnected(Algo2QuickUnionWeighted algo, int p, int q)  {
        System.out.println(String.format("connected(%d, %d) - %s", p, q, algo.connected(p, q)));
    }

    private static void doUnion(Algo2QuickUnionWeighted algo, int p, int q) {
        algo.union(p, q);
        System.out.println(String.format("union(%d, %d) - %s", p, q, String.join(",", Arrays.toString(id))));
    }
}
