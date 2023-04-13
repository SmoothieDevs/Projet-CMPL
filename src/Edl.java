import java.io.*;
import java.util.HashMap;

/**
 * 
 * @author William Stephan, Badara TALL, Evenn RESNAIS
 * @version 2023
 *
 */

public class Edl {

	// nombre max de modules, taille max d'un code objet d'une unite
	static final int MAXMOD = 5, MAXOBJ = 1000;
	// nombres max de references externes (REF) et de points d'entree (DEF)
	// pour une unite
	private static final int MAXREF = 10, MAXDEF = 10;

	// typologie des erreurs
	private static final int FATALE = 0, NONFATALE = 1;

	// valeurs possibles du vecteur de translation
	private static final int TRANSDON = 1, TRANSCODE = 2, REFEXT = 3;

	// table de tous les descripteurs concernes par l'edl
	static Descripteur[] tabDesc = new Descripteur[MAXMOD + 1];

	static int ipo, nMod, nbErr;
	static String nomProg;

	// classe interne pour les elements du dictionnaire des definitions
	static class EltDef {
		String nomProc; // nom de la procedure
		int adPo; // adresse de la procedure
		int nbParam; // nombre de parametres

		EltDef(String nomProc, int adPo, int nbParam) {
			this.nomProc = nomProc;
			this.adPo = adPo;
			this.nbParam = nbParam;
		}
	}

	// Les tableaux necessaires
	static String[] nomUnites = new String[MAXMOD + 1]; // noms des unites
	static int[] tabTransDon = new int[MAXMOD + 1]; // vecteur de translation DON
	static int[] tabTransCode = new int[MAXMOD + 1]; // vecteur de translation CODE
	static EltDef[] dicoDef = new EltDef[60]; // dictionnaire des definitions
	static int indexDico = 0; // index du dictionnaire des definitions
	static int[][] adFinale = new int[MAXMOD + 1][10]; // adresses finales des unites

	// utilitaire de traitement des erreurs
	// ------------------------------------
	static void erreur(int te, String m) {
		System.out.println(m);
		if (te == FATALE) {
			System.out.println("ABANDON DE L'EDITION DE LIENS");
			System.exit(1);
		}
		nbErr = nbErr + 1;
	}

	// utilitaire de recherche dans le dictionnaire des definitions
	// -----------------------------------------------------------
	static int containDico(String nomProc) {
		for (int i = 0; i < indexDico; i++) {
			if (dicoDef[i].nomProc.equals(nomProc))
				return i;
		}
		return -1;
	}

	// utilitaire d'ajout dans le dictionnaire des definitions
	// ------------------------------------------------------
	static void ajouterDico(String nomProc, int adPo, int nbParam) {
		dicoDef[indexDico] = new EltDef(nomProc, adPo, nbParam);
		indexDico = indexDico + 1;
	}

	// utilitaire d'affichage du dictionnaire des definitions
	// -----------------------------------------------------
	static void afficherDico() {
		System.out.println("Dictionnaire des definitions");
		System.out.println("----------------------------");
		System.out.println("Nom Proc\tAdPo\tNb Param");
		System.out.println("----------------------------");
		for (int i = 0; i < indexDico; i++) {
			System.out.println(dicoDef[i].nomProc + "\t\t" + dicoDef[i].adPo + "\t" + dicoDef[i].nbParam);
		}
		System.out.println("----------------------------");
	}

	// utilitaire d'affichage du vecteur de translation
	// -----------------------------------------------
	static void afficherVecteur(int[] tabTrans) {
		System.out.println("Vecteur de translation");
		System.out.println("----------------------");
		System.out.println("Unite\tVecteur");
		System.out.println("----------------------");
		for (int i = 0; i <= nMod; i++) {
			System.out.println(nomUnites[i] + "\t" + tabTrans[i]);
		}
		System.out.println("----------------------");
	}

	// utilitaire d'affichage des adresses finales
	// ------------------------------------------
	static void afficherAdFinale() {
		System.out.println("Adresses finales");
		System.out.println("----------------");
		for (int y = 0; y <= nMod; y++) {
			System.out.print(y + " | ");

			for (int x = 1; x <= tabDesc[y].getNbRef(); x++)
				System.out.print(adFinale[y][x] + " ");

			if (tabDesc[y].getNbRef() == 0)
				System.out.print("Vide ( Pas de réference )");

			System.out.println("");
		}
		System.out.println("----------------");
	}

