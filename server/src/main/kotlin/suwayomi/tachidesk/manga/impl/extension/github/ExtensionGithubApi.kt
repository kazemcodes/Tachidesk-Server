package suwayomi.tachidesk.manga.impl.extension.github

/*
 * Copyright (C) Contributors to the Suwayomi project
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/. */

import org.kodein.di.DI
import org.kodein.di.conf.global
import org.kodein.di.instance
import suwayomi.tachidesk.manga.model.dataclass.ExtensionDataClass
import xyz.nulldev.ts.config.TACHIYOMI
import xyz.nulldev.ts.config.UNKNOWN_EXTENSION_SOURCE

object ExtensionGithubApi {
    private val tachiyomiGithubApiManager by DI.global.instance<TachiyomiGithubApiManager>()
    suspend fun findExtensions(type: String = TACHIYOMI): List<OnlineExtension> {
        return when (type) {
            TACHIYOMI -> tachiyomiGithubApiManager.findExtensions()
            else -> throw UNKNOWN_EXTENSION_SOURCE()
        }
    }

    fun getApkUrl(extension: ExtensionDataClass, type: String = TACHIYOMI): String {
        return when (type) {
            TACHIYOMI -> tachiyomiGithubApiManager.getApkUrl(extension)
            else -> throw UNKNOWN_EXTENSION_SOURCE()
        }
    }
}
