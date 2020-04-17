package al00952.com1028.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Create a Data Access Object for the OrderDetail class.
 * 
 * This class is part of Requirement 3 (Set H).
 * 
 * @author Andy Lee
 *
 */
public class OrderDetailDAO extends AbstractDAO<OrderDetail> {
	private ArrayList<OrderDetail> allOrderDetails = new ArrayList<OrderDetail>();
	private ArrayList<Integer> resultsOrderNumbers = new ArrayList<Integer>();
	private ArrayList<Double> resultsOrderTotals = new ArrayList<Double>();

	public OrderDetailDAO() {
		super();
		this.allOrderDetails = this.findAllObjectData();
		this.sortByTotalOrderAmount();
	}
	
	private ArrayList<Double> calculateEachOrderTotal() {
		double totalOrderAmount = 0;

		ArrayList<Integer> uniqueOrderNumbers = this.sortByUniqueOrderNumber();
		ArrayList<Double> uniqueOrderTotals = new ArrayList<Double>();

		for (int orderNumber : uniqueOrderNumbers) {
			for (OrderDetail orderDetail : this.allOrderDetails) {
				if (orderDetail.getOrderNumber() == orderNumber) {
					totalOrderAmount += orderDetail.getPriceEach() * orderDetail.getQuantityOrdered();
				}
			}
			uniqueOrderTotals.add(totalOrderAmount);
			totalOrderAmount = 0;
		}
		return uniqueOrderTotals;
	}
	
	@Override
	protected ArrayList<OrderDetail> findAllObjectData() {
		try {
			ResultSet results = this.baseQuery.useTable("orderdetails");

			while (results.next()) {
				int orderNumber = results.getInt("orderNumber");
				String productCode = results.getString("productCode");
				int quantityOrdered = results.getInt("quantityOrdered");
				double priceEach = results.getDouble("priceEach");
				int orderLineNumber = results.getInt("orderLineNumber");

				OrderDetail newOrderDetail = new OrderDetail(orderNumber, productCode, quantityOrdered, priceEach,
						orderLineNumber);

				this.allOrderDetails.add(newOrderDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.allOrderDetails;
	}
	
	public ArrayList<Integer> getResultsOrderNumbers() {
		return resultsOrderNumbers;
	}

	public ArrayList<Double> getResultsOrderTotals() {
		return resultsOrderTotals;
	}

	// We know that the data is inserted by OrderNumber so we can search adjacently
		private ArrayList<Integer> sortByUniqueOrderNumber() {
			int prevOrderNumber = 0;
			ArrayList<Integer> uniqueOrderNumbers = new ArrayList<Integer>();

			for (OrderDetail orderDetail : this.allOrderDetails) {
				if (orderDetail.getOrderNumber() != prevOrderNumber) {
					uniqueOrderNumbers.add(orderDetail.getOrderNumber());
					prevOrderNumber = orderDetail.getOrderNumber();
				}
			}
			return uniqueOrderNumbers;
		}
		
	private void sortByTotalOrderAmount() {
		ArrayList<Integer> uniqueOrderNumbers = this.sortByUniqueOrderNumber();
		ArrayList<Double> uniqueOrderTotals = this.calculateEachOrderTotal();
		
		for (int i = 0; i < uniqueOrderTotals.size(); i++) {
			if (uniqueOrderTotals.get(i) > 25000) {
				this.resultsOrderNumbers.add(uniqueOrderNumbers.get(i));
				this.resultsOrderTotals.add(uniqueOrderTotals.get(i));
			}
		}
	}

}
