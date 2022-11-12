import java.util.*;

public class onlinejudge_11459 {

	public static void main(String[] args) {
		// Collecting input data.
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		
		// Iterating through test cases.
		for (int cases = 0; cases < numCases; cases++) {
			// Creating variables for number of players, "sads" (snakes/ladders), and dice rolls.
			int numPlayers = input.nextInt();
			if (numPlayers > 0){
				int numSads = input.nextInt();
				int numRolls = input.nextInt();
				
				// sads is a 2D array where the first dimension is the sad and the second is the beginning/end of the sad.
				int[][] sads = new int[numSads][2];
				for (int i = 0; i < numSads; i++) {
					for (int j = 0; j < 2; j++) {
						// Recording sad data into array for later checks.
						sads[i][j] = input.nextInt();
					}
				}
				
				// rolls is a 1D array that contains a series of dice rolls.
				int[] rolls = new int[numRolls];
				for (int i = 0; i < numRolls; i++) {
					// Recording dice roll data for later simulation.
					rolls[i] = input.nextInt();
				}
				
				// pos is a 1D array containing the current position of each player.
				int[] pos = new int[numPlayers];
				// Setting start position for all.
				Arrays.fill(pos, 1);
				
				// Iterating through each player repeatedly to simulate the game as a main loop until the game ends.
				int rollIn = 0;
				boolean done = false;
				while (!done){
					for (int i = 0; i < numPlayers; i++) {
						// Flag to denote landing on the mouth of a sad (and therefore needing a recursive call).
						boolean	sadsMouth = false;
						// Checking for each sad if the player will land on a mouth.
						for (int s = 0; s < numSads; s++) {
							if (pos[i] + rolls[rollIn] == sads[s][0]) {
								// Immediately shifting to tail of sad.
								pos[i] = sads[s][1];
								sadsMouth = true;
							}
						}
						
						// Moving the player a die roll number of spaces when no mouth is landed on.
						if (!sadsMouth) {pos[i] += rolls[rollIn];}
						// Advancing the dice roll index.
						rollIn++;
						// Ending the game when a player wins or the rolls cease.
						if (pos[i] > 99 || rollIn == numRolls){
							for (int p = 0; p < numPlayers; p++) {
								System.out.println("Position of player " + (p + 1) + " is " + pos[p] + ".");
								done = true;
							}
						}
					}
				}
			} else {
				System.out.println("There are no players.");
			}
		}
		input.close();
	}

}
