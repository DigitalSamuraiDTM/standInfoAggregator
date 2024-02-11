package com.digitalsamurai.standaggregator.desktoplogic.logging

import com.digitalsamurai.standaggregator.desktoplogic.di.AppScope
import com.digitalsamurai.standaggregator.desktoplogic.di.components.Environment
import java.nio.file.Files
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.Date
import java.util.logging.FileHandler
import java.util.logging.Logger
import java.util.logging.SimpleFormatter
import javax.inject.Inject

/**
 * Don't use default logger because every logger instance with file handler create log output file
 * But i need only one log output file per app session
 */
@AppScope
public class LoggerFactory @Inject constructor(private val environment: Environment) {

    public val fileHandler: FileHandler

    private val dateFormatter = SimpleDateFormat("YYYY.MM.DD-HH.mm.ss")

    public val systemLogger: Logger

    init {
        val startAppTime = Date(System.currentTimeMillis())
        val fileName = dateFormatter.format(startAppTime)
        val generatedPath = "logs/${fileName}.logs"

        val path = Paths.get(generatedPath)
        Files.createDirectories(path.parent)

        fileHandler = FileHandler(generatedPath).apply {
            formatter = SimpleFormatter()
        }

        systemLogger = Logger.getLogger(environment.name).apply {
            addHandler(fileHandler)
        }
    }

    public inline fun <reified T : Any> buildLogger(owner: T): AppLogger {
        return AppLogger(owner::class.simpleName ?: "Unknown host", systemLogger)
    }
}