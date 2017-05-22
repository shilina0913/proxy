package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxySubject implements InvocationHandler {

	private Object real;

	private ProxySubject(Object real) {
		this.real = real;
	}

	@Override
	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("beford real subject");
		method.invoke(real, args);
		System.out.println("after real subject");
		return null;
	}

	public static void main(String[] args) {
		RealSubject real = new RealSubject();
		InvocationHandler h = new ProxySubject(real);
		Subject proxy = (Subject) Proxy.newProxyInstance(real.getClass().getClassLoader(),
				new Class[] { Subject.class }, h);
		proxy.print();
	}

}
