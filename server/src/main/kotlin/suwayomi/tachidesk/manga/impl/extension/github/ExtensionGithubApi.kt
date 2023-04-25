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

object ExtensionGithubApi {
    private val tachiyomiGithubApiManager by DI.global.instance<TachiyomiGithubApiManager>()
    suspend fun findExtensions(): List<OnlineExtension> {
        return tachiyomiGithubApiManager.findExtensions()
    }

    fun getApkUrl(extension: ExtensionDataClass): String {
        return tachiyomiGithubApiManager.getApkUrl(extension)
    }
}
