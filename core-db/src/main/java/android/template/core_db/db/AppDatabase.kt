package android.template.core_db.db

import android.template.core_db.entity.MyModel
import android.template.core_db.entity.MyModelDao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MyModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun myModelDao(): MyModelDao
}