	// utilitaire de remplissage de la table des descripteurs tabDesc
	// --------------------------------------------------------------
	static void lireDescripteurs() {
		String s;
		System.out.println("les noms doivent etre fournis sans suffixe");
		System.out.print("nom du programme : ");
		s = Lecture.lireString();
		tabDesc[0] = new Descripteur();
		tabDesc[0].lireDesc(s);
		if (!tabDesc[0].getUnite().equals("programme"))
			erreur(FATALE, "programme attendu");
		nomProg = s;

		// on recupere le nom de l'unité
		nomUnites[0] = nomProg;
		nMod = 0;
		// tant que le nom n'est pas vide et que le nombre de modules n'est pas depassé
		while (!s.equals("") && nMod < MAXMOD) {
			System.out.print("nom de module " + (nMod + 1)
					+ " (RC si termine) ");
			s = Lecture.lireString();
			// si le nom n'est pas vide
			if (!s.equals("")) {
				// on incremente le nombre de modules
				nMod = nMod + 1;
				// on recupere le nom de l'unité
				nomUnites[nMod] = s;
				// on cree un nouveau descripteur
				tabDesc[nMod] = new Descripteur();
				tabDesc[nMod].lireDesc(s);
				// on verifie que c'est bien un module sinon on affiche une erreur
				if (!tabDesc[nMod].getUnite().equals("module"))
					erreur(FATALE, "module attendu");
				// on met à jour les tableaux de translation à partir de de l'ancienne table de
				// translation
				tabTransDon[nMod] = tabTransDon[nMod - 1] + tabDesc[nMod - 1].getTailleGlobaux();
				tabTransCode[nMod] = tabTransCode[nMod - 1] + tabDesc[nMod - 1].getTailleCode();
				afficherVecteur(tabTransDon);
				afficherVecteur(tabTransCode);

				for (int i = 1; i <= tabDesc[nMod].getNbDef(); i++) {

					// Si la proc n'est pas dans le dictionnaire
					if (containDico(tabDesc[nMod].getDefNomProc(i)) == -1) {
						// on l'ajoute au dictionnaire
						ajouterDico(tabDesc[nMod].getDefNomProc(i), tabTransCode[nMod] + tabDesc[nMod].getDefAdPo(i),
								tabDesc[nMod].getDefNbParam(i));
					} else { // sinon on affiche une erreur
						erreur(NONFATALE, "Double déclaration de " + tabDesc[nMod].getDefNomProc(i));
					}
				}
				// on affiche le dictionnaire des definitions
				afficherDico();
			}
		}
	}

	static void constMap() {
		// f2 = fichier executable .map construit
		OutputStream f2 = Ecriture.ouvrir(nomProg + ".map");
		if (f2 == null)
			erreur(FATALE, "creation du fichier " + nomProg
					+ ".map impossible");
		// pour construire le code concatene de toutes les unités
		int[] po = new int[(nMod + 1) * MAXOBJ + 1];
		// pour construire le code mnemonique correspondant
		for (int i = 0; i <= nMod; i++) {
			// on recupere le fichier .obj
			InputStream f = Lecture.ouvrir(nomUnites[i] + ".obj");
			if (f == null)
				erreur(FATALE, "ouverture du fichier " + nomUnites[i]
						+ ".obj impossible");

			// On créer une HashMap pour stocker les lignes de code ou il y a des
			// translations
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

			// on rempli la HashMap avec les lignes de code ou il y a des translations
			for (int j = 0; j < tabDesc[i].getNbTransExt(); j++) {
				// on recupere la ligne de code et on ajoute la translation
				// Plus précisément on ajoute comme clé la ligne de code + la translation et
				// comme valeur la ligne de code
				map.put(Lecture.lireInt(f) + tabTransCode[i], Lecture.lireIntln(f));
			}

			// on recupere la taille du code de l'unité
			int taille = tabDesc[i].getTailleCode();
			// compteur de références externes
			int refExt = 0;
			// si c'est la fin du programme on enleve 1 à la taille
			if(nMod == i) taille = taille - 1;

			// on parcourt le code de l'unité
			for (int p = 1; p <= taille; p++) {
				// on recupere l'instruction
				po[ipo] = Lecture.lireIntln(f);
				// si la HashMap contient la ligne de code
				if (map.get(ipo) != null) {
					switch (map.get(ipo).intValue()) {
						case TRANSDON:
							// on ajoute la translation des adresses de donnees
							po[ipo] = po[ipo] + tabTransDon[i];
							break;
						case TRANSCODE:
							// on ajoute la translation des adresses de code
							po[ipo] = po[ipo] + tabTransCode[i];
							break;
						case REFEXT:
							refExt++;
							po[ipo] = adFinale[i][refExt];
							break;
						default:
							break;
					}
				}
				ipo++;
			}
			// on ferme le fichier
			Lecture.fermer(f);
		}
		// Met a jour le nombre de variables globales a reserver
		for(int i = 1; i <= nMod; i++) {
			po[2] = po[2] + tabDesc[i].getTailleGlobaux();
		}

		// on ecrit le fichier .map
		for (int i = 0; i < ipo; i++)
			Ecriture.ecrireStringln(f2, "" + po[i+1]);

		Ecriture.fermer(f2);

		// creation du fichier en mnemonique correspondant
		Mnemo.creerFichier(ipo, po, nomProg + ".ima");
	}

	public static void main(String argv[]) {
		System.out.println("EDITEUR DE LIENS / PROJET LICENCE");
		System.out.println("---------------------------------");
		System.out.println("");
		nbErr = 0; // initialisation du compteur d'erreurs
		tabTransCode[0] = 0; // translation des adresses de code
		tabTransDon[0] = 0; // translation des adresses de donnees
		ipo = 1; // compteur de lignes de code

		// Phase 1 de l'edition de liens : Préparation des translations
		// -----------------------------
		lireDescripteurs();
		int index = 0;
		// On parcourt les modules
		for (int i = 0; i <= nMod; i++) {
			// On parcourt les références
			for (int j = 1; j <= tabDesc[i].getNbRef(); j++) {
				index = containDico(tabDesc[i].getRefNomProc(j));
				if (index == -1) { // si la proc n'est pas dans le dictionnaire
					erreur(NONFATALE, "Référence de " + tabDesc[i].getRefNomProc(j) + " non déclarée");
				} else { // sinon on met à jour la table des adresses finales
					adFinale[i][j] = dicoDef[index].adPo;
				}
			}
		}
		afficherAdFinale();

		// si des erreurs ont ete detectees, on abandonne
		if (nbErr > 0) {
			System.out.println("programme executable non produit");
			System.exit(1);
		}

		// Phase 2 de l'edition de liens : Concatenation des codes objets
		// -----------------------------
		constMap();
		System.out.println("Edition de liens terminee");
	}
}
