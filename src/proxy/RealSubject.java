package proxy;

public class RealSubject implements Subject {

	@Override
	public void print() {
		System.out.println("This is a real subject");
	}

}
