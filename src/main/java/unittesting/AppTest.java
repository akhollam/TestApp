package unittesting;

public class AppTest {
	
	public static void main(String[] args) {
		
		ContactManager contactManager = new ContactManager();
		contactManager.addContact("Sachin", "Tendulkar", "0123456789");
		System.out.println(contactManager.getAllContacts());
		
	}

}
