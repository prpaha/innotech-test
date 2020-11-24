package com.innotechnum.prpaha.data.generator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.net.URISyntaxException;

@RunWith(JUnit4.class)
public class ApplicationTests {

    private static final String TEST_APPLICATION_OPERATION_RESULT_TXT = "test-application-operation-result.txt";

    @Test
    public void successRunApplication() throws URISyntaxException {
        File file = new File(getClass().getClassLoader().getResource(TestDataProvider.PREPARE_OFFICES_FILE).toURI());
        String[] args = new String[] {file.getAbsolutePath(), "99", TEST_APPLICATION_OPERATION_RESULT_TXT};
        Application.main(args);
    }

}
