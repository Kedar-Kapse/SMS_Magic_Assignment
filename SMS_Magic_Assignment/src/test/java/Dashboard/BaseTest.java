package Dashboard;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void beforeEachTestMethod() {
        System.out.println("Before each test method is executing...");
       
    }

    @AfterEach
    public void afterEachTestMethod() {
        System.out.println("After each test method is executing...");
       
    }
}
