package al00952.com1028.assignment;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Requirement1Test {

	@Test
	public void productTest() {
		Product product = new Product("S10_1678", "1969 Harley Davidson Ultimate Chopper", "Motorcycles", "1:10", "Min Lin Diecast", "This replica features working kickstand, front suspension, gear-shift lever, footbrake lever, drive chain, wheels and steering. All parts are particularly delicate due to their precise scale and require special care and attention.", 7933, 48.81, 95.70);
		assertEquals("S10_1678", product.getProductCode());
		assertEquals("1969 Harley Davidson Ultimate Chopper", product.getProductName());
		assertEquals("Motorcycles", product.getProductLine());
		assertEquals("1:10", product.getProductScale());
		assertEquals("Min Lin Diecast", product.getProductVendor());
		assertEquals("This replica features working kickstand, front suspension, gear-shift lever, footbrake lever, drive chain, wheels and steering. All parts are particularly delicate due to their precise scale and require special care and attention.", product.getProductDescription());
		assertEquals(7933, product.getQuantityInStock(), 0);
		assertEquals(48.81, product.getBuyPrice(), 0);
		assertEquals(95.7, product.getMSRP(), 0);
	}

	@Test
	public void productLineTest() {
		ProductLine productLine = new ProductLine("Ships", "The perfect holiday or anniversary gift for executives, clients, friends, and family. These handcrafted model ships are unique, stunning works of art that will be treasured for generations! They come fully assembled and ready for display in the home or office. We guarantee the highest quality, and best value." );
		assertEquals("Ships", productLine.getProductLine());
		assertEquals("The perfect holiday or anniversary gift for executives, clients, friends, and family. These handcrafted model ships are unique, stunning works of art that will be treasured for generations! They come fully assembled and ready for display in the home or office. We guarantee the highest quality, and best value.", productLine.getTextDescription());

	}
	
	@Test
	public void productLineDAOTest() {
		// The expected values for the ProductLines
		ArrayList<String> expectedProductLines = new ArrayList<String>();
		expectedProductLines.add("Classic Cars");
		expectedProductLines.add("Motorcycles");
		expectedProductLines.add("Planes");
		expectedProductLines.add("Ships");
		expectedProductLines.add("Trains");
		expectedProductLines.add("Trucks and Buses");
		expectedProductLines.add("Vintage Cars");
		
		ProductLineDAO productLineDAO = new ProductLineDAO();
		// The actual values for the ProductLines
		ArrayList<String> actualProductLines = new ArrayList<String>();
		
		for (ProductLine productLine : productLineDAO.getAllProductLines()) {
			actualProductLines.add(productLine.getProductLine());
		}
		
		assertEquals(expectedProductLines, actualProductLines);
	}
	
	@Test
	public void productDAOTest() {
		ProductDAO productDAO = new ProductDAO();
		assertEquals("------------- Classic Cars -------------\r\n" + 
				"1952 Alpine Renault 1300 - [S10_1949]\r\n" + 
				"1972 Alfa Romeo GTA - [S10_4757]\r\n" + 
				"1962 LanciaA Delta 16V - [S10_4962]\r\n" + 
				"1968 Ford Mustang - [S12_1099]\r\n" + 
				"2001 Ferrari Enzo - [S12_1108]\r\n" + 
				"1969 Corvair Monza - [S12_3148]\r\n" + 
				"1968 Dodge Charger - [S12_3380]\r\n" + 
				"1969 Ford Falcon - [S12_3891]\r\n" + 
				"1970 Plymouth Hemi Cuda - [S12_3990]\r\n" + 
				"1969 Dodge Charger - [S12_4675]\r\n" + 
				"1993 Mazda RX-7 - [S18_1129]\r\n" + 
				"1965 Aston Martin DB5 - [S18_1589]\r\n" + 
				"1948 Porsche 356-A Roadster - [S18_1889]\r\n" + 
				"1995 Honda Civic - [S18_1984]\r\n" + 
				"1998 Chrysler Plymouth Prowler - [S18_2238]\r\n" + 
				"1999 Indy 500 Monte Carlo SS - [S18_2870]\r\n" + 
				"1992 Ferrari 360 Spider red - [S18_3232]\r\n" + 
				"1985 Toyota Supra - [S18_3233]\r\n" + 
				"1969 Dodge Super Bee - [S18_3278]\r\n" + 
				"1976 Ford Gran Torino - [S18_3482]\r\n" + 
				"1948 Porsche Type 356 Roadster - [S18_3685]\r\n" + 
				"1970 Triumph Spitfire - [S18_4027]\r\n" + 
				"1957 Corvette Convertible - [S18_4721]\r\n" + 
				"1957 Ford Thunderbird - [S18_4933]\r\n" + 
				"1970 Chevy Chevelle SS 454 - [S24_1046]\r\n" + 
				"1970 Dodge Coronet - [S24_1444]\r\n" + 
				"1966 Shelby Cobra 427 S/C - [S24_1628]\r\n" + 
				"1949 Jaguar XK 120 - [S24_2766]\r\n" + 
				"1958 Chevy Corvette Limited Edition - [S24_2840]\r\n" + 
				"1952 Citroen-15CV - [S24_2887]\r\n" + 
				"1982 Lamborghini Diablo - [S24_2972]\r\n" + 
				"1969 Chevrolet Camaro Z28 - [S24_3191]\r\n" + 
				"1971 Alpine Renault 1600s - [S24_3371]\r\n" + 
				"2002 Chevy Corvette - [S24_3432]\r\n" + 
				"1956 Porsche 356A Coupe - [S24_3856]\r\n" + 
				"1992 Porsche Cayenne Turbo Silver - [S24_4048]\r\n" + 
				"1961 Chevrolet Impala - [S24_4620]\r\n" + 
				"1982 Camaro Z28 - [S700_2824]\r\n" + 
				"\r\n" + 
				"------------- Motorcycles -------------\r\n" + 
				"1969 Harley Davidson Ultimate Chopper - [S10_1678]\r\n" + 
				"1996 Moto Guzzi 1100i - [S10_2016]\r\n" + 
				"2003 Harley-Davidson Eagle Drag Bike - [S10_4698]\r\n" + 
				"2002 Suzuki XREO - [S12_2823]\r\n" + 
				"1936 Harley Davidson El Knucklehead - [S18_2625]\r\n" + 
				"1957 Vespa GS150 - [S18_3782]\r\n" + 
				"1997 BMW R 1100 S - [S24_1578]\r\n" + 
				"1960 BSA Gold Star DBD34 - [S24_2000]\r\n" + 
				"1982 Ducati 900 Monster - [S24_2360]\r\n" + 
				"1997 BMW F650 ST - [S32_1374]\r\n" + 
				"1982 Ducati 996 R - [S32_2206]\r\n" + 
				"1974 Ducati 350 Mk3 Desmo - [S32_4485]\r\n" + 
				"2002 Yamaha YZR M1 - [S50_4713]\r\n" + 
				"\r\n" + 
				"------------- Planes -------------\r\n" + 
				"1980s Black Hawk Helicopter - [S18_1662]\r\n" + 
				"P-51-D Mustang - [S18_2581]\r\n" + 
				"1928 British Royal Navy Airplane - [S24_1785]\r\n" + 
				"1900s Vintage Bi-Plane - [S24_2841]\r\n" + 
				"Corsair F4U ( Bird Cage) - [S24_3949]\r\n" + 
				"1900s Vintage Tri-Plane - [S24_4278]\r\n" + 
				"American Airlines: B767-300 - [S700_1691]\r\n" + 
				"America West Airlines B757-200 - [S700_2466]\r\n" + 
				"ATA: B757-300 - [S700_2834]\r\n" + 
				"F/A 18 Hornet 1/72 - [S700_3167]\r\n" + 
				"American Airlines: MD-11S - [S700_4002]\r\n" + 
				"Boeing X-32A JSF - [S72_1253]\r\n" + 
				"\r\n" + 
				"------------- Ships -------------\r\n" + 
				"1999 Yamaha Speed Boat - [S18_3029]\r\n" + 
				"18th century schooner - [S24_2011]\r\n" + 
				"The Schooner Bluenose - [S700_1138]\r\n" + 
				"The Mayflower - [S700_1938]\r\n" + 
				"HMS Bounty - [S700_2047]\r\n" + 
				"The USS Constitution Ship - [S700_2610]\r\n" + 
				"The Titanic - [S700_3505]\r\n" + 
				"The Queen Mary - [S700_3962]\r\n" + 
				"Pont Yacht - [S72_3212]\r\n" + 
				"\r\n" + 
				"------------- Trains -------------\r\n" + 
				"Collectable Wooden Train - [S18_3259]\r\n" + 
				"1950's Chicago Surface Lines Streetcar - [S32_3207]\r\n" + 
				"1962 City of Detroit Streetcar - [S50_1514]\r\n" + 
				"\r\n" + 
				"------------- Trucks and Buses -------------\r\n" + 
				"1958 Setra Bus - [S12_1666]\r\n" + 
				"1957 Chevy Pickup - [S12_4473]\r\n" + 
				"1940 Ford Pickup Truck - [S18_1097]\r\n" + 
				"1964 Mercedes Tour Bus - [S18_2319]\r\n" + 
				"1926 Ford Fire Engine - [S18_2432]\r\n" + 
				"1940s Ford truck - [S18_4600]\r\n" + 
				"1962 Volkswagen Microbus - [S24_2300]\r\n" + 
				"1980’s GM Manhattan Express - [S32_1268]\r\n" + 
				"1954 Greyhound Scenicruiser - [S32_2509]\r\n" + 
				"1996 Peterbilt 379 Stake Bed with Outrigger - [S32_3522]\r\n" + 
				"Diamond T620 Semi-Skirted Tanker - [S50_1392]\r\n" + 
				"\r\n" + 
				"------------- Vintage Cars -------------\r\n" + 
				"1937 Lincoln Berline - [S18_1342]\r\n" + 
				"1936 Mercedes-Benz 500K Special Roadster - [S18_1367]\r\n" + 
				"1917 Grand Touring Sedan - [S18_1749]\r\n" + 
				"1911 Ford Town Car - [S18_2248]\r\n" + 
				"1932 Model A Ford J-Coupe - [S18_2325]\r\n" + 
				"1928 Mercedes-Benz SSK - [S18_2795]\r\n" + 
				"1913 Ford Model T Speedster - [S18_2949]\r\n" + 
				"1934 Ford V8 Coupe - [S18_2957]\r\n" + 
				"18th Century Vintage Horse Carriage - [S18_3136]\r\n" + 
				"1903 Ford Model A - [S18_3140]\r\n" + 
				"1917 Maxwell Touring Car - [S18_3320]\r\n" + 
				"1941 Chevrolet Special Deluxe Cabriolet - [S18_3856]\r\n" + 
				"1932 Alfa Romeo 8C2300 Spider Sport - [S18_4409]\r\n" + 
				"1904 Buick Runabout - [S18_4522]\r\n" + 
				"1939 Cadillac Limousine - [S18_4668]\r\n" + 
				"1939 Chevrolet Deluxe Coupe - [S24_1937]\r\n" + 
				"1938 Cadillac V-16 Presidential Limousine - [S24_2022]\r\n" + 
				"1912 Ford Model T Delivery Wagon - [S24_3151]\r\n" + 
				"1937 Horch 930V Limousine - [S24_3420]\r\n" + 
				"1940 Ford Delivery Sedan - [S24_3816]\r\n" + 
				"1936 Mercedes Benz 500k Roadster - [S24_3969]\r\n" + 
				"1936 Chrysler Airflow - [S24_4258]\r\n" + 
				"1928 Ford Phaeton Deluxe - [S32_4289]\r\n" + 
				"1930 Buick Marquette Phaeton - [S50_1341]\r\n" + 
				"\r\n" + 
				"", productDAO.printProductsFromProductLines());
	}
	
	@Test
	public void verifyProductDAOAgainstSQL() {
		BaseQuery baseQuery = new BaseQuery("root", "password123");
		ProductDAO productDAO = new ProductDAO();
		ArrayList<ArrayList<Product>> actualResults = productDAO.getProductsFromProductLines();
 		ArrayList<ArrayList<Product>> expectedResults = new ArrayList<ArrayList<Product>>();
		
		try {
			ResultSet resultsClassicCars = baseQuery.customSQLstatement("SELECT * FROM products WHERE productLine = 'Classic Cars'");
			ResultSet resultsMotorcycles = baseQuery.customSQLstatement("SELECT * FROM products WHERE productLine = 'Motorcycles'");
			ResultSet resultsPlanes = baseQuery.customSQLstatement("SELECT * FROM products WHERE productLine = 'Planes'");
			ResultSet resultsShips = baseQuery.customSQLstatement("SELECT * FROM products WHERE productLine = 'Ships'");
			ResultSet resultsTrains = baseQuery.customSQLstatement("SELECT * FROM products WHERE productLine = 'Trains'");
			ResultSet resultsTrucksAndBuses = baseQuery.customSQLstatement("SELECT * FROM products WHERE productLine = 'Trucks and Buses'");
			ResultSet resultsVintageCars = baseQuery.customSQLstatement("SELECT * FROM products WHERE productLine = 'Vintage Cars'");
			
			ArrayList<ResultSet> resultsProductLines = new ArrayList<ResultSet>(Arrays.asList(resultsClassicCars, resultsMotorcycles, resultsPlanes, resultsShips, resultsTrains, resultsTrucksAndBuses, resultsVintageCars));

			for (ResultSet results : resultsProductLines) {
				ArrayList<Product> expectedProductLine = new ArrayList<Product>();
				while (results.next()) {
					String productCode = results.getString("productCode");
					String productName = results.getString("productName");
					String productLine = results.getString("productLine");
					String productScale = results.getString("productScale");
					String productVendor = results.getString("productVendor");
					String productDescription = results.getString("productDescription");
					int quantityInStock = results.getInt("quantityInStock");
					double buyPrice = results.getDouble("buyPrice");
					double MSRP = results.getDouble("MSRP");

					Product newProduct = new Product(productCode, productName, productLine, productScale, productVendor,
							productDescription, quantityInStock, buyPrice, MSRP);
					
					expectedProductLine.add(newProduct);
				}
				expectedResults.add(expectedProductLine);
			}
			
			for (int i = 0; i < expectedResults.size(); i++) {
				for (int j = 0; j < expectedResults.get(i).size(); j++) {
					assertEquals(expectedResults.get(i).get(j).getProductName(), actualResults.get(i).get(j).getProductName());
				}
			}
			
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	
}
