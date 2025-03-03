package hib1;



import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ass.classes.Customer;
import ass.classes.Item;
import ass.classes.LiveItem;
import ass.classes.Order;
import ass.dao.LiveItemDAO;
import ass.dao.OrderDAO;
import ass.services.CustomerService;
import ass.services.InventoryService;
import ass.services.OrderService;


public class HibClient {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("tx-hib-ann.xml");
		
		CustomerService cs=ctx.getBean(CustomerService.class);
		InventoryService is=ctx.getBean(InventoryService.class);
		OrderService os=ctx.getBean(OrderService.class);
		LiveItemDAO lDAO=ctx.getBean(LiveItemDAO.class);
		

	
//	Customer c1= new Customer("RAHUL",24,"RAJ","DIU");
//		Customer c2= new Customer("VAIBHAV",23,"RJT","HMT");
//		Customer c3= new Customer("MONISH",25,"VDA","SRT");
//		Customer c4= new Customer("PANKAJ",22,"AMR","AHM");
//		
//		cs.addCustomer(c1);
//		cs.addCustomer(c2);
//		cs.addCustomer(c3);
//		cs.addCustomer(c4);
//		
		//cs.deleteCustomer(9);
	
//		Item i1=new Item("PRINTER","ABC",6,2,20);
//		Item i2=new Item("MAC","M4",3,6,20);
//		Item i3=new Item("DESKTOP","WIRELESS",3,6,9);
//		Item i4=new Item("MOUSE","WIRELESS",4,4,8);
//
//		is.addInventory(i1);
//		is.addInventory(i2);
//		is.addInventory(i3);
//		is.addInventory(i4);
//		
//		LiveItem l1= new LiveItem(i1,2);
//		lDAO.addLiveItem(l1);
//		
//		
		ctx.close();
	}
	
	
}
