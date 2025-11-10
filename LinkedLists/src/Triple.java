/*
 * T is a type variable. When a triple is created,
 * we get to decide whether its data is String,Integer,
 * Double, or something else
 * 
 * T can only be substituted with types of object and not primitives
 * 
 * Java includes an object version of the primitive type
 * int -> Integer
 * double -> Double
 * boolean -> Boolean
 */



public class Triple<T> {

	private T a;

	private T b;

	private T c;

	public Triple(T a, T b, T c) {

		this.a = a;

		this.b = b;

		this.c = c;

	}

	public T getA() {

		return a;

	}

	public T getB() {

		return b;

	}

	public T getC() {

		return c;

	}

	@Override

	public String toString() {

		return "Triple [" + a + ", " + b + ", " + c + "]";

	}

	//TYPES HAVE TO BE OBJECTS, NOT PRIMITIVE TYPES
	public static void main(String[] args) {
		//Triple t = new Triple("David", "Michael", "Anderson");
		Triple<String> t = new Triple<>("A", "B", "C");
		System.out.println(t);
		Triple<Double> t1 = new Triple<>(1.2, 1.5, 3.4);
		System.out.println(t1);
		Triple<Integer> t2 = new Triple<>(1, 1, 3);
		System.out.println(t2);
		Triple<Boolean> t3 = new Triple<>(true, false, false);
		System.out.println(t3);
		
		Triple<Triple<Integer>> t4 = new Triple<>(
				new Triple<>(1,2,3),
				new Triple<>(4,5,6),
				new Triple<>(6,7,8)
				);
		System.out.println(t4);
	}

}