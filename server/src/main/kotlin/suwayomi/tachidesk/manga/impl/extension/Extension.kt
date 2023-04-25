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
import xyz.nulldev.ts.config.TACHIYOMI
import xyz.nulldev.ts.config.UNKNOWN_EXTENSION_SOURCE
import java.io.InputStream

object Extension {
    private val tachiyomiExtensionManager by DI.global.instance<TachiyomiExtensionManager>()

    suspend fun installExtension(pkgName: String, type: String = TACHIYOMI): Int {
        return when (type) {
            TACHIYOMI -> tachiyomiExtensionManager.installExtension(pkgName)
            else -> throw UNKNOWN_EXTENSION_SOURCE()
        }
    }

    suspend fun installExternalExtension(inputStream: InputStream, apkName: String, type: String = TACHIYOMI): Int {
        return when (type) {
            TACHIYOMI -> tachiyomiExtensionManager.installExternalExtension(inputStream, apkName)
            else -> throw UNKNOWN_EXTENSION_SOURCE()
        }
    }

    suspend fun installAPK(type: String = TACHIYOMI, forceReinstall: Boolean = false, fetcher: suspend () -> String): Int {
        return when (type) {
            TACHIYOMI -> tachiyomiExtensionManager.installAPK(forceReinstall, fetcher)
            else -> throw UNKNOWN_EXTENSION_SOURCE()
        }
    }

    fun uninstallExtension(pkgName: String, type: String = TACHIYOMI) {
        return when (type) {
            TACHIYOMI -> tachiyomiExtensionManager.uninstallExtension(pkgName)
            else -> throw UNKNOWN_EXTENSION_SOURCE()
        }
    }

    suspend fun updateExtension(pkgName: String, type: String = TACHIYOMI): Int {
        return when (type) {
            TACHIYOMI -> tachiyomiExtensionManager.updateExtension(pkgName)
            else -> throw UNKNOWN_EXTENSION_SOURCE()
        }
    }

    suspend fun getExtensionIcon(apkName: String, type: String = TACHIYOMI): Pair<InputStream, String> {
        return when (type) {
            TACHIYOMI -> tachiyomiExtensionManager.getExtensionIcon(apkName)
            else -> throw UNKNOWN_EXTENSION_SOURCE()
        }
    }

    fun getExtensionIconUrl(apkName: String, type: String = TACHIYOMI): String {
        return when (type) {
            TACHIYOMI -> tachiyomiExtensionManager.getExtensionIconUrl(apkName)
            else -> throw UNKNOWN_EXTENSION_SOURCE()
        }
    }
}
