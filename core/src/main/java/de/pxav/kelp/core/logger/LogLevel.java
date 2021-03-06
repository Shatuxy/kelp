package de.pxav.kelp.core.logger;

import java.util.logging.Level;

/**
 * A class description goes here.
 *
 * @author pxav
 */
public enum LogLevel {

  INFO(Level.INFO),
  WARNING(Level.WARNING),
  ERROR(Level.SEVERE),
  DEBUG(Level.INFO);

  private Level javaLogLevel;

  LogLevel(Level javaLogLevel) {
    this.javaLogLevel = javaLogLevel;
  }

  public Level toJavaLogLevel() {
    return javaLogLevel;
  }

}
