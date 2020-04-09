package al00952.com1028.assignment;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class OrderDetailDAO {
	private BaseQuery baseQuery;
	private ArrayList<OrderDetail> allOrderDetails = new ArrayList<OrderDetail>();
	private ArrayList<Integer> uniqueOrderNumbers = new ArrayList<Integer>();
	private ArrayList<Double> uniqueOrderTotals = new ArrayList<Double>();
	private ArrayList<Integer> resultsOrderNumbers = new ArrayList<Integer>();
	private ArrayList<Double> resultsOrderTotals = new ArrayList<Double>();

	public OrderDetailDAO() {
		this.baseQuery = new BaseQuery();
		this.allOrderDetails = this.getAllOrderDetails();
		this.uniqueOrderNumbers = this.sortByUniqueOrderNumber();
		this.uniqueOrderTotals = this.calculateEachOrderNumber();
		this.sortByTotalOrderAmount();
	}

	private void sortByTotalOrderAmount() {
		for (int i = 0; i < this.uniqueOrderTotals.size(); i++) {
			if (this.uniqueOrderTotals.get(i) > 25000) {
				this.resultsOrderNumbers.add(this.uniqueOrderNumbers.get(i));
				this.resultsOrderTotals.add(this.uniqueOrderTotals.get(i));
			}
		}
	}

	public ArrayList<Integer> getResultsOrderNumbers() {
		return resultsOrderNumbers;
	}

	public ArrayList<Double> getResultsOrderTotals() {
		return resultsOrderTotals;
	}

	private ArrayList<Double> calculateEachOrderNumber() {
		double totalOrderAmount = 0;

		ArrayList<Double> uniqueOrderTotals = new ArrayList<Double>();

		for (int orderNumber : this.uniqueOrderNumbers) {
			for (OrderDetail orderDetail : this.allOrderDetails) {
				if (orderDetail.getOrderNumber() == orderNumber) {
					totalOrderAmount += orderDetail.getPriceEach() * orderDetail.getQuantityOrdered();
				}
			}
			uniqueOrderTotals.add(twoDecimalPlaces(totalOrderAmount));
			totalOrderAmount = 0;
		}
		return uniqueOrderTotals;
	}

	// This method is used to round the total order amount to 2 d.p.
	private static double twoDecimalPlaces(double value) {
		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
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

	private ArrayList<OrderDetail> getAllOrderDetails() {
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

}
