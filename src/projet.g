// Grammaire du langage PROJET
// CMPL L3info 
// Nathalie Girard, Veronique Masson, Laurent Perraudeau
// il convient d'y inserer les appels a {PtGen.pt(k);}
// relancer Antlr apres chaque modification et raffraichir le projet Eclipse le cas echeant

// attention l'analyse est poursuivie apres erreur si l'on supprime la clause rulecatch

grammar projet;

options {
  language=Java; k=1;
 }

@header {           
import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;
} 


// partie syntaxique :  description de la grammaire //
// les non-terminaux doivent commencer par une minuscule


@members {

 
// variables globales et methodes utiles a placer ici
  
}
// la directive rulecatch permet d'interrompre l'analyse a la premiere erreur de syntaxe
@rulecatch {
catch (RecognitionException e) {reportError (e) ; throw e ; }}


unite  :   unitprog {PtGen.pt(255);} EOF
      |    unitmodule  EOF
  ;
  
unitprog
  : 'programme' ident ':'  
     declarations  
     corps { System.out.println("succes, arret de la compilation "); }
  ;
  
unitmodule
  : 'module' ident ':' 
     declarations   
  ;
  
declarations
  : partiedef? partieref? consts? vars? decprocs? 
  ;
  
partiedef
  : 'def' ident  (',' ident )* ptvg
  ;
  
partieref: 'ref'  specif (',' specif)* ptvg
  ;
  
specif  : ident  ( 'fixe' '(' type  ( ',' type  )* ')' )? 
                 ( 'mod'  '(' type  ( ',' type  )* ')' )? 
  ;
  
consts  : 'const' ( ident {PtGen.pt(1);}  '=' valeur ptvg {PtGen.pt(9);} )+ 
  ;
  
vars  : 'var' ( type ident {PtGen.pt(2);} ( ','  ident {PtGen.pt(2);} )* ptvg  )+  {PtGen.pt(10);}
  ;
  
type  : 'ent' {PtGen.pt(7);}   
  |     'bool' {PtGen.pt(8);}
  ;
  
decprocs: {PtGen.pt(102);} (decproc ptvg)+ {PtGen.pt(103);}
  ;
  
decproc :  'proc'  ident {PtGen.pt(104);} parfixe? parmod? {PtGen.pt(107);} consts? vars? corps {PtGen.pt(101);}
  ;
  
ptvg  : ';'
  | 
  ;
  
corps : 'debut' {PtGen.pt(100);} instructions 'fin' {PtGen.pt(101);}
  ;
  
parfixe: 'fixe' '(' pf( ';' pf )* ')'
  ;
  
pf  : type ident {PtGen.pt(105);} ( ',' ident {PtGen.pt(105);} )*  
  ;

parmod  : 'mod' '(' pm ( ';' pm)* ')'
  ;
  
pm  : type ident {PtGen.pt(106);}  ( ',' ident {PtGen.pt(106);}  )*
  ;
  
instructions
  : instruction ( ';' instruction)*
  ;
  
instruction
  : inssi
  | inscond
  | boucle
  | lecture
  | ecriture
  | affouappel
  |
  ;
  
inssi : 'si' expression {PtGen.pt(80);} 'alors' instructions  ( {PtGen.pt(81);} 'sinon'  instructions)? 'fsi' {PtGen.pt(82);}
  ;
  
inscond : 'cond' {PtGen.pt(78);} expression {PtGen.pt(75);} ':' instructions 
          (',' {PtGen.pt(76);} expression {PtGen.pt(75);} ':' instructions  )* 
          ({PtGen.pt(79);} 'aut'  instructions |  ) 
          {PtGen.pt(77);} 'fcond' 
  ;
  
boucle  : 'ttq' {PtGen.pt(83);}  expression {PtGen.pt(80);} 'faire' instructions 'fait' {PtGen.pt(84);}
  ;
  
lecture: 'lire' '(' ident {PtGen.pt(89);} ( ',' ident {PtGen.pt(89);} )* ')' 
  ;
  
ecriture: 'ecrire' '(' expression {PtGen.pt(90);} ( ',' expression {PtGen.pt(90);} )*  ')'
   ;
  
