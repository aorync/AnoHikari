package com.syntxr.anohikari.data.source

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameTable
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.syntxr.anohikari.domain.model.Jozz
import com.syntxr.anohikari.domain.model.Qoran
import com.syntxr.anohikari.domain.model.Sora

@Database(
    exportSchema = true,
    entities = [Qoran::class],
    views = [Sora::class, Jozz::class],
    version = 2,
    autoMigrations = [
        AutoMigration(
            from = 1,
            to = 2,
            spec = QoranDatabase.Migration1To2::class
        )
    ]
)
abstract class QoranDatabase: RoomDatabase() {
    abstract val  qoranDao: QoranDao

    @RenameTable(fromTableName = "qoran", toTableName = "quran")
    class Migration1To2 : AutoMigrationSpec

    companion object {
        const val DB_NAME = "qoran.db"
    }
}