package com.morpion.classes;
public class IA {
	public IA(){}
	
	public int[][] tourIa(int[][]grille){
		int y =(int)(Math.random()*2);
		int x = (int)(Math.random()*2);
		
		int copyGrille[][] = grille.clone();
		while(grille[x][y]!=0){
			y =(int)(Math.random()*2);
			x = (int)(Math.random()*2);
		}
		copyGrille[x][y] = 2;
		return copyGrille;
	}
	
}
