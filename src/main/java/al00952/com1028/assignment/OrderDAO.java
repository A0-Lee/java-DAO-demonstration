package al00952.com1028.assignment;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Create a Data Access Object for the Order class.
 * 
 * This class is part of Requirement 3 (Set H).
 * 
 * @author Andy Lee
 */
public class OrderDAO extends AbstractDAO<Order>{
	private ArrayList<Order> allOrders = new ArrayList<Order>();
	private ArrayList<Integer> resultsCustomerNumber = new ArrayList<Integer>();
	private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

	public OrderDAO() {
		super();
		this.allOrders = this.findAllObjectData();
		this.resultsCustomerNumber = this.findCustomerNumbers();
	}

	public ArrayList<Integer> getResultsCustomerNumber() {
		return resultsCustomerNumber;
	}

	private ArrayList<Integer> findCustomerNumbers() {
		ArrayList<Integer> resultsOrderNumbers = this.orderDetailDAO.getResultsOrderNumbers();
		for (Order order : this.allOrders) {
			for (Integer orderNumber : resultsOrderNumbers) {
				if (order.getOrderNumber() == orderNumber) {
					this.resultsCustomerNumber.add(order.getCustomerNumber());
				}
			}
		}
		return this.resultsCustomerNumber;
	}

	@Override
	protected ArrayList<Order> findAllObjectData() {
		try {
			ResultSet results = this.baseQuery.useTable("orders");

			while (results.next()) {
				int orderNumber = results.getInt("orderNumber");
				Date orderDate = results.getDate("orderDate");
				Date requiredDate = results.getDate("requiredDate");
				Date shippedDate = results.getDate("shippedDate");
				String status = results.getString("status");
				String comments = results.getString("comments");
				int customerNumber = results.getInt("customerNumber");

				Order newOrder = new Order(orderNumber, orderDate, requiredDate, shippedDate, status, comments,
						customerNumber);

				this.allOrders.add(newOrder);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.allOrders;
	}

}
