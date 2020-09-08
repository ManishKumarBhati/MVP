package com.bmk.daggerproject.data.db

import androidx.room.*
import io.reactivex.Single

@Entity(tableName = "match_data")
data class MatchData(
    @PrimaryKey
    @ColumnInfo(name = "message") var message: String
)

@Dao
interface MatchDOA {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(data: MatchData)

    @Query("SELECT message FROM match_data")
    fun getAlData(): Single<String>
}