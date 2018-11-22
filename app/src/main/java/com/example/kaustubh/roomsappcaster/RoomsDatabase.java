package com.example.kaustubh.roomsappcaster;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import android.content.Context;
import androidx.annotation.NonNull;



@Database(entities = {Task.class},version = 1,exportSchema = false)
public abstract class RoomsDatabase extends RoomDatabase {

     static final Migration migrations = new Migration(1,2) {
         @Override
         public void migrate(@NonNull SupportSQLiteDatabase database) {

         }
     };

    public  abstract TaskDao getTaskDao();

    private RoomsDatabase.Callback newCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };


    private static RoomsDatabase databaseObject;

    public static RoomsDatabase getInstance(Context ctx){
        if(databaseObject==null){
            databaseObject = buildDatabaseInstance(ctx);
        }
        return databaseObject;
    }

    private static RoomsDatabase buildDatabaseInstance(Context ctx) {
        return Room.databaseBuilder(ctx.getApplicationContext(),RoomsDatabase.class,"app-database")
                .build();
    }

}
