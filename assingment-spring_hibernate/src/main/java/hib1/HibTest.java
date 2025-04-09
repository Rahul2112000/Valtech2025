package hib1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ass.classes.Customer;
import ass.classes.Item;
import ass.classes.LiveItem;
import ass.classes.OrderEx;
import ass.services.CustomerService;
import ass.services.InventoryService;
import ass.services.OrderService;

class HibTest {


	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ass-config.xml");
	CustomerService customerService = ctx.getBean(CustomerService.class);
    OrderService orderService = ctx.getBean(OrderService.class);
    InventoryService inventoryService = ctx.getBean(InventoryService.class);
    
    @Test
    public void testDisabledCustomerCannotPlaceOrder() {
        Customer customer = customerService.getCustomer(1);
        
        customerService.update(customer);

        Item item = inventoryService.getItem(1);
        OrderEx order = new OrderEx();
        order.setCustomer(customer);

        LiveItem lineItem = new LiveItem();
        lineItem.setItem(item);
        lineItem.setQty(item.getMinQuantity() - 3);
        lineItem.setOrder(order);

        order.setLiveItems(Arrays.asList(lineItem));

        orderService.addOrder(order);
        

    }
   
    
    @Test
    public void testEnabledCustomerCanPlaceOrder() {
        Customer customer = customerService.getCustomer(3);
        Item item = inventoryService.getItem(2);
        OrderEx order = new OrderEx();
        order.setCustomer(customer);

        LiveItem lineItem = new LiveItem();
        lineItem.setItem(item);
        lineItem.setQuantity(item.getCurrentQuantity() - 3);
        lineItem.setOrder(order);

        order.setLiveItems(Arrays.asList(lineItem));

        

        assertEquals(OrderEx.Status.PLACED, order.getStatus());
    }

    @Test
    public void testOrderFailsIfQuantityExceedsStock() {
        Customer customer = customerService.getCustomer(1);
        Item item =inventoryService.getItem(1);
        OrderEx order = new OrderEx();
        order.setCustomer(customer);

        LiveItem lineItem = new LiveItem();
        lineItem.setItem(item);
        lineItem.setQuantity(item.getCurrentQuantity() + 5);
        lineItem.setOrder(order);

        order.setLiveItems(Arrays.asList(lineItem));

       

        assertEquals(OrderEx.Status.FAILED, order.getStatus());
    }
	
	
   

}
