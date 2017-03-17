package com.morpion.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

class Dessin extends JPanel implements MouseListener {

    int grille[][]= {{0,0,0},{0,0,0},{0,0,0}};
    int tourJoueur = 1 ;
    int i=0;
    public Dessin(){
        super();
        this.setBackground(Color.lightGray);
        this.setSize(300, 300);
        this.addMouseListener(this);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
       // g.drawString("TOTO"+(i++),100,100);
        ((Graphics2D) g).setStroke(new BasicStroke(10));
        g.setColor(Color.blue);
        g.drawLine(100, 0, 100, 300);
        g.drawLine(200, 0, 200, 300);
        g.drawLine(0, 100, 300, 100);
        g.drawLine(0, 200, 300, 200);

        for (int y= 0 ; y < 3 ; y ++) {
            for (int x = 0 ; x < 3 ; x ++) {
                System.out.println(grille[x][y]);
                if (grille[x][y] == 1){
                    drawCroix(x,y,g);
                }
                if (grille[x][y] == 2){
                    drawRond(x, y, g);
                }

            }
        }

    }

    private void drawRond(int x, int y, Graphics g) {

        ((Graphics2D) g).setStroke(new BasicStroke(10));


        g.setColor(Color.red);
        g.drawOval((x*100+10),(y*100+10),80,80);

    }

    private void drawCroix(int x, int y, Graphics g) {
        ((Graphics2D) g).setStroke(new BasicStroke(10));


        g.setColor(Color.green);
        g.drawLine((x * 100  +20), (y * 100 +20 ), (x * 100+80),(y*100+80));
        g.drawLine((x * 100  +20), (y * 100 +80 ), (x * 100+80),(y*100+20));


    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	Method set = new Method();
    	int winner = -1;
        System.out.println(e.getX()+" "+e.getY());
        int X = e.getX() / 100 ;
        int Y = e.getY() / 100 ;
        System.out.println(X+" "+Y + " "  + tourJoueur);
        if(set.setCase(tourJoueur, X, Y, grille)){
        	grille[X][Y] = tourJoueur ;
        	IA ia = new IA();
        	grille = ia.tourIa(grille);
        	this.repaint();
        	winner = set.grilleHasWinner(grille);
        }else{
        	System.out.println("Cliquer sur une autre case");
        }
        if(winner > 0 && winner != -1){
        	System.out.println("Le gagnant est le joueur "+ winner);
        }else if(winner == 0){
        	System.out.println("Personne n'a gagner");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

public class Main extends JFrame {


    public static void main(String args[]){
        Main F = new Main();
        F.setSize(330,330);
        F.add(new Dessin());
        F.setVisible(true);
        F.repaint();
        F.repaint();



    }

}