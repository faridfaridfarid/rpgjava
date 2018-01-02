package com.farid.jeu;

import javax.swing.JFrame;

public class Main {
	
	public static Scene scene;

	public static void main(String[] args) {
		//Creation de ma fenetre d'application
		JFrame fenetre = new JFrame("Jeu Farid Mario");
		//quand on clique sur la croix en haut a droite on quitte le jeu et ferme la fenetre
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//taille de la fenetre
		fenetre.setSize(700, 360);
		//on centre la fenetre a l'ecran
		fenetre.setLocationRelativeTo(null);
		//on interdit de la redimensionner
		fenetre.setResizable(false);
		//on empeche qu'une autre fenetre passe devant celle ci
		fenetre.setAlwaysOnTop(true);
		
		scene = new Scene();
		
		//on associe la scene à la fenetre de l'application
		fenetre.setContentPane(scene);
		fenetre.setVisible(true);
		

	}

}
