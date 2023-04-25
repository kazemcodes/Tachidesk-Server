package suwayomi.tachidesk.manga.impl.extension.github

import suwayomi.tachidesk.manga.model.dataclass.ExtensionDataClass

interface ExtensionGithubApiManager {
    suspend fun findExtensions(): List<OnlineExtension>
    fun getApkUrl(extension: ExtensionDataClass): String
}
