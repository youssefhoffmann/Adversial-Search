package fr.emse.ai.util;
import fr.emse.ai.util.SimpleTwoPlyGameTree;

public class Minimax {


    public int minimax(SimpleTwoPlyGameTree<Integer> tree) {
        if (tree.isLeaf()) {
            return tree.getValue();
        } else {
            int minimax = Integer.MIN_VALUE;
            if (tree.isMax()) {
                for (SimpleTwoPlyGameTree<Integer> child : tree.getChildren()) {
                    minimax = Math.max(minimax(child), minimax);
                }
                tree.setValue((Integer) minimax);
                return minimax;

            } else {
                minimax = Integer.MAX_VALUE;
                for (SimpleTwoPlyGameTree<Integer> child : tree.getChildren()) {
                    minimax = Math.min(minimax(child), minimax);
                }
                tree.setValue((Integer) minimax);
                return minimax;


            }
        }
    }

}