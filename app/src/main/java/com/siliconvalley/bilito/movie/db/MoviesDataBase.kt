package com.siliconvalley.bilito.movie.db

import androidx.room.Database
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
/*
 * our data base mange which will get interface of user data base model and Dao and will implement service of data base
 */
@Database(
    entities = [MoviesEntity::class],
    version = 1 ,
    exportSchema = false
)

abstract class MoviesDataBase:RoomDatabase() {
    abstract fun getMovieDao(): MovieDao

    companion object{
        //Volatile is for immediate running in jvm background
        @Volatile private var instance : MoviesDataBase? = null

        private val LOCK = Any()

        //here we build our data base
        //we need our context which we will have in invoke
        //a simple title and instance of db manager
        private fun dbBuilder(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MoviesDataBase::class.java,
            "movieDB"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        //we are building our instance here
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: dbBuilder(context).also {
                instance = it
            }
        }
    }

}