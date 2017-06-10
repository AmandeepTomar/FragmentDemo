package tailor.latest.imran.amandeep.com.latesttailor.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 9/27/2016.
 */

public class LTDatabase extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME="LTDATABASE";
    public static final int DATABASE_VERSION=1;

    // ****************************** Define Table in Database ********************
    public static final String USER_TABLE="USERTABLE";


    // ******************************** Table Column ************************************

    // User Table Contain
    public static final String ID="id";
    public static final String USER_NAME="USERNAME";
    public static final String USER_EMAIL_ID="USERMAILID";
    public static final String USER_PASSWORD="USERPASSWORD";
    public static final String USER_MOBILE_NO="USERMOBILENO";
    public static final String USER_CREATED_ON="USERCREATEDON";
    public static final String USER_DEVICE_ID="USERDEVICEID";
    public static final String USER_IMAGE="USERIMAGE";




    //******************************** Table Create and Drop Query *********************************

    // User Table
    public static final String CREATE_USER_TABLE="CREATE"+USER_TABLE+"("
            +ID +"INTEGER PRIMARY KEY,"
            +USER_NAME+ "TEXT,"
            +USER_EMAIL_ID+ "TEXT,"
            +USER_PASSWORD+ "TEXT,"
            +USER_MOBILE_NO+ "TEXT,"
            +USER_CREATED_ON+ "TEXT,"
            +USER_DEVICE_ID+"TEXT,"
            +USER_IMAGE+ "TEXT"+")";



    public LTDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // On Create Method will be run first time
            db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // it will run only when we update the database

        if (oldVersion<=newVersion){
            // worked
        }

    }

    public SQLiteDatabase initializeDatabase(){
        SQLiteDatabase db=this.getWritableDatabase();
        return db;
    }

    public SQLiteDatabase getReadableDatabase(){
        SQLiteDatabase db=this.getReadableDatabase();
        return db;
    }
}