affouappel: 
  ident   ( {PtGen.pt(11);}   ':=' expression {PtGen.pt(12);}
            | {PtGen.pt(98);}  (effixes (effmods)?)? {PtGen.pt(99);}  
           )
  ;
  
effixes : '(' (expression pt (',' expression  )*)? ')'
  ;
  
effmods :'(' (ident  (',' ident  )*)? ')'
  ; 
  
expression: (exp1) ('ou'{PtGen.pt(61);}  exp1 {PtGen.pt(61);}{PtGen.pt(66);} )*
  ;
  
exp1  : exp2 ('et' {PtGen.pt(61);} exp2 {PtGen.pt(61);}{PtGen.pt(67);} )*
  ;
  
exp2  : 'non' exp2 {PtGen.pt(61);} {PtGen.pt(68);}
  | exp3  
  ;
  
exp3  : exp4 
  ( '='  {PtGen.pt(60);} exp4 {PtGen.pt(60);}{PtGen.pt(69);}
  | '<>' {PtGen.pt(60);} exp4 {PtGen.pt(60);}{PtGen.pt(70);}
  | '>'  {PtGen.pt(60);} exp4 {PtGen.pt(60);}{PtGen.pt(71);}
  | '>=' {PtGen.pt(60);} exp4 {PtGen.pt(60);}{PtGen.pt(72);}
  | '<'  {PtGen.pt(60);} exp4 {PtGen.pt(60);}{PtGen.pt(73);}
  | '<=' {PtGen.pt(60);} exp4  {PtGen.pt(60);} {PtGen.pt(74);}
  ) ?
  ;
  
exp4  : exp5 
        ('+' {PtGen.pt(60);} exp5 {PtGen.pt(60);} {PtGen.pt(62);}
        |'-' {PtGen.pt(60);} exp5 {PtGen.pt(60);} {PtGen.pt(63);}
        )*
  ;
  
exp5  : primaire 
        (    '*' {PtGen.pt(60);}  primaire {PtGen.pt(60);}{PtGen.pt(64);}
          | 'div' {PtGen.pt(60);} primaire {PtGen.pt(60);}{PtGen.pt(65);}
        )*
  ;
  
primaire: valeur {PtGen.pt(13);}
  | ident {PtGen.pt(14);}
  | '(' expression ')'
  ;
  
valeur  : nbentier {PtGen.pt(3);}
  | '+' nbentier {PtGen.pt(3);}
  | '-' nbentier {PtGen.pt(4);}
  | 'vrai' {PtGen.pt(5);}
  | 'faux' {PtGen.pt(6);}
  ;

// partie lexicale  : cette partie ne doit pas etre modifiee  //
// les unites lexicales de ANTLR doivent commencer par une majuscule
// Attention : ANTLR n'autorise pas certains traitements sur les unites lexicales, 
// il est alors ncessaire de passer par un non-terminal intermediaire 
// exemple : pour l'unit lexicale INT, le non-terminal nbentier a du etre introduit
 
      
nbentier  :   INT { UtilLex.valEnt = Integer.parseInt($INT.text);}; // mise a jour de valEnt

ident : ID  { UtilLex.traiterId($ID.text); } ; // mise a jour de numIdCourant
     // tous les identificateurs seront places dans la table des identificateurs, y compris le nom du programme ou module
     // (NB: la table des symboles n'est pas geree au niveau lexical mais au niveau du compilateur)
        
  
ID  :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ; 
     
// zone purement lexicale //

INT :   '0'..'9'+ ;
WS  :   (' '|'\t' |'\r')+ {skip();} ; // definition des "blocs d'espaces"
RC  :   ('\n') {UtilLex.incrementeLigne(); skip() ;} ; // definition d'un unique "passage a la ligne" et comptage des numeros de lignes

COMMENT
  :  '\{' (.)* '\}' {skip();}   // toute suite de caracteres entouree d'accolades est un commentaire
  |  '#' ~( '\r' | '\n' )* {skip();}  // tout ce qui suit un caractere diese sur une ligne est un commentaire
  ;

// commentaires sur plusieurs lignes
ML_COMMENT    :   '/*' (options {greedy=false;} : .)* '*/' {$channel=HIDDEN;}
    ;	   