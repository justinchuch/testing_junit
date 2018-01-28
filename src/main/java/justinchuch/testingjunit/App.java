/**
 * @author justinchuch
 *
 */
package justinchuch.testingjunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Testing JUnit
 *
 */
public class App {

  // logger
  private static final Logger testLogger = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    testLogger.debug("Hello World!");
  }

  public static void print() {
    // log message to be captured in JUnit
    testLogger.debug("print");
  }
}
