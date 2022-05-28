package unittesting;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("A special test case")
class ContactManagerTest {

	ContactManager manager = new ContactManager();;

	@BeforeAll
	static void init() {

	}

	@BeforeEach
	void beforeEachTest() {
		System.out.println("Before each called. ");
		manager = new ContactManager();
	}

	@AfterEach
	void afterEachTest() {
		System.out.println("After each called. ");
	}

	@AfterAll
	static void afterAllTests() {
		System.out.println("After all tests called. ");
	}

	@Test
	void cotactAddedSuccessfully() {
		manager.addContact("Sachin", "Tendulkar", "0123456789");
		assertEquals(1, manager.getAllContacts().size());
	}

	@Test
	@DisplayName("Test case to check contact with special chars")
	void cotactAddedSuccessfullyWithSpecialChars() {
		manager.addContact("123123Sachin@@@", "##Tendulkar!!", "0123456789");
		assertEquals(1, manager.getAllContacts().size());
	}

	@Test
	void cotactAddedwithEmptyName() {
		assertThrows(RuntimeException.class, () -> {
			manager.addContact(null, "Tendulkar", "0123456789");
		});
	}

	@Test
	void cotactAddedwithEmptyLastName() {
		assertThrows(RuntimeException.class, () -> {
			manager.addContact("Sachin", null, "0123456789");
		});
	}

	@Test
	@EnabledOnOs(value = OS.WINDOWS)
	void cotactAddedwithEmptyPhoneNumber() {
		assertThrows(RuntimeException.class, () -> {
			manager.addContact("Sachin", "Tendulkar", null);
		});
	}

	@Test
	void testOnlyOnDeveloperWorkstation() {
		assumeTrue("DEV".equals(System.getenv("ENV")), () -> "Aborting test: not on developer workstation");
		// remainder of test
	}

	@ParameterizedTest
	// @ValueSource(strings = { "01234678987979", "01234678987" })
	@MethodSource("namedArguments")
	// @CsvSource()
	void cotactAddedwithPhoneNumberMoreThan10Digit(Contact c) {

		assertThrows(RuntimeException.class, () -> {
			manager.addContact(c);
		});
	}

	static Stream<Contact> namedArguments() {
		return Stream.of(new Contact("A", "B", "012346789"), new Contact("A1", "B1", "012346789"));
	}

}
