package ru.stimmax.ru.stimmax.lessons.lesson26.lesson

import java.io.File

fun createFile(path: String) {
    val file = File(path)
    if (path.endsWith("/")) {
        file.mkdirs()
    } else {
        file.parentFile?.mkdirs()
        file.createNewFile()
    }

}


fun writeFile(path: String, obj: Map<String, Double>) {
    with(File(path)) {
        parentFile?.mkdirs()
        createNewFile()
        obj.map { "${it.key}=${it.value}" }
            .joinToString("\n")
            .also { writeText(it) }
    }
}

fun deleteFile(path: String, text: String) {
    File(path).apply {
        if (exists() && readText().contains(text)) {
            delete()
        }
    }
}

fun findFiles(basePath: String, keyWord: String): List<String> {
    return File(basePath).walk()
        .filter { it.isFile && it.name.contains(keyWord) }
        .map { it.readText() }
        .toList()
}

fun String.copyTo(targetPath: String) {
    val file = File(this).run {
        check(exists()) {
            "File doesn't exist"
        }
        val newFile = File(targetPath)
        newFile.parentFile?.mkdirs()
        copyTo(newFile)
    }
}

