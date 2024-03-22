public class Service {

    private Database database;

    public Service() {
        database = new Database();
    }

    public boolean query(String query) {
        //code using database to be added
        return database.isAvailable();
    }

    @Override
    public String toString() {
        return "Using database with id: " + String.valueOf(database.getUniqueId());
    }
}
