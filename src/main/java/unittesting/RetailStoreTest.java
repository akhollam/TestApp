package unittesting;

import java.util.List;

public class RetailStoreTest {

	public static void main(String[] args) {

		SlabProvider slabProvider = null;

		double purchaseAmount = 9000;

		List<AmountSlab> amountSlabs = slabProvider.getSlabs("premium");
		for (AmountSlab amountSlab : amountSlabs) {

		}
	}
}
