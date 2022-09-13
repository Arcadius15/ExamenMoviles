package edu.pe.idat.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.pe.idat.app.db.dao.PacienteDao
import edu.pe.idat.app.db.entity.PacienteEntity

@Database(entities = [PacienteEntity::class], version = 1)
public abstract class PacienteRoomDatabase : RoomDatabase(){
    abstract fun pacienteDao():PacienteDao

    companion object{
        @Volatile
        private var INSTANCE:PacienteRoomDatabase? = null

        fun getDatabase(context: Context):PacienteRoomDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!=null)
                return tempInstance
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PacienteRoomDatabase::class.java,
                    "pacientedb"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}