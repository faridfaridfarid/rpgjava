package com.farid.jeu;

public class Chrono implements Runnable {

	private final int PAUSE = 3; // temps de 3 miliseconde entre 2 tours de boucle
	
	@Override
	public void run() {
		while(true) {
			//BOUCLE INFINI qui à chaque tour de boucle de 3 miliseconde
			//va repeindre la scene de fonds et l'image de mario
			//en appelant la fonction scene
			Main.scene.repaint();
		
			
			try {
				//mon thread permet de marque ma pause de 3 miliseconde
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {}
		}
		
	}
	
}
