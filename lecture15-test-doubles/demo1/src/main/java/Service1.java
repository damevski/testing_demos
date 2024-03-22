public class Service1 {

    private IDatabase database;

    public Service1(IDatabase database) {
        this.database = database;
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
