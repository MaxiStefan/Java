package floroiu.maximilian.stefan.g1091.assignment4.StubsTestSuites;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import ro.ase.cts.assignment4.CategoryImportantTests;
import ro.ase.cts.assignment4.StubsTest.TestCasePayOnline;
import ro.ase.cts.assignment4.StubsTest.TestCaseSetIban;



@RunWith(Categories.class)
@IncludeCategory(CategoryImportantTests.class)
@SuiteClasses({
	   TestCasePayOnline.class,
	   TestCaseSetIban.class
	})
public class SuiteImportantTests {

}
