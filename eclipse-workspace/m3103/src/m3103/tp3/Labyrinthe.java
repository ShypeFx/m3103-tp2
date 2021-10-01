package m3103.tp3;

/**
 * C. Durr, Ecole Polytechnique, INF421
 *
 * Modifs I. Boneva, CRIStAL, Université de Lille
 */

import java.awt.*;
import java.awt.event.*;

class Labyrinthe extends Canvas {
	private static final long serialVersionUID = 1L;
	private String[] murs = { 
			"#########################################",
			"    #        # # # #       #        # # #",
			"### # #### # # # # # ### ##### ## ### # #",
			"#   # #    # #   #   #   # #    #   #   #",
			"### ### ###### ######### # ###  # # ### #",
			"#          #   #     #   #        # #   #",
			"### ##### #### # ####### ### ###### ### #",
			"# # # # #  #     #   #       #    #     #",
			"# # # # # ## ### # # # # ###### ##### ###",
			"#   # #        #   #   #   #      #     #",
			"# #        # # # #   # # # # #      # # #",
			"# # # ###### # # ### # ### # # #### ### #",
			"# # #      # #     # #     # #  # #   # #",
			"# # ###### ##### ######### # #  # # ### #",
			"#   #      # #         #   #            #",
			"########## # ##### ######### ## ####### #",
			"#   #          #   # #     #      #     #",
			"### # ### #### ##### ### ######## ##### #",
			"#   #   #            #          # #     #",
			"### #####  ##### ########### #### ##### #",
			"#   #   #  #   #       #            # # #",
			"### # ### ## ### ####### # ######## # # #",
			"#     #    #           # #        # #   #",
			"### ### ######## ########### ## # # ### #",
			"#                # #         #  # # #   #",
			"### ### ###### # # # ########## ### ### #",
			"# # #      # # #   #       # #  #     # #",
			"# ##### # ## ##### # # # # # # ## ### ###",
			"#       #    # # # # # # #          #   #",
			"##### #### # # # # # ########## # ##" +
					"" +
					"#####",
					"#       #  #     #   #     #    # #     #",
					"# # #            # # #   #        # #   #",
					"# # # # ## ########### # # ### ###### ###",
					"# # # #    #   # # #   # # # #  #   #   #",
					"# ### #### # ### # ##### ### ## # # #  ##",
					"#   # #          # # #     #      #     #",
					"# ### ### ###### # # # # #####  # ### ###",
					"# #   #    #     #   # #        # #     #",
					"### ### # ## # ### ###########  ### # # #",
					"#     # #  # #             #      # # #  ",
					"#########################################"};
	private int[] sortie = new int[]{murs.length-1,murs.length-2};
	private int[] entree = new int[]{0,1};

	// coordonées (x,y) de l'entree
	int[] entree() {
		return entree;
	}
	// coordonées (x,y) de la sortie
	int[] sortie() {
		return sortie;
	}
	// coordonées (x,y) de la sortie
	boolean estSortie(int x, int y) {
		return x==sortie[0] && y==sortie[1];
	}
	boolean estSortie(int[] s) {
		return s[0]==sortie[0] && s[1]==sortie[1];
	}

	// est-ce que (x,y) est un mur ?
	boolean estMur(int x, int y) {
		return murs[y].charAt(x)=='#';
	}
	boolean estMur(int[] m) {
		return murs[m[1]].charAt(m[0])=='#';
	}

	// la taille du labyrinthe, a la fois nb lignes et nb colonnes
	int n() { 
		return murs.length; 
	}

	static final char VIDE = 'a', ROUGE = 'b', ROSE = 'c';
	
	// les marques 
	char[][] marque;

	// teste si la cellule (x,y) comporte une marque
	boolean estMarque(int x, int y) {
		return marque[x][y] != VIDE;
	}
	boolean estMarque(int[] c) {
		return marque[c[0]][c[1]] != VIDE;
	}
	// pose une marque
	void poserMarque(int x, int y) {
		marque[x][y] = ROSE;
		repaint();
	}
	void poserMarque(int[] c) {
		marque[c[0]][c[1]] = ROSE;
		repaint();
	}
	void poserMarqueChemin (int x, int y) {
		marque[x][y] = ROUGE;
		repaint();
	}
	void poserMarqueChemin (int[] c) {
		marque[c[0]][c[1]] = ROUGE;
		repaint();
	}
	
	static final int c = 8; // taille d'affichage d'une cellule

	// cree une fenetre et affiche le labyrinthe dedans
	Labyrinthe() {
		marque = new char[n()][n()];
		for (int i = 0; i < n(); i++) {
			for (int j = 0; j < n(); j++) {
				marque[i][j] = VIDE;
			}
		}

		Frame f = new Frame("Labyrinthe");
		f.setBounds(100,100, c*n()+20, c*n()+60);
		f.add(this);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setVisible(true);
	}


	// ne pas effacer avant pour eviter que l'image clignote lors d'un
	// redessinement
	public void update(Graphics g) {
		paint(g);
	}


	public void paint(Graphics g) {
		// dessiner les murs et les marques
		for (int x=0; x<n(); x++)
			for (int y=0; y<n(); y++) 
				if (estMur(x,y)) {
					g.setColor(Color.gray);
					g.fillRect(x*c, y*c, c, c);
				}
				else {
					if (! estMarque(x, y)) g.setColor(Color.white);
					else if (marque[x][y] == ROUGE) g.setColor(Color.red);
					else g.setColor(Color.pink);
					//g.setColor(estMarque(x,y) ? Color.red: Color.white);
					g.fillOval(x*c+c/4, y*c+c/4, c-c/2, c-c/2);
				}
	}

	// ce main est juste la pour tester la classe
	public static void main(String args[]) {
		Labyrinthe l = new Labyrinthe();
		l.poserMarque(1,1);
	}

}


