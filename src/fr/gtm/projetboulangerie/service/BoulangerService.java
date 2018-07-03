package fr.gtm.projetboulangerie.service;

import java.util.ArrayList;

import fr.gtm.projetboulangerie.dao.BoulangerDAO;
import fr.gtm.projetboulangerie.domaine.Beurre;
import fr.gtm.projetboulangerie.domaine.Boulanger;
import fr.gtm.projetboulangerie.domaine.Farine;

public class BoulangerService {

	private BoulangerDAO dao = new BoulangerDAO();;
	
	public void faireCroissant(Boulanger boulanger, Farine farine, Beurre beurre) {
		System.out.println("Je fais un croissant");
	}
	
	public void creerBoulanger(Boulanger boulanger) {
		dao.createBoulanger(boulanger);
	}
	
	public ArrayList<Boulanger> getListeBoulangers() {
		ArrayList<Boulanger> listeBoulangersDemandee = dao.getAllBoulanger();
		return listeBoulangersDemandee;
	}
	
	public Boulanger recupereMonBoulanger(int id) {
		Boulanger boulangerDemande = dao.getBoulangerById(id);
		return boulangerDemande;
	}
	
	public void effacerBoulanger(Boulanger boulanger) {
		dao.deleteBoulanger(boulanger);
	}
	
}
