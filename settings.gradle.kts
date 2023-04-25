rootProject.name = System.getenv("ProductName") ?: "Tachidesk-Server"
enableFeaturePreview("STABLE_CONFIGURATION_CACHE")
include("server")

include("AndroidCompat")
include("AndroidCompat:Config")