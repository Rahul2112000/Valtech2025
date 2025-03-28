package hib1;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ass.classes.Customer;

import ass.classes.Item;

import ass.classes.LiveItem;

import ass.classes.OrderEx;

import ass.services.CustomerService;

import ass.services.InventoryService;

import ass.services.OrderService;

import java.util.List;

public class HibClient {

	public static void main(String[] args) {

		// Load Spring Context

		ApplicationContext context = new ClassPathXmlApplicationContext("ass-hib-ann.xml");

		// Get Service Beans from Spring

		CustomerService customerService = context.getBean(CustomerService.class);

		InventoryService inventoryService = context.getBean(InventoryService.class);

//        LiveItemService liveItemService = context.getBean("liveItemServiceImpl", LiveItemService.class);

		OrderService orderService = context.getBean(OrderService.class);

		// Perform CRUD operations

		// performCustomerOperations(customerService);

		// performInventoryOperations(inventoryService);

		// performLiveItemOperations(liveItemService);

		// performOrderOperations(orderService);
//
	}
}
//
//    private static void performCustomerOperations(CustomerService customerService) {
//
//        System.out.println("----- CUSTOMER OPERATIONS -----");
// 
//        // Add Customer
//
//        Customer customer = new Customer();
//
//        customer.setName("Rani");
//
//        customerService.addCustomer(customer);
//
//        System.out.println("Customer Added: " + customer.getName());
// 
//        // Get Customer
//
//        Customer retrievedCustomer = customerService.getCustomer(customer.getId());
//
//        System.out.println("Retrieved Customer: " + retrievedCustomer.getName());
// 
//        // Update Customer
//
////       
//
//        customerService.updateCustomer(retrievedCustomer);
//
////        System.out.println("Customer Updated: " + retrievedCustomer.getEmail());
// 
//        // Get All Customers
//
//        List<Customer> allCustomers = customerService.getAll();
//
//        System.out.println("All Customers: " + allCustomers.size());
// 
//        // Delete Customer
//
//        customerService.deleteCustomer(customer.getId());
//
//        System.out.println("Customer Deleted: " + customer.getId());
//
//    }

//    private static void performInventoryOperations(InventoryService inventoryService) {
//
//        System.out.println("----- INVENTORY OPERATIONS -----");
//
//        // Add Item to Inventory
//
//        Item item = new Item();
//
//        item.setName("iphone 17");
//
//        item.setQty(30);  
//
//        item.setMinQuantity(4);  // Minimum threshold for reorder
//
//        item.setMaxQty(20);      // Maximum quantity after restocking
//
//        item.setReorderQty(5);   // Reorder threshold
// 
//        inventoryService.addInventory(item);
//
//        System.out.println("Item Added: " + item.getName());
// 
//        // Get Inventory Item
//
//        Item retrievedItem = inventoryService.getInventory(item.getId());
//
//        if (retrievedItem != null) {
//
//            System.out.println(" Retrieved Item: " + retrievedItem.getName());
//
//        } else {
//
//            System.out.println(" Item not found.");
//
//            return;
//
//        }
// 
//   //      Update Inventory Item
//
////        retrievedItem.setQty(15);
//
////        inventoryService.updateInventory(retrievedItem);
//
////        System.out.println(" Inventory Item Updated: " + retrievedItem.getQty());
// 
//        // Get All Inventory Items
//
//        List<Item> allItems = inventoryService.getAll();
//
//        System.out.println(" Total Inventory Items: " + allItems.size());
// 
//        // Remove Items
//
//        inventoryService.removeItem(retrievedItem.getId(), 6);
//
//        System.out.println(" Removed " + 6 + " items from inventory.");
// 
// 
//        // Check Reordering after removal
//
////        inventoryService.removeItem(retrievedItem.getId(), 10);
// 
//        // Fetch item again to check stock level
//
//        retrievedItem = inventoryService.getInventory(item.getId());
//
//        if (retrievedItem.getQty() < retrievedItem.getReorderQty()) {
//
//            System.out.println(" Stock below reorder level! Initiating reorder...");
//
//            inventoryService.reorderItem(retrievedItem);
//
//            System.out.println(" Item restocked to max quantity: " + retrievedItem.getMaxQty());
//
//        } else {
//
//            System.out.println(" Stock level is sufficient.");
//
//        }
//
//    }
//
//    private static void performOrderOperations(OrderService orderService) {
//
//        System.out.println("----- ORDER OPERATIONS -----");
// 
//        // Add Order
//
//        OrderEx order = new OrderEx();
//
//        order.setStatus("Pending");
//
//        orderService.addOrder(order);
//
//        System.out.println("Order Added: ID = " + order.getId());
// 
//        // Get Order
//
//        OrderEx retrievedOrder = orderService.getOrder(order.getId());
//
//        System.out.println("Retrieved Order: ID = " + retrievedOrder.getId() + ", Status = " + retrievedOrder.getStatus());
// 
//        // Update Order
//
//        retrievedOrder.setStatus("Completed");
//
//        orderService.updateOrder(retrievedOrder);
//
//        System.out.println("Order Updated: " + retrievedOrder.getStatus());
// 
//        // Get All Orders
//
//        List<OrderEx> allOrders = orderService.getAll();
//
//        System.out.println("Total Orders: " + allOrders.size());
// 
//        // Delete Order
//
////        orderService.deleteOrder(order.getId());
//
////        System.out.println("Order Deleted: " + order.getId());
//
//    }
//
//}

//package hibernate.client;

//

//import static org.junit.jupiter.api.Assertions.assertEquals;

//

//import java.util.Arrays;

//import java.util.List;

//

//import org.springframework.context.support.ClassPathXmlApplicationContext;

//

//import assignment.classes.Customer;

//import assignment.classes.Item;

//import assignment.classes.LiveItem;

//import assignment.classes.OrderEn;

//import assignment.dao.LiveItemDAO;

//import assignment.dao.OrderDAO;

//import assignment.services.CustomerService;

//import assignment.services.InventoryService;

//import assignment.services.OrderService;

//

//

//public class HibernateClient {

//

//	public static void main(String[] args) {

//		

//		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("ass-hib-ann.xml");

//		

//		CustomerService cs=ctx.getBean(CustomerService.class);

//		InventoryService is=ctx.getBean(InventoryService.class);

//		OrderService os=ctx.getBean(OrderService.class);

//		LiveItemDAO lDAO=ctx.getBean(LiveItemDAO.class);

//		

//

//	

////		Customer c1= new Customer("Janvi",23,"JAI","RAJ");

////		Customer c2= new Customer("Jesu",23,"BLR","KAI");

////		Customer c3= new Customer("Kesu",21,"DEL","DUI");

////		Customer c4= new Customer("Tesu",22,"AMR","HMT");

////		

////		cs.addCustomer(c1);

////		cs.addCustomer(c2);

////		cs.addCustomer(c3);

////		cs.addCustomer(c4);

//		

//		//cs.deleteCustomer(9);

//	

//		Item i1=new Item("Iphone 16","Mobile",10,4,15);

//		Item i2=new Item("Vivo","S775",6,2,10);

//		Item i3=new Item("MOUSE","WIRELESS",5,2,8);

//		Item i4=new Item("KEYBOARD","WIRED",5,2,6);

//

//		is.addInventory(i1);

//		is.addInventory(i2);

//		is.addInventory(i3);

//		is.addInventory(i4);

//		

//		LiveItem l1= new LiveItem(i1,2);

//		lDAO.addLiveItem(l1);

		

//		ctx.close();

//	}


//}
