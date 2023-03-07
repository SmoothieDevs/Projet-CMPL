/*********************************************************************************
 * VARIABLES ET METHODES FOURNIES PAR LA CLASSE UtilLex (cf libClass_Projet)     *
 *       complement à l'ANALYSEUR LEXICAL produit par ANTLR                      *
 *                                                                               *
 *                                                                               *
 *   nom du programme compile, sans suffixe : String UtilLex.nomSource           *
 *   ------------------------                                                    *
 *                                                                               *
 *   attributs lexicaux (selon items figurant dans la grammaire):                *
 *   ------------------                                                          *
 *     int UtilLex.valEnt = valeur du dernier nombre entier lu (item nbentier)   *
 *     int UtilLex.numIdCourant = code du dernier identificateur lu (item ident) *
 *                                                                               *
 *                                                                               *
 *   methodes utiles :                                                           *
 *   ---------------                                                             *
 *     void UtilLex.messErr(String m)  affichage de m et arret compilation       *
 *     String UtilLex.chaineIdent(int numId) delivre l'ident de codage numId     *
 *     void afftabSymb()  affiche la table des symboles                          *
 *********************************************************************************/

/**
 * classe de mise en oeuvre du compilateur
 * =======================================
 * (verifications semantiques + production du code objet)
 * 
 * @author Girard, Masson, Perraudeau
 *
 */

public class PtGen {

	// constantes manipulees par le compilateur
	// ----------------------------------------

	private static final int

	// taille max de la table des symboles
	MAXSYMB = 300,

			// codes MAPILE :
			RESERVER = 1, EMPILER = 2, CONTENUG = 3, AFFECTERG = 4, OU = 5, ET = 6, NON = 7, INF = 8,
			INFEG = 9, SUP = 10, SUPEG = 11, EG = 12, DIFF = 13, ADD = 14, SOUS = 15, MUL = 16, DIV = 17,
			BSIFAUX = 18, BINCOND = 19, LIRENT = 20, LIREBOOL = 21, ECRENT = 22, ECRBOOL = 23,
			ARRET = 24, EMPILERADG = 25, EMPILERADL = 26, CONTENUL = 27, AFFECTERL = 28,
			APPEL = 29, RETOUR = 30,

			// codes des valeurs vrai/faux
			VRAI = 1, FAUX = 0,

			// types permis :
			ENT = 1, BOOL = 2, NEUTRE = 3,

			// categories possibles des identificateurs :
			CONSTANTE = 1, VARGLOBALE = 2, VARLOCALE = 3, PARAMFIXE = 4, PARAMMOD = 5, PROC = 6,
			DEF = 7, REF = 8, PRIVEE = 9,

			// valeurs possible du vecteur de translation
			TRANSDON = 1, TRANSCODE = 2, REFEXT = 3;

	// utilitaires de controle de type
	// -------------------------------
	/**
	 * verification du type entier de l'expression en cours de compilation
	 * (arret de la compilation sinon)
	 */
	private static void verifEnt() {
		if (tCour != ENT)
			UtilLex.messErr("expression entiere attendue");
	}

	/**
	 * verification du type booleen de l'expression en cours de compilation
	 * (arret de la compilation sinon)
	 */
	private static void verifBool() {
		if (tCour != BOOL)
			UtilLex.messErr("expression booleenne attendue");
	}

	// pile pour gerer les chaines de reprise et les branchements en avant
	// -------------------------------------------------------------------

	private static TPileRep pileRep;

	// production du code objet en memoire
	// -----------------------------------

	private static ProgObjet po;

	// COMPILATION SEPAREE
	// -------------------
	//
	/**
	 * modification du vecteur de translation associe au code produit
	 * + incrementation attribut nbTransExt du descripteur
	 * NB: effectue uniquement si c'est une reference externe ou si on compile un
	 * module
	 * 
	 * @param valeur : TRANSDON, TRANSCODE ou REFEXT
	 */
	private static void modifVecteurTrans(int valeur) {
		if (valeur == REFEXT || desc.getUnite().equals("module")) {
			po.vecteurTrans(valeur);
			desc.incrNbTansExt();
		}
	}

