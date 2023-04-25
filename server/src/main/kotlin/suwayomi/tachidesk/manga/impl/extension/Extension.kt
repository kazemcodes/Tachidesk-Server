import suwayomi.tachidesk.manga.impl.extension.TachiyomiExtensionManager
/*
 * Copyright (C) Contributors to the Suwayomi project
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

import org.kodein.di.DI
import org.kodein.di.conf.global
import org.kodein.di.instance
import java.io.InputStream

object Extension {
    private val tachiyomiExtensionManager by DI.global.instance<TachiyomiExtensionManager>()

    suspend fun installExtension(pkgName: String): Int {
        return tachiyomiExtensionManager.installExtension(pkgName)
    }

    suspend fun installExternalExtension(inputStream: InputStream, apkName: String): Int {
        return tachiyomiExtensionManager.installExternalExtension(inputStream, apkName)
    }

    suspend fun installAPK(forceReinstall: Boolean = false, fetcher: suspend () -> String): Int {
        return tachiyomiExtensionManager.installAPK(forceReinstall, fetcher)
    }

    fun uninstallExtension(pkgName: String) {
        return tachiyomiExtensionManager.uninstallExtension(pkgName)
    }

    suspend fun updateExtension(pkgName: String): Int {
        return tachiyomiExtensionManager.updateExtension(pkgName)
    }

    suspend fun getExtensionIcon(apkName: String): Pair<InputStream, String> {
        return tachiyomiExtensionManager.getExtensionIcon(apkName)
    }

    fun getExtensionIconUrl(apkName: String): String {
        return tachiyomiExtensionManager.getExtensionIconUrl(apkName)
    }
}
