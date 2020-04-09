package al00952.com1028.assignment;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Run this class to test all 3 Requirements.
 * 
 * -------- Set H --------
 * Requirement 1 - List the Products in each ProductLine
 * Requirement 2 - Report the total Payments by Date
 * Requirement 3 - List the CustomerNames and OrderNumbers where an Order is > $25,000
 * 
 * @author Andy Lee
 */
@RunWith(Suite.class)
@SuiteClasses({ Requirement1Test.class, Requirement2Test.class, Requirement3Test.class })
public class AllRequirementTests {

}
