import java.io.File

fun String.asFile(work: (File) -> Unit) {
    val content = File(Resource::class.java.getResource(this).file)
    work(content)
}

class Resource