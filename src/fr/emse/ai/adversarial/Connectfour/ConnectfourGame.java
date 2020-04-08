package fr.emse.ai.adversarial.Connectfour;
import fr.emse.ai.adversarial.Game;

import java.util.ArrayList;
import java.util.List;

public class ConnectfourGame implements Game<String[][], Integer, String> {
    public final static String[] players = {"0", "1"};
    public final static String[][] initialState = {{"1"},{ "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_","_","_","_","_","_"},
            {"_","_","_","_","_","_","_"},
            {"_","_","_","_","_","_","_"},
            {"_","_","_,","_","_","_","_"},
            {"_","_","_","_","_","_","_"}};

    public ConnectfourGame(String player) {
        initialState[0][0] = player;

    }

    @Override
    public String[][] getInitialState() {
        return initialState;
    }

    @Override
    public String[] getPlayers() {
        return players;
    }

    @Override
    public String getPlayer(String[][] state) {
        return state[0][0];
    }

    @Override
    public List<Integer> getActions(String[][] state) {
        ArrayList<Integer> actions = new ArrayList<Integer>();
            for (int i = 1; i < 7; i++) {
                for (int j = 0; j < 6; j++) {
                    if (state[i][j].equals("_")) {
                        actions.add(7 * i + j );
                    }
                }
            }
            return actions;
        }

    @Override
    public String[][] getResult(String[][] state, Integer action) {
                String newPlayer = (state[0][0].equals("1")) ? "0" : "1";
                String[][] newState = {{newPlayer},{ "_", "_", "_", "_", "_", "_", "_"},
                        {"_", "_","_","_","_","_","_"},
                        {"_","_","_","_","_","_","_"},
                        {"_","_","_","_","_","_","_"},
                        {"_","_","_,","_","_","_","_"},
                        {"_","_","_","_","_","_","_"} };
                int m = (action ) / 7;
                int n = (action ) % 7;
                if (state[m][n].equals("_")) {
                    for (int i = 1; i < 7; i++) {
                        System.arraycopy(state[i], 0, newState[i], 0, 3);
                    }
                    newState[m][n] = state[0][0];
                } else {
                    return state;
                }
                return newState;
            }
    @Override
    public boolean isTerminal(String[][] state) {
        String o = "0";
        String x = "1";

       // cas des lignes
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                if((state[i][j].equals(x) & state[i][j+1].equals(x) & state[i][j+2].equals(x) & state[i][j+3].equals(x)) || (state[i][j].equals(o)& state[i][j+1].equals(o) & state[i][j+2].equals(o) & state[i][j+3].equals(o)))
                     return true;
            }}
        //cas des colonnes
        for (int i = 1; i <4; i++) {
            for (int j = 0; j < 6; j++) {
                if ((state[i][j].equals(x) & state[i + 1][j].equals(x) & state[i + 2][j].equals(x) & state[i + 3][j].equals(x)) || (state[i][j].equals(o) & state[i + 1][j].equals(o) & state[i + 2][j].equals(o) & state[i + 3][j].equals(o)))
                    return true;
            }}
        // cas des diagonales
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((state[i][j].equals(x) & state[i + 1][j+1].equals(x) & state[i + 2][j+2].equals(x) & state[i + 3][j+3].equals(x)) || (state[i][j].equals(o) & state[i + 1][j+1].equals(o) & state[i + 2][j+2].equals(o) & state[i + 3][j+3].equals(o)))
                    return true;
            }}
        // cas des antidiagonales
        for (int i=7 ; i < 4; i--) {
            for (int j = 6; j < 4; j--) {
                if ((state[i][j].equals(x) & state[i - 1][j - 1].equals(x) & state[i - 2][j - 2].equals(x) & state[i - 3][j - 3].equals(x)) || (state[i][j].equals(o) & state[i - 1][j - 1].equals(o) & state[i - 2][j - 2].equals(o) & state[i - 3][j - 3].equals(o)))
                    return true;
            }}

        // cas de case vide
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (state[i][j].equals("_")) {
                    return false;
                }
            }
        }
        // une fois le tableau est tout rempli
        return true;
    }

    @Override
    public double getUtility(String[][]state, String player) {
        boolean egalite= true;
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (state[i][j].equals("_")) {
                    egalite = false;
                    break;
                }
            }
        }
        if (egalite)
            return 0.5;
        else {
            return (state[0][0].equals(player)) ? 0 : 1;
        }
    }

    public String toString(String[][] state) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                sBuffer.append(state[i][j]).append(" ");
            }
            sBuffer.append("\n");
        }
        return sBuffer.toString();
    }


}
