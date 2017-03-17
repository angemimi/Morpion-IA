package com.morpion.classes;

public class Method {
	public Method(){}
	
	public int grilleHasWinner(int grille [][]){
		int winner = -1;		
		//test en diagonnal de gauche à droite
		if(grille[0][0]!=0 && grille[1][1] != 0 && grille[2][2] != 0){
			winner = (grille[0][0]+grille[1][1]+grille[2][2])/3;
		}
		if(grille[0][2]!=0 && grille[1][1] != 0 && grille[2][0] != 0){
			winner = (grille[0][2]+grille[1][1]+grille[2][0])/3;
		}
		//parcour de la grille en ligne
		for(int line=0; line <2; line++){
			if((grille[line][0] != 0)&&(grille[line][1]!=0) && (grille[line][2] != 0) && (winner == -1)){
				winner = (grille[line][2]+grille[line][1]+grille[line][0])/3;
			}
		}
		//parcour de la grille en colonne
		for(int cols = 0; cols < 2; cols++){
			if((grille[0][cols] != 0)&&(grille[1][cols]!=0) && (grille[2][cols] != 0) && (winner == -1)){
				winner = (grille[0][cols]+grille[1][cols]+grille[2][cols])/3;
			}
		}
		return winner;
	}
	
	public boolean setCase(int joueur, int ligne, int colonne, int[][]grille){
		int valeur = grille[ligne][colonne];
		if(valeur == 0 && joueur != 0){
			return true;
		}
		return false;
	}
}
