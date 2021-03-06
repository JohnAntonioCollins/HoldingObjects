package collins.john;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by johncollins on 2/7/17.
 */
public class PhoneBookTest {

    PhoneBook testPhoneBook;
    Entries testEntries;
    String testName = "Test Name";
    String testNumber = "215-333-5555";

    @Before
    public void setUp() {
        testPhoneBook = new PhoneBook();
        testEntries = new Entries(testNumber);
        testPhoneBook.addEntry(testName, testNumber);
        testPhoneBook.addEntry("Test Name 2", "222-222-2222");
        testPhoneBook.addEntry("Test Name 3", "333333333333");
        testPhoneBook.addEntry("Test Name 4", "444444444444");
        testPhoneBook.addEntry("Test Name 5", "555555555555");


    }

    @Test
    public void addEntryTest() {
        int actual = testPhoneBook.phoneBook.size();
        //int expected = -1; //fail test
        int expected = 5;
        assertEquals("should return 5, map size 5", expected, actual);
    }

    @Test
    public void removeEntryTest() {
        testPhoneBook.removeEntry(testName);
        int actual = testPhoneBook.phoneBook.size();
        //int expected = -1; //fail test
        int expected = 4;
        assertEquals("should return 4, map size 4", expected, actual);

    }

    @Test
    public void lookupTest() {
        String actual = testPhoneBook.lookup("Test Name");
        String expected = "[215-333-5555]";
        //String expected = "fail";//fail test
        assertEquals("should return testNumber", expected, actual);
    }

    @Test
    public void printEntriesTest() {
        testPhoneBook.removeEntry("Test Name");
        String actual = testPhoneBook.printEntries();
        String expected = "Test Name 2    [222-222-2222]\nTest Name 3    [333333333333]\nTest Name 4    [444444444444]\nTest Name 5    [555555555555]\n";
        //String expected = "fail";//fail test
        assertEquals("should return Test Name   [215-333-5555]", expected, actual);

    }

    @Test
    public void printEntriesPhonebookIsEmptyTest() {
        PhoneBook emptyBook = new PhoneBook();
        String actual = emptyBook.printEntries();
        String expected = "Phonebook is empty";
        //String expected = "fail";//fail test
        assertEquals("should return Phonebook is empty", expected, actual);
    }

    @Test
    public void reverseLookupTest() {
        String actual = testPhoneBook.reverseLookup("333333333333");
        String expected = "Test Name 3";
        //String expected = "fail";//fail test
        assertEquals("should return Test Name 3, contact that has that ph#", expected, actual);
    }

    @Test
    public void reverseLookupDoesNotExistTest() {
        String actual = testPhoneBook.reverseLookup("xxx-xxx-xxxx");
        String expected = "Does not exist";
        //String expected = "fail";//fail test
        assertEquals("should return Does Not Exist", expected, actual);
    }
    @Test
    public void printEntriesKeysTest(){
        String actual = String.valueOf(testPhoneBook.printEntriesKeys());
        //String expected = "fail";//fail test
        String expected = "[Test Name, Test Name 2, Test Name 3, Test Name 4, Test Name 5]";
        assertEquals("should return...", expected, actual);
    }

}
