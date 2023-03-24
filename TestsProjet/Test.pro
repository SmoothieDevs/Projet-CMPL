programme condition: 
var bool b1;

proc ajout1 fixe (ent y) mod (bool z)
    var ent i;
	debut
		i:=0;
        z:=vrai;
	fin;

debut
    b1:=vrai;
    ajout1(10)(b1);
fin