package ireader.core.http

import org.jsoup.nodes.Document

class WebViewManger {
    var isInit: Boolean
        get() = false
        set(value) {}
    var userAgent: String = ""
    var selector: String?
        get() = ""
        set(value) {}
    var html: Document
        get() = Document("")
        set(value) {}
    var webUrl: String?
        get() = ""
        set(value) {}
    var inProgress: Boolean
        get() = false
        set(value) {}

    fun init(): Any {
        return 0
    }

    fun update() {
    }

    fun destroy() {
    }
}
