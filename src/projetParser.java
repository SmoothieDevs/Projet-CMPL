// $ANTLR 3.5.2 C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g 2023-04-12 09:21:48
           
import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class projetParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ID", "INT", "ML_COMMENT", 
		"RC", "WS", "'('", "')'", "'*'", "'+'", "','", "'-'", "':'", "':='", "';'", 
		"'<'", "'<='", "'<>'", "'='", "'>'", "'>='", "'alors'", "'aut'", "'bool'", 
		"'cond'", "'const'", "'debut'", "'def'", "'div'", "'ecrire'", "'ent'", 
		"'et'", "'faire'", "'fait'", "'faux'", "'fcond'", "'fin'", "'fixe'", "'fsi'", 
		"'lire'", "'mod'", "'module'", "'non'", "'ou'", "'proc'", "'programme'", 
		"'ref'", "'si'", "'sinon'", "'ttq'", "'var'", "'vrai'"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int COMMENT=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int ML_COMMENT=7;
	public static final int RC=8;
	public static final int WS=9;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public projetParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public projetParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return projetParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g"; }



	 
	// variables globales et methodes utiles a placer ici
	  



	// $ANTLR start "unite"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:37:1: unite : ( unitprog EOF | unitmodule EOF );
	public final void unite() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:37:8: ( unitprog EOF | unitmodule EOF )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==49) ) {
				alt1=1;
			}
			else if ( (LA1_0==45) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:37:12: unitprog EOF
					{
					pushFollow(FOLLOW_unitprog_in_unite64);
					unitprog();
					state._fsp--;

					PtGen.pt(255);
					match(input,EOF,FOLLOW_EOF_in_unite68); 
					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:38:12: unitmodule EOF
					{
					pushFollow(FOLLOW_unitmodule_in_unite81);
					unitmodule();
					state._fsp--;

					PtGen.pt(254);
					match(input,EOF,FOLLOW_EOF_in_unite85); 
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unite"



	// $ANTLR start "unitprog"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:41:1: unitprog : 'programme' ident ':' declarations corps ;
	public final void unitprog() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:42:3: ( 'programme' ident ':' declarations corps )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:42:5: 'programme' ident ':' declarations corps
			{
			match(input,49,FOLLOW_49_in_unitprog100); 
			pushFollow(FOLLOW_ident_in_unitprog102);
			ident();
			state._fsp--;

			match(input,16,FOLLOW_16_in_unitprog104); 
			PtGen.pt(110);
			pushFollow(FOLLOW_declarations_in_unitprog114);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_corps_in_unitprog123);
			corps();
			state._fsp--;

			 System.out.println("succes, arret de la compilation "); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitprog"



	// $ANTLR start "unitmodule"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:47:1: unitmodule : 'module' ident ':' declarations ;
	public final void unitmodule() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:48:3: ( 'module' ident ':' declarations )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:48:5: 'module' ident ':' declarations
			{
			match(input,45,FOLLOW_45_in_unitmodule140); 
			pushFollow(FOLLOW_ident_in_unitmodule142);
			ident();
			state._fsp--;

			match(input,16,FOLLOW_16_in_unitmodule144); 
			PtGen.pt(111);
			pushFollow(FOLLOW_declarations_in_unitmodule154);
			declarations();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitmodule"



	// $ANTLR start "declarations"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:52:1: declarations : ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? ;
	public final void declarations() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:3: ( ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:5: ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )?
			{
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:5: ( partiedef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==31) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:5: partiedef
					{
					pushFollow(FOLLOW_partiedef_in_declarations172);
					partiedef();
					state._fsp--;

					}
					break;

			}

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:16: ( partieref )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==50) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:16: partieref
					{
					pushFollow(FOLLOW_partieref_in_declarations175);
					partieref();
					state._fsp--;

					}
					break;

			}

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:27: ( consts )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==29) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:27: consts
					{
					pushFollow(FOLLOW_consts_in_declarations178);
					consts();
					state._fsp--;

					}
					break;

			}

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:35: ( vars )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==54) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:35: vars
					{
					pushFollow(FOLLOW_vars_in_declarations181);
					vars();
					state._fsp--;

					}
					break;

			}

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:41: ( decprocs )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==48) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:53:41: decprocs
					{
					pushFollow(FOLLOW_decprocs_in_declarations184);
					decprocs();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(113);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "partiedef"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:56:1: partiedef : 'def' ident ( ',' ident )* ptvg ;
	public final void partiedef() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:57:3: ( 'def' ident ( ',' ident )* ptvg )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:57:5: 'def' ident ( ',' ident )* ptvg
			{
			match(input,31,FOLLOW_31_in_partiedef202); 
			pushFollow(FOLLOW_ident_in_partiedef204);
			ident();
			state._fsp--;

			PtGen.pt(112);
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:57:35: ( ',' ident )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==14) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:57:36: ',' ident
					{
					match(input,14,FOLLOW_14_in_partiedef210); 
					pushFollow(FOLLOW_ident_in_partiedef212);
					ident();
					state._fsp--;

					PtGen.pt(112);
					}
					break;

				default :
					break loop7;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partiedef219);
			ptvg();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partiedef"



	// $ANTLR start "partieref"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:60:1: partieref : 'ref' specif ( ',' specif )* ptvg ;
	public final void partieref() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:60:10: ( 'ref' specif ( ',' specif )* ptvg )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:60:12: 'ref' specif ( ',' specif )* ptvg
			{
			match(input,50,FOLLOW_50_in_partieref231); 
			pushFollow(FOLLOW_specif_in_partieref234);
			specif();
			state._fsp--;

			PtGen.pt(116);
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:60:43: ( ',' specif )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==14) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:60:44: ',' specif
					{
					match(input,14,FOLLOW_14_in_partieref239); 
					pushFollow(FOLLOW_specif_in_partieref241);
					specif();
					state._fsp--;

					PtGen.pt(116);
					}
					break;

				default :
					break loop8;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partieref248);
			ptvg();
			state._fsp--;

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partieref"



	// $ANTLR start "specif"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:63:1: specif : ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? ;
	public final void specif() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:63:9: ( ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:63:11: ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )?
			{
			pushFollow(FOLLOW_ident_in_specif262);
			ident();
			state._fsp--;

			PtGen.pt(114);
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:63:34: ( 'fixe' '(' type ( ',' type )* ')' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==41) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:63:36: 'fixe' '(' type ( ',' type )* ')'
					{
					match(input,41,FOLLOW_41_in_specif268); 
					match(input,10,FOLLOW_10_in_specif270); 
					pushFollow(FOLLOW_type_in_specif272);
					type();
					state._fsp--;

					PtGen.pt(115);
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:63:69: ( ',' type )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==14) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:63:71: ',' type
							{
							match(input,14,FOLLOW_14_in_specif278); 
							pushFollow(FOLLOW_type_in_specif280);
							type();
							state._fsp--;

							PtGen.pt(115);
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,11,FOLLOW_11_in_specif288); 
					}
					break;

			}

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:64:18: ( 'mod' '(' type ( ',' type )* ')' )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==44) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:64:20: 'mod' '(' type ( ',' type )* ')'
					{
					match(input,44,FOLLOW_44_in_specif313); 
					match(input,10,FOLLOW_10_in_specif316); 
					pushFollow(FOLLOW_type_in_specif318);
					type();
					state._fsp--;

					PtGen.pt(115);
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:64:53: ( ',' type )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==14) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:64:55: ',' type
							{
							match(input,14,FOLLOW_14_in_specif324); 
							pushFollow(FOLLOW_type_in_specif326);
							type();
							state._fsp--;

							PtGen.pt(115);
							}
							break;

						default :
							break loop11;
						}
					}

					match(input,11,FOLLOW_11_in_specif333); 
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "specif"



	// $ANTLR start "consts"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:67:1: consts : 'const' ( ident '=' valeur ptvg )+ ;
	public final void consts() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:67:9: ( 'const' ( ident '=' valeur ptvg )+ )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:67:11: 'const' ( ident '=' valeur ptvg )+
			{
			match(input,29,FOLLOW_29_in_consts352); 
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:67:19: ( ident '=' valeur ptvg )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==ID) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:67:21: ident '=' valeur ptvg
					{
					pushFollow(FOLLOW_ident_in_consts356);
					ident();
					state._fsp--;

					PtGen.pt(1);
					match(input,22,FOLLOW_22_in_consts361); 
					pushFollow(FOLLOW_valeur_in_consts363);
					valeur();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_consts365);
					ptvg();
					state._fsp--;

					PtGen.pt(9);
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "consts"



	// $ANTLR start "vars"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:70:1: vars : 'var' ( type ident ( ',' ident )* ptvg )+ ;
	public final void vars() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:70:7: ( 'var' ( type ident ( ',' ident )* ptvg )+ )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:70:9: 'var' ( type ident ( ',' ident )* ptvg )+
			{
			match(input,54,FOLLOW_54_in_vars385); 
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:70:15: ( type ident ( ',' ident )* ptvg )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==27||LA15_0==34) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:70:17: type ident ( ',' ident )* ptvg
					{
					pushFollow(FOLLOW_type_in_vars389);
					type();
					state._fsp--;

					pushFollow(FOLLOW_ident_in_vars391);
					ident();
					state._fsp--;

					PtGen.pt(2);
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:70:43: ( ',' ident )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==14) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:70:45: ',' ident
							{
							match(input,14,FOLLOW_14_in_vars397); 
							pushFollow(FOLLOW_ident_in_vars400);
							ident();
							state._fsp--;

							PtGen.pt(2);
							}
							break;

						default :
							break loop14;
						}
					}

					pushFollow(FOLLOW_ptvg_in_vars407);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			PtGen.pt(10);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "vars"



	// $ANTLR start "type"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:73:1: type : ( 'ent' | 'bool' );
	public final void type() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:73:7: ( 'ent' | 'bool' )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==34) ) {
				alt16=1;
			}
			else if ( (LA16_0==27) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:73:9: 'ent'
					{
					match(input,34,FOLLOW_34_in_type428); 
					PtGen.pt(7);
					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:74:9: 'bool'
					{
					match(input,27,FOLLOW_27_in_type443); 
					PtGen.pt(8);
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "decprocs"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:77:1: decprocs : ( decproc ptvg )+ ;
	public final void decprocs() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:77:9: ( ( decproc ptvg )+ )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:77:11: ( decproc ptvg )+
			{
			PtGen.pt(102);
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:77:28: ( decproc ptvg )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==48) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:77:29: decproc ptvg
					{
					pushFollow(FOLLOW_decproc_in_decprocs460);
					decproc();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_decprocs462);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			PtGen.pt(103);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decprocs"



	// $ANTLR start "decproc"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:80:1: decproc : 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps ;
	public final void decproc() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:80:9: ( 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:80:12: 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps
			{
			match(input,48,FOLLOW_48_in_decproc480); 
			pushFollow(FOLLOW_ident_in_decproc483);
			ident();
			state._fsp--;

			PtGen.pt(104);
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:80:43: ( parfixe )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==41) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:80:43: parfixe
					{
					pushFollow(FOLLOW_parfixe_in_decproc487);
					parfixe();
					state._fsp--;

					}
					break;

			}

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:80:52: ( parmod )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==44) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:80:52: parmod
					{
					pushFollow(FOLLOW_parmod_in_decproc490);
					parmod();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(107);
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:80:77: ( consts )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==29) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:80:77: consts
					{
					pushFollow(FOLLOW_consts_in_decproc495);
					consts();
					state._fsp--;

					}
					break;

			}

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:80:85: ( vars )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==54) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:80:85: vars
					{
					pushFollow(FOLLOW_vars_in_decproc498);
					vars();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_corps_in_decproc501);
			corps();
			state._fsp--;

			PtGen.pt(101);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decproc"



	// $ANTLR start "ptvg"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:83:1: ptvg : ( ';' |);
	public final void ptvg() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:83:7: ( ';' |)
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==18) ) {
				alt22=1;
			}
			else if ( (LA22_0==EOF||LA22_0==ID||LA22_0==27||(LA22_0 >= 29 && LA22_0 <= 30)||LA22_0==34||LA22_0==48||LA22_0==50||LA22_0==54) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:83:9: ';'
					{
					match(input,18,FOLLOW_18_in_ptvg517); 
					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:85:3: 
					{
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ptvg"



	// $ANTLR start "corps"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:87:1: corps : 'debut' instructions 'fin' ;
	public final void corps() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:87:7: ( 'debut' instructions 'fin' )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:87:9: 'debut' instructions 'fin'
			{
			match(input,30,FOLLOW_30_in_corps535); 
			pushFollow(FOLLOW_instructions_in_corps537);
			instructions();
			state._fsp--;

			match(input,40,FOLLOW_40_in_corps539); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "corps"



	// $ANTLR start "parfixe"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:90:1: parfixe : 'fixe' '(' pf ( ';' pf )* ')' ;
	public final void parfixe() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:90:8: ( 'fixe' '(' pf ( ';' pf )* ')' )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:90:10: 'fixe' '(' pf ( ';' pf )* ')'
			{
			match(input,41,FOLLOW_41_in_parfixe551); 
			match(input,10,FOLLOW_10_in_parfixe553); 
			pushFollow(FOLLOW_pf_in_parfixe555);
			pf();
			state._fsp--;

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:90:23: ( ';' pf )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==18) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:90:25: ';' pf
					{
					match(input,18,FOLLOW_18_in_parfixe558); 
					pushFollow(FOLLOW_pf_in_parfixe560);
					pf();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			match(input,11,FOLLOW_11_in_parfixe565); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parfixe"



	// $ANTLR start "pf"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:93:1: pf : type ident ( ',' ident )* ;
	public final void pf() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:93:5: ( type ident ( ',' ident )* )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:93:7: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pf579);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pf581);
			ident();
			state._fsp--;

			PtGen.pt(105);
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:93:35: ( ',' ident )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==14) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:93:37: ',' ident
					{
					match(input,14,FOLLOW_14_in_pf587); 
					pushFollow(FOLLOW_ident_in_pf589);
					ident();
					state._fsp--;

					PtGen.pt(105);
					}
					break;

				default :
					break loop24;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pf"



	// $ANTLR start "parmod"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:96:1: parmod : 'mod' '(' pm ( ';' pm )* ')' ;
	public final void parmod() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:96:9: ( 'mod' '(' pm ( ';' pm )* ')' )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:96:11: 'mod' '(' pm ( ';' pm )* ')'
			{
			match(input,44,FOLLOW_44_in_parmod608); 
			match(input,10,FOLLOW_10_in_parmod610); 
			pushFollow(FOLLOW_pm_in_parmod612);
			pm();
			state._fsp--;

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:96:24: ( ';' pm )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==18) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:96:26: ';' pm
					{
					match(input,18,FOLLOW_18_in_parmod616); 
					pushFollow(FOLLOW_pm_in_parmod618);
					pm();
					state._fsp--;

					}
					break;

				default :
					break loop25;
				}
			}

			match(input,11,FOLLOW_11_in_parmod622); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parmod"



	// $ANTLR start "pm"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:99:1: pm : type ident ( ',' ident )* ;
	public final void pm() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:99:5: ( type ident ( ',' ident )* )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:99:7: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pm636);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pm638);
			ident();
			state._fsp--;

			PtGen.pt(106);
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:99:36: ( ',' ident )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==14) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:99:38: ',' ident
					{
					match(input,14,FOLLOW_14_in_pm645); 
					pushFollow(FOLLOW_ident_in_pm647);
					ident();
					state._fsp--;

					PtGen.pt(106);
					}
					break;

				default :
					break loop26;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pm"



	// $ANTLR start "instructions"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:102:1: instructions : instruction ( ';' instruction )* ;
	public final void instructions() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:103:3: ( instruction ( ';' instruction )* )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:103:5: instruction ( ';' instruction )*
			{
			pushFollow(FOLLOW_instruction_in_instructions668);
			instruction();
			state._fsp--;

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:103:17: ( ';' instruction )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==18) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:103:19: ';' instruction
					{
					match(input,18,FOLLOW_18_in_instructions672); 
					pushFollow(FOLLOW_instruction_in_instructions674);
					instruction();
					state._fsp--;

					}
					break;

				default :
					break loop27;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instructions"



	// $ANTLR start "instruction"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:106:1: instruction : ( inssi | inscond | boucle | lecture | ecriture | affouappel |);
	public final void instruction() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:107:3: ( inssi | inscond | boucle | lecture | ecriture | affouappel |)
			int alt28=7;
			switch ( input.LA(1) ) {
			case 51:
				{
				alt28=1;
				}
				break;
			case 28:
				{
				alt28=2;
				}
				break;
			case 53:
				{
				alt28=3;
				}
				break;
			case 43:
				{
				alt28=4;
				}
				break;
			case 33:
				{
				alt28=5;
				}
				break;
			case ID:
				{
				alt28=6;
				}
				break;
			case 14:
			case 18:
			case 26:
			case 37:
			case 39:
			case 40:
			case 42:
			case 52:
				{
				alt28=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:107:5: inssi
					{
					pushFollow(FOLLOW_inssi_in_instruction691);
					inssi();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:108:5: inscond
					{
					pushFollow(FOLLOW_inscond_in_instruction697);
					inscond();
					state._fsp--;

					}
					break;
				case 3 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:109:5: boucle
					{
					pushFollow(FOLLOW_boucle_in_instruction703);
					boucle();
					state._fsp--;

					}
					break;
				case 4 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:110:5: lecture
					{
					pushFollow(FOLLOW_lecture_in_instruction709);
					lecture();
					state._fsp--;

					}
					break;
				case 5 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:111:5: ecriture
					{
					pushFollow(FOLLOW_ecriture_in_instruction715);
					ecriture();
					state._fsp--;

					}
					break;
				case 6 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:112:5: affouappel
					{
					pushFollow(FOLLOW_affouappel_in_instruction721);
					affouappel();
					state._fsp--;

					}
					break;
				case 7 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:114:3: 
					{
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instruction"



	// $ANTLR start "inssi"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:116:1: inssi : 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' ;
	public final void inssi() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:116:7: ( 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:116:9: 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi'
			{
			match(input,51,FOLLOW_51_in_inssi738); 
			pushFollow(FOLLOW_expression_in_inssi740);
			expression();
			state._fsp--;

			PtGen.pt(80);
			match(input,25,FOLLOW_25_in_inssi744); 
			pushFollow(FOLLOW_instructions_in_inssi746);
			instructions();
			state._fsp--;

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:116:63: ( 'sinon' instructions )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==52) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:116:65: 'sinon' instructions
					{
					PtGen.pt(81);
					match(input,52,FOLLOW_52_in_inssi753); 
					pushFollow(FOLLOW_instructions_in_inssi756);
					instructions();
					state._fsp--;

					}
					break;

			}

			match(input,42,FOLLOW_42_in_inssi760); 
			PtGen.pt(82);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inssi"



	// $ANTLR start "inscond"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:119:1: inscond : 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' ;
	public final void inscond() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:119:9: ( 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:119:11: 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond'
			{
			match(input,28,FOLLOW_28_in_inscond775); 
			PtGen.pt(78);
			pushFollow(FOLLOW_expression_in_inscond779);
			expression();
			state._fsp--;

			PtGen.pt(75);
			match(input,16,FOLLOW_16_in_inscond783); 
			pushFollow(FOLLOW_instructions_in_inscond785);
			instructions();
			state._fsp--;

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:120:11: ( ',' expression ':' instructions )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==14) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:120:12: ',' expression ':' instructions
					{
					match(input,14,FOLLOW_14_in_inscond799); 
					PtGen.pt(76);
					pushFollow(FOLLOW_expression_in_inscond803);
					expression();
					state._fsp--;

					PtGen.pt(75);
					match(input,16,FOLLOW_16_in_inscond807); 
					pushFollow(FOLLOW_instructions_in_inscond809);
					instructions();
					state._fsp--;

					}
					break;

				default :
					break loop30;
				}
			}

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:121:11: ( 'aut' instructions |)
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==26) ) {
				alt31=1;
			}
			else if ( (LA31_0==39) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:121:12: 'aut' instructions
					{
					PtGen.pt(79);
					match(input,26,FOLLOW_26_in_inscond829); 
					pushFollow(FOLLOW_instructions_in_inscond832);
					instructions();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:121:51: 
					{
					}
					break;

			}

			PtGen.pt(77);
			match(input,39,FOLLOW_39_in_inscond852); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inscond"



	// $ANTLR start "boucle"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:125:1: boucle : 'ttq' expression 'faire' instructions 'fait' ;
	public final void boucle() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:125:9: ( 'ttq' expression 'faire' instructions 'fait' )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:125:11: 'ttq' expression 'faire' instructions 'fait'
			{
			match(input,53,FOLLOW_53_in_boucle867); 
			PtGen.pt(83);
			pushFollow(FOLLOW_expression_in_boucle872);
			expression();
			state._fsp--;

			PtGen.pt(80);
			match(input,36,FOLLOW_36_in_boucle876); 
			pushFollow(FOLLOW_instructions_in_boucle878);
			instructions();
			state._fsp--;

			match(input,37,FOLLOW_37_in_boucle880); 
			PtGen.pt(84);
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "boucle"



	// $ANTLR start "lecture"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:128:1: lecture : 'lire' '(' ident ( ',' ident )* ')' ;
	public final void lecture() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:128:8: ( 'lire' '(' ident ( ',' ident )* ')' )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:128:10: 'lire' '(' ident ( ',' ident )* ')'
			{
			match(input,43,FOLLOW_43_in_lecture894); 
			match(input,10,FOLLOW_10_in_lecture896); 
			pushFollow(FOLLOW_ident_in_lecture898);
			ident();
			state._fsp--;

			PtGen.pt(89);
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:128:43: ( ',' ident )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==14) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:128:45: ',' ident
					{
					match(input,14,FOLLOW_14_in_lecture904); 
					pushFollow(FOLLOW_ident_in_lecture906);
					ident();
					state._fsp--;

					PtGen.pt(89);
					}
					break;

				default :
					break loop32;
				}
			}

			match(input,11,FOLLOW_11_in_lecture913); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lecture"



	// $ANTLR start "ecriture"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:131:1: ecriture : 'ecrire' '(' expression ( ',' expression )* ')' ;
	public final void ecriture() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:131:9: ( 'ecrire' '(' expression ( ',' expression )* ')' )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:131:11: 'ecrire' '(' expression ( ',' expression )* ')'
			{
			match(input,33,FOLLOW_33_in_ecriture926); 
			match(input,10,FOLLOW_10_in_ecriture928); 
			pushFollow(FOLLOW_expression_in_ecriture930);
			expression();
			state._fsp--;

			PtGen.pt(90);
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:131:51: ( ',' expression )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==14) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:131:53: ',' expression
					{
					match(input,14,FOLLOW_14_in_ecriture936); 
					pushFollow(FOLLOW_expression_in_ecriture938);
					expression();
					state._fsp--;

					PtGen.pt(90);
					}
					break;

				default :
					break loop33;
				}
			}

			match(input,11,FOLLOW_11_in_ecriture946); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ecriture"



	// $ANTLR start "affouappel"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:134:1: affouappel : ident ( ':=' expression | ( effixes ( effmods )? )? ) ;
	public final void affouappel() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:134:11: ( ident ( ':=' expression | ( effixes ( effmods )? )? ) )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:135:3: ident ( ':=' expression | ( effixes ( effmods )? )? )
			{
			pushFollow(FOLLOW_ident_in_affouappel962);
			ident();
			state._fsp--;

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:135:11: ( ':=' expression | ( effixes ( effmods )? )? )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==17) ) {
				alt36=1;
			}
			else if ( (LA36_0==10||LA36_0==14||LA36_0==18||LA36_0==26||LA36_0==37||(LA36_0 >= 39 && LA36_0 <= 40)||LA36_0==42||LA36_0==52) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:135:13: ':=' expression
					{
					PtGen.pt(11);
					match(input,17,FOLLOW_17_in_affouappel972); 
					pushFollow(FOLLOW_expression_in_affouappel974);
					expression();
					state._fsp--;

					PtGen.pt(12);
					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:136:15: ( effixes ( effmods )? )?
					{
					PtGen.pt(98);
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:136:31: ( effixes ( effmods )? )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==10) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:136:32: effixes ( effmods )?
							{
							pushFollow(FOLLOW_effixes_in_affouappel995);
							effixes();
							state._fsp--;

							// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:136:40: ( effmods )?
							int alt34=2;
							int LA34_0 = input.LA(1);
							if ( (LA34_0==10) ) {
								alt34=1;
							}
							switch (alt34) {
								case 1 :
									// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:136:41: effmods
									{
									pushFollow(FOLLOW_effmods_in_affouappel998);
									effmods();
									state._fsp--;

									}
									break;

							}

							}
							break;

					}

					PtGen.pt(99);
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "affouappel"



	// $ANTLR start "effixes"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:140:1: effixes : '(' ( expression ( ',' expression )* )? ')' ;
	public final void effixes() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:140:9: ( '(' ( expression ( ',' expression )* )? ')' )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:140:11: '(' ( expression ( ',' expression )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effixes1032); 
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:140:15: ( expression ( ',' expression )* )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( ((LA38_0 >= ID && LA38_0 <= INT)||LA38_0==10||LA38_0==13||LA38_0==15||LA38_0==38||LA38_0==46||LA38_0==55) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:140:16: expression ( ',' expression )*
					{
					pushFollow(FOLLOW_expression_in_effixes1035);
					expression();
					state._fsp--;

					PtGen.pt(96);
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:140:43: ( ',' expression )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==14) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:140:44: ',' expression
							{
							match(input,14,FOLLOW_14_in_effixes1040); 
							pushFollow(FOLLOW_expression_in_effixes1042);
							expression();
							state._fsp--;

							PtGen.pt(96);
							}
							break;

						default :
							break loop37;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effixes1051); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effixes"



	// $ANTLR start "effmods"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:143:1: effmods : '(' ( ident ( ',' ident )* )? ')' ;
	public final void effmods() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:143:9: ( '(' ( ident ( ',' ident )* )? ')' )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:143:10: '(' ( ident ( ',' ident )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effmods1063); 
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:143:14: ( ident ( ',' ident )* )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==ID) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:143:15: ident ( ',' ident )*
					{
					pushFollow(FOLLOW_ident_in_effmods1066);
					ident();
					state._fsp--;

					PtGen.pt(100);
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:143:38: ( ',' ident )*
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==14) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:143:39: ',' ident
							{
							match(input,14,FOLLOW_14_in_effmods1071); 
							pushFollow(FOLLOW_ident_in_effmods1073);
							ident();
							state._fsp--;

							PtGen.pt(100);
							}
							break;

						default :
							break loop39;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effmods1082); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effmods"



	// $ANTLR start "expression"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:146:1: expression : ( exp1 ) ( 'ou' exp1 )* ;
	public final void expression() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:146:11: ( ( exp1 ) ( 'ou' exp1 )* )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:146:13: ( exp1 ) ( 'ou' exp1 )*
			{
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:146:13: ( exp1 )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:146:14: exp1
			{
			pushFollow(FOLLOW_exp1_in_expression1096);
			exp1();
			state._fsp--;

			}

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:146:20: ( 'ou' exp1 )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==47) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:146:21: 'ou' exp1
					{
					match(input,47,FOLLOW_47_in_expression1100); 
					PtGen.pt(61);
					pushFollow(FOLLOW_exp1_in_expression1104);
					exp1();
					state._fsp--;

					PtGen.pt(61);
					PtGen.pt(66);
					}
					break;

				default :
					break loop41;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "exp1"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:149:1: exp1 : exp2 ( 'et' exp2 )* ;
	public final void exp1() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:149:7: ( exp2 ( 'et' exp2 )* )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:149:9: exp2 ( 'et' exp2 )*
			{
			pushFollow(FOLLOW_exp2_in_exp11124);
			exp2();
			state._fsp--;

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:149:14: ( 'et' exp2 )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==35) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:149:15: 'et' exp2
					{
					match(input,35,FOLLOW_35_in_exp11127); 
					PtGen.pt(61);
					pushFollow(FOLLOW_exp2_in_exp11131);
					exp2();
					state._fsp--;

					PtGen.pt(61);
					PtGen.pt(67);
					}
					break;

				default :
					break loop42;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp1"



	// $ANTLR start "exp2"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:152:1: exp2 : ( 'non' exp2 | exp3 );
	public final void exp2() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:152:7: ( 'non' exp2 | exp3 )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==46) ) {
				alt43=1;
			}
			else if ( ((LA43_0 >= ID && LA43_0 <= INT)||LA43_0==10||LA43_0==13||LA43_0==15||LA43_0==38||LA43_0==55) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:152:9: 'non' exp2
					{
					match(input,46,FOLLOW_46_in_exp21151); 
					pushFollow(FOLLOW_exp2_in_exp21153);
					exp2();
					state._fsp--;

					PtGen.pt(61);
					PtGen.pt(68);
					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:153:5: exp3
					{
					pushFollow(FOLLOW_exp3_in_exp21163);
					exp3();
					state._fsp--;

					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp2"



	// $ANTLR start "exp3"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:156:1: exp3 : exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? ;
	public final void exp3() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:156:7: ( exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:156:9: exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			{
			pushFollow(FOLLOW_exp4_in_exp31179);
			exp4();
			state._fsp--;

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:157:3: ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			int alt44=7;
			switch ( input.LA(1) ) {
				case 22:
					{
					alt44=1;
					}
					break;
				case 21:
					{
					alt44=2;
					}
					break;
				case 23:
					{
					alt44=3;
					}
					break;
				case 24:
					{
					alt44=4;
					}
					break;
				case 19:
					{
					alt44=5;
					}
					break;
				case 20:
					{
					alt44=6;
					}
					break;
			}
			switch (alt44) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:157:5: '=' exp4
					{
					match(input,22,FOLLOW_22_in_exp31186); 
					PtGen.pt(60);
					pushFollow(FOLLOW_exp4_in_exp31191);
					exp4();
					state._fsp--;

					PtGen.pt(60);
					PtGen.pt(69);
					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:158:5: '<>' exp4
					{
					match(input,21,FOLLOW_21_in_exp31200); 
					PtGen.pt(60);
					pushFollow(FOLLOW_exp4_in_exp31204);
					exp4();
					state._fsp--;

					PtGen.pt(60);
					PtGen.pt(70);
					}
					break;
				case 3 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:159:5: '>' exp4
					{
					match(input,23,FOLLOW_23_in_exp31213); 
					PtGen.pt(60);
					pushFollow(FOLLOW_exp4_in_exp31218);
					exp4();
					state._fsp--;

					PtGen.pt(60);
					PtGen.pt(71);
					}
					break;
				case 4 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:160:5: '>=' exp4
					{
					match(input,24,FOLLOW_24_in_exp31227); 
					PtGen.pt(60);
					pushFollow(FOLLOW_exp4_in_exp31231);
					exp4();
					state._fsp--;

					PtGen.pt(60);
					PtGen.pt(72);
					}
					break;
				case 5 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:161:5: '<' exp4
					{
					match(input,19,FOLLOW_19_in_exp31240); 
					PtGen.pt(60);
					pushFollow(FOLLOW_exp4_in_exp31245);
					exp4();
					state._fsp--;

					PtGen.pt(60);
					PtGen.pt(73);
					}
					break;
				case 6 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:162:5: '<=' exp4
					{
					match(input,20,FOLLOW_20_in_exp31254); 
					PtGen.pt(60);
					pushFollow(FOLLOW_exp4_in_exp31258);
					exp4();
					state._fsp--;

					PtGen.pt(60);
					PtGen.pt(74);
					}
					break;

			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp3"



	// $ANTLR start "exp4"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:166:1: exp4 : exp5 ( '+' exp5 | '-' exp5 )* ;
	public final void exp4() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:166:7: ( exp5 ( '+' exp5 | '-' exp5 )* )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:166:9: exp5 ( '+' exp5 | '-' exp5 )*
			{
			pushFollow(FOLLOW_exp5_in_exp41283);
			exp5();
			state._fsp--;

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:167:9: ( '+' exp5 | '-' exp5 )*
			loop45:
			while (true) {
				int alt45=3;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==13) ) {
					alt45=1;
				}
				else if ( (LA45_0==15) ) {
					alt45=2;
				}

				switch (alt45) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:167:10: '+' exp5
					{
					match(input,13,FOLLOW_13_in_exp41295); 
					PtGen.pt(60);
					pushFollow(FOLLOW_exp5_in_exp41299);
					exp5();
					state._fsp--;

					PtGen.pt(60);
					PtGen.pt(62);
					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:168:10: '-' exp5
					{
					match(input,15,FOLLOW_15_in_exp41314); 
					PtGen.pt(60);
					pushFollow(FOLLOW_exp5_in_exp41318);
					exp5();
					state._fsp--;

					PtGen.pt(60);
					PtGen.pt(63);
					}
					break;

				default :
					break loop45;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp4"



	// $ANTLR start "exp5"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:172:1: exp5 : primaire ( '*' primaire | 'div' primaire )* ;
	public final void exp5() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:172:7: ( primaire ( '*' primaire | 'div' primaire )* )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:172:9: primaire ( '*' primaire | 'div' primaire )*
			{
			pushFollow(FOLLOW_primaire_in_exp51347);
			primaire();
			state._fsp--;

			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:173:9: ( '*' primaire | 'div' primaire )*
			loop46:
			while (true) {
				int alt46=3;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==12) ) {
					alt46=1;
				}
				else if ( (LA46_0==32) ) {
					alt46=2;
				}

				switch (alt46) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:173:14: '*' primaire
					{
					match(input,12,FOLLOW_12_in_exp51363); 
					PtGen.pt(60);
					pushFollow(FOLLOW_primaire_in_exp51368);
					primaire();
					state._fsp--;

					PtGen.pt(60);
					PtGen.pt(64);
					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:174:13: 'div' primaire
					{
					match(input,32,FOLLOW_32_in_exp51385); 
					PtGen.pt(60);
					pushFollow(FOLLOW_primaire_in_exp51389);
					primaire();
					state._fsp--;

					PtGen.pt(60);
					PtGen.pt(65);
					}
					break;

				default :
					break loop46;
				}
			}

			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp5"



	// $ANTLR start "primaire"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:178:1: primaire : ( valeur | ident | '(' expression ')' );
	public final void primaire() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:178:9: ( valeur | ident | '(' expression ')' )
			int alt47=3;
			switch ( input.LA(1) ) {
			case INT:
			case 13:
			case 15:
			case 38:
			case 55:
				{
				alt47=1;
				}
				break;
			case ID:
				{
				alt47=2;
				}
				break;
			case 10:
				{
				alt47=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}
			switch (alt47) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:178:11: valeur
					{
					pushFollow(FOLLOW_valeur_in_primaire1415);
					valeur();
					state._fsp--;

					PtGen.pt(13);
					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:179:5: ident
					{
					pushFollow(FOLLOW_ident_in_primaire1423);
					ident();
					state._fsp--;

					PtGen.pt(14);
					}
					break;
				case 3 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:180:5: '(' expression ')'
					{
					match(input,10,FOLLOW_10_in_primaire1431); 
					pushFollow(FOLLOW_expression_in_primaire1433);
					expression();
					state._fsp--;

					match(input,11,FOLLOW_11_in_primaire1435); 
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "primaire"



	// $ANTLR start "valeur"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:183:1: valeur : ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' );
	public final void valeur() throws RecognitionException {
		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:183:9: ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' )
			int alt48=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt48=1;
				}
				break;
			case 13:
				{
				alt48=2;
				}
				break;
			case 15:
				{
				alt48=3;
				}
				break;
			case 55:
				{
				alt48=4;
				}
				break;
			case 38:
				{
				alt48=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}
			switch (alt48) {
				case 1 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:183:11: nbentier
					{
					pushFollow(FOLLOW_nbentier_in_valeur1449);
					nbentier();
					state._fsp--;

					PtGen.pt(3);
					}
					break;
				case 2 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:184:5: '+' nbentier
					{
					match(input,13,FOLLOW_13_in_valeur1457); 
					pushFollow(FOLLOW_nbentier_in_valeur1459);
					nbentier();
					state._fsp--;

					PtGen.pt(3);
					}
					break;
				case 3 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:185:5: '-' nbentier
					{
					match(input,15,FOLLOW_15_in_valeur1467); 
					pushFollow(FOLLOW_nbentier_in_valeur1469);
					nbentier();
					state._fsp--;

					PtGen.pt(4);
					}
					break;
				case 4 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:186:5: 'vrai'
					{
					match(input,55,FOLLOW_55_in_valeur1477); 
					PtGen.pt(5);
					}
					break;
				case 5 :
					// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:187:5: 'faux'
					{
					match(input,38,FOLLOW_38_in_valeur1485); 
					PtGen.pt(6);
					}
					break;

			}
		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "valeur"



	// $ANTLR start "nbentier"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:197:1: nbentier : INT ;
	public final void nbentier() throws RecognitionException {
		Token INT1=null;

		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:197:11: ( INT )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:197:15: INT
			{
			INT1=(Token)match(input,INT,FOLLOW_INT_in_nbentier1515); 
			 UtilLex.valEnt = Integer.parseInt((INT1!=null?INT1.getText():null));
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "nbentier"



	// $ANTLR start "ident"
	// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:199:1: ident : ID ;
	public final void ident() throws RecognitionException {
		Token ID2=null;

		try {
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:199:7: ( ID )
			// C:\\Users\\willi\\Documents\\Licence 3\\CMPL\\TP Projet\\src\\projet.g:199:9: ID
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_ident1526); 
			 UtilLex.traiterId((ID2!=null?ID2.getText():null)); 
			}

		}

		catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ident"

	// Delegated rules



	public static final BitSet FOLLOW_unitprog_in_unite64 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unitmodule_in_unite81 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_unitprog100 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitprog102 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitprog104 = new BitSet(new long[]{0x00450000E0000000L});
	public static final BitSet FOLLOW_declarations_in_unitprog114 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_unitprog123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_unitmodule140 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitmodule142 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitmodule144 = new BitSet(new long[]{0x00450000A0000000L});
	public static final BitSet FOLLOW_declarations_in_unitmodule154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partiedef_in_declarations172 = new BitSet(new long[]{0x0045000020000002L});
	public static final BitSet FOLLOW_partieref_in_declarations175 = new BitSet(new long[]{0x0041000020000002L});
	public static final BitSet FOLLOW_consts_in_declarations178 = new BitSet(new long[]{0x0041000000000002L});
	public static final BitSet FOLLOW_vars_in_declarations181 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_decprocs_in_declarations184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_partiedef202 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef204 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partiedef210 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef212 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partiedef219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_partieref231 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref234 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partieref239 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref241 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partieref248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_specif262 = new BitSet(new long[]{0x0000120000000002L});
	public static final BitSet FOLLOW_41_in_specif268 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif270 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif272 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif278 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif280 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif288 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_44_in_specif313 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif316 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif318 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif324 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif326 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_consts352 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_consts356 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_consts361 = new BitSet(new long[]{0x008000400000A040L});
	public static final BitSet FOLLOW_valeur_in_consts363 = new BitSet(new long[]{0x0000000000040020L});
	public static final BitSet FOLLOW_ptvg_in_consts365 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_54_in_vars385 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_vars389 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars391 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_14_in_vars397 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars400 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_ptvg_in_vars407 = new BitSet(new long[]{0x0000000408000002L});
	public static final BitSet FOLLOW_34_in_type428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_type443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decproc_in_decprocs460 = new BitSet(new long[]{0x0001000000040000L});
	public static final BitSet FOLLOW_ptvg_in_decprocs462 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_48_in_decproc480 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_decproc483 = new BitSet(new long[]{0x0040120060000000L});
	public static final BitSet FOLLOW_parfixe_in_decproc487 = new BitSet(new long[]{0x0040100060000000L});
	public static final BitSet FOLLOW_parmod_in_decproc490 = new BitSet(new long[]{0x0040000060000000L});
	public static final BitSet FOLLOW_consts_in_decproc495 = new BitSet(new long[]{0x0040000040000000L});
	public static final BitSet FOLLOW_vars_in_decproc498 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_decproc501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_ptvg517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_corps535 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_corps537 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_corps539 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_parfixe551 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parfixe553 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe555 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parfixe558 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe560 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parfixe565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pf579 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf581 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pf587 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf589 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_44_in_parmod608 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parmod610 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod612 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parmod616 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod618 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parmod622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pm636 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm638 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pm645 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm647 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_instruction_in_instructions668 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_instructions672 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instruction_in_instructions674 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_inssi_in_instruction691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inscond_in_instruction697 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boucle_in_instruction703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lecture_in_instruction709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ecriture_in_instruction715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affouappel_in_instruction721 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_inssi738 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inssi740 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_inssi744 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inssi746 = new BitSet(new long[]{0x0010040000000000L});
	public static final BitSet FOLLOW_52_in_inssi753 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inssi756 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_inssi760 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_inscond775 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inscond779 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond783 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond785 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_14_in_inscond799 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_inscond803 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond807 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond809 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_26_in_inscond829 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond832 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_inscond852 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_boucle867 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_boucle872 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle876 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_boucle878 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_boucle880 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_lecture894 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_lecture896 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture898 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_lecture904 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture906 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_lecture913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_ecriture926 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_ecriture928 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_ecriture930 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_ecriture936 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_ecriture938 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_ecriture946 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_affouappel962 = new BitSet(new long[]{0x0000000000020402L});
	public static final BitSet FOLLOW_17_in_affouappel972 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_affouappel974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effixes_in_affouappel995 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_effmods_in_affouappel998 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effixes1032 = new BitSet(new long[]{0x008040400000AC60L});
	public static final BitSet FOLLOW_expression_in_effixes1035 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effixes1040 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_effixes1042 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effixes1051 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effmods1063 = new BitSet(new long[]{0x0000000000000820L});
	public static final BitSet FOLLOW_ident_in_effmods1066 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effmods1071 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_effmods1073 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effmods1082 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp1_in_expression1096 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_expression1100 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp1_in_expression1104 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_exp2_in_exp11124 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_exp11127 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp2_in_exp11131 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_46_in_exp21151 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_exp2_in_exp21153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp3_in_exp21163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp4_in_exp31179 = new BitSet(new long[]{0x0000000001F80002L});
	public static final BitSet FOLLOW_22_in_exp31186 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_exp31200 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_exp31213 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_exp31227 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_exp31240 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_exp31254 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp4_in_exp31258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp5_in_exp41283 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_13_in_exp41295 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp5_in_exp41299 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_15_in_exp41314 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_exp5_in_exp41318 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_primaire_in_exp51347 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_12_in_exp51363 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_primaire_in_exp51368 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_32_in_exp51385 = new BitSet(new long[]{0x008000400000A460L});
	public static final BitSet FOLLOW_primaire_in_exp51389 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_valeur_in_primaire1415 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_primaire1423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_primaire1431 = new BitSet(new long[]{0x008040400000A460L});
	public static final BitSet FOLLOW_expression_in_primaire1433 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_primaire1435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nbentier_in_valeur1449 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_valeur1457 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_valeur1467 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_valeur1477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_valeur1485 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_nbentier1515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ident1526 = new BitSet(new long[]{0x0000000000000002L});
}
