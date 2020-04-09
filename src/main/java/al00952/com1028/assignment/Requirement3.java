package al00952.com1028.assignment;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is used to output Requirement 3 to console.
 * 
 * Requirement 3 - List the CustomerNames and OrderNumbers where an Order is > $25,000
 * 
 * @author Andy Lee
 * 
 */
public class Requirement3 {
	private CustomerDAO customerDAO;
	private OrderDAO orderDAO;
	private OrderDetailDAO orderDetailDAO;
	
	public Requirement3() {
		this.customerDAO = new CustomerDAO();
		this.orderDAO = new OrderDAO();
		this.orderDetailDAO = new OrderDetailDAO();
	}
	
	public String printMatchingRequirement() {
		ArrayList<String> resultsCustomerNames = this.customerDAO.getResultsCustomerNames();
		ArrayList<Integer> resultsCustomerNumbers = this.orderDAO.getResultsCustomerNumber();
		ArrayList<Integer> resultsOrderNumbers = this.orderDetailDAO.getResultsOrderNumbers();
		ArrayList<Double> resultsOrderTotals = this.orderDetailDAO.getResultsOrderTotals();
		
		ArrayList<InnerJoin> resultsInnerJoins = new ArrayList<InnerJoin>();
			
		for (int i = 0; i < resultsCustomerNumbers.size(); i++) {
			int customerNumber = resultsCustomerNumbers.get(i);
			String customerName = resultsCustomerNames.get(i);
			int orderNumber = resultsOrderNumbers.get(i);
			double orderTotal = resultsOrderTotals.get(i);
			
			InnerJoin newInnerJoin = new InnerJoin(customerNumber, customerName, orderNumber, orderTotal);
			
			resultsInnerJoins.add(newInnerJoin);
		}
		
		Collections.sort(resultsInnerJoins, new InnerJoinSort());
		
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < resultsInnerJoins.size(); i++) {
			buffer.append("CustomerNumber: ");
			buffer.append(resultsInnerJoins.get(i).getCustomerNumber());
			buffer.append("  ");
			buffer.append("OrderNumber: ");
			buffer.append(resultsInnerJoins.get(i).getOrderNumber());
			buffer.append("  ");
			buffer.append("OrderTotal: ");
			buffer.append(String.format("%1$8.2f", resultsInnerJoins.get(i).getOrderTotal()));
			buffer.append("  ");
			buffer.append("CustomerName: ");
			buffer.append(resultsInnerJoins.get(i).getCustomerName());
			buffer.append("\n");
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		Requirement3 requirement3 = new Requirement3();
		System.out.print(requirement3.printMatchingRequirement());
	}
	
}
