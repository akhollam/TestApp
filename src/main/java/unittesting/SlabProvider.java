package unittesting;

import java.util.List;

public interface SlabProvider {

	List<AmountSlab> getSlabs(String customerType);

}
