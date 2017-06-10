package tailor.latest.imran.amandeep.com.latesttailor.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;

import tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern.DataBaseModelUserProfile;

/**
 * Created by admin on 9/27/2016.
 */

public class UserDb implements Serializable {
    private Context context;

    public UserDb(Context context) {
        this.context = context;
    }
//****************************************** Method for Adding User Profile Data ****************************

    public void addUserProfile(DataBaseModelUserProfile dmup){
        LTDatabase database=new LTDatabase(context);
        SQLiteDatabase db=database.initializeDatabase();

        ContentValues cv=new ContentValues();

        cv.put(LTDatabase.ID,dmup.getUserId());
        cv.put(LTDatabase.USER_NAME,dmup.getUserName());
        cv.put(LTDatabase.USER_EMAIL_ID,dmup.getUserMailId());
        cv.put(LTDatabase.USER_PASSWORD,dmup.getPassword());
        cv.put(LTDatabase.USER_MOBILE_NO,dmup.getMobileNo());
        cv.put(LTDatabase.USER_CREATED_ON,dmup.getCreatedOn());
        cv.put(LTDatabase.USER_DEVICE_ID,dmup.getUserDeviceId());
        cv.put(LTDatabase.USER_IMAGE,dmup.getImage());
        db.insert(LTDatabase.USER_TABLE,null,cv);
        db.close();

    }

    //***************************** Method for fetching all user profile data **************************************

    public ArrayList<DataBaseModelUserProfile> getAllProfileData(){
        ArrayList<DataBaseModelUserProfile> userList=new ArrayList<>();
        // All Select Query
        String selectQuery="SELECT * FROM"+LTDatabase.USER_TABLE;

        LTDatabase database=new LTDatabase(context);
        SQLiteDatabase db=database.initializeDatabase();

        Cursor cursor=db.rawQuery(selectQuery,null);

        if (cursor!=null)
            if (cursor.moveToFirst()){
                do{
                   /*
                    this is aliso a way to initialize or set values in a model class we will test it in future it will work or not
                   DataBaseModelUserProfile user=new DataBaseModelUserProfile(cursor.getString(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),
                            cursor.getString(7));*/

                    DataBaseModelUserProfile user=new DataBaseModelUserProfile();
                    user.setUserId(cursor.getString(0));
                    user.setUserName(cursor.getString(1));
                    user.setUserMailId(cursor.getString(2));
                    user.setPassword(cursor.getString(3));
                    user.setMobileNo(cursor.getString(4));
                    user.setCreatedOn(cursor.getString(5));
                    user.setUserDeviceId(cursor.getString(6));
                    user.setImage(cursor.getString(7));

                    userList.add(user);

                }while (cursor.moveToNext());
            }
        cursor.close();
        db.close();

        return userList;
    }

    //****************************************** Method for Count database count *******************************

    public int getProfileDataCount(){
        int count=0;
        LTDatabase database=new LTDatabase(context);
        SQLiteDatabase db=database.initializeDatabase();
        String countQuery="SELECT * FROM"+LTDatabase.USER_TABLE;
        Cursor cursor=db.rawQuery(countQuery,null);
        if (cursor!=null&&!cursor.isClosed()){
            count=cursor.getCount();
            cursor.close();
        }
        db.close();
        return count;
    }

    //************************************* Delete User **********************************************

    public void deleteUser(DataBaseModelUserProfile dbmup){
        LTDatabase database=new LTDatabase(context);
        SQLiteDatabase db=database.initializeDatabase();
        db.delete(LTDatabase.USER_TABLE,LTDatabase.ID+"= ?",
                new String[]{String.valueOf(dbmup.getUserId())});
        db.close();

    }

    //********************************** Delete User Without User Id***********************
     public void deleteUser() {
         LTDatabase database=new LTDatabase(context);
         SQLiteDatabase db=database.initializeDatabase();
         db.delete(LTDatabase.USER_TABLE,null,null);
         db.close();
     }


    //*************************** method for update some thing***************************************

    public void updateTablePlatforms(String id,String values) {
        LTDatabase database = new LTDatabase(context);
        SQLiteDatabase db = database.initializeDatabase();

       /* SQLiteDatabase db = dba.initilizeSqlitedb();
        String updatequery = "UPDATE " + DataBaseHelper.TABLE_USER + " SET " + DataBaseHelper.KEY_COURSE_STATUS  + " ='" + value + "'"+
                " WHERE " +  DataBaseHelper.KEY_ID_PROFILE  + " = " + id + "";
        db.execSQL(updatequery);*/
        db.close();
    }

}