	// descripteur associe a un programme objet (compilation separee)
	private static Descripteur desc;

	// autres variables fournies
	// -------------------------

	// MERCI de renseigner ici un nom pour le trinome, constitue EXCLUSIVEMENT DE
	// LETTRES
	public static final String TRINOME = "William STEPHAN Evenn Resnais Badara TALL";

	private static int tCour; // type de l'expression compilee
	private static int vCour; // sert uniquement lors de la compilation d'une valeur (entiere ou boolenne)

	// TABLE DES SYMBOLES
	// ------------------
	//
	private static EltTabSymb[] tabSymb = new EltTabSymb[MAXSYMB + 1];

	// it = indice de remplissage de tabSymb
	// bc = bloc courant (=1 si le bloc courant est le programme principal)
	// info = adresse d'execution du code objet associe a l'ident courant
	private static int it, bc, info, code, cat, type, index;

	/**
	 * utilitaire de recherche de l'ident courant (ayant pour code
	 * UtilLex.numIdCourant) dans tabSymb
	 * 
	 * @param borneInf : recherche de l'indice it vers borneInf (=1 si recherche
	 *                 dans tout tabSymb)
	 * @return : indice de l'ident courant (de code UtilLex.numIdCourant) dans
	 *         tabSymb (O si absence)
	 */
	private static int presentIdent(int borneInf) {
		int i = it;
		while (i >= borneInf && tabSymb[i].code != UtilLex.numIdCourant)
			i--;
		if (i >= borneInf)
			return i;
		else
			return 0;
	}

	/**
	 * utilitaire de placement des caracteristiques d'un nouvel ident dans tabSymb
	 * 
	 * @param code : UtilLex.numIdCourant de l'ident
	 * @param cat  : categorie de l'ident parmi CONSTANTE, VARGLOBALE, PROC, etc.
	 * @param type : ENT, BOOL ou NEUTRE
	 * @param info : valeur pour une constante, ad d'exécution pour une variable,
	 *             etc.
	 */
	private static void placeIdent(int code, int cat, int type, int info) {
		if (it == MAXSYMB)
			UtilLex.messErr("debordement de la table des symboles");
		it = it + 1;
		tabSymb[it] = new EltTabSymb(code, cat, type, info);
	}

	/**
	 * utilitaire d'affichage de la table des symboles
	 */
	private static void afftabSymb() {
		System.out.println("       code           categorie      type    info");
		System.out.println("      |--------------|--------------|-------|----");
		for (int i = 1; i <= it; i++) {
			if (i == bc) {
				System.out.print("bc=");
				Ecriture.ecrireInt(i, 3);
			} else if (i == it) {
				System.out.print("it=");
				Ecriture.ecrireInt(i, 3);
			} else
				Ecriture.ecrireInt(i, 6);
			if (tabSymb[i] == null)
				System.out.println(" reference NULL");
			else
				System.out.println(" " + tabSymb[i]);
		}
		System.out.println();
	}

	/**
	 * initialisations A COMPLETER SI BESOIN
	 * -------------------------------------
	 */
	public static void initialisations() {

		// indices de gestion de la table des symboles
		it = 0; // indice de remplissage de tabSymb
		bc = 1; // bloc courant (=1 si le bloc courant est le programme principal)
		info = 0; // adresse d'execution du code objet associe a l'ident courant
		code = 0; // code de l'ident courant
		cat = 0; // categorie de l'ident courant
		type = 0; // type de l'ident courant
		index = 0; // indice de l'ident courant dans tabSymb
		// pile des reprises pour compilation des branchements en avant
		pileRep = new TPileRep();
		// programme objet = code Mapile de l'unite en cours de compilation
		po = new ProgObjet();
		// COMPILATION SEPAREE: desripteur de l'unite en cours de compilation
		desc = new Descripteur();

		// initialisation necessaire aux attributs lexicaux
		UtilLex.initialisation();

		// initialisation du type de l'expression courante
		tCour = NEUTRE;

	} // initialisations

