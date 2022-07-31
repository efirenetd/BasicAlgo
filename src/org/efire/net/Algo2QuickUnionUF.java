package org.efire.net;

import java.util.Arrays;

public class Algo2QuickUnionUF {

    private static int[] id;

    public Algo2QuickUnionUF(int n) {
        id = new int[n];
        // set id of each object to itself
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        System.out.println("initial - "+String.join(",", Arrays.toString(id)));
    }

    // chase parent pointer until it reaches the root
    private int root(int i) {
        while (i != id[i]) i = id[i];
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
        id[i] = j;
    }

    public static void main(String[] args) {
        Algo2QuickUnionUF algo = new Algo2QuickUnionUF(10);
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

    private static void isConnected(Algo2QuickUnionUF algo, int p, int q)  {
        System.out.println(String.format("connected(%d, %d) - %s", p, q, algo.connected(p, q)));
    }

    private static void doUnion(Algo2QuickUnionUF algo, int p, int q) {
        algo.union(p, q);
        System.out.println(String.format("union(%d, %d) - %s", p, q, String.join(",", Arrays.toString(id))));
    }
}
