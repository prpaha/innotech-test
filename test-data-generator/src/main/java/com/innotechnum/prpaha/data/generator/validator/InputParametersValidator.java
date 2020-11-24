package com.innotechnum.prpaha.data.generator.validator;

import lombok.AllArgsConstructor;

/**
 * Валидатор входных параметров.
 */
@AllArgsConstructor
public class InputParametersValidator {

    private final String[] args;

    public void validate() {
        if (args == null) {
            throw new IllegalArgumentException("NULL input parameters");
        }
        if (args.length != 3) {
            throw new IllegalArgumentException("Invalid count input parameters");
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                throw new IllegalArgumentException("NULL one of input parameters");
            }
        }
        try {
            Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Count is not integer");
        }
    }

}
