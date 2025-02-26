package hibernate.client;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import hibernate.Account;
import hibernate.Address;
//import antlr.collections.List;
import hibernate.AtmTx;
import hibernate.Car;
import hibernate.ChequeTx;
import hibernate.Customer;
import hibernate.Student;
import hibernate.StudentAddress;
import hibernate.StudentId;
import hibernate.TellerTx;
import hibernate.Tx;
import java.util.List;

public class HibenateClient {

	public static void main(String[] args) {
		SessionFactory sesFac=new AnnotationConfiguration()
				.addAnnotatedClass(Car.class)
				.addAnnotatedClass(Tx.class)
				.addAnnotatedClass(ChequeTx.class)
				.addAnnotatedClass(TellerTx.class)
				.addAnnotatedClass(AtmTx.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session ses=sesFac.openSession();
		Transaction tx=ses.beginTransaction();
		
		//each line use stream
//		ses.createQuery("FROM Tx t").list().stream().forEach(t->System.out.println(t));
//		ses.createQuery("FROM Customer c WHERE c.age>?").setInteger(0, 25).list().stream().forEach(t->System.out.println(t));

//		ses.createQuery("SELECT t FROM Tx t JOIN t.account.customers c WHERE c.age<?").setInteger(0, 25).setInteger(0, 25).list().stream().forEach(t->System.out.println(t));

		ses.createQuery("SELECT t.account.id,t.amount FROM Tx t JOIN t.account.customers c WHERE c.age<?").setInteger(0, 25).setInteger(0, 25).list().stream().forEach(t->System.out.println(t));

		
		//System.out.println(ses.createQuery("FROM Tx t").list());
		
//		StudentId id=(StudentId) ses.save(new Student(new StudentId(1,2025),"Abc","Def","CS",9898989898L));
//		System.out.println(ses.load(Student.class,id));
		
//		StudentId id=(StudentId)ses.save(new Student(new StudentId(1,2025),"Abc","Def","CS",6367456054L,
//				new StudentAddress("SomeWhere","Ahm",3432432),
//				new StudentAddress("NoWhere","Raj",563444)));
//		System.out.println(ses.load(Student.class, id));
//
//		
//		
//		Account acc=(Account) ses.load(Account.class,2L);
//		Customer cus=(Customer) ses.load(Customer.class, 1L);
//		
//		Account acc1=new Account(50000,"CA");
//		Account acc2=new Account(30000,"SB");
//		Customer cus1=new Customer("DEF",32,false);
//		Customer cus2=new Customer("XYZ",36,false);
//		
//		ses.save(acc1);
//		ses.save(cus1);
//		ses.save(acc2);
//		ses.save(cus2);
//		
//		cus.addAccount(acc);cus.addAccount(acc1);cus.addAccount(acc2);
//		cus1.addAccount(acc);cus.addAccount(acc1);
//		cus2.addAccount(acc);
//		
		
		
//		List<Tx> txs=ses.createQuery("from Tx t").list();
//		Account acc=new Account(10000,"SB");
//		ses.save(acc);
//		txs.stream().forEach(t->acc.addTx(t));
//		
		
//		Customer c=(Customer)ses.load(Customer.class, 1L);
//		System.out.println(c);
//		System.out.println(c.getAddress());
////		
//		
//		Customer c=new Customer("Abc",23,true);
//		ses.save(c);
//		Address a=new Address("Venus","Amd",382204);
//		c.setAddress(a);
//		a.setCustomer(c);
//		a.setId(c.getId());
//		ses.saveOrUpdate(a);
//		
		
		
		
//		ses.save(new Tx(1000));
//		ses.save(new ChequeTx(2000,123456));
//		ses.save(new TellerTx(3000,"Admin","NKT"));
//		ses.save(new AtmTx(4000,123));
//		
//		
//		List<Tx> txs=ses.createQuery("from Tx t").list();
//		System.out.println(txs);
//		
//		
//		ses.save(new Tx(1000));
//		ses.save(new ChequeTx(2000,123456));
//		ses.save(new TellerTx(3000,"Admin","NKT"));
//		ses.save(new AtmTx(4000,123));
		
//		Long id=(Long)ses.save(new Car(0,"Honda","City",2025));
//		System.out.println(id);
//		Car car=(Car)ses.load(Car.class,id);
//		System.out.println(car);
//		car.setName("Civic");
//		Car car1=(Car)ses.load(Car.class,id);
//		ses.update(car);
//		ses.flush();//please don't call session on flush on your own.
//		System.out.println(car);
//		System.out.println(car.getClass().getName());
//		
		
		tx.commit();
		
		//System.out.println(car);
		ses.close();
		sesFac.close();
		
		
	}
}
