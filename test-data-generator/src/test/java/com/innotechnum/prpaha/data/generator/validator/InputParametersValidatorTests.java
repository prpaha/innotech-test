package com.innotechnum.prpaha.data.generator.validator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InputParametersValidatorTests {

    @Test
    public void nullInputParametersTest() {
        String[] args = null;
        InputParametersValidator validator = new InputParametersValidator(args);
        try {
            validator.validate();
            Assert.fail("NULL input parameters");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void moreCountInputParametersTest() {
        String[] args = new String[] {"", "", "", ""};
        InputParametersValidator validator = new InputParametersValidator(args);
        try {
            validator.validate();
            Assert.fail("More input parameters");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void  lessCountInputParametersTest() {
        String[] args = new String[] {"", ""};
        InputParametersValidator validator = new InputParametersValidator(args);
        try {
            validator.validate();
            Assert.fail("Less input parameters");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void nullFirstInputParametersTest() {
        String[] args = new String[] {null, "100", "test"};
        InputParametersValidator validator = new InputParametersValidator(args);
        try {
            validator.validate();
            Assert.fail("NULL first input parameters");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void nullSecondInputParametersTest() {
        String[] args = new String[] {"test", null, "test"};
        InputParametersValidator validator = new InputParametersValidator(args);
        try {
            validator.validate();
            Assert.fail("NULL second input parameters");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void nullThirdInputParametersTest() {
        String[] args = new String[] {"test", "100", null};
        InputParametersValidator validator = new InputParametersValidator(args);
        try {
            validator.validate();
            Assert.fail("NULL third input parameters");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void countNotIntegerInputParameterTest() {
        String[] args = new String[] {"test", "100q", "test"};
        InputParametersValidator validator = new InputParametersValidator(args);
        try {
            validator.validate();
            Assert.fail("Not integer in second input parameters");
        } catch (IllegalArgumentException e) {

        }
    }

}
