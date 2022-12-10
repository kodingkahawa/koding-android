package com.koding.data

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentsDatabase : RoomDatabase() {
    abstract fun studentsDao(): StudentsDao

    companion object {
        private var INSTANCE: StudentsDatabase? = null

        fun getInstance(context: Context): StudentsDatabase {
            if (INSTANCE == null) {
                synchronized(StudentsDatabase::class.java) {
                    INSTANCE = createDatabase(context)
                }
            }
            return INSTANCE!!
        }

//        fun getDatabase(context: Context): StudentsDatabase {
//            return createDatabase(context)
//        }

        fun createDatabase(context: Context): StudentsDatabase {
            return Room.databaseBuilder(
                context,
                StudentsDatabase::class.java,
                "students-db"
            ).allowMainThreadQueries().build()
        }
    }


}

//object DatabaseBuilder {
//    private var INSTANCE: StudentsDatabase? = null
//
//    fun getInstance(context: Context): StudentsDatabase {
//        if (INSTANCE == null){
//            synchronized(StudentsDatabase::class.java){
//                INSTANCE = createDatabase(context)
//            }
//        }
//        return INSTANCE!!
//    }
//
//    private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,StudentsDatabase::class.java,"").build()
//}