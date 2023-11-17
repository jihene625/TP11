package bowling;

import java.util.Arrays;


public class PartieMonoJoueur {
	Tour[] tours = new Tour[10];

	
	public PartieMonoJoueur() {
		for (int i = 0; i < 9; i++) {
			tours[i] = new Tour();
		}
		tours[tours.length - 1] = new DernierTour();
	}

	
	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		int currentTour = this.numeroTourCourant() - 1;
		if (this.numeroTourCourant() <= 0) {
			throw new IllegalStateException("La partie est déja finie");
		}
		tours[this.numeroTourCourant() - 1].ajouterScolancer(nombreDeQuillesAbattues);
		if (tours[currentTour].getNumLancer() == 0) {
			return false;
		}
		return true;
	}
	
	public int score() {
		Integer[] score = new Integer[10];
		Arrays.fill(score, 0);
		for (int i = 0; i <= tours.length - 2; i++) {
			if (i < 8 && tours[i + 1].getScoreQuillelancer2() == -1) {
				score[i] = tours[i].getTourSco(tours[i + 1].getlancer1(), tours[i + 2].getlancer1());
			} else {
				score[i] = tours[i].getTourSco(tours[i + 1].getlancer1(), tours[i + 1].getlancer2());
			}
			score[tours.length - 1] = tours[tours.length - 1].getTourSco(null, null);
		}
		int scoreTot = 0;
		for (int s : score) {
			scoreTot += s;
		}
		return scoreTot;
	}

	
	public boolean estTerminee() {
		if (this.numeroTourCourant() == 0) {
			return true;
		}
		return false;
	}


	
	public int numeroTourCourant() {
		for (int i = 0; i < tours.length; i++) {
			if (tours[i].getNumLancer() != 0) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public int numeroProchainLancer() {
		return tours[numeroTourCourant() - 1].getNumLancer();
	}

}