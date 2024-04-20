package comp3350.umhub.persistence.sqlite;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.io.File;
import java.io.IOException;

import comp3350.umhub.BuildConfig;

public class DatabaseHelper {
    private SQLiteDatabase myDataBase;

    // Database Information
    private static final String DB_PATH = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/";
    static final String DB_NAME = "db.db";

    public DatabaseHelper() throws IOException, DatabaseNotCreatedException {
        boolean dbexist = checkdatabase();
        if (dbexist) {
            opendatabase();
        } else {
            createdatabase();
            throw new DatabaseNotCreatedException("Database doesn't exist");
        }
    }

    public void opendatabase() throws SQLException {
        //Open the database
        String mypath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    private void createdatabase() throws IOException {
        //Open your local db as the input stream
        String mypath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openOrCreateDatabase(mypath, null);

        DBScriptIter scriptIter = new DBScriptIter();
        while (scriptIter.hasNext()) {
            myDataBase.execSQL(scriptIter.next());
        }
    }


    private boolean checkdatabase() {

        boolean checkdb = false;
        try {

            File dbFolder = new File(DB_PATH);
            if (!dbFolder.exists())
                dbFolder.mkdirs();

            String myPath = DB_PATH + DB_NAME;
            File dbfile = new File(myPath);
            checkdb = dbfile.exists();

        } catch (SQLiteException e) {
            System.out.println("Database doesn't exist");
        }
        return checkdb;
    }

    public synchronized void close() {
        if (myDataBase != null) {
            myDataBase.close();
        }
    }

    public SQLiteDatabase getDataBase() {
        return myDataBase;
    }

}
