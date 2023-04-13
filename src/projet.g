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
      |    unitmodule {PtGen.pt(255);} EOF
  ;
  
unitprog
  : 'programme' ident ':' {PtGen.pt(51);} 
     declarations  
     corps { System.out.println("succes, arret de la compilation "); }
  ;
  
unitmodule
  : 'module' ident ':' {PtGen.pt(52);} 
     declarations
  ;
  
declarations
  : partiedef? partieref? consts? vars? decprocs? {PtGen.pt(54);}
  ;
  
partiedef
  : 'def' ident {PtGen.pt(53);}  (',' ident {PtGen.pt(53);} )* ptvg
  ;
  
partieref: 'ref'  specif {PtGen.pt(57);} (',' specif {PtGen.pt(57);})*  ptvg
  ;
  
specif  : ident {PtGen.pt(55);} ( 'fixe' '(' type {PtGen.pt(56);} ( ',' type {PtGen.pt(56);}  )* ')' )? 
                 ( 'mod'  '(' type {PtGen.pt(56);} ( ',' type {PtGen.pt(56);} )* ')'  )? 
  ;
  
consts  : 'const' ( ident {PtGen.pt(1);}  '=' valeur ptvg {PtGen.pt(9);} )+ 
  ;
  
vars  : 'var' ( type ident {PtGen.pt(2);} ( ','  ident {PtGen.pt(2);} )* ptvg  )+  {PtGen.pt(10);}
  ;
  
type  : 'ent' {PtGen.pt(7);}   
  |     'bool' {PtGen.pt(8);}
  ;
  
decprocs: {PtGen.pt(45);} (decproc ptvg)+ {PtGen.pt(46);}
  ;
  
decproc :  'proc'  ident {PtGen.pt(47);} parfixe? parmod? {PtGen.pt(50);} consts? vars? corps {PtGen.pt(44);}
  ;
  
ptvg  : ';'
  | 
  ;
  
corps : 'debut' instructions 'fin'
  ;
  
parfixe: 'fixe' '(' pf( ';' pf )* ')'
  ;
  
pf  : type ident {PtGen.pt(48);} ( ',' ident {PtGen.pt(48);} )*  
  ;

parmod  : 'mod' '(' pm ( ';' pm)* ')'
  ;
  
pm  : type ident {PtGen.pt(49);}  ( ',' ident {PtGen.pt(49);}  )*
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
  
inssi : 'si' expression {PtGen.pt(30);} 'alors' instructions  ( {PtGen.pt(34);} 'sinon'  instructions)? 'fsi' {PtGen.pt(35);}
  ;
  
inscond : 'cond' {PtGen.pt(33);} expression {PtGen.pt(30);} ':' instructions 
          (',' {PtGen.pt(31);} expression {PtGen.pt(30);} ':' instructions  )* 
          ({PtGen.pt(34);} 'aut'  instructions |  ) 
          {PtGen.pt(32);} 'fcond' 
  ;
  
boucle  : 'ttq' {PtGen.pt(36);}  expression {PtGen.pt(30);} 'faire' instructions 'fait' {PtGen.pt(37);}
  ;
  
lecture: 'lire' '(' ident {PtGen.pt(38);} ( ',' ident {PtGen.pt(38);} )* ')' 
  ;
  
ecriture: 'ecrire' '(' expression {PtGen.pt(39);} ( ',' expression {PtGen.pt(39);} )*  ')'
   ;
  
affouappel: 
  ident   ( {PtGen.pt(11);}   ':=' expression {PtGen.pt(12);}
            | {PtGen.pt(41);} (effixes (effmods)?)? {PtGen.pt(42);}  
           )
  ;
  
effixes : '(' (expression {PtGen.pt(40);} (',' expression {PtGen.pt(40);} )*)? ')'
  ;
  
effmods :'(' (ident {PtGen.pt(43);} (',' ident {PtGen.pt(43);} )*)? ')'
  ; 
  
expression: (exp1) ('ou'{PtGen.pt(16);}  exp1 {PtGen.pt(16);}{PtGen.pt(21);} )*
  ;
  
exp1  : exp2 ('et' {PtGen.pt(16);} exp2 {PtGen.pt(16);}{PtGen.pt(22);} )*
  ;
  
exp2  : 'non' exp2 {PtGen.pt(16);} {PtGen.pt(23);}
  | exp3  
  ;
  
exp3  : exp4 
  ( '='  {PtGen.pt(15);} exp4 {PtGen.pt(15);}{PtGen.pt(24);}
  | '<>' {PtGen.pt(15);} exp4 {PtGen.pt(15);}{PtGen.pt(25);}
  | '>'  {PtGen.pt(15);} exp4 {PtGen.pt(15);}{PtGen.pt(26);}
  | '>=' {PtGen.pt(15);} exp4 {PtGen.pt(15);}{PtGen.pt(27);}
  | '<'  {PtGen.pt(15);} exp4 {PtGen.pt(15);}{PtGen.pt(28);}
  | '<=' {PtGen.pt(15);} exp4  {PtGen.pt(15);} {PtGen.pt(29);}
  ) ?
  ;
  
exp4  : exp5 
        ('+' {PtGen.pt(15);} exp5 {PtGen.pt(15);} {PtGen.pt(17);}
        |'-' {PtGen.pt(15);} exp5 {PtGen.pt(15);} {PtGen.pt(18);}
        )*
  ;
  
exp5  : primaire 
        (    '*' {PtGen.pt(15);}  primaire {PtGen.pt(15);}{PtGen.pt(19);}
          | 'div' {PtGen.pt(15);} primaire {PtGen.pt(15);}{PtGen.pt(20);}
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