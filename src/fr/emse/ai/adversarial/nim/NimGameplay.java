package fr.emse.ai.adversarial.nim;

import fr.emse.ai.adversarial.AlphaBetaSearch;
import fr.emse.ai.adversarial.IterativeDeepeningAlphaBetaSearch;
import fr.emse.ai.adversarial.MinimaxSearch;

import java.util.List;
import java.util.Scanner;

public class NimGameplay {

    public static void main(String[] args) {
        NimGame game = new NimGame(20);
        MinimaxSearch<List<Integer>, Integer, Integer> minimaxSearch = MinimaxSearch.createFor(game);
        AlphaBetaSearch<List<Integer>, Integer, Integer> alphabetaSearch = AlphaBetaSearch.createFor(game);
        IterativeDeepeningAlphaBetaSearch<List<Integer>, Integer, Integer> iterativeDeepeningAlphaBetaSearch = IterativeDeepeningAlphaBetaSearch.createFor(game, -1, 1, 10);
        List<Integer> state = game.getInitialState();
        while (!game.isTerminal(state)) {
            System.out.println("======================");
            System.out.println(state);
            int action = -1;
            if (state.get(0) == 0) {
                //human
                List<Integer> actions = game.getActions(state);
                Scanner in = new Scanner(System.in);
                while (!actions.contains(action)) {
                    System.out.println("Human player, what is your action?");
                    action = in.nextInt();
                }
            } else {
                //machine
                System.out.println("Machine player, what is your action?");
                action = minimaxSearch.makeDecision(state);
                System.out.println("Metrics for Minimax : " + minimaxSearch.getMetrics());
                alphabetaSearch.makeDecision(state);
                System.out.println("Metrics for AlphaBeta : " + alphabetaSearch.getMetrics());
                iterativeDeepeningAlphaBetaSearch.makeDecision(state);
                System.out.println("Metrics for IDAlphaBetaSearch : " + iterativeDeepeningAlphaBetaSearch.getMetrics());
            }
            System.out.println("Chosen action is " + action);
            state = game.getResult(state, action);
        }
        System.out.print("GAME OVER: ");
        if (state.get(0) == 0)
            System.out.println("Human wins!");
        else
            System.out.println("Machine wins!");

    }
}
