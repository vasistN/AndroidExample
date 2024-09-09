package com.app.dumyproject.db

import android.content.Context
import androidx.room.*


@Database(entities = [Subscriber::class], version = 1)
abstract  class SubscriberDatabase : RoomDatabase() {

    abstract val subscriberDAO: SubscriberDAO

    companion object{
        @Volatile
        private var INSTANCE : SubscriberDatabase? = null
        fun getInstance(context: Context):SubscriberDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SubscriberDatabase::class.java,
                        "subscriber_data_database"
                    ).build()
                    INSTANCE = instance //This line is missing in the lesson's code
                }
                INSTANCE = instance
                return instance
            }
        }

    }


}