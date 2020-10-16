/**
 * Chifoumi
 * @author Laurélenne
 *
 */
public class Chifoumi {

	public static void main(String[] args) {
		int[][] tableauScoreFinal = new int[3][2];

		clearConsole();
		titleGame();
		setTimeout(() -> gameMode(tableauScoreFinal), 1000);
	}

	/**
	 * Title of game
	 */
	public static void titleGame() {
		System.out.println("--------------------------------------------------");
		System.out.println("    ####  #    # # ######  ####  #    # #    # #  ");
		System.out.println("   #    # #    # # #      #    # #    # ##  ## #  ");
		System.out.println("   #      ###### # #####  #    # #    # # ## # #  ");
		System.out.println("   #      #    # # #      #    # #    # #    # #  ");
		System.out.println("   #    # #    # # #      #    # #    # #    # #  ");
		System.out.println("    ####  #    # # #       ####   ####  #    # #  ");
		System.out.println("--------------------------------------------------");
	}

	/**
	 * Title of game mode 1 player vs IA
	 */
	public static void titleMode1() {
		System.out.println("\n                  1 Joueur VS IA                \n");
	}

	/**
	 * Title of game mode 2 players
	 */
	public static void titleMode2() {
		System.out.println("\n                     2 Joueurs                   \n");
	}
	
	/**
	 * Allow user to choose the game mode or quit the game
	 * @param tableauScoreFinal
	 */
	public static void gameMode(int[][] tableauScoreFinal) {
		int gameMode = 0;

		System.out.println("\n------------ Choisissez un mode de jeu -----------");
		System.out.println("\n(1) - Contre l'IA \n(2) - 2 Joueurs\n(3) - Quitter\n");
		gameMode = Clavier.lireInt();

		switch (gameMode) {
		case 1:
			clearConsole();
			titleGame();
			titleMode1();
			round(gameMode, null, null, 0, 0, 1, tableauScoreFinal);
			demandeChoix(gameMode, null, null, 0, 0, 1, tableauScoreFinal);
			break;
		case 2:
			clearConsole();
			titleGame();
			titleMode2();
			round(gameMode, null, null, 0, 0, 1, tableauScoreFinal);
			demandeChoix(gameMode, null, null, 0, 0, 1, tableauScoreFinal);
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("Saisissez 1, 2 ou 3");
			gameMode(tableauScoreFinal);
			break;
		}
	}
	
	/**
	 * Print winner of the round
	 * @param gameMode
	 * @param strchoicePlayer1
	 * @param strchoicePlayer2
	 * @param intChoicePlayer1
	 * @param intChoicePlayer2
	 * @param tableauScoreFinal
	 * @param numberRound
	 */
	public static void winnerRound(int gameMode, String strchoicePlayer1, String strchoicePlayer2, int intChoicePlayer1,
			int intChoicePlayer2, int[][] tableauScoreFinal, int numberRound) {

		if (strchoicePlayer1 == strchoicePlayer2) {
			System.out.println("******************** EGALITE ! *******************"); //
			tableauScoreFinal[numberRound - 1][0]++;
			tableauScoreFinal[numberRound - 1][1]++;
		} else if (strchoicePlayer1 == "Feuille") {

			if (strchoicePlayer2 == "Pierre") {
				System.out.println("*************** VICTOIRE Joueur 1 ***************");
				tableauScoreFinal[numberRound - 1][0]++;
			} else {
				if (gameMode == 1) {
					System.out.println("***************** VICTOIRE de l'IA ***************");
				} else {
					System.out.println("**************** VICTOIRE Joueur 2 **************");
				}
				tableauScoreFinal[numberRound - 1][1]++;
			}

		} else if (strchoicePlayer1 == "Ciseaux") {

			if (strchoicePlayer2 == "Feuille") {
				System.out.println("*************** VICTOIRE Joueur 1 ***************");
				tableauScoreFinal[numberRound - 1][0]++;
			} else {
				if (gameMode == 1) {
					System.out.println("***************** VICTOIRE de l'IA ***************");
				} else {
					System.out.println("**************** VICTOIRE Joueur 2 **************");
				}
				tableauScoreFinal[numberRound - 1][1]++;
			}

		} else if (strchoicePlayer1 == "Pierre") {

			if (strchoicePlayer2 == "Ciseaux") {
				System.out.println("*************** VICTOIRE Joueur 1 ***************");
				tableauScoreFinal[numberRound - 1][0]++;
			} else {
				if (gameMode == 1) {
					System.out.println("***************** VICTOIRE de l'IA ***************");
				} else {
					System.out.println("**************** VICTOIRE Joueur 2 **************");
				}
				tableauScoreFinal[numberRound - 1][1]++;
			}
		}

	}

