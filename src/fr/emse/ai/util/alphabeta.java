package fr.emse.ai.util;
import fr.emse.ai.util.SimpleTwoPlyGameTree;

public class alphabeta {

    public int minimax(SimpleTwoPlyGameTree<Integer> tree, int alpha, int beta) {
        if (tree.isLeaf()) {
            return tree.getValue();
        } else {
            int minimax = Integer.MIN_VALUE;
            if (tree.isMax()) {
                for (SimpleTwoPlyGameTree<Integer> child : tree.getChildren()) {
                    minimax = Math.max(minimax(child, alpha, beta), minimax);
                    alpha = Math.max(alpha, minimax);
                    if (alpha >= beta) {
                        break;
                    }}
                    return minimax;
                }else {
                       minimax = Integer.MAX_VALUE;
                        for (SimpleTwoPlyGameTree<Integer> child : tree.getChildren()) {
                            minimax = Math.min(minimax(child, alpha, beta), minimax);
                            beta = Math.min(beta, minimax);
                            if (beta <= alpha) {
                                break;

                            }}
                            return minimax;


                        }
                    }
                }
            }




