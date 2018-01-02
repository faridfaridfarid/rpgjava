package com.farid.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.farid.objets.Bloc;
import com.farid.objets.TuyauRouge;
import com.farid.personnage.Mario;

@SuppressWarnings("serial")
public class Scene extends JPanel {
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;
	private Image imgChateau1;
	private ImageIcon icoDepart;
	private Image imgDepart;
	
	private int xFond1;
	private int xFond2;
	private int dx; //deplacement du fonds de l'ecran
	private int xPos; // position absolue dans le jeu
	private int ySol; // la hauteur courante du sol
	private int hauteurPlafond; // hauteur courante du plafond
	
	public Mario mario;
	public TuyauRouge tuyauRouge1;
	public Bloc bloc1;
	
	

	public Scene() {
		
		super();
		this.xFond1 = -50;
		// ecran 800 de large donc -50 = 800 = 750
		this.xFond2 = 750;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 293;     //du plafonds au sol il y a 293
		this.hauteurPlafond = 0;
		
		icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
		this.imgFond1 = this.icoFond.getImage();
		this.imgFond2 = this.icoFond.getImage();
		
		//on ajoute le chateau et le panneau de depart dans la fenetre
		this.icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
		this.imgChateau1 = this.icoChateau1.getImage();
		this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		this.imgDepart = this.icoDepart.getImage();
		
		//instances de mes classes
		mario = new Mario(300, 245);
		tuyauRouge1 = new TuyauRouge(600, 230);
		bloc1 = new Bloc(400, 180);
		
		//pour pouvoir ecouter l'ecran 
		this.setFocusable(true);
		//pour etre sur de recuperer le focus
		this.requestFocusInWindow();
		//on relie notre clavier à notre scene pour avoir accées au methode KEYLISTENER
		this.addKeyListener(new Clavier());
		
		
		//on cree une instance (programme indepandant)
		Thread chronoEcran = new Thread(new Chrono());
		//je demarre ici mon chrono
		chronoEcran.start();
	}
	
	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}
	
	
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	public void setxFond1(int xFond1) {
		this.xFond1 = xFond1;
	}



	public void setxFond2(int xFond2) {
		this.xFond2 = xFond2;
	}
	
	
	public int getySol() {
		return ySol;
	}

	public int getHautPlafond() {
		return hauteurPlafond;
	}

		//Methode qui va gerer le deplacement du fond
		public void deplacementFond() {
			if(this.xPos >= 0) {
				this.xPos = this.xPos + this.dx;
				this.xFond1 = this.xFond1 - this.dx;
				this.xFond2 = this.xFond2 - this.dx;
			}

			
			if(this.xFond1 == -800) {  //si toute l'image est à gauche de l'ecran et qu'on ne la voit donc plus
				this.xFond1 = 800;
			}else if(this.xFond2 == -800) {
				this.xFond2 = 800;
			}else if(this.xFond1 == 800) { // pareil pour la gauche de l'ecran
				this.xFond1 = -800;
			}else if(this.xFond2 == 800) {
				this.xFond2 = -800;
			}
		}

	//Methode Java permettant de dessinner
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		//detection contact
				if(this.mario.contactAvant(tuyauRouge1) == true) {
					// si il y'a contact on arrete la marche de mario
					this.mario.setMarche(false);
					// et on arrete egalement le deplacement des objets
					this.dx = 0;
				}
		
		this.deplacementFond();
		// à chaque fois qu'on repeint l'ecran on fait appel a cette methode
		//et si la valeur de DX different de 0 du coups l'absice de ref du fond va etre modifier 
		//et donc on aura l'impression que mario ce deplace 
		this.tuyauRouge1.deplacement();
		
		
		g2.drawImage(this.imgFond1, this.xFond1, 0, null); //Dessin de l'image de fond
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		//on dessine le chateau et le panneau de depart
		g2.drawImage(imgChateau1, 10 - this.xPos, 95, null);
		g2.drawImage(imgDepart, 220 - this.xPos, 234, null);
		//on dessine le tuyau et le chateau
		g2.drawImage(this.tuyauRouge1.getImgTuyauRouge(), this.tuyauRouge1.getX() 
		,this.tuyauRouge1.getY(), null);
		g2.drawImage(this.bloc1.getImgBloc(), this.bloc1.getX() - this.xPos,
		this.bloc1.getY(), null);
		if(this.mario.isSaut()) {g2.drawImage(this.mario.saute(), 
		this.mario.getX(), this.mario.getY(), null);}
		else {g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), 
		this.mario.getY(), null);}
	}
	
	

	
	
	
	
}
