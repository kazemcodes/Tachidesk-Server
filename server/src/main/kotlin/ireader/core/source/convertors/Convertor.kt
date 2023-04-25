package ireader.core.source.convertors

import eu.kanade.tachiyomi.source.model.SChapter
import eu.kanade.tachiyomi.source.model.SManga
import ireader.core.source.model.ChapterInfo
import ireader.core.source.model.MangaInfo
import ireader.core.source.model.Page
import ireader.core.source.model.Text

fun MangaInfo.toSManga(): SManga {
    return SManga.create().apply {
        this@apply.title = this@toSManga.title
        this@apply.url = this@toSManga.key
        this@apply.thumbnail_url = this@toSManga.cover
        this@apply.artist = this@toSManga.artist
        this@apply.author = this@toSManga.author
        this@apply.genre = this@toSManga.genres.joinToString(",")
        this@apply.description = this@toSManga.description
        this@apply.status = this@toSManga.status.toInt()
    }
}
fun SManga.toMangaInfo(): MangaInfo {
    return MangaInfo(
        key = this.url,
        title = this.title,
        artist = this.artist ?: "",
        author = this.author ?: "",
        description = this.description ?: "",
        genres = this.genre?.split(",") ?: emptyList(),
        status = this.status.toLong(),
        cover = this.thumbnail_url ?: ""
    )
}

fun ChapterInfo.toSChapter(): SChapter {
    return SChapter.create().apply {
        this@apply.name = this@toSChapter.name
        this@apply.url = this@toSChapter.key
        this@apply.chapter_number = this@toSChapter.number
        this@apply.date_upload = this@toSChapter.dateUpload
        this@apply.scanlator = this@toSChapter.scanlator
    }
}

fun SChapter.toChapterInfo(): ChapterInfo {
    return ChapterInfo(
        key = this.url,
        name = this.name,
        dateUpload = this.date_upload,
        number = this.chapter_number,
        scanlator = this.scanlator ?: ""
    )
}
fun eu.kanade.tachiyomi.source.model.Page.toIReaderPage(): Page {
    return ireader.core.source.model.ImageUrl(this.url)
}

fun ireader.core.source.model.Page.toTachiPage(): eu.kanade.tachiyomi.source.model.Page {
    return (this as? Text)?.let {
        return eu.kanade.tachiyomi.source.model.Page(0, this.text, imageUrl = this.text)
    } ?: eu.kanade.tachiyomi.source.model.Page(0, "")
}
