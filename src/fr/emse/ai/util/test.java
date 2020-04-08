package fr.emse.ai.util;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        SimpleTwoPlyGameTree<Integer> tree1 =
                new SimpleTwoPlyGameTree<Integer>(Integer.MAX_VALUE, true);
        ArrayList<SimpleTwoPlyGameTree<Integer>> sublist1 =
                new ArrayList<SimpleTwoPlyGameTree<Integer>>();
        sublist1.add(new SimpleTwoPlyGameTree<Integer>(3, true));
        sublist1.add(new SimpleTwoPlyGameTree<Integer>(12, true));
        sublist1.add(new SimpleTwoPlyGameTree<Integer>(8, true));
        SimpleTwoPlyGameTree<Integer> subtree1 =
                new SimpleTwoPlyGameTree<Integer>(Integer.MIN_VALUE, false, sublist1);
        ArrayList<SimpleTwoPlyGameTree<Integer>> sublist2 =
                new ArrayList<SimpleTwoPlyGameTree<Integer>>();
        sublist2.add(new SimpleTwoPlyGameTree<Integer>(2, true));
        sublist2.add(new SimpleTwoPlyGameTree<Integer>(4, true));
        sublist2.add(new SimpleTwoPlyGameTree<Integer>(6, true));
        SimpleTwoPlyGameTree<Integer> subtree2 =
                new SimpleTwoPlyGameTree<Integer>(Integer.MIN_VALUE, false, sublist2);
        ArrayList<SimpleTwoPlyGameTree<Integer>> sublist3 =
                new ArrayList<SimpleTwoPlyGameTree<Integer>>();
        sublist3.add(new SimpleTwoPlyGameTree<Integer>(14, true));
        sublist3.add(new SimpleTwoPlyGameTree<Integer>(5, true));
        sublist3.add(new SimpleTwoPlyGameTree<Integer>(2, true));
        SimpleTwoPlyGameTree<Integer> subtree3 =
                new SimpleTwoPlyGameTree<Integer>(Integer.MIN_VALUE, false, sublist3);
        tree1.addChild(subtree1);
        tree1.addChild(subtree2);
        tree1.addChild(subtree3);
        Minimax solver = new Minimax();
        long start = System.nanoTime();



        System.out.println(solver.minimax(tree1));
        long end = System.nanoTime();

        long elapsedTime = end - start;
        System.out.println(elapsedTime);

        alphabeta solver2=new alphabeta();
         start = System.nanoTime();

        System.out.println(solver2.minimax(tree1,Integer.MIN_VALUE,Integer.MAX_VALUE));
        end = System.nanoTime();

        elapsedTime = end - start;
        System.out.println(elapsedTime);
    }
}