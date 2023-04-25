package suwayomi.tachidesk.manga.impl.extension

import java.io.InputStream

interface ExtensionManager {
    suspend fun installExtension(pkgName: String): Int
    suspend fun installExternalExtension(inputStream: InputStream, apkName: String): Int
    suspend fun installAPK(forceReinstall: Boolean = false, fetcher: suspend () -> String): Int
    fun uninstallExtension(pkgName: String)
    suspend fun updateExtension(pkgName: String): Int
    suspend fun getExtensionIcon(apkName: String): Pair<InputStream, String>
    fun getExtensionIconUrl(apkName: String): String
}
