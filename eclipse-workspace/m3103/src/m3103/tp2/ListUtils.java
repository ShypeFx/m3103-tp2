package m3103.tp2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class ListUtils {
	
	
	
	public static List<Integer> genereRdmIntList(){
		List<Integer> list = new ArrayList<Integer>();
		Random size = new Random();
		int value = size.nextInt(30 - 1)+1;
		int val;
		for(int i = 0; i < value; ++i) {
			val = size.nextInt(100);
			list.add(val);
		}
		return list;
	}
	
	static void affiche(List<Integer> l) {
		Iterator<Integer> it = l.iterator();
		String res = "";
		while(it.hasNext()) {
			res += it.next() + " -> ";
		}
		System.out.println(res.substring(0, res.length()-4));
	}
	
	static void afficheInverse(List<Integer> l){
		ListIterator<Integer> listit = l.listIterator(l.size());
		String res = "";
		
		if(listit.hasPrevious()) {
			res = listit.previous()+"";
			
		while (listit.hasPrevious()) {
			res = " -> " +listit.previous();
				
			}
		}		
		
		
		
	}
	
	static int somme(List<Integer> l) {
		int res=  0;
		for(Integer i: l) {
			res += i;
		}
		return res;
	}
	
	static int moyenne(List<Integer> l) {
		int res=  somme(l)/ l.size();
		return res;
	}
	
	static int max(List<Integer> l) {
		
		if ( l.isEmpty()) {
			throw new NoSuchElementException();
		}
		ListIterator<Integer> list = l.listIterator();
		int max = list.next();
		while(list.hasNext()) {
			Integer integer = list.next();
			if ( max < integer) {
				max = integer;
			}
		}
		return max;
	}
	
	static int min(List<Integer> l) {
		
		if ( l.isEmpty()) {
			throw new NoSuchElementException();
		}
		ListIterator<Integer> list = l.listIterator();
		int min = list.next();
		while(list.hasNext()) {
			Integer integer = list.next();
			if ( min > integer) {
				min = integer;
			}
		}
		return min;
	}
	
	static List<Integer> positions(List<Integer> l, int n){
		List<Integer> list = new ArrayList<Integer>();
		
		int val = 0;
		for(Integer i: l) {
			if(i == n) {
				list.add(val);
			}
			val++;
		}
		return list;
				
	}
	
	static List<Integer> paire(List<Integer> l){
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		for(Integer integer: l) {
			if( integer%2 == 0) {
				list.add(integer);
			}
			i++;
		}
		return list;
	}
	
	static boolean estTrie(List<Integer> l) {
		ListIterator<Integer> list = l.listIterator();
		int actuelval = 0;
		int nextval;
		boolean res = true;
		
		while(list.hasNext() && res) {
			nextval = list.next();
			if (actuelval > nextval) {
				res = false;
			}
			actuelval = nextval;
		}
		return res;
	}

	
	
	
	
	
	
	


}
