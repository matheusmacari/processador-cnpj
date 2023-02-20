package br.com.macari.cnpj.fileutils

import br.com.macari.cnpj.consts.C_COLUNAS_CSV
import java.io.File

object utils {

    fun saveToFile(aText: String, aPath: String, aFileName: String) {
        File(aPath, aFileName).writeText(aText)
    }

    fun loadListFromFile(aPath: String, aFileName: String): List<String> {
        return File(aPath, aFileName).readLines()
    }

    fun loadFilesFromDir(aPath: String): FileTreeWalk {
        return File(aPath).walkTopDown()
    }

    fun fileExists(aPath: String, aFileName: String): Boolean{
        return File(aPath, aFileName).exists()
    }

    fun addJsonItemToCsv(aPath : String, aFileName: String, aFields: String) {
        var aList = StringBuilder()

        if (fileExists(aPath, aFileName)) {
            for (readLine in File(aPath, aFileName).readLines()) {
                aList.appendLine(readLine)
            }
        }else
            aList.appendLine(C_COLUNAS_CSV)

        aList.appendLine(aFields)

        saveToFile(aList.toString(), aPath, aFileName)
    }

}