	/**
	 * code des points de generation A COMPLETER
	 * -----------------------------------------
	 * 
	 * @param numGen : numero du point de generation a executer
	 */
	public static void pt(int numGen) {
		// A RETIRER POUR LE RENDU :
		// Afficher le numero du point de generation a chaque appel de pt pour le
		// debuggage
		System.out.print("NumGen: " + numGen + "\n");
		switch (numGen) {
			case 0:
				initialisations();
				break;

			////// DECLARATION ///////
			case 1:
				// lecture d'un ident pour déclaration d'une constante
				code = UtilLex.numIdCourant;
				break;
			case 2:
				// lecture d'un ident pour déclaration d'une variable
				code = UtilLex.numIdCourant;
				// Recherche de l'ident dans la table des symboles
				if (presentIdent(1) == 0) {
					// Si l'ident n'est pas présent dans la table des symboles
					if (bc > 1) {
						// Si on est dans un bloc
						// On place l'ident dans la table des symboles
						placeIdent(code, VARLOCALE, tCour, info);
						// On incrémente l'adresse d'exécution
						info++;
					} else {
						// Si on est dans le programme principal
						// On place l'ident dans la table des symboles
						placeIdent(code, VARGLOBALE, tCour, info);
						// On incrémente l'adresse d'exécution
						info++;
					}
				} else {
					// Si l'ident est présent dans la table des symboles
					// On affiche un message d'erreur
					UtilLex.messErr("Identifiant déjà déclaré");
				}
				break;
			case 3:
				// Lecture d'un nbentier positif
				tCour = ENT;
				vCour = UtilLex.valEnt;
				break;
			case 4:
				// Lecture d'un nbentier negatif
				tCour = ENT;
				vCour = -UtilLex.valEnt;
				break;
			case 5:
				// Lecture d'un booléen vrai
				tCour = BOOL;
				vCour = VRAI;
				break;
			case 6:
				// lecture d'un booléen faux
				tCour = BOOL;
				vCour = FAUX;
				break;
			case 7:
				// lecture d'une déclaration de type entier
				// On met à jour le type de l'expression courante
				tCour = ENT;
				break;
			case 8:
				// lecture d'une déclaration de type booléen
				// On met à jour le type de l'expression courante
				tCour = BOOL;
				break;
			case 9:
				// lecture d'une déclaration d'une constante
				// Recherche de l'ident dans la table des symboles
				if (presentIdent(1) == 0) {
					// Si l'ident n'est pas présent dans la table des symboles
					// On place l'ident dans la table des symboles
					placeIdent(code, CONSTANTE, tCour, vCour);
				} else {
					// Si l'ident est présent dans la table des symboles
					// On affiche un message d'erreur
					UtilLex.messErr("Constante : " + UtilLex.chaineIdent(UtilLex.numIdCourant) + " déjà déclarée");
				}
				break;
			case 10:
				// Uniquement si programme
				po.produire(RESERVER);
				po.produire(info);
				break;
			case 11: // lecture d'un ident pour affectation (ex : foo := 50)
				index = presentIdent(1);
				if (index == 0) {
					UtilLex.messErr("Identifiant " + UtilLex.chaineIdent(UtilLex.numIdCourant) + " non déclaré");
				}
				// on regarde dans la table des symbole si l'ident est une constante
				if (tabSymb[index].categorie == CONSTANTE) {
					UtilLex.messErr("Affectation impossible sur une constante");
				}
				tCour = tabSymb[index].type;
				// on recupere la categorie de l'ident et on le sauvegarde dans type pour après
				// check le type pour l'affectation
				type = tabSymb[index].type;
				// on recupere la categorie de l'ident
				cat = tabSymb[index].categorie;
				break;
			case 12: // affectation d'un ident
				// on verifie le type de l'expression
				if (type == ENT) {
					verifEnt();
				} else {
					verifBool();
				}
				// on verifie si l'ident est une variable locale ou globale
				switch (cat) {
					case VARLOCALE:
						po.produire(AFFECTERL);
						po.produire(tabSymb[index].info);
						po.produire(0); // Si c'est une variable locale, on empile 0
						break;
					case VARGLOBALE:
						po.produire(AFFECTERG);
						po.produire(tabSymb[index].info);
						break;
					default:
						UtilLex.messErr("Erreur de catégorie");
						break;
				}
				break;
			case 13: // Empiler une valeur entière ou booléenne
				po.produire(EMPILER);
				po.produire(info);
				break;
			case 14: // lecture d'un ident dans l'expression d'une affectation (ex : variable := foo)
				index = presentIdent(1);
				if (index == 0) {
					UtilLex.messErr("Identifiant " + UtilLex.chaineIdent(UtilLex.numIdCourant) + " non déclaré");
				}
				// on met à jour le type de l'expression courante
				tCour = tabSymb[index].type;
				// on regarde dans la table des symbole si l'ident est une constante
				switch (tabSymb[index].categorie) {
					case CONSTANTE:
						// on empile la valeur de la constante
						po.produire(EMPILER);
						po.produire(tabSymb[index].info);
						break;
					case VARLOCALE:
						// on empile la valeur de la variable locale
						po.produire(CONTENUL);
						po.produire(tabSymb[index].info);
						po.produire(0); // Si c'est une variable locale, on empile 0
						break;
					case VARGLOBALE:
						// on empile la valeur de la variable globale
						po.produire(CONTENUG);
						po.produire(tabSymb[index].info);
						break;
					default:
						UtilLex.messErr("Erreur de catégorie");
						break;
				}
				break;
			//////// EXPRESSION ////////
			case 60: // Vérifier que l'expression est de type entier
				verifEnt();
				break;
			case 61: // Vérifier que l'expression est de type booléen
				verifBool();
				break;
			case 62: // Produire un ADD
				po.produire(ADD);
				break;
			case 63: // Produire un SOUS
				po.produire(SOUS);
				break;
			case 64: // Produire un MUL
				po.produire(MUL);
				break;
			case 65: // Produire un DIV
				po.produire(DIV);
				break;
			case 66: // produire un OU
				po.produire(OU);
				tCour = BOOL;
				break;
			case 67: // produire un ET
				po.produire(ET);
				tCour = BOOL;
				break;
			case 68: // produire un NON
				po.produire(NON);
				tCour = BOOL;
				break;
			case 69: // produire un EGAL
				po.produire(EG);
				tCour = BOOL;
				break;
			case 70: // produire un DIFF
				po.produire(DIFF);
				tCour = BOOL;
				break;
			case 71: // produire un SUP
				po.produire(SUP);
				tCour = BOOL;
				break;
			case 72: // produire un SUPEG
				po.produire(SUPEG);
				tCour = BOOL;
				break;
			case 73: // produire un INF
				po.produire(INF);
				tCour = BOOL;
				break;
			case 74: // produire un INFEG
				po.produire(INFEG);
				tCour = BOOL;
				break;
			case 90: // Ecriture
				index = presentIdent(1);
				if (index == 0) {
					UtilLex.messErr("Identifiant " + UtilLex.chaineIdent(UtilLex.numIdCourant) + " non déclaré");
				}
				// on regarde dans la table des symbole si l'ident est un entier ou un booléen
				if (tabSymb[index].type == ENT) {
					po.produire(ECRENT);
				} else {
					po.produire(ECRBOOL);
				}
				break;
			case 100: // Debut d'un bloc
				// On incrémente le bloc courant
				bc++;
				// On met à jour l'adresse d'éxécution
				info = 0;
				break;
			case 101: // Fin d'un bloc
				// On décrémente le bloc courant
				bc--;
				// On met à jour l'adresse d'éxécution
				info = 0;
				break;
			case 255:
				afftabSymb(); // affichage de la table des symboles en fin de compilation
				po.constGen();
				po.constObj();
				break;

			default:
				System.out.println("Point de generation non prevu dans votre liste");
				break;

		}
	}
}
