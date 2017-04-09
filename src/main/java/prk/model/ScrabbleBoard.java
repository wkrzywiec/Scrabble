package prk.model;

import java.util.Scanner;

public class ScrabbleBoard {

	private char[][] charCurrentBoard = new char[15][15];
	
	public String getNewWord(char[][] newBoard){
		
		char[][] tempBoard = newBoard;
		/*
		for(int i=0; i<15; i++){
			for (int j = 0; j<15; j++){
				if (Character.valueOf(tempBoard[i][j]).compareTo(Character.valueOf(charCurrentBoard[i][j]))==0)
				System.out.println(tempBoard[i][j]);
				charCurrentBoard[i][j] = tempBoard[i][j];
				System.out.println(charCurrentBoard[i][j]);
				tempBoard[i][j] = '\u0000';
				System.out.println(tempBoard[i][j]);
			}
		}*/
		
		StringBuilder out = new StringBuilder();
		for (int i=0; i<15; i++){
			for (int j = 0; j<15; j++){
				if(tempBoard[i][j]!= '\u0000'){
					out.append(i).append(",").append(j).append(",").append(tempBoard[i][j]).append(",");
				}
			}
		}
		out.deleteCharAt(out.length()-1);
		return out.toString();
	}
	
	public void addNewWordToCharBoard(String word){
		Scanner in = new Scanner(word).useDelimiter(",");
		
		while (in.hasNext())
			charCurrentBoard[in.nextInt()][in.nextInt()]=in.next().charAt(0);
	}

	
	public char[][] getCharCurrentBoard() {
		return charCurrentBoard;
	}

	public void setCharCurrentBoard(char[][] charCurrentBoard) {
		this.charCurrentBoard = charCurrentBoard;
	}
	
}