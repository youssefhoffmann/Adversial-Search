package fr.emse.ai.adversarial.Tictactoe;
import fr.emse.ai.adversarial.Game;

import java.util.ArrayList;
import java.util.List;


public class TictactoeGame implements Game<String[], Integer, String> {
    public final static String[] players = {"O", "X"};
    public final static String[] initialState = {"X", "_", "_", "_", "_", "_", "_", "_", "_", "_"};

    public TictactoeGame(String player) {
        initialState[0] = player;

    }

    @Override
    public String[] getInitialState() {
        return initialState;
    }

    @Override
    public String[] getPlayers() {
        return players;
    }

    @Override
    public String getPlayer(String[] state) {
        return state[0];
    }

    @Override
    public List<Integer> getActions(String[] state) {
        ArrayList<Integer> actions = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++)
            if (state[i].equals("_")) {
                actions.add(i);
            }
        return actions;
    }

    @Override
    public String[] getResult(String[] state, Integer action) {
        String nouveljoueur = (state[0].equals("X")) ? "O" : "X";
        String[] nouveletat = {nouveljoueur, "_", "_", "_", "_", "_", "_", "_", "_", "_"};
        int a = action;
        if (state[a].equals("_")) {
            for (int i = 1; i <=9; i++) {
                nouveletat[i] = state[i];
            }
            nouveletat[a] = state[0];
        } else {
            return state;
        }
        return nouveletat;
    }

    @Override
    public boolean isTerminal(String[] state) {
        String x = "X";
        String o="O";


            if ((state[1].equals(x) & state[2].equals(x)  & state[3].equals(x)) || (state[1].equals(o) & state[2].equals(o) & state[3].equals(o))) {
                return true;
            } else if ((state[4].equals(x) & state[5].equals(x) & state[6].equals(x)) || (state[4].equals(o) & state[5].equals(o) & state[6].equals(o))) {
                return true;
            }else if ((state[7].equals(x) & state[8].equals(x) & state[9].equals(x)) || (state[7].equals(o) & state[8].equals(o) & state[9].equals(o))) {
                return true;
            }else if ((state[1].equals(x) & state[5].equals(x) & state[9].equals(x)) || (state[1].equals(o) & state[5].equals(o) & state[9].equals(o))) {
                return true;
            }else if ((state[3].equals(x) & state[5].equals(x) & state[7].equals(x)) || (state[3].equals(o) & state[5].equals(o) & state[7].equals(o))) {
                return true;
            }else if ((state[1].equals(x)& state[4].equals(x) & state[7].equals(x)) || (state[1].equals(o) & state[4].equals(o) & state[7].equals(o))) {
                return true;
            }else if ((state[2].equals(x)& state[5].equals(x) & state[8].equals(x)) || (state[2].equals(o) & state[5].equals(o) & state[8].equals(o))) {
                return true;
            }else if ((state[3].equals(x)& state[6].equals(x) & state[9].equals(x)) || (state[3].equals(o) & state[6].equals(o) & state[9].equals(o))) {
                return true;
            }

        // cas de case vide
        for (int i = 1; i <= 9; i++) {
            if (state[i].equals("_")) {
                return false;
            }

        }
        // une fois le tableau est tout rempli
        return true;
    }

    @Override
    public double getUtility(String[] state, String player) {
        boolean egalite = true;
        for (int i = 1; i <= 9; i++) {
            if (state[i].equals("_")) {
                egalite = false;
                break;
            }
        }

        if (egalite) {
            return 0.5;
        } else {
            return (state[0].equals(player)) ? 0 : 1;
        }
    }

    public String toString(String[] state) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 1; i <= 9; i++) {
            if (i % 3 == 0) {
                sBuffer.append(state[i]);
                sBuffer.append("\n");

            } else {
                sBuffer.append(state[i]);
                sBuffer.append(" ");
            }

        }
        return sBuffer.toString();
    }
}