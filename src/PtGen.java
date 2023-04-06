import javax.rmi.CORBA.Util;

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

	private static final String
	// Valeur pour le descripteur
	MODULE = "module", PROGRAMME = "programme";

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
	public static final String trinome = "William STEPHAN Evenn Resnais Badara TALL";

	private static int tCour; // type de l'expression compilee
	private static int vCour; // sert uniquement lors de la compilation d'une valeur (entiere ou boolenne)

	// TABLE DES SYMBOLES
	// ------------------
	//
	private static EltTabSymb[] tabSymb = new EltTabSymb[MAXSYMB + 1];

	// it = indice de remplissage de tabSymb
	// bc = bloc courant (=1 si le bloc courant est le programme principal)
	// info = adresse d'execution du code objet associe a l'ident courant
	private static int it, bc, info, code, cat, type, index, infoProc, nbParam, indexProc, nbDef;
	private static String nomFichier;
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

		nbParam = 0; // nombre de parametre d'une procedure
		code = 0; // code de l'ident courant (UtilLex.numIdCourant)
		cat = 0; // categorie de l'ident courant
		type = 0; // type de l'ident courant
		index = 0; // indice de l'ident courant dans tabSymb

		// PROCEDURE
		indexProc = 0; // indice de l'ident courant dans tabSymb dans une procedure
		infoProc = 0; // adresse d'execution du code objet associe a l'ident courant dans une
						// procedure
		// MODULE
		nbDef = 0; // nombre de definition d'une procedure dans un module
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

		nomFichier = "";

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
				// Recherche de l'ident dans la table des symboles
				if (presentIdent(1) == 0) {
					// Si l'ident n'est pas présent dans la table des symboles
					if (bc > 1) {
						// Si on est dans un bloc
						// On place l'ident dans la table des symboles
						placeIdent(UtilLex.numIdCourant, VARLOCALE, tCour, infoProc);
						// On incrémente l'adresse d'exécution
						info++;
					} else {
						// Si on est dans le programme principal
						// On place l'ident dans la table des symboles
						placeIdent(UtilLex.numIdCourant, VARGLOBALE, tCour, info);
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
				if (bc > 1) { // produire RESERVER infoProc que si on est dans une procedure peut importe l'unite
					po.produire(RESERVER);
					po.produire(infoProc);
				} else if (desc.getUnite().equals(PROGRAMME)) { // produire RESERVER info que si on est dans un programme
					po.produire(RESERVER);
					po.produire(info);
				}
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
					case PARAMMOD:
						po.produire(AFFECTERL);
						po.produire(tabSymb[index].info);
						po.produire(1); // Si c'est un paramètre modifiable, on empile 1
						break;
					default:
						UtilLex.messErr("Erreur de catégorie");
						break;
				}
				break;
			case 13: // Empiler une valeur entière ou booléenne (ex : 50 ou true)
				po.produire(EMPILER);
				po.produire(vCour);
				break;
			case 14: // lecture d'un ident dans l'expression d'une affectation (ex : variable := foo)
				int indexExpression = presentIdent(1);
				if (indexExpression == 0) {
					UtilLex.messErr("Identifiant " + UtilLex.chaineIdent(UtilLex.numIdCourant) + " non déclaré");
				}
				// on met à jour le type de l'expression courante
				tCour = tabSymb[indexExpression].type;
				// on regarde dans la table des symbole si l'ident est une constante
				switch (tabSymb[indexExpression].categorie) {
					case CONSTANTE:
						// on empile la valeur de la constante
						po.produire(EMPILER);
						po.produire(tabSymb[indexExpression].info);
						break;
					case PARAMFIXE:
					case VARLOCALE:
						// on empile la valeur de la variable locale
						po.produire(CONTENUL);
						po.produire(tabSymb[indexExpression].info);
						po.produire(0); // Si c'est une variable locale, on empile 0
						break;
					case VARGLOBALE:
						// on empile la valeur de la variable globale
						po.produire(CONTENUG);
						po.produire(tabSymb[indexExpression].info);
						break;
					case PARAMMOD:
						// on empile la valeur du paramètre modifiable
						po.produire(CONTENUL);
						po.produire(tabSymb[indexExpression].info);
						po.produire(1); // Si c'est un paramètre modifiable, on empile 1
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
			//////// INSTRUCTION ////////
			case 75: // lecture d'un case
				verifBool();
				po.produire(BSIFAUX);
				po.produire(0); // on sauvegarde l'adresse de l'instruction à modifier
				// on empile l'adresse de l'instruction à modifier
				pileRep.empiler(po.getIpo());
				pileRep.toString();
				break;
			case 76:// fin de l'instruction d'un case
				po.produire(BINCOND);
				po.modifier(pileRep.depiler(), po.getIpo() + 2);
				po.produire(pileRep.depiler()); // on sauvegarde l'adresse de l'instruction à modifier
				pileRep.empiler(po.getIpo());
				pileRep.toString();
				break;
			case 77: // fin cond
				po.modifier(pileRep.depiler(), po.getIpo() + 1);
				int lastIncond = pileRep.depiler();
				// parcourir la pile pour modifier les adresses des instructions à modifier
				while (po.getElt(lastIncond) != 0) {
					int tmp = po.getElt(lastIncond);
					po.modifier(lastIncond, po.getIpo() + 1);
					lastIncond = tmp;
				}
				po.modifier(lastIncond, po.getIpo() + 1);
				break;
			case 78: // cond
				pileRep.empiler(0);
				pileRep.toString();
				break;
			case 79: // autre
				po.produire(BINCOND);
				po.produire(0); // on sauvegarde l'adresse de l'instruction à modifier
				po.modifier(pileRep.depiler(), po.getIpo() + 1);
				// on empile l'adresse de l'instruction à modifier
				pileRep.empiler(po.getIpo());
				pileRep.toString();
				break;
			case 80: // Après l'expression du si ou après l'expression du ttq ou après l'expression
						// du cond
				// on verifie que l'expression est de type booléen
				verifBool();
				po.produire(BSIFAUX);
				po.produire(0); // on sauvegarde l'adresse de l'instruction à modifier
				// on empile l'adresse de l'instruction à modifier
				pileRep.empiler(po.getIpo());
				break;
			case 81: // Sinon
				po.produire(BINCOND);
				po.produire(0); // on sauvegarde l'adresse de l'instruction à modifier
				po.modifier(pileRep.depiler(), po.getIpo() + 1);
				// on empile l'adresse de l'instruction à modifier
				pileRep.empiler(po.getIpo());
				break;
			case 82: // finSi
				po.modifier(pileRep.depiler(), po.getIpo() + 1);
				break;
			case 83: // TantQue
				pileRep.empiler(po.getIpo() + 1);
				break;
			case 84: // Faits
				po.produire(BINCOND);
				po.modifier(pileRep.depiler(), po.getIpo() + 2);
				po.produire(pileRep.depiler());
				break;
			case 89: // Lecture
				afftabSymb();
				index = presentIdent(1);
				System.out.println(index);
				if (index == 0) {
					UtilLex.messErr("Identifiant " + UtilLex.chaineIdent(UtilLex.numIdCourant) + " non déclaré");
				}
				// on regarde dans la table des symbole si l'ident est une constante
				switch (tabSymb[index].type) {
					case ENT:
						po.produire(LIRENT);
						break;
					case BOOL:
						po.produire(LIREBOOL);
						break;
					default:
						UtilLex.messErr("Erreur de type");
						break;
				}
				// on regarde dans la table des symbole si l'ident est une constante
				switch (tabSymb[index].categorie) {
					case CONSTANTE:
						UtilLex.messErr("Erreur : on ne peut pas affecter une valeur à une constante");
						break;
					case VARLOCALE:
						po.produire(AFFECTERL);
						po.produire(tabSymb[index].info);
						po.produire(0); // Si c'est une variable locale, on empile 0
						break;
					case VARGLOBALE:
						po.produire(AFFECTERG);
						po.produire(tabSymb[index].info);
						break;
					case PARAMMOD:
						po.produire(AFFECTERL);
						po.produire(tabSymb[index].info);
						po.produire(1);
						break;
					default:
						UtilLex.messErr("Erreur de catégorie");
						break;
				}
				break;
			case 90: // Ecriture
				switch (tCour) {
					case ENT:
						po.produire(ECRENT);
						break;
					case BOOL:
						po.produire(ECRBOOL);
						break;
					default:
						UtilLex.messErr("Erreur de type");
						break;
				}
				break;
			case 96: // Paramètre Fixe
				nbParam++;
				break;
			case 97: // début corps

			case 98:
				indexProc = presentIdent(1);
				if (indexProc == 0) {
					UtilLex.messErr("Identifiant " + UtilLex.chaineIdent(UtilLex.numIdCourant) + " non déclaré");
				}
				nbParam = 0;
				break;
			case 99: // Appel de procédure
				if (nbParam != tabSymb[indexProc + 1].info) {
					UtilLex.messErr("Erreur : nombre de paramètres incorrect");
				}
				po.produire(APPEL);
				po.produire(tabSymb[indexProc].info);
				po.produire(tabSymb[indexProc + 1].info);
				break;
			case 100: // Lecture un ident pour appel de procedure
				// on regarde dans la table des symbole si l'ident est déclaré
				index = presentIdent(bc);
				if (index == 0) {
					UtilLex.messErr("Identifiant " + UtilLex.chaineIdent(UtilLex.numIdCourant) + " non déclaré");
				}
				nbParam++;
				// on regarde dans la table des symbole si l'ident est une constante
				switch (tabSymb[index].categorie) {
					case CONSTANTE:
						UtilLex.messErr("Erreur : on ne peut pas affecter une valeur à une constante");
						break;
					case PARAMFIXE:
						UtilLex.messErr("Erreur : on ne peut pas affecter une valeur à un paramètre fixe");
						break;
					case VARLOCALE:
						po.produire(EMPILERADL);
						po.produire(tabSymb[index].info);
						po.produire(0); // Si c'est une variable locale, on empile 0
						break;
					case VARGLOBALE:
						po.produire(EMPILERADG);
						po.produire(tabSymb[index].info);
						break;
					case PARAMMOD:
						po.produire(EMPILERADL);
						po.produire(tabSymb[index].info);
						po.produire(1); // Si c'est un paramètre modifiable, on empile 1
						break;
					default:
						UtilLex.messErr("Erreur de catégorie");
						break;
				}
				break;
			case 101: // Fin d'un bloc de procédure
				// Suppression des variables locales
				it = bc + nbParam - 1;

				// Mise a -1 des indents de parametres
				for (int i = it; i >= bc; i--) {
					tabSymb[i].code = -1;
				}
				bc = 1; // on remet le compteur de bloc à 1 (pour le main)
				po.produire(RETOUR);
				po.produire(nbParam);
				break;
			case 102: // BINCOND pour aller directement au main
				if (desc.getUnite().equals(PROGRAMME)) {
					po.produire(BINCOND);
					po.produire(0); // on sauvegarde l'adresse de l'instruction à modifier
					pileRep.empiler(po.getIpo());
				}
				break;
			case 103: // fin de la déclaration des procs, on modifie le BINCOND pour aller au main
				if (desc.getUnite().equals(PROGRAMME)) {
					po.modifier(pileRep.depiler(), po.getIpo() + 1);
				}
				break;
			case 104: // Déclaration d'une Procedure
				// On regarde si la procédure est déjà déclarée
				index = presentIdent(1);
				if (index != 0 && tabSymb[index].categorie == PROC) {
					UtilLex.messErr("Erreur : la procédure " + UtilLex.chaineIdent(UtilLex.numIdCourant)
							+ " est déjà déclarée");
					break;
				}
				nbDef++; // On incrémente le nombre de procédure déclarées
				// On ajoute la procédure dans la table des symboles
				placeIdent(UtilLex.numIdCourant, PROC, NEUTRE, po.getIpo());
				placeIdent(-1, PRIVEE, NEUTRE, 0);
				pileRep.empiler(it);
				infoProc = 0; // On met à 0 l'adresse d'éxécution des paramètres de la procédure
				nbParam = 0;
				break;

			case 105: // Lecture d'un parametre fixe
				index = presentIdent(bc);
				if (index > 0 && tabSymb[index].categorie == PARAMFIXE) {
					UtilLex.messErr("Erreur : l'identifiant " + UtilLex.chaineIdent(UtilLex.numIdCourant)
							+ " est déjà déclaré");
				}
				// On ajoute l'identifiant dans la table des symboles
				placeIdent(UtilLex.numIdCourant, PARAMFIXE, tCour, infoProc);
				infoProc++;
				nbParam++;
				break;
			case 106:
				index = presentIdent(bc);
				if (index > 0 && tabSymb[index].categorie == PARAMMOD) {
					UtilLex.messErr("Erreur : l'identifiant " + UtilLex.chaineIdent(UtilLex.numIdCourant)
							+ " est déjà déclaré");
				}
				// On ajoute l'identifiant dans la table des symboles
				placeIdent(UtilLex.numIdCourant, PARAMMOD, tCour, infoProc);
				infoProc++;
				nbParam++;
				break;
			case 107: // Fin de la déclaration des paramètres
				// On met à jour l'adresse d'éxécution des paramètres de la procédure
				tabSymb[pileRep.depiler()].info = infoProc;
				bc = it - (nbParam - 1); // On met à jour le bc pour les paramètres (infosProc - 1 car on doit
											// retrourner au premeir paramètre)
				infoProc += 2; // On ajoute 2 pour laisser de la place pour le retour de la procédure pour
								// MAPILE
				break;
			case 110:
				nomFichier = UtilLex.chaineIdent(UtilLex.numIdCourant);
				desc.setUnite(PROGRAMME);
				break;
			case 111:
				desc.setUnite(MODULE);
				break;
			case 112: // Def de procedure
				desc.ajoutDef(UtilLex.chaineIdent(UtilLex.numIdCourant));
				break;
			case 113:
				desc.setTailleCode(po.getIpo());
				desc.setTailleGlobaux(info);
				break;
			case 114:
				if(desc.presentDef(UtilLex.chaineIdent(UtilLex.numIdCourant)) != 0){
					desc.ajoutRef(UtilLex.chaineIdent(UtilLex.numIdCourant));
				}else {
					UtilLex.messErr("Erreur ref non existante : " + UtilLex.chaineIdent(UtilLex.numIdCourant));
				}
				break;
			case 115:
				desc.modifRefNbParam(desc.getNbRef(), desc.getRefNbParam(desc.getNbRef()) + 1);
				break;
			case 254:
				// On vérifie que le nombre de définitions correspond au nombre de procédures
				if (nbDef != desc.getNbDef()) {
					UtilLex.messErr("Erreur : le nombre de définitions ne correspond pas au nombre de procédures");
				}

				System.out.println(desc.toString());
				afftabSymb(); // affichage de la table des symboles en fin de compilation
				po.constGen();
				po.constObj();
				break;
			case 255:
				po.produire(ARRET);
				System.out.println(desc.toString());
				afftabSymb(); // affichage de la table des symboles en fin de compilation
				po.constGen();
				po.constObj();
				desc.ecrireDesc(nomFichier);
				break;

			default:
				System.out.println("Point de generation non prevu dans votre liste");
				break;

		}
	}
}
