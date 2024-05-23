package Pack;

import org.springframework.context.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


//@Service("Lion")
//class Lion{
//	Lion(){
//		System.out.println("생성자 콜");
//	}
//	void f1() {
//		System.out.println("함수 콜");
//	}
//}
//
//@SpringBootTest
//class BitClass10SpringBootMSAApplicationTests implements ApplicationContextAware {
//	
//	ApplicationContext applicationContext;
//	@Override
//	public void setApplicationContext(
//			ApplicationContext applicationContext
//			) throws BeansException{
//		this.applicationContext = applicationContext;
//	}
//
//	@Test
//	void test01() {
//		System.out.println(1000);
//		Lion lion = applicationContext.getBean("Lion",  Lion.class);
//		lion.f1();
//	}
//}


//@Service
//class A{
//
//	void f1() {
//		System.out.println("A class");
//	}
//}
//
//
//class B{
//	@Autowired
//	A a;
//	
//	void f2() {
//		System.out.println("B call");
//		System.
//		a.f1(); 
//	}
//}
//
//@SpringBootTest
//class BitClass10SpringBootMSAApplicationTests  {
////	@Autowired
////	A a;
////	
//	@Test
//	void test01() {
////		a.f1();
//		B b = new B(); //B의 경우 Component가 존재하지 않는다. 따라서 Spring processor에 의해서 초기화되지 않기에 A도 autowired가 되지 않는 것. 
//		b.f2();
//	}
//}
//




//interface A{
//	public void f1();
//}
//
//
//class AImpl implements A{
//	@Override
//	public void f1() {
//		System.out.println("call");
//	}
//}
//
//@SpringBootTest
//class BitClass10SpringBootMSAApplicationTests  {
//
//	@Test
//	void test01() {
//	}
//}
//



//========================놓침==============================
//class A{
//	int a, b;
//	A(int a, int b) {
//		this.a = a;
//		this.b = b;
//	}
//	
//	int getResult() {
//		return a * b;
//	}
//}
//
//interface B {
//	public int getNum();
//}
//
//@Service
//class BImple implements B{
//	@Override
//	public int getNum() {
//		return 10;
//	}
//}
//
//
//
//interface C{
//	public A f1();
//}
//
//
//@Service
//class CImpl implements C{
//	@Autowired
//	B b;
//	@Override
//	public A f1() {
//		return new A(2,3);
//	}
//}
//
//@SpringBootTest
//class BitClass10SpringBootMSAApplicationTests  {
//
//	@Autowired
//	C c;
//	@Test
//	void test01() {
//		A a = c.f1();
//		System.out.println(a.getResult());
//	}
//}
//========================놓침==============================


