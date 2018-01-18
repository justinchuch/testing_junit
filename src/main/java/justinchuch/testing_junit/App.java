package justinchuch.testing_junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Testing JUnit
 *
 */
public class App {

  private static final Logger testLogger = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    testLogger.debug("Hello World!");
  }

  public static void print() {
    testLogger.debug("print");
  }
}
