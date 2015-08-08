package fr.usagymancenis.usagym.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Noemie RULLIER on 06/04/15.
 */
public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 100;
    private static final String DATABASE_NAME = "USAGymDB";

    // Table Names
    public static final String TABLE_USA_USER = "USA_USER";

    // Common column names
    public static final String KEY_ID = "id";

    // USA_USER Table - column names
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_USER_EMAIL = "userEmail";
    public static final String KEY_USER_PASSWORD = "userPassword";

    // Table Create Statements
    // USA_USER table create statement
    private static final String CREATE_TABLE_USA_USER = "CREATE TABLE "
            + TABLE_USA_USER + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USER_NAME
            + " TEXT," + KEY_USER_EMAIL + " TEXT," + KEY_USER_PASSWORD
            + " TEXT" + ")";

    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating required tables
        db.execSQL(CREATE_TABLE_USA_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // On upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USA_USER);

        // Create new tables
        onCreate(db);
    }
}
