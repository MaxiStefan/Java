package ro.ase.cts.assignment3.testsuites;

import org.junit.runners.Suite;
import ro.ase.cts.assignment3.tests.*;
import org.junit.runner.RunWith;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestProductReq1.class,
   TestProductReq2.class,
   TestProductReq3.class
})

public class SuiteAllTests {

}
