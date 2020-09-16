# Adversial-Search
 This is a model of the tic-tac-toe game using adversarial search algotithms: Minimax, Alpha-Beta pruning and Iterative deepening.

Here is his statement of the problem: https://www.emse.fr/~picard/cours/ai/adversarial/index.html

The files are to be found in the src folder of the Java Project.

util contains a simple example of the maximin search algorithm with and without alpha-beta pruning, it is applied in a simple 2-depth tree.

adversarial contains the interfaces of the game and the search algorithms (AdversarialSearch.java, Game.java). And the search algorithms ready to use : MinimaxSearch.java, AlphaBetaSearch.jave, IterativeDeepeningAlphaBetaSearch.java .

adversarial/core contains Metrics.java which calculates the number of expanded nodes by a used search algorithm.

adversarial/tictactoe The game's folder, contains the game implementation TicTacToe.java, and the gameplay file (which is to execute to try the game) TicTacToeGamePlay.java .
