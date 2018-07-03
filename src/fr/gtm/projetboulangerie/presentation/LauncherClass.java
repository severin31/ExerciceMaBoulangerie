package fr.gtm.projetboulangerie.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import fr.gtm.projetboulangerie.domaine.Boulanger;
import fr.gtm.projetboulangerie.service.BoulangerService;

public class LauncherClass {

	public static void main(String[] args) {

		BoulangerService monBoulangerService = new BoulangerService();
		int id;
		char charChoice;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println();
			System.out.println("Faites votre choix parmi les options suivantes");
			System.out.println("-------------");
			System.out.println("1- Créer un nouveau Boulanger ");
			System.out.println("2- Afficher information sur un boulanger");
			System.out.println("3- Supprimer un boulanger");
			System.out.println("4- Afficher la liste des boulangers enregistrés dans le système");
			System.out.println("q- Quitter");
			charChoice = scanner.nextLine().charAt(0);

			switch (charChoice) {

			case '1':
				System.out.println("Entrez le nom du boulanger.");
				String nom = scanner.nextLine();
				System.out.println("Entrez le prenom du boulanger.");
				String prenom = scanner.nextLine();
				System.out.println("Entrez le specialite du boulanger.");
				String specialite = scanner.nextLine();
				Boulanger monBoulanger1 = new Boulanger(nom, prenom, specialite);
				monBoulangerService.creerBoulanger(monBoulanger1);
				break;

			case '2':
				System.out.println("Veuillez saisir le numéro ID du boulanger à afficher");

				// Demander à l'utilisateur un numéro ID pour afficher boulanger choisi
				id = scanner.nextInt();
				scanner.nextLine(); // vider la ligne

				Boulanger monBoulanger2 = monBoulangerService.recupereMonBoulanger(id);
				System.out.println("On va recuperer et afficher le boulanger" + monBoulanger2.getId());
				System.out.println(monBoulanger2);

				break;

			case '3':
				System.out.println("Entrez le numéro du boulanger à effacer.");
				// supprimer le boulanger
				id = scanner.nextInt();
				scanner.nextLine(); // vider la ligne
				Boulanger monBoulanger3 = monBoulangerService.recupereMonBoulanger(id);
				System.out.println("Le Boulanger numéro " + id + " va etre supprimé");
				monBoulangerService.effacerBoulanger(monBoulanger3);

				break;

			case '4':
				//  Ajouter la requete getAll
				System.out.println("Voici la liste des boulangers à jour");
				ArrayList<Boulanger> listeBoulangers = monBoulangerService.getListeBoulangers();
				for (Boulanger boulanger : listeBoulangers) {
					System.out.println(boulanger);
				}
				break;

			case 'q':
				System.out.println("Aurevoir !");
				break;

			default:
				System.out.println("Je n'ai pas compris votre choix");
			}

		} while (charChoice != 'q');

		scanner.close();

	
	}

}
