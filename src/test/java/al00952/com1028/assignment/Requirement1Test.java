package al00952.com1028.assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Requirement1Test {

	@Test
	public void productTest() {
		Products product = new Products("S10_1678", "1969 Harley Davidson Ultimate Chopper", "Motorcycles", "1:10", "Min Lin Diecast", "This replica features working kickstand, front suspension, gear-shift lever, footbrake lever, drive chain, wheels and steering. All parts are particularly delicate due to their precise scale and require special care and attention.", 7933, 48.81, 95.70);
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
		ProductLines productLine = new ProductLines("Ships", "The perfect holiday or anniversary gift for executives, clients, friends, and family. These handcrafted model ships are unique, stunning works of art that will be treasured for generations! They come fully assembled and ready for display in the home or office. We guarantee the highest quality, and best value." );
		assertEquals("Ships", productLine.getProductLine());
		assertEquals("The perfect holiday or anniversary gift for executives, clients, friends, and family. These handcrafted model ships are unique, stunning works of art that will be treasured for generations! They come fully assembled and ready for display in the home or office. We guarantee the highest quality, and best value.", productLine.getTextDescription());

	}
	
	@Test
	public void productDAOTest() {
		ProductDAO productDAO = new ProductDAO();
		int productLineCount = 0;
		int i = 0;
		// The expected values for the products (i.e. the product names in this case)
		ArrayList<ArrayList<String>> expectedProducts = new ArrayList<ArrayList<String>>();
		ArrayList<String> expectedClassicCars = new ArrayList<String>(Arrays.asList("1952 Alpine Renault 1300", "1972 Alfa Romeo GTA", "1962 LanciaA Delta 16V", "1968 Ford Mustang", "2001 Ferrari Enzo", "1969 Corvair Monza", "1968 Dodge Charger", "1969 Ford Falcon", "1970 Plymouth Hemi Cuda", "1969 Dodge Charger", "1993 Mazda RX-7", "1965 Aston Martin DB5", "1948 Porsche 356-A Roadster", "1995 Honda Civic", "1998 Chrysler Plymouth Prowler", "1999 Indy 500 Monte Carlo SS", "1992 Ferrari 360 Spider red", "1985 Toyota Supra", "1969 Dodge Super Bee", "1976 Ford Gran Torino", "1948 Porsche Type 356 Roadster", "1970 Triumph Spitfire", "1957 Corvette Convertible", "1957 Ford Thunderbird", "1970 Chevy Chevelle SS 454", "1970 Dodge Coronet", "1966 Shelby Cobra 427 S/C", "1949 Jaguar XK 120", "1958 Chevy Corvette Limited Edition", "1952 Citroen-15CV", "1982 Lamborghini Diablo", "1969 Chevrolet Camaro Z28", "1971 Alpine Renault 1600s", "2002 Chevy Corvette", "1956 Porsche 356A Coupe", "1992 Porsche Cayenne Turbo Silver", "1961 Chevrolet Impala", "1982 Camaro Z28"));
		ArrayList<String> expectedMotorcycles = new ArrayList<String>(Arrays.asList("1969 Harley Davidson Ultimate Chopper", "1996 Moto Guzzi 1100i", "2003 Harley-Davidson Eagle Drag Bike", "2002 Suzuki XREO", "1936 Harley Davidson El Knucklehead", "1957 Vespa GS150", "1997 BMW R 1100 S", "1960 BSA Gold Star DBD34", "1982 Ducati 900 Monster", "1997 BMW F650 ST", "1982 Ducati 996 R", "1974 Ducati 350 Mk3 Desmo", "2002 Yamaha YZR M1"));
		ArrayList<String> expectedPlanes = new ArrayList<String>(Arrays.asList("1980s Black Hawk Helicopter", "P-51-D Mustang", "1928 British Royal Navy Airplane", "1900s Vintage Bi-Plane", "Corsair F4U ( Bird Cage)", "1900s Vintage Tri-Plane", "American Airlines: B767-300", "America West Airlines B757-200", "ATA: B757-300", "F/A 18 Hornet 1/72", "American Airlines: MD-11S", "Boeing X-32A JSF"));
		ArrayList<String> expectedShips = new ArrayList<String>(Arrays.asList("1999 Yamaha Speed Boat", "18th century schooner", "The Schooner Bluenose", "The Mayflower", "HMS Bounty", "The USS Constitution Ship", "The Titanic", "The Queen Mary", "Pont Yacht"));
		ArrayList<String> expectedTrains = new ArrayList<String>(Arrays.asList("Collectable Wooden Train", "1950's Chicago Surface Lines Streetcar", "1962 City of Detroit Streetcar"));
		ArrayList<String> expectedTrucksAndBuses = new ArrayList<String>(Arrays.asList("1958 Setra Bus", "1957 Chevy Pickup", "1940 Ford Pickup Truck", "1964 Mercedes Tour Bus", "1926 Ford Fire Engine", "1940s Ford truck", "1962 Volkswagen Microbus", "1980’s GM Manhattan Express", "1954 Greyhound Scenicruiser", "1996 Peterbilt 379 Stake Bed with Outrigger", "Diamond T620 Semi-Skirted Tanker"));
		ArrayList<String> expectedVintageCars = new ArrayList<String>(Arrays.asList("1937 Lincoln Berline", "1936 Mercedes-Benz 500K Special Roadster", "1917 Grand Touring Sedan", "1911 Ford Town Car", "1932 Model A Ford J-Coupe", "1928 Mercedes-Benz SSK", "1913 Ford Model T Speedster", "1934 Ford V8 Coupe", "18th Century Vintage Horse Carriage", "1903 Ford Model A", "1917 Maxwell Touring Car", "1941 Chevrolet Special Deluxe Cabriolet", "1932 Alfa Romeo 8C2300 Spider Sport", "1904 Buick Runabout", "1939 Cadillac Limousine", "1939 Chevrolet Deluxe Coupe", "1938 Cadillac V-16 Presidential Limousine", "1912 Ford Model T Delivery Wagon", "1937 Horch 930V Limousine", "1940 Ford Delivery Sedan", "1936 Mercedes Benz 500k Roadster", "1936 Chrysler Airflow", "1928 Ford Phaeton Deluxe", "1930 Buick Marquette Phaeton"));
		expectedProducts.add(expectedClassicCars);
		expectedProducts.add(expectedMotorcycles);
		expectedProducts.add(expectedPlanes);
		expectedProducts.add(expectedShips);
		expectedProducts.add(expectedTrains);
		expectedProducts.add(expectedTrucksAndBuses);
		expectedProducts.add(expectedVintageCars);
		
		for (ArrayList<Products> productLine : productDAO.getProductsFromProductLines()) {
			// Checks the total number of productlines from the actual method
			productLineCount++;
			// The actual values for the products (i.e. the product names in this case)
			// Checks one productline at a time
			ArrayList<String> actualProducts = new ArrayList<String>();
			for (Products product : productLine) {
				actualProducts.add(product.getProductName());
			}
			
			assertEquals(expectedProducts.get(i), actualProducts);
			i++;
		}
		
		assertEquals(7, productLineCount, 0);
		
		
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
		
		for (ProductLines productLine : productLineDAO.getAllProductLines()) {
			actualProductLines.add(productLine.getProductLine());
		}
		
		assertEquals(expectedProductLines, actualProductLines);
	}
	

	
}
