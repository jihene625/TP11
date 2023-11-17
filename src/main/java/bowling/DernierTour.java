package bowling;

public class DernierTour extends Tour {
	Lancer lancer3;

	public DernierTour() {
		lancer3 = new Lancer();
	}

	@Override
	public int getTourSco(Lancer l1, Lancer l2) {

		return Math.max(0, getlancer1().getNbQuille()) + Math.max(0, getlancer2().getNbQuille()) + Math.max(0, lancer3.getNbQuille());
	}

	public void ajouterScolancer(int nbQuille) {
		if (this.getNumLancer() == 3) {
			super.ajouterScolancer(nbQuille, lancer3);
		} else {
			super.ajouterScolancer(nbQuille);
		}
	}
	
	@Override
	public int getNumLancer() {
		if (this.getlancer1().getNbQuille() == -1) {
			return 1;
		} else if (this.getlancer2().getNbQuille() == -1 ) {
			return 2;
		} else if (this.lancer3.getNbQuille() == -1 && (this.getlancer1().getNbQuille() + this.getlancer2().getNbQuille()) >=10 ) {
			return 3;
		} else {
			return 0;
		}
	}

	public int getScoreQuilleLancer3(){
		return super.getScoreQuillelancer(lancer3);
	}
}