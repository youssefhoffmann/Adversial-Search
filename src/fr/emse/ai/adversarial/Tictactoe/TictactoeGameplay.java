package fr.emse.ai.adversarial.Tictactoe;
import fr.emse.ai.adversarial.AlphaBetaSearch;
import fr.emse.ai.adversarial.IterativeDeepeningAlphaBetaSearch;
import fr.emse.ai.adversarial.MinimaxSearch;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TictactoeGameplay {
    public static void main(String[] args) {
    TictactoeGame game = new TictactoeGame("X");
    MinimaxSearch<String[], Integer, String> minimaxSearch = MinimaxSearch.createFor(game);
    AlphaBetaSearch<String[], Integer, String> alphabetaSearch = AlphaBetaSearch.createFor(game);
    IterativeDeepeningAlphaBetaSearch<String[], Integer, String> iterativeDeepeningAlphaBetaSearch = IterativeDeepeningAlphaBetaSearch.createFor(game, -1, 1, 10);
    String[] state = game.getInitialState();
        while (!game.isTerminal(state)) {
        System.out.println("======================");
        System.out.println(game.toString(state));
        int action = 0;
        if (state[0].equals("X"))
            //human
        {
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
        if (game.getUtility(state,"X")==1)
                System.out.println("Human wins!");
        else if(game.getUtility(state,"X")==0.5)
            System.out.println("No one wins!,Please repaeat again");
        else
            System.out.println("Machine wins!");

}
}

