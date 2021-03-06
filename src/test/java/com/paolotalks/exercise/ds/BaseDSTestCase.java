package com.paolotalks.exercise.ds;

import com.paolotalks.exception.TestCaseNotImplementedException;

public class BaseDSTestCase {

    protected static final String PACKAGE_PATH = "com.paolotalks.exercise.ds.impl";

    protected static Class<?> getImplClass(String forName){
        try {
            return Class.forName(forName);
        } catch (ClassNotFoundException nfe) {
            // Class does not exist so not yet implemented
            throw new TestCaseNotImplementedException();
        }
    }
}
