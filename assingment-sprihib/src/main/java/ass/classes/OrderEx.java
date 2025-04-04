package ass.classes;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "OrderEx")
public class OrderEx {

	public enum Status {
	    PLACED,
	    FAILED;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_seq", allocationSize = 1)
	private int id;

	private String status;

	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	@ManyToMany(targetEntity = Item.class)
	@JoinTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
	private List<Item> items;

	@OneToMany(targetEntity = LiveItem.class, mappedBy = "order")
	private List<LiveItem> liveItems;

	public OrderEx() {
	}

	public OrderEx(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<LiveItem> getLiveItems() {
		return liveItems;
	}

	public void setLiveItems(List<LiveItem> liveItems) {
		this.liveItems = liveItems;
	}
}
