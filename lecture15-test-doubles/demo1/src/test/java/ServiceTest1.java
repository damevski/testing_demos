import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ServiceTest1 {

    class FakeDatabase implements IDatabase {

        @Override
        public boolean isAvailable() {
            return true;
        }

        @Override
        public int getUniqueId() {
            return 0;
        }
    }

    @Test
    public void testQuery()  {
        Service1 t  = new Service1(new FakeDatabase());
        boolean check = t.query("* from t");
        assertTrue(check);
    }

    /*
     * Problem: This is too much work and clutters my code
     */

}
