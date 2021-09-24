package m3103.tp2;

public class MyList<E> {

	E data;
	MyList<E> next;
	
	public MyList(E data, MyList<E> next) {
		super();
		this.data = data;
		this.next = next;
	}
	public MyList() {
		super();
		this.data = data;
		this.next = next;
	}
	
	public boolean isEmpty() {
		return this.next.data == null;
	}
	
	public void clear() {
		this.next = null;
		this.data = null;
	}
	
	public int size() {
		int i = 0;
		while(!isEmpty()) {
			++i;
		}
		return i;
	}
	
	public String toString() {
		String res = "";
		if (!isEmpty()) {
			
			res = "[";
			res += this.data+",";
			MyList<E> current = this.next;
			while(!current.isEmpty()) {
				res += current.data + ",";
				if(current.next != null) {
					res += ",";
				}
				current = current.next;
			
			}
			res += "]";
		}
		
		return res;
	}
	
	public E get(int index) {
		int i = 0;
		MyList<E> current = this;
		E res = null;
		while(!current.isEmpty()) {
			if(index == i) {
				res = this.data;
			}
			i++;
			current = current.next;
		}
		return res;
	}
	
	public int indexOf(Object o) {
		int i = 0;
		boolean bool = false;
		MyList<E> current = this;
		while(!isEmpty() && !bool) {
			if ( !current.data.equals(o)) {
				++i;
				current = current.next;
			}else {
				bool = true;
			}

		}
		return i;
	}
	
	public boolean contains(Object o) {
		int i = 0;
		boolean bool = false;
		MyList<E> current = this;
		while(!isEmpty() && !bool) {
			if(!current.data.equals(o)) {
				bool = true;
			}
			++i;
			current = current.next;
		}
		return bool;
	}
	
	
	
	
	
}