	/**
	 * Print the winner and score of the game
	 * @param tableauScoreFinal
	 * @param gameMode
	 */
	public static void printWinnerOfGame(int[][] tableauScoreFinal, int gameMode) {
		int scoreJoueur1 = 0;
		int scoreJoueur2 = 0;

		for (int i = 0; i < tableauScoreFinal.length; i++) {
			scoreJoueur1 += tableauScoreFinal[i][0];
			scoreJoueur2 += tableauScoreFinal[i][1];
		}

		if (gameMode == 1) {
			if (scoreJoueur1 < scoreJoueur2) {
				System.out.println("\nL'IA GAGNE LA PARTIE\n");
				System.out.println("Score IA : " + scoreJoueur2);
				System.out.println("Score Joueur 1 : " + scoreJoueur1);
			} else {
				System.out.println("\nJoueur 1 GAGNE LA PARTIE\n");
				System.out.println("Score Joueur 1 : " + scoreJoueur1);
				System.out.println("Score IA  : " + scoreJoueur2);
			}
		} else if (scoreJoueur1 > scoreJoueur2) {
			System.out.println("\nJoueur 1 GAGNE LA PARTIE\n");
			System.out.println("Score Joueur 1 : " + scoreJoueur1);
			System.out.println("Score Joueur 2 : " + scoreJoueur2);
		} else {
			System.out.println("\nJoueur 2 GAGNE LA PARTIE\n");
			System.out.println("Score Joueur 2 : " + scoreJoueur2);
			System.out.println("Score Joueur 1 : " + scoreJoueur1);
		}

	}

	/**
	 * Print the winner of round
	 * @param gameMode
	 * @param strchoicePlayer1
	 * @param strchoicePlayer2
	 * @param intChoicePlayer1
	 * @param intChoicePlayer2
	 * @param numberRound
	 * @param tableauScoreFinal
	 */
	public static void printChoice(int gameMode, String strchoicePlayer1, String strchoicePlayer2, int intChoicePlayer1,
			int intChoicePlayer2, int numberRound, int[][] tableauScoreFinal) {
		clearConsole();
		System.out.print("\n....3");
		wait(1000);
		System.out.print("....2");
		wait(1000);
		System.out.println("....1");
		wait(1000);

		if (gameMode == 1) {
			System.out.println("\nJoueur 1 : " + strchoicePlayer1);
			printGoodDrawLeft(gameMode, strchoicePlayer1, strchoicePlayer2);
			System.out.println("\n                            L'ordinateur : " + strchoicePlayer2 + "\n");
			printGoodDrawRight(gameMode, strchoicePlayer1, strchoicePlayer2);
		} else {
			System.out.println("Joueur 1 : " + strchoicePlayer1);
			printGoodDrawLeft(gameMode, strchoicePlayer1, strchoicePlayer2);
			System.out.println("\n                                 Joueur 2 : " + strchoicePlayer2 + "\n");
			printGoodDrawRight(gameMode, strchoicePlayer1, strchoicePlayer2);
		}

		winnerRound(gameMode, strchoicePlayer1, strchoicePlayer2, intChoicePlayer1, intChoicePlayer2, tableauScoreFinal,
				numberRound);
		numberRound++;
		round(gameMode, strchoicePlayer1, strchoicePlayer2, intChoicePlayer1, intChoicePlayer2, numberRound,
				tableauScoreFinal);
	}
	
