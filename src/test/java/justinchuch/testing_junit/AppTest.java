package justinchuch.testing_junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * Unit test
 *
 */
public class AppTest {

  @Test
  public void test_print() {

    // get the logger instance of the corresponding class
    ch.qos.logback.classic.Logger testLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(App.class);

    // init and instrument the TestAppender
    TestAppender testAppender = new TestAppender();
    testLogger.addAppender(testAppender);
    testLogger.setLevel(Level.DEBUG);

    // run the print method
    App.print();

    // get the events from TestAppender
    List<ILoggingEvent> events = testAppender.getEvents();

    String actualMsg = events.get(0).getMessage();

    // expected output
    String expectedMsg = "print";

    Assert.assertEquals(expectedMsg, actualMsg);
  }


  // custom appender
  private static class TestAppender extends AppenderBase<ILoggingEvent> {
    private final List<ILoggingEvent> events = new ArrayList<>();

    private TestAppender() {
      start();
    }

    @Override
    protected synchronized void append(ILoggingEvent event) {
      events.add(event);
    }

    protected List<ILoggingEvent> getEvents() {
      return events;
    }
  }

}
