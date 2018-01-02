package com.farid.personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.farid.jeu.Main;

public class Mario extends Personnage {

	private Image imgMario;
	private ImageIcon icoMario;
	private boolean saut; //renvoie vrai si mario saute
	private int compteurSaut; // gere la durée et la hauteur du saut
	
	public Mario(int x, int y) {
		super(x, y, 28, 50);
		this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
		this.imgMario = this.icoMario.getImage();
		this.saut = false;
		this.compteurSaut = 0;
	}
	
	public Image getImgMario() {
		return imgMario;
	}

	public boolean isSaut() {
		return saut;
	}

	public void setSaut(boolean saut) {
		this.saut = saut;
	}
	
	public Image saute() {
		ImageIcon ico;
		Image img;
		String str;
		
		//montée du saut
		this.compteurSaut++;
		
		if(this.compteurSaut <= 35) {
			//getY c'est la hauteur de la tête de mario avec montée de 4px a la fois
			if(this.getY() > Main.scene.getHautPlafond()) {this.setY(this.getY() - 4);}
			else {this.compteurSaut = 36;}
			if(this.isVersDroite() == true) {str = "/images/marioSautDroite.png";}
			else { str = "/images/marioSautGauche.png";}
			
			//retombée du saut                                              //descente de 1px a la fois
		}else if(this.getY() + this.getHauteur() < Main.scene.getySol()) {this.setY(this.getY() + 1);
			if(this.isVersDroite() == true) { str = "/images/marioSautDroite.png"; }
			else {str = "/images/marioSautGauche.png";}
			
			//Saut terminé
	}else {
		if(this.isVersDroite() == true) {str = "/images/marioArretDroite.png";}
		else {str = "/images/marioArretGauche.png"; }
		this.saut = false;
		this.compteurSaut = 0;
	}
		//affichage de l'image de mario
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
}

