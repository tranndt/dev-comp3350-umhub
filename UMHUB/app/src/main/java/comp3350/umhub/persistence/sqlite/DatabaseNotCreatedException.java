package comp3350.umhub.persistence.sqlite;

public class DatabaseNotCreatedException extends Exception {
    public DatabaseNotCreatedException(String exception)
    {
        super(exception);
    }
}