	/**
	 * Allow the user to replay or quit my game
	 * @param numberRound
	 * @param tableauScoreFinal
	 * @param gameMode
	 */
	public static void endMessage(int numberRound, int[][] tableauScoreFinal, int gameMode) {
		printWinnerOfGame(tableauScoreFinal, gameMode);
		numberRound = 0;
		System.out.println("\n(1) Rejouer                           (2) Quitter");
		int finalChoice = Clavier.lireInt();
		clearConsole();
		titleGame();
		switch (finalChoice) {
		case 1:
			gameMode(tableauScoreFinal);
			break;
		case 2:
			System.exit(0);
			break;
		default:
			System.out.println("Saisissez 1 ou 2");
			endMessage(numberRound, tableauScoreFinal, gameMode);
			break;
		}
	}

	/**
	 * Print the round number if ins't finish or finish and print score
	 * @param gameMode
	 * @param strchoicePlayer1
	 * @param strchoicePlayer2
	 * @param intChoicePlayer1
	 * @param intChoicePlayer2
	 * @param numberRound
	 * @param tableauScoreFinal
	 */
	public static void round(int gameMode, String strchoicePlayer1, String strchoicePlayer2, int intChoicePlayer1,
			int intChoicePlayer2, int numberRound, int[][] tableauScoreFinal) {

		if (numberRound < 4) {
			System.out.println("\n--------------------- Manche " + numberRound + " -------------------\n");
			demandeChoix(gameMode, strchoicePlayer1, strchoicePlayer2, intChoicePlayer1, intChoicePlayer2, numberRound,
					tableauScoreFinal);
		} else {
			endMessage(numberRound, tableauScoreFinal, gameMode);
		}
	}


	/**
	 * Ask choices to players 
	 * @param gameMode
	 * @param strchoicePlayer1
	 * @param strchoicePlayer2
	 * @param intChoicePlayer1
	 * @param intChoicePlayer2
	 * @param numberRound
	 * @param tableauScoreFinal
	 */
	public static void demandeChoix(int gameMode, String strchoicePlayer1, String strchoicePlayer2,
			int intChoicePlayer1, int intChoicePlayer2, int numberRound, int[][] tableauScoreFinal) {
		int choicePlayer = 0;
		strchoicePlayer1 = "";
		strchoicePlayer2 = "";
		intChoicePlayer1 = 0;
		intChoicePlayer2 = 0;

		int playerTurn = 1;

		while ((choicePlayer != 1 && choicePlayer != 2 && choicePlayer != 3) || strchoicePlayer2 == "") {

			if (strchoicePlayer1 == "") {
				playerTurn = 1;
			} else if (strchoicePlayer1 != "" && strchoicePlayer2 == "") {
				playerTurn = 2;
			}

			if (playerTurn == 2 && gameMode == 1) {
				choicePlayer = (int) (Math.random() * 3 + 1);
			} else {
				System.out.println("Joueur " + playerTurn + " : saisissez un nombre");
				System.out.println("(1) : Pierre\n(2) : Feuille\n(3) : Ciseaux\n");
				choicePlayer = Clavier.lireInt();
			}

			switch (choicePlayer) {
			case 1:
				if ((playerTurn == 1 && gameMode == 1) || (playerTurn == 1 && gameMode == 2)) {
					strchoicePlayer1 = "Pierre";
				} else if (playerTurn == 2 && gameMode == 2) {
					strchoicePlayer2 = "Pierre";
				} else if (playerTurn == 2 && gameMode == 1) {
					strchoicePlayer2 = "Pierre";
				}
				break;
			case 2:
				if ((playerTurn == 1 && gameMode == 1) || (playerTurn == 1 && gameMode == 2)) {
					strchoicePlayer1 = "Feuille";
				} else if (playerTurn == 2 && gameMode == 2) {
					strchoicePlayer2 = "Feuille";
				} else if (playerTurn == 2 && gameMode == 1) {
					strchoicePlayer2 = "Feuille";
				}
				break;
			case 3:
				if ((playerTurn == 1 && gameMode == 1) || (playerTurn == 1 && gameMode == 2)) {
					strchoicePlayer1 = "Ciseaux";
				} else if (playerTurn == 2 && gameMode == 2) {
					strchoicePlayer2 = "Ciseaux";
				} else if (playerTurn == 2 && gameMode == 1) {
					strchoicePlayer2 = "Ciseaux";
				}
				break;
			default:
				System.out.println("\nSaisissez 1, 2 ou 3\n");
				break;
			}

		}
		
		printChoice(gameMode, strchoicePlayer1, strchoicePlayer2, intChoicePlayer1, intChoicePlayer2, numberRound,
				tableauScoreFinal);

	}

