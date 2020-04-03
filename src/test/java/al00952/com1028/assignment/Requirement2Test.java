package al00952.com1028.assignment;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class Requirement2Test {
	
	// This method converts a String to a Date SQL data type
	public Date dateConversion(String date) throws ParseException {
		Date convertedDate = Date.valueOf(date);
		return convertedDate;
	}
	
	@Test
	public void paymentTest() throws ParseException {		
		Date testDate = this.dateConversion("2004-10-19");
		
		Payments payment = new Payments(103, "HQ336336", testDate, 6066.78);
		
		assertEquals(103, payment.getCustomerNumber());
		assertEquals("HQ336336", payment.getCheckNumber());
		assertEquals(testDate, payment.getPaymentDate());
		assertEquals(6066.78, payment.getAmount(), 0);
	}
		
	@Test 
	public void verifyPaymentDAOAgainstSQL() {
		BaseQuery baseQuery = new BaseQuery("root", "password123");
		PaymentDAO paymentDAO = new PaymentDAO();
		
		try {
			ResultSet results = baseQuery.customSQLstatement("SELECT * FROM payments ORDER BY paymentDate");
			ArrayList<Payments> expectedResults = new ArrayList<Payments>();
			ArrayList<Payments> actualResults = paymentDAO.sortAllPaymentsbyDate();
			
			while(results.next()) {
				int customerNumber = results.getInt("customerNumber");
				String checkNumber = results.getString("checkNumber");
				Date paymentDate = results.getDate("paymentDate");
				double amount = results.getDouble("amount");
				
				Payments newPayment = new Payments(customerNumber, checkNumber, paymentDate, amount);
				
				expectedResults.add(newPayment);
			}
			
			for (int i = 0; i < expectedResults.size(); i++) {
				assertEquals(expectedResults.get(i).getPaymentDate(), actualResults.get(i).getPaymentDate());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void paymentDAOTest() {
		PaymentDAO paymentDAO = new PaymentDAO();
		
		assertEquals("Date:  2003-01-16  CustomerNumber:  363  Amount:  10223.83  CheckNumber:  IS232033\r\n" + 
				"Date:  2003-01-28  CustomerNumber:  128  Amount:  10549.01  CheckNumber:  DI925118\r\n" + 
				"Date:  2003-01-30  CustomerNumber:  181  Amount:   5494.78  CheckNumber:  GQ132144\r\n" + 
				"Date:  2003-02-16  CustomerNumber:  121  Amount:  50218.95  CheckNumber:  DB889831\r\n" + 
				"Date:  2003-02-20  CustomerNumber:  145  Amount:  53959.21  CheckNumber:  JJ246391\r\n" + 
				"Date:  2003-02-25  CustomerNumber:  141  Amount:  40206.20  CheckNumber:  JN722010\r\n" + 
				"Date:  2003-03-02  CustomerNumber:  278  Amount:  52151.81  CheckNumber:  GP636783\r\n" + 
				"Date:  2003-03-09  CustomerNumber:  385  Amount:  51001.22  CheckNumber:  EK785462\r\n" + 
				"Date:  2003-03-12  CustomerNumber:  131  Amount:  22292.62  CheckNumber:  CL442705\r\n" + 
				"Date:  2003-03-20  CustomerNumber:  486  Amount:  25833.14  CheckNumber:  JB117768\r\n" + 
				"Date:  2003-03-27  CustomerNumber:  187  Amount:  48425.69  CheckNumber:  KL124726\r\n" + 
				"Date:  2003-04-09  CustomerNumber:  129  Amount:  16537.85  CheckNumber:  PI42991\r\n" + 
				"Date:  2003-04-09  CustomerNumber:  144  Amount:   7674.94  CheckNumber:  LA685678\r\n" + 
				"Date:  2003-04-11  CustomerNumber:  124  Amount:  11044.30  CheckNumber:  CQ287967\r\n" + 
				"Date:  2003-04-16  CustomerNumber:  424  Amount:  21665.98  CheckNumber:  LM271923\r\n" + 
				"Date:  2003-04-19  CustomerNumber:  381  Amount:   1627.56  CheckNumber:  CC475233\r\n" + 
				"Date:  2003-04-20  CustomerNumber:  172  Amount:  33383.14  CheckNumber:  EH208589\r\n" + 
				"Date:  2003-04-22  CustomerNumber:  148  Amount:  44380.15  CheckNumber:  BI507030\r\n" + 
				"Date:  2003-05-09  CustomerNumber:  216  Amount:   3101.40  CheckNumber:  BG407567\r\n" + 
				"Date:  2003-05-12  CustomerNumber:  382  Amount:  35826.33  CheckNumber:  CC871084\r\n" + 
				"Date:  2003-05-20  CustomerNumber:  114  Amount:  45864.03  CheckNumber:  GG31455\r\n" + 
				"Date:  2003-05-21  CustomerNumber:  353  Amount:  16700.47  CheckNumber:  GT878649\r\n" + 
				"Date:  2003-05-25  CustomerNumber:  350  Amount:  50824.66  CheckNumber:  CI471510\r\n" + 
				"Date:  2003-05-31  CustomerNumber:  114  Amount:   7565.08  CheckNumber:  NP603840\r\n" + 
				"Date:  2003-06-05  CustomerNumber:  103  Amount:  14571.44  CheckNumber:  JM555205\r\n" + 
				"Date:  2003-06-06  CustomerNumber:  112  Amount:  32641.98  CheckNumber:  HQ55022\r\n" + 
				"Date:  2003-06-13  CustomerNumber:  458  Amount:  57131.92  CheckNumber:  OO606861\r\n" + 
				"Date:  2003-06-18  CustomerNumber:  151  Amount:  58841.35  CheckNumber:  IP568906\r\n" + 
				"Date:  2003-06-25  CustomerNumber:  447  Amount:  17032.29  CheckNumber:  ER615123\r\n" + 
				"Date:  2003-07-05  CustomerNumber:  323  Amount:   2880.00  CheckNumber:  HG738664\r\n" + 
				"Date:  2003-07-06  CustomerNumber:  198  Amount:   6036.96  CheckNumber:  HQ920205\r\n" + 
				"Date:  2003-07-07  CustomerNumber:  324  Amount:  29429.14  CheckNumber:  FP443161\r\n" + 
				"Date:  2003-07-16  CustomerNumber:  496  Amount:  32077.44  CheckNumber:  MB342426\r\n" + 
				"Date:  2003-07-18  CustomerNumber:  250  Amount:  23419.47  CheckNumber:  HN114306\r\n" + 
				"Date:  2003-07-19  CustomerNumber:  141  Amount:  36251.03  CheckNumber:  AU364101\r\n" + 
				"Date:  2003-07-21  CustomerNumber:  242  Amount:  14232.70  CheckNumber:  KI744716\r\n" + 
				"Date:  2003-07-21  CustomerNumber:  353  Amount:  13920.26  CheckNumber:  ED878227\r\n" + 
				"Date:  2003-08-03  CustomerNumber:  282  Amount:  24013.52  CheckNumber:  IA793562\r\n" + 
				"Date:  2003-08-05  CustomerNumber:  161  Amount:  38675.13  CheckNumber:  NI908214\r\n" + 
				"Date:  2003-08-15  CustomerNumber:  124  Amount:  111654.40  CheckNumber:  KI131716\r\n" + 
				"Date:  2003-08-16  CustomerNumber:  334  Amount:  29716.86  CheckNumber:  HH517378\r\n" + 
				"Date:  2003-08-20  CustomerNumber:  320  Amount:  41016.75  CheckNumber:  HO576374\r\n" + 
				"Date:  2003-08-22  CustomerNumber:  381  Amount:   1128.20  CheckNumber:  MS154481\r\n" + 
				"Date:  2003-09-05  CustomerNumber:  205  Amount:  50342.74  CheckNumber:  LL562733\r\n" + 
				"Date:  2003-09-15  CustomerNumber:  447  Amount:   6631.36  CheckNumber:  AO757239\r\n" + 
				"Date:  2003-09-16  CustomerNumber:  379  Amount:  32680.31  CheckNumber:  FR499138\r\n" + 
				"Date:  2003-09-28  CustomerNumber:  276  Amount:  41554.73  CheckNumber:  LE432182\r\n" + 
				"Date:  2003-09-28  CustomerNumber:  487  Amount:  29997.09  CheckNumber:  AH612904\r\n" + 
				"Date:  2003-10-06  CustomerNumber:  311  Amount:  32723.04  CheckNumber:  FA728475\r\n" + 
				"Date:  2003-10-17  CustomerNumber:  333  Amount:   9821.32  CheckNumber:  JK479662\r\n" + 
				"Date:  2003-10-18  CustomerNumber:  128  Amount:  24101.81  CheckNumber:  FA465482\r\n" + 
				"Date:  2003-10-18  CustomerNumber:  219  Amount:   4465.85  CheckNumber:  BR941480\r\n" + 
				"Date:  2003-10-20  CustomerNumber:  201  Amount:  23908.24  CheckNumber:  DP677013\r\n" + 
				"Date:  2003-10-24  CustomerNumber:  299  Amount:  36798.88  CheckNumber:  AD304085\r\n" + 
				"Date:  2003-10-24  CustomerNumber:  347  Amount:  20452.50  CheckNumber:  LG808674\r\n" + 
				"Date:  2003-10-26  CustomerNumber:  141  Amount:  49539.37  CheckNumber:  JN355280\r\n" + 
				"Date:  2003-10-27  CustomerNumber:  186  Amount:  37602.48  CheckNumber:  AK412714\r\n" + 
				"Date:  2003-10-27  CustomerNumber:  473  Amount:  17746.26  CheckNumber:  PC688499\r\n" + 
				"Date:  2003-10-28  CustomerNumber:  121  Amount:   1491.38  CheckNumber:  FD317790\r\n" + 
				"Date:  2003-10-31  CustomerNumber:  227  Amount:  36164.46  CheckNumber:  MQ413968\r\n" + 
				"Date:  2003-10-31  CustomerNumber:  424  Amount:  22042.37  CheckNumber:  OA595449\r\n" + 
				"Date:  2003-11-03  CustomerNumber:  321  Amount:  85559.12  CheckNumber:  DJ15149\r\n" + 
				"Date:  2003-11-08  CustomerNumber:  462  Amount:   9977.85  CheckNumber:  GC60330\r\n" + 
				"Date:  2003-11-13  CustomerNumber:  276  Amount:  38547.19  CheckNumber:  KM841847\r\n" + 
				"Date:  2003-11-15  CustomerNumber:  333  Amount:  23936.53  CheckNumber:  HL209210\r\n" + 
				"Date:  2003-11-15  CustomerNumber:  452  Amount:  27121.90  CheckNumber:  ED473873\r\n" + 
				"Date:  2003-11-18  CustomerNumber:  161  Amount:  50743.65  CheckNumber:  BR478494\r\n" + 
				"Date:  2003-11-18  CustomerNumber:  233  Amount:  16909.84  CheckNumber:  JG981190\r\n" + 
				"Date:  2003-11-18  CustomerNumber:  386  Amount:  38524.29  CheckNumber:  DO106109\r\n" + 
				"Date:  2003-11-19  CustomerNumber:  175  Amount:  24879.08  CheckNumber:  IO448913\r\n" + 
				"Date:  2003-11-20  CustomerNumber:  452  Amount:  15130.97  CheckNumber:  FN640986\r\n" + 
				"Date:  2003-11-22  CustomerNumber:  171  Amount:  42783.81  CheckNumber:  IL104425\r\n" + 
				"Date:  2003-11-22  CustomerNumber:  242  Amount:  33818.34  CheckNumber:  AF40894\r\n" + 
				"Date:  2003-11-23  CustomerNumber:  324  Amount:  37455.77  CheckNumber:  HB150714\r\n" + 
				"Date:  2003-11-24  CustomerNumber:  278  Amount:  37723.79  CheckNumber:  NI983021\r\n" + 
				"Date:  2003-11-24  CustomerNumber:  320  Amount:  52548.49  CheckNumber:  MU817160\r\n" + 
				"Date:  2003-11-24  CustomerNumber:  344  Amount:  31428.21  CheckNumber:  AF246722\r\n" + 
				"Date:  2003-11-25  CustomerNumber:  124  Amount:  45084.38  CheckNumber:  NT141748\r\n" + 
				"Date:  2003-11-28  CustomerNumber:  339  Amount:  34606.28  CheckNumber:  DA98827\r\n" + 
				"Date:  2003-11-29  CustomerNumber:  484  Amount:  47513.19  CheckNumber:  JH546765\r\n" + 
				"Date:  2003-12-02  CustomerNumber:  385  Amount:  20644.24  CheckNumber:  BN347084\r\n" + 
				"Date:  2003-12-03  CustomerNumber:  167  Amount:  85024.46  CheckNumber:  GN228846\r\n" + 
				"Date:  2003-12-04  CustomerNumber:  205  Amount:   3879.96  CheckNumber:  GL756480\r\n" + 
				"Date:  2003-12-04  CustomerNumber:  489  Amount:  22275.73  CheckNumber:  OC773849\r\n" + 
				"Date:  2003-12-05  CustomerNumber:  363  Amount:  55425.77  CheckNumber:  PN238558\r\n" + 
				"Date:  2003-12-05  CustomerNumber:  455  Amount:  38139.18  CheckNumber:  HA777606\r\n" + 
				"Date:  2003-12-07  CustomerNumber:  259  Amount:  27988.47  CheckNumber:  GB361972\r\n" + 
				"Date:  2003-12-07  CustomerNumber:  319  Amount:  36092.40  CheckNumber:  OM548174\r\n" + 
				"Date:  2003-12-09  CustomerNumber:  141  Amount:  63843.55  CheckNumber:  KT52578\r\n" + 
				"Date:  2003-12-09  CustomerNumber:  211  Amount:  45480.79  CheckNumber:  BJ535230\r\n" + 
				"Date:  2003-12-09  CustomerNumber:  475  Amount:   7678.25  CheckNumber:  JP113227\r\n" + 
				"Date:  2003-12-10  CustomerNumber:  146  Amount:  39712.10  CheckNumber:  LJ160635\r\n" + 
				"Date:  2003-12-10  CustomerNumber:  471  Amount:  35505.63  CheckNumber:  CO645196\r\n" + 
				"Date:  2003-12-11  CustomerNumber:  129  Amount:  23923.93  CheckNumber:  ID449593\r\n" + 
				"Date:  2003-12-14  CustomerNumber:  216  Amount:  40473.86  CheckNumber:  MM342086\r\n" + 
				"Date:  2003-12-16  CustomerNumber:  357  Amount:  20220.04  CheckNumber:  AG240323\r\n" + 
				"Date:  2003-12-18  CustomerNumber:  202  Amount:  36527.61  CheckNumber:  HI358554\r\n" + 
				"Date:  2003-12-22  CustomerNumber:  151  Amount:  58793.53  CheckNumber:  BF686658\r\n" + 
				"Date:  2003-12-26  CustomerNumber:  148  Amount:  105743.00  CheckNumber:  KM172879\r\n" + 
				"Date:  2003-12-26  CustomerNumber:  495  Amount:  59265.14  CheckNumber:  BH167026\r\n" + 
				"Date:  2004-01-16  CustomerNumber:  146  Amount:  49614.72  CheckNumber:  FU793410\r\n" + 
				"Date:  2004-01-18  CustomerNumber:  347  Amount:  21053.69  CheckNumber:  DG700707\r\n" + 
				"Date:  2004-01-19  CustomerNumber:  177  Amount:  47177.59  CheckNumber:  CI381435\r\n" + 
				"Date:  2004-01-28  CustomerNumber:  406  Amount:  49165.16  CheckNumber:  HJ217687\r\n" + 
				"Date:  2004-01-30  CustomerNumber:  141  Amount:  59830.55  CheckNumber:  HJ32686\r\n" + 
				"Date:  2004-01-31  CustomerNumber:  489  Amount:   7310.42  CheckNumber:  PO860906\r\n" + 
				"Date:  2004-02-06  CustomerNumber:  458  Amount:  22162.61  CheckNumber:  NA377824\r\n" + 
				"Date:  2004-02-10  CustomerNumber:  256  Amount:   5759.42  CheckNumber:  EP227123\r\n" + 
				"Date:  2004-02-13  CustomerNumber:  475  Amount:  36070.47  CheckNumber:  PB951268\r\n" + 
				"Date:  2004-02-17  CustomerNumber:  473  Amount:   7612.06  CheckNumber:  LL427009\r\n" + 
				"Date:  2004-02-28  CustomerNumber:  166  Amount:  22474.17  CheckNumber:  LA318629\r\n" + 
				"Date:  2004-02-29  CustomerNumber:  487  Amount:  12573.28  CheckNumber:  PT550181\r\n" + 
				"Date:  2004-03-01  CustomerNumber:  189  Amount:  32538.74  CheckNumber:  NM916675\r\n" + 
				"Date:  2004-03-03  CustomerNumber:  314  Amount:  16901.38  CheckNumber:  MD809704\r\n" + 
				"Date:  2004-03-10  CustomerNumber:  114  Amount:  44894.74  CheckNumber:  NR27552\r\n" + 
				"Date:  2004-03-13  CustomerNumber:  298  Amount:  47375.92  CheckNumber:  AJ574927\r\n" + 
				"Date:  2004-03-15  CustomerNumber:  171  Amount:  18997.89  CheckNumber:  GB878038\r\n" + 
				"Date:  2004-03-15  CustomerNumber:  239  Amount:  80375.24  CheckNumber:  NQ865547\r\n" + 
				"Date:  2004-03-18  CustomerNumber:  146  Amount:  40978.53  CheckNumber:  FP549817\r\n" + 
				"Date:  2004-03-24  CustomerNumber:  128  Amount:  33820.62  CheckNumber:  FH668230\r\n" + 
				"Date:  2004-03-26  CustomerNumber:  124  Amount:  43369.30  CheckNumber:  LF217299\r\n" + 
				"Date:  2004-03-28  CustomerNumber:  240  Amount:  24995.61  CheckNumber:  JO719695\r\n" + 
				"Date:  2004-03-29  CustomerNumber:  173  Amount:  20355.24  CheckNumber:  IG462397\r\n" + 
				"Date:  2004-04-02  CustomerNumber:  344  Amount:  15322.93  CheckNumber:  NJ906924\r\n" + 
				"Date:  2004-04-14  CustomerNumber:  412  Amount:  31670.37  CheckNumber:  PJ434867\r\n" + 
				"Date:  2004-04-14  CustomerNumber:  486  Amount:   5899.38  CheckNumber:  BL66528\r\n" + 
				"Date:  2004-04-16  CustomerNumber:  328  Amount:   7178.66  CheckNumber:  EN930356\r\n" + 
				"Date:  2004-04-17  CustomerNumber:  177  Amount:  15183.63  CheckNumber:  AU750837\r\n" + 
				"Date:  2004-04-24  CustomerNumber:  260  Amount:  29284.42  CheckNumber:  NH776924\r\n" + 
				"Date:  2004-04-25  CustomerNumber:  181  Amount:  22602.36  CheckNumber:  CM564612\r\n" + 
				"Date:  2004-04-25  CustomerNumber:  311  Amount:  16212.59  CheckNumber:  NQ966143\r\n" + 
				"Date:  2004-04-26  CustomerNumber:  145  Amount:  28211.70  CheckNumber:  ED39322\r\n" + 
				"Date:  2004-04-30  CustomerNumber:  456  Amount:   1679.92  CheckNumber:  MO743231\r\n" + 
				"Date:  2004-05-04  CustomerNumber:  209  Amount:  36069.26  CheckNumber:  PH785937\r\n" + 
				"Date:  2004-05-12  CustomerNumber:  455  Amount:  32239.47  CheckNumber:  IR662429\r\n" + 
				"Date:  2004-05-13  CustomerNumber:  173  Amount:  11843.45  CheckNumber:  GP545698\r\n" + 
				"Date:  2004-05-14  CustomerNumber:  495  Amount:   6276.60  CheckNumber:  FN155234\r\n" + 
				"Date:  2004-05-15  CustomerNumber:  357  Amount:  36442.34  CheckNumber:  NB291497\r\n" + 
				"Date:  2004-05-17  CustomerNumber:  141  Amount:  26155.91  CheckNumber:  NU627706\r\n" + 
				"Date:  2004-05-22  CustomerNumber:  334  Amount:  28394.54  CheckNumber:  LF737277\r\n" + 
				"Date:  2004-05-30  CustomerNumber:  328  Amount:  31102.85  CheckNumber:  NR631421\r\n" + 
				"Date:  2004-06-15  CustomerNumber:  201  Amount:  37258.94  CheckNumber:  OO846801\r\n" + 
				"Date:  2004-06-17  CustomerNumber:  406  Amount:  25080.96  CheckNumber:  NA197101\r\n" + 
				"Date:  2004-06-21  CustomerNumber:  209  Amount:   4632.31  CheckNumber:  ED520529\r\n" + 
				"Date:  2004-06-21  CustomerNumber:  398  Amount:  22037.91  CheckNumber:  DO787644\r\n" + 
				"Date:  2004-06-21  CustomerNumber:  450  Amount:  59551.38  CheckNumber:  EF485824\r\n" + 
				"Date:  2004-06-24  CustomerNumber:  323  Amount:  37281.36  CheckNumber:  ES347491\r\n" + 
				"Date:  2004-07-01  CustomerNumber:  233  Amount:  22997.45  CheckNumber:  II180006\r\n" + 
				"Date:  2004-07-03  CustomerNumber:  145  Amount:   4710.73  CheckNumber:  CN328545\r\n" + 
				"Date:  2004-07-07  CustomerNumber:  166  Amount:  44160.92  CheckNumber:  DC979307\r\n" + 
				"Date:  2004-07-09  CustomerNumber:  141  Amount:  35420.74  CheckNumber:  MC46946\r\n" + 
				"Date:  2004-07-10  CustomerNumber:  175  Amount:  42044.77  CheckNumber:  PI15215\r\n" + 
				"Date:  2004-07-11  CustomerNumber:  362  Amount:  18473.71  CheckNumber:  FP170292\r\n" + 
				"Date:  2004-07-18  CustomerNumber:  386  Amount:  51619.02  CheckNumber:  HG438769\r\n" + 
				"Date:  2004-07-25  CustomerNumber:  412  Amount:  35034.57  CheckNumber:  GH197075\r\n" + 
				"Date:  2004-07-26  CustomerNumber:  151  Amount:  20314.44  CheckNumber:  GB852215\r\n" + 
				"Date:  2004-07-28  CustomerNumber:  471  Amount:   9415.13  CheckNumber:  AB661578\r\n" + 
				"Date:  2004-08-01  CustomerNumber:  382  Amount:   6419.84  CheckNumber:  CT821147\r\n" + 
				"Date:  2004-08-02  CustomerNumber:  282  Amount:  35806.73  CheckNumber:  JT819493\r\n" + 
				"Date:  2004-08-02  CustomerNumber:  379  Amount:  12530.51  CheckNumber:  GB890854\r\n" + 
				"Date:  2004-08-08  CustomerNumber:  119  Amount:  47924.19  CheckNumber:  LN373447\r\n" + 
				"Date:  2004-08-09  CustomerNumber:  314  Amount:  45352.47  CheckNumber:  LQ244073\r\n" + 
				"Date:  2004-08-11  CustomerNumber:  148  Amount:   2611.84  CheckNumber:  DD635282\r\n" + 
				"Date:  2004-08-13  CustomerNumber:  204  Amount:  51152.86  CheckNumber:  GC697638\r\n" + 
				"Date:  2004-08-16  CustomerNumber:  141  Amount:  20009.53  CheckNumber:  MF629602\r\n" + 
				"Date:  2004-08-20  CustomerNumber:  112  Amount:  33347.88  CheckNumber:  ND748579\r\n" + 
				"Date:  2004-08-28  CustomerNumber:  124  Amount:  85410.87  CheckNumber:  BG255406\r\n" + 
				"Date:  2004-08-30  CustomerNumber:  260  Amount:  37527.58  CheckNumber:  IO164641\r\n" + 
				"Date:  2004-09-04  CustomerNumber:  249  Amount:  48298.99  CheckNumber:  NE404084\r\n" + 
				"Date:  2004-09-05  CustomerNumber:  286  Amount:  43134.04  CheckNumber:  KH910279\r\n" + 
				"Date:  2004-09-05  CustomerNumber:  299  Amount:  32260.16  CheckNumber:  NR157385\r\n" + 
				"Date:  2004-09-07  CustomerNumber:  157  Amount:  63357.13  CheckNumber:  NN711988\r\n" + 
				"Date:  2004-09-09  CustomerNumber:  172  Amount:   1960.80  CheckNumber:  AD832091\r\n" + 
				"Date:  2004-09-11  CustomerNumber:  131  Amount:  35321.97  CheckNumber:  NB445135\r\n" + 
				"Date:  2004-09-16  CustomerNumber:  166  Amount:  38785.48  CheckNumber:  BQ327613\r\n" + 
				"Date:  2004-09-18  CustomerNumber:  298  Amount:  61402.00  CheckNumber:  LF501133\r\n" + 
				"Date:  2004-09-19  CustomerNumber:  167  Amount:  12538.01  CheckNumber:  ED743615\r\n" + 
				"Date:  2004-09-19  CustomerNumber:  249  Amount:  33924.24  CheckNumber:  IJ399820\r\n" + 
				"Date:  2004-09-21  CustomerNumber:  198  Amount:   5858.56  CheckNumber:  IS946883\r\n" + 
				"Date:  2004-09-21  CustomerNumber:  362  Amount:  15059.76  CheckNumber:  OG208861\r\n" + 
				"Date:  2004-09-24  CustomerNumber:  204  Amount:   4424.40  CheckNumber:  IS150005\r\n" + 
				"Date:  2004-09-28  CustomerNumber:  415  Amount:  31310.09  CheckNumber:  ER54537\r\n" + 
				"Date:  2004-09-30  CustomerNumber:  448  Amount:  48809.90  CheckNumber:  KR822727\r\n" + 
				"Date:  2004-10-03  CustomerNumber:  189  Amount:  17359.53  CheckNumber:  BO711618\r\n" + 
				"Date:  2004-10-19  CustomerNumber:  103  Amount:   6066.78  CheckNumber:  HQ336336\r\n" + 
				"Date:  2004-10-21  CustomerNumber:  186  Amount:  34341.08  CheckNumber:  KA602407\r\n" + 
				"Date:  2004-10-22  CustomerNumber:  256  Amount:  53116.99  CheckNumber:  HE84936\r\n" + 
				"Date:  2004-10-24  CustomerNumber:  339  Amount:  23333.06  CheckNumber:  AP286625\r\n" + 
				"Date:  2004-10-26  CustomerNumber:  484  Amount:   3474.66  CheckNumber:  GK294076\r\n" + 
				"Date:  2004-10-28  CustomerNumber:  286  Amount:  47411.33  CheckNumber:  DR578578\r\n" + 
				"Date:  2004-11-01  CustomerNumber:  141  Amount:  36140.38  CheckNumber:  DB583216\r\n" + 
				"Date:  2004-11-02  CustomerNumber:  124  Amount:  55639.66  CheckNumber:  HR86578\r\n" + 
				"Date:  2004-11-02  CustomerNumber:  227  Amount:  53745.34  CheckNumber:  NU21326\r\n" + 
				"Date:  2004-11-03  CustomerNumber:  187  Amount:  52825.29  CheckNumber:  AM968797\r\n" + 
				"Date:  2004-11-04  CustomerNumber:  121  Amount:  17876.32  CheckNumber:  KI831359\r\n" + 
				"Date:  2004-11-06  CustomerNumber:  259  Amount:  61234.67  CheckNumber:  EU280955\r\n" + 
				"Date:  2004-11-06  CustomerNumber:  319  Amount:  42339.76  CheckNumber:  HL685576\r\n" + 
				"Date:  2004-11-08  CustomerNumber:  202  Amount:  33594.58  CheckNumber:  IQ627690\r\n" + 
				"Date:  2004-11-13  CustomerNumber:  456  Amount:  27550.51  CheckNumber:  GJ715659\r\n" + 
				"Date:  2004-11-14  CustomerNumber:  119  Amount:  19501.82  CheckNumber:  DB933704\r\n" + 
				"Date:  2004-11-14  CustomerNumber:  161  Amount:   2434.25  CheckNumber:  BR352384\r\n" + 
				"Date:  2004-11-15  CustomerNumber:  458  Amount:  33145.56  CheckNumber:  DD995006\r\n" + 
				"Date:  2004-11-16  CustomerNumber:  181  Amount:  44400.50  CheckNumber:  OH367219\r\n" + 
				"Date:  2004-11-16  CustomerNumber:  240  Amount:  46788.14  CheckNumber:  IF245157\r\n" + 
				"Date:  2004-11-17  CustomerNumber:  363  Amount:  50799.69  CheckNumber:  HL575273\r\n" + 
				"Date:  2004-11-18  CustomerNumber:  128  Amount:   7466.32  CheckNumber:  IP383901\r\n" + 
				"Date:  2004-11-19  CustomerNumber:  157  Amount:  35152.12  CheckNumber:  HI618861\r\n" + 
				"Date:  2004-11-19  CustomerNumber:  385  Amount:  15822.84  CheckNumber:  CP804873\r\n" + 
				"Date:  2004-11-23  CustomerNumber:  486  Amount:  45994.07  CheckNumber:  HS86661\r\n" + 
				"Date:  2004-11-27  CustomerNumber:  382  Amount:  42813.83  CheckNumber:  PH29054\r\n" + 
				"Date:  2004-11-27  CustomerNumber:  462  Amount:  48355.87  CheckNumber:  PE176846\r\n" + 
				"Date:  2004-11-28  CustomerNumber:  121  Amount:  34638.14  CheckNumber:  MA302151\r\n" + 
				"Date:  2004-11-29  CustomerNumber:  398  Amount:  48927.64  CheckNumber:  KB54275\r\n" + 
				"Date:  2004-12-01  CustomerNumber:  145  Amount:  20564.86  CheckNumber:  HR182688\r\n" + 
				"Date:  2004-12-02  CustomerNumber:  131  Amount:  50025.35  CheckNumber:  MA724562\r\n" + 
				"Date:  2004-12-03  CustomerNumber:  381  Amount:  12081.52  CheckNumber:  BC726082\r\n" + 
				"Date:  2004-12-04  CustomerNumber:  172  Amount:  51209.58  CheckNumber:  CE51751\r\n" + 
				"Date:  2004-12-05  CustomerNumber:  278  Amount:  37654.09  CheckNumber:  BJ483870\r\n" + 
				"Date:  2004-12-06  CustomerNumber:  198  Amount:   9658.74  CheckNumber:  FI192930\r\n" + 
				"Date:  2004-12-06  CustomerNumber:  216  Amount:  24945.21  CheckNumber:  ML780814\r\n" + 
				"Date:  2004-12-07  CustomerNumber:  424  Amount:  25505.98  CheckNumber:  KF480160\r\n" + 
				"Date:  2004-12-08  CustomerNumber:  129  Amount:  26248.78  CheckNumber:  DM826140\r\n" + 
				"Date:  2004-12-08  CustomerNumber:  187  Amount:  47159.11  CheckNumber:  BQ39062\r\n" + 
				"Date:  2004-12-11  CustomerNumber:  350  Amount:  18888.31  CheckNumber:  BQ602907\r\n" + 
				"Date:  2004-12-12  CustomerNumber:  144  Amount:  36005.71  CheckNumber:  IR846303\r\n" + 
				"Date:  2004-12-13  CustomerNumber:  324  Amount:  13671.82  CheckNumber:  DQ409197\r\n" + 
				"Date:  2004-12-14  CustomerNumber:  151  Amount:  39964.63  CheckNumber:  KI884577\r\n" + 
				"Date:  2004-12-15  CustomerNumber:  114  Amount:  82261.22  CheckNumber:  MA765515\r\n" + 
				"Date:  2004-12-17  CustomerNumber:  112  Amount:  14191.12  CheckNumber:  BO864823\r\n" + 
				"Date:  2004-12-17  CustomerNumber:  447  Amount:  26304.13  CheckNumber:  OU516561\r\n" + 
				"Date:  2004-12-18  CustomerNumber:  103  Amount:   1676.14  CheckNumber:  OM314933\r\n" + 
				"Date:  2004-12-24  CustomerNumber:  323  Amount:  39440.59  CheckNumber:  PQ803830\r\n" + 
				"Date:  2004-12-27  CustomerNumber:  124  Amount:  47142.70  CheckNumber:  HI366474\r\n" + 
				"Date:  2004-12-30  CustomerNumber:  250  Amount:  26311.63  CheckNumber:  HD284647\r\n" + 
				"Date:  2004-12-31  CustomerNumber:  141  Amount:  116208.40  CheckNumber:  ID10962\r\n" + 
				"Date:  2004-12-31  CustomerNumber:  496  Amount:  52166.00  CheckNumber:  MN89921\r\n" + 
				"Date:  2005-01-03  CustomerNumber:  282  Amount:  31835.36  CheckNumber:  OD327378\r\n" + 
				"Date:  2005-01-10  CustomerNumber:  353  Amount:  49705.52  CheckNumber:  CO351193\r\n" + 
				"Date:  2005-01-18  CustomerNumber:  320  Amount:   8307.28  CheckNumber:  GJ597719\r\n" + 
				"Date:  2005-01-27  CustomerNumber:  334  Amount:  45785.34  CheckNumber:  CS435306\r\n" + 
				"Date:  2005-01-29  CustomerNumber:  350  Amount:   1834.56  CheckNumber:  OB648482\r\n" + 
				"Date:  2005-02-02  CustomerNumber:  161  Amount:  12692.19  CheckNumber:  KG644125\r\n" + 
				"Date:  2005-02-03  CustomerNumber:  381  Amount:  14379.90  CheckNumber:  GB117430\r\n" + 
				"Date:  2005-02-06  CustomerNumber:  205  Amount:  39580.60  CheckNumber:  NM739638\r\n" + 
				"Date:  2005-02-09  CustomerNumber:  276  Amount:  27083.78  CheckNumber:  EM979878\r\n" + 
				"Date:  2005-02-12  CustomerNumber:  379  Amount:  28322.83  CheckNumber:  CA762595\r\n" + 
				"Date:  2005-02-14  CustomerNumber:  398  Amount:  33967.73  CheckNumber:  AJ478695\r\n" + 
				"Date:  2005-02-15  CustomerNumber:  311  Amount:  46770.52  CheckNumber:  DG336041\r\n" + 
				"Date:  2005-02-22  CustomerNumber:  119  Amount:  49523.67  CheckNumber:  NG94694\r\n" + 
				"Date:  2005-03-01  CustomerNumber:  333  Amount:  21432.31  CheckNumber:  NF959653\r\n" + 
				"Date:  2005-03-02  CustomerNumber:  219  Amount:   3452.75  CheckNumber:  BN17870\r\n" + 
				"Date:  2005-03-05  CustomerNumber:  124  Amount:  101244.59  CheckNumber:  AE215433\r\n" + 
				"Date:  2005-03-10  CustomerNumber:  186  Amount:  23602.90  CheckNumber:  AE192287\r\n" + 
				"Date:  2005-03-15  CustomerNumber:  321  Amount:  46781.66  CheckNumber:  LA556321\r\n" + 
				"Date:  2005-03-18  CustomerNumber:  141  Amount:  120166.58  CheckNumber:  JE105477\r\n" + 
				"Date:  2005-03-25  CustomerNumber:  141  Amount:  65071.26  CheckNumber:  IN446258\r\n" + 
				"Date:  2005-03-27  CustomerNumber:  148  Amount:   3516.04  CheckNumber:  ME497970\r\n" + 
				"Date:  2005-04-15  CustomerNumber:  462  Amount:  30293.77  CheckNumber:  ED203908\r\n" + 
				"Date:  2005-04-16  CustomerNumber:  124  Amount:  83598.04  CheckNumber:  ET64396\r\n" + 
				"Date:  2005-04-18  CustomerNumber:  448  Amount:  27966.54  CheckNumber:  FS299615\r\n" + 
				"Date:  2005-04-23  CustomerNumber:  406  Amount:  12190.85  CheckNumber:  BJMPR4545\r\n" + 
				"Date:  2005-04-30  CustomerNumber:  276  Amount:  29848.52  CheckNumber:  OJ819725\r\n" + 
				"Date:  2005-05-03  CustomerNumber:  209  Amount:  35157.75  CheckNumber:  BOAF82044\r\n" + 
				"Date:  2005-05-03  CustomerNumber:  452  Amount:   8807.12  CheckNumber:  HG635467\r\n" + 
				"Date:  2005-05-17  CustomerNumber:  250  Amount:  17928.09  CheckNumber:  EQ12267\r\n" + 
				"Date:  2005-05-18  CustomerNumber:  398  Amount:    615.45  CheckNumber:  JPMR4544\r\n" + 
				"Date:  2005-05-19  CustomerNumber:  141  Amount:  46895.48  CheckNumber:  DL460618\r\n" + 
				"Date:  2005-05-19  CustomerNumber:  175  Amount:  28500.78  CheckNumber:  CITI3434344\r\n" + 
				"Date:  2005-05-20  CustomerNumber:  233  Amount:  29070.38  CheckNumber:  BOFA23232\r\n" + 
				"Date:  2005-05-23  CustomerNumber:  323  Amount:  75020.13  CheckNumber:  AL493079\r\n" + 
				"Date:  2005-05-25  CustomerNumber:  496  Amount:  30253.75  CheckNumber:  EU531600\r\n" + 
				"Date:  2005-06-03  CustomerNumber:  242  Amount:  12432.32  CheckNumber:  HR224331\r\n" + 
				"Date:  2005-06-09  CustomerNumber:  353  Amount:  46656.94  CheckNumber:  HJ618252\r\n" + 
				"", paymentDAO.printTotalPaymentsByDate());
	}
}
