package m3103.tp3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ParcoursFile {
	
	public static void main(String [] args) {
		 Labyrinthe lab = new Labyrinthe();
		 Queue<Cellule> l = new ArrayDeque<Cellule>();
		 Cellule d = new Cellule(0,1);
		 l.offer(d);
		 lab.poserMarque(0, 1);
		 boolean fini = false;
		 
		 while(!l.isEmpty() && !fini) {
			 Cellule c = l.peek();
			 try {Thread.sleep(1) ;}catch(InterruptedException e){}
			 
			 if(lab.estSortie(c.toArray())) {
				 fini = true;
			 }
			 else {
				 Cellule cel = voisin(lab,c);
				 if(cel == null) {
					 l.poll();
					 lab.poserMarque(c.toArray());
				 }
				 else {
					 l.offer(cel);
					 lab.poserMarqueChemin(cel.toArray());
				 }
				 
			 }
		 }
		  if(fini) {
			  System.out.println("Sortie trouvée");
		  }else {
			  System.out.println("Pas de sortie");
		  }
		 
	}
	
	private static Cellule voisin(Labyrinthe l, Cellule depart) {
		Cellule res = null;
		int x = depart.getX();
		int y = depart.getY();
		

		
		if(!l.estMarque(x+1,y) && !l.estMur(x+1, y)) 
			res = new Cellule(x+1,y);

		else if(!l.estMarque(x,y+1) && !l.estMur(x, y+1)) 
			res = new Cellule(x,y+1);
		
		else if(x != 0 && !l.estMarque(x-1,y) && !l.estMur(x-1, y)) 
			res = new Cellule(x-1,y);

		else if(y != 0 && !l.estMarque(x,y-1) && !l.estMur(x, y-1)) 
			res = new Cellule(x,y-1);
		
		if(res != null) {
			l.poserMarque(res.toArray());
		}
		
		return res;
	}
}

