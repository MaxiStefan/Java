package ro.ase.cts.assignment3.testsuites;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import ro.ase.cts.assignment3.testCategories.CategoryImportantProductTest;
import ro.ase.cts.assignment3.tests.TestProductReq1;
import ro.ase.cts.assignment3.tests.TestProductReq2;
import ro.ase.cts.assignment3.tests.TestProductReq3;

@RunWith(Categories.class)
@IncludeCategory(CategoryImportantProductTest.class)
@SuiteClasses({
	   TestProductReq1.class,
	   TestProductReq2.class,
	   TestProductReq3.class
	})
public class SuiteCategoriesTests {

}
