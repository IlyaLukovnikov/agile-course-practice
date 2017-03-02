package ru.unn.agile.IntersectLineAndPlane.infrastructure;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.unn.agile.IntersectLineAndPlane.viewmodel.RegexMatcher.matchesPattern;


public class TxtLoggerTest {
    private static final String FILENAME = "./TxtLoggerTest.log";
    private TxtLogger logger;

    @Before
    public void setUp() {
        logger = new TxtLogger(FILENAME);
    }

    @Test
    public void canCreateLoggerWithFileName() {
        assertNotNull(logger);
    }

    @Test
    public void canCreateLogFileOnDisk() {
        try {
            new BufferedReader(new FileReader(FILENAME));
        } catch (FileNotFoundException exc) {
            fail("File " + FILENAME + " wasn't found!");
        }
    }

    @Test
    public void canWriteLogMessage() {
        String testMess = "Test message";

        logger.log(testMess);

        String message = logger.getLog().get(0);
        assertThat(message, matchesPattern(".*" + testMess + "$"));
    }

    @Test
    public void canWriteSeveralLogMessage() {
        String[] message = {"Test message 1", "Test message 2"};

        logger.log(message[0]);
        logger.log(message[1]);

        List<String> actualMessages = logger.getLog();
        for (int i = 0; i < actualMessages.size(); i++) {
            assertThat(actualMessages.get(i), matchesPattern(".*" + message[i] + "$"));
        }
    }

    @Test
    public void doLogContainDateAndTime() {
        String testMessage = "Test message";

        logger.log(testMessage);

        String message = logger.getLog().get(0);
        assertThat(message, matchesPattern("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2} > .*"));
    }
}
