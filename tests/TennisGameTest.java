import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();
	}		
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();
	}	
	
	@Test 
	public void testPlayer1Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		// Assert
		assertEquals("Player 1 did not win correctly", "player1 wins", game.getScore());
	}
	
	@Test 
	public void testPlayer2Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		// Assert
		 assertEquals("Player 2 did not win correctly", "player2 wins", game.getScore());
	}
	
	@Test 
	public void testAdvantagePlayer1() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		//Act
		for (int i = 0; i < 3; i++) {
			game.player1Scored();
			game.player2Scored();
		}
		game.player1Scored();
		
		//Assert
		assertEquals("Player 1 advantage not correct", "player1 has advantage", game.getScore());
		}

	@Test 
	public void testAdvantagePlayer2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
	
		//Act
		for (int i = 0; i < 3; i++) {
		game.player2Scored();
		game.player1Scored();
		
		}
		game.player2Scored();
	
		//Assert
		assertEquals("Player 2 advantage not correct", "player2 has advantage", game.getScore());
		}

	@Test 
	public void testScorePlayer1() throws TennisGameException {
		//Arrange	
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		//Assert
		assertEquals("15 - love", game.getScore());
		
		game.player1Scored();
		//Assert
		assertEquals("30 - love", game.getScore());
	}
	
	
	@Test 
	public void testScorePlayer2() throws TennisGameException {
		//Arrange	
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		//Assert
		assertEquals("love - 15", game.getScore());
		
		game.player2Scored();
		//Assert
		assertEquals("love - 30", game.getScore());
		
	}
	

	
	
}
