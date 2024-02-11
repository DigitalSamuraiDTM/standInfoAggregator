package com.digitalsamurai.standaggregator.desktoplogic.logging

import java.util.logging.Logger

public class AppLogger(
    private val owner: String,
    private val logger: Logger
) {

    public fun i(message: String) {
        logger.info("${owner}:${message}")
    }

    public fun w(message: String) {
        logger.warning("${owner}:${message}")
    }

    public fun f(message: String) {
        logger.fine("${owner}:${message}")
    }
}