	/**
	 * Print rock to the left
	 */
	public static void printRockLeft() {
		System.out.println("       _______");
		System.out.println("  ----'   ____)");
		System.out.println("         (_____)");
		System.out.println("         (_____)");
		System.out.println("         (____)");
		System.out.println("  ----.__(___)");
	}

	/**
	 * Print leaf to the left
	 */
	public static void printLeafLeft() {
		System.out.println("         ________");
		System.out.println("   -----'    ____)____");
		System.out.println("                ______)");
		System.out.println("               _______)");
		System.out.println("              _______)");
		System.out.println("   -----.__________)");
	}

	/**
	 * Print scissors to the left
	 */
	public static void printScissorsLeft() {
		System.out.println("        _______");
		System.out.println("   ----'   ____)____");
		System.out.println("              ______)");
		System.out.println("           __________)");
		System.out.println("          (____)");
		System.out.println("   ----.__(___)");
	}

	/**
	 * Print rock to the right
	 */
	public static void printRockRight() {
		System.out.println("                                   _______       ");
		System.out.println("                                  (____   '------");
		System.out.println("                                 (_____)         ");
		System.out.println("                                 (_____)         ");
		System.out.println("                                 (____)          ");
		System.out.println("                                  (___)__.-------\n");
	}

	/**
	 * Print leaf to the right
	 */
	public static void printLeafRight() {
		System.out.println("                                    ________     ");
		System.out.println("                               ____(____    '----");
		System.out.println("                              (______            ");
		System.out.println("                              (_______           ");
		System.out.println("                               (_______          ");
		System.out.println("                                (__________.-----\n");
	}

	
	/**
	 * Print scissors to the right
	 */
	public static void printScissorsRight() {
		System.out.println("                                   _______       ");
		System.out.println("                              ____(____   '------");
		System.out.println("                             (______             ");
		System.out.println("                            (__________          ");
		System.out.println("                                  (____)         ");
		System.out.println("                                   (___)__.------\n\n");
	}

	/**
	 * Allows to print the right sign on the left side
	 * @param gameMode
	 * @param strchoicePlayer1
	 * @param strchoicePlayer2
	 */
	public static void printGoodDrawLeft(int gameMode, String strchoicePlayer1, String strchoicePlayer2) {

		if (strchoicePlayer1 == "Pierre") {
			printRockLeft();
		} else if (strchoicePlayer1 == "Feuille") {
			printLeafLeft();
		} else if (strchoicePlayer1 == "Ciseaux") {
			printScissorsLeft();
		}
	}
	
	/**
	 * Allows to print the right sign on the right side
	 * @param gameMode
	 * @param strchoicePlayer1
	 * @param strchoicePlayer2
	 */
	public static void printGoodDrawRight(int gameMode, String strchoicePlayer1, String strchoicePlayer2) {

		if (strchoicePlayer2 == "Pierre") {
			printRockRight();
		} else if (strchoicePlayer2 == "Feuille") {
			printLeafRight();
		} else if (strchoicePlayer2 == "Ciseaux") {
			printScissorsRight();
		}

	}

	/**
	 * ----------------- utils -----------------
	 */

	/**
	 * SetTimeOut for function
	 * @param runnable
	 * @param delay
	 */
	public static void setTimeout(Runnable runnable, int delay) {
		new Thread(() -> {
			try {
				Thread.sleep(delay);
				runnable.run();
			} catch (Exception e) {
				System.err.println(e);
			}
		}).start();
	}
	
	/**
	 * SetTimeOut for the next instruction
	 * @param delay
	 */
	public static void wait(int delay) {

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Clear console with println
	 */
	public static void clearConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println("\n");
		}
	}

}
