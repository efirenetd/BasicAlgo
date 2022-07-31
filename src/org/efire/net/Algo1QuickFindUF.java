package org.efire.net;

import java.util.Arrays;

public class Algo1QuickFindUF {

    private static int[] id;

    public Algo1QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        System.out.println("initial - "+String.join(",", Arrays.toString(id)));
    }

    boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    void union( int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)  {
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        Algo1QuickFindUF algo = new Algo1QuickFindUF(10);
        doUnion(algo, 4, 3);
        doUnion(algo, 3, 8);
        doUnion(algo, 6, 5);
        doUnion(algo, 9, 4);
        doUnion(algo, 2, 1);
        isConnected(algo, 8, 9);
        isConnected(algo, 5, 0);
        doUnion(algo, 5, 0);
        doUnion(algo, 7, 1);
        doUnion(algo, 6, 1);

    }

    private static void doUnion(Algo1QuickFindUF algo, int p, int q) {
        algo.union(p, q);
        System.out.println(String.format("union(%d, %d) - %s", p, q, String.join(",", Arrays.toString(id))));
    }

    private static void isConnected(Algo1QuickFindUF algo, int p, int q)  {
        System.out.println(String.format("connected(%d, %d) - %s", p, q, algo.connected(p, q)));
    }

}
