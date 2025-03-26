package interfaces;

class ClonableClass implements Cloneable  {
	int i;
	String s;
	RelatedClass rc;

	// A class constructor
	public ClonableClass(int i, String s, RelatedClass rc) {
		this.i = i;
		this.s = s;
		this.rc = rc;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		ClonableClass res =  (ClonableClass) super.clone();
		res.rc = (RelatedClass) rc.clone();
		return res;
	}
}

class RelatedClass implements Cloneable{
	String s;

	public RelatedClass(String s) {
		this.s = s;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class CloneClass {
	public static void main(String[] args) throws CloneNotSupportedException {
		ClonableClass a = new ClonableClass(20, "GeeksForGeeks", new RelatedClass("pippo"));

		// cloning 'a' and holding
		// new cloned object reference in b

		// down-casting as clone() return type is Object
		ClonableClass b = (ClonableClass) a.clone();

		System.out.println(b.i);
		System.out.println(b.s);
		System.out.println(b == a);
		
		System.out.println(b.s);
		System.out.println(a.s);
	}

}
