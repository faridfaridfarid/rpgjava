package com.farid.personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.farid.jeu.Main;
import com.farid.objets.Objet;

public class Personnage {
	
	private int largeur;         //dimension du personnage
	private int hauteur;	     //dimension du personnage
	private int x;			      //position du personnage
	private int y;			        //position du personnage
	private boolean marche;        //vrai quand le personnage marche
	private boolean versDroite;   //vrai quand le personnage est tourné vers la droite
	public int compteur;          //compteur de pas du personnage
	
	
	public Personnage(int largeur, int hauteur, int x, int y) {
		
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.x = x;
		this.y = y;
		this.marche = false;
		this.versDroite = true;
		this.compteur = 0;
	}


	public int getLargeur() {
		return largeur;
	}


	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}


	public int getHauteur() {
		return hauteur;
	}


	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public boolean isMarche() {
		return marche;
	}


	public void setMarche(boolean marche) {
		this.marche = marche;
	}


	public boolean isVersDroite() {
		return versDroite;
	}


	public void setVersDroite(boolean versDroite) {
		this.versDroite = versDroite;
	}


	public int getCompteur() {
		return compteur;
	}


	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}
	
	
	public Image marche(String nom, int frequence) {
		String str;
		ImageIcon ico;
		Image img;
		
		//si personnage arreter ou completement a la gauche de l'ecran et donc bloqué
		if(this.marche == false || Main.scene.getxPos() <= 0) {
			if(this.versDroite == true) {str = "/images/" + nom + "ArretDroite.png";}
			else {str = "/images/" + nom + "ArretGauche.png";}
		}else {
			this.compteur++;
			if(this.compteur / frequence == 0) {
				if(this.versDroite == true) {str = "/images/" + nom + "ArretDroite.png";}
				else {str = "/images/" + nom + "ArretGauche.png";}
			}else {
					if(this.versDroite == true) {str = "/images/" + nom + "MarcheDroite.png";}
					else {str = "/images/" + nom + "MarcheGauche.png";}
				
			}
			if(this.compteur == 2 * frequence) {this.compteur = 0;}
			}
			//affichage de l'image du personnage
			ico = new ImageIcon(getClass().getResource(str));
			img = ico.getImage();
			return img;
		
		
	}
	
	public boolean contactAvant(Objet objet) {
		if(this.isVersDroite() == true) {
			if(this.x + this.largeur < objet.getX() || this.x + this.largeur > objet.getX() + 5 || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()){return false;}
			else { return true;}
			
	}else {return false;}
}
}
