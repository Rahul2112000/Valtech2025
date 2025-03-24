package ass.classes;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

import javax.persistence.SequenceGenerator;

@Entity

public class LiveItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liveitemseq")

	@SequenceGenerator(name = "liveitemseq", sequenceName = "liveitem_seq", allocationSize = 1)

	private int id;

	private int qty;

	@OneToOne(targetEntity = Item.class)

	@JoinColumn(name = "item_id")

	private Item item;

	@ManyToOne(targetEntity = OrderEx.class)

	@JoinColumn(name = "order_id", referencedColumnName = "id")

	private OrderEx order;

	public LiveItem() {
	}

	public LiveItem(Item item, int qty) {

		this.item = item;

		this.qty = qty;

	}

	public int getQty() {

		return qty;

	}

	public void setQty(int qty) {

		this.qty = qty;

	}

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public Item getItem() {

		return item;

	}

	public void setItem(Item item) {

		this.item = item;

	}

	public OrderEx getOrder() {

		return order;

	}

	public void setOrder(OrderEx order) {

		this.order = order;

	}

	public void setQuantity(int i) {
		// TODO Auto-generated method stub
		
	}

}
