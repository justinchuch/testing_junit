/**
 * @author justinchuch
 *
 */
package justinchuch.testingjunit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * Unit test
 *
 */
public class AppTest {

  @Test
  public void testPrint() {

    // get the logger instance of the corresponding class,
    // in this case, justinchuch.testingjunit.App
    Logger testLogger = (Logger) LoggerFactory.getLogger(App.class);

    // init and instrument the TestAppender
    TestAppender testAppender = new TestAppender();
    testLogger.addAppender(testAppender);
    testLogger.setLevel(Level.DEBUG); // log level

    // run the method that we want to capture the log message in the App
    App.print();

    // get the events from TestAppender
    List<ILoggingEvent> events = testAppender.getEvents();

    // since there is only one event in this case, so we use events.get(0).
    // adjust this accordingly!
    String actualMsg = events.get(0).getMessage();

    // expected output
    String expectedMsg = "print";

    Assert.assertEquals(expectedMsg, actualMsg);
  }


  // Custom appender. To be added into the logger
  private static class TestAppender extends AppenderBase<ILoggingEvent> {
    private final List<ILoggingEvent> events = Collections.synchronizedList(new ArrayList<>());

    private TestAppender() {
      start();
    }

    @Override
    protected void append(ILoggingEvent event) {
      synchronized(events) {
        events.add(event);
      }
    }

    protected List<ILoggingEvent> getEvents() {
      return events;
    }
  }

}
