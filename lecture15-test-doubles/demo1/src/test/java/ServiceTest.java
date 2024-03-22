import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ServiceTest {

    @Test
    public void testQuery()  {
        Service t  = new Service();
        boolean check = t.query("* from t");
        assertTrue(check);
    }

    /*
     * Problem: I don't want to mess with the database each time
     */

}
