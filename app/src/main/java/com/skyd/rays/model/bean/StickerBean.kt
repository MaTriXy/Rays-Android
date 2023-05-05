package com.skyd.rays.model.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import java.util.UUID

const val STICKER_TABLE_NAME = "Sticker"

@Serializable
@Entity(tableName = STICKER_TABLE_NAME)
data class StickerBean(
    @PrimaryKey
    @ColumnInfo(name = UUID_COLUMN)
    var uuid: String,
    @ColumnInfo(name = TITLE_COLUMN)
    var title: String,
    @ColumnInfo(name = STICKER_MD5_COLUMN)
    var stickerMd5: String,
    @ColumnInfo(name = CREATE_TIME_COLUMN)
    var createTime: Long,
    @ColumnInfo(name = MODIFY_TIME_COLUMN)
    var modifyTime: Long?,
) : BaseBean {
    constructor(
        title: String,
        createTime: Long = System.currentTimeMillis(),
    ) : this(
        uuid = UUID.randomUUID().toString(),
        title = title,
        stickerMd5 = "",
        createTime = createTime,
        modifyTime = null,
    )

    fun fields(): List<Any?> {
        return listOf(uuid, title, stickerMd5, createTime, modifyTime)
    }

    override fun toString(): String {
        return "$uuid,$title,$stickerMd5,$createTime,$modifyTime"
    }

    companion object {
        const val UUID_COLUMN = "uuid"
        const val TITLE_COLUMN = "title"
        const val STICKER_MD5_COLUMN = "stickerMd5"
        const val CREATE_TIME_COLUMN = "createTime"
        const val MODIFY_TIME_COLUMN = "modifyTime"

        val columnName: List<Any> = listOf(
            UUID_COLUMN,
            TITLE_COLUMN,
            STICKER_MD5_COLUMN,
            CREATE_TIME_COLUMN,
            MODIFY_TIME_COLUMN
        )
    }
}
