package com.paolotalks.util;

import com.paolotalks.exception.TestCaseNotImplementedException;
import org.junit.AssumptionViolatedException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class PartialTestRunner extends BlockJUnit4ClassRunner {

    private static final Class<? extends Throwable> EXPECTED = TestCaseNotImplementedException.class;

    public PartialTestRunner(Class<?> cls) throws InitializationError {
        super(cls);
    }

    @Override
    protected Statement possiblyExpectingExceptions(FrameworkMethod method, Object test, Statement next) {
        return new NotImplementedStatement(next);
    }

    static class NotImplementedStatement extends Statement {

        private final Statement next;

        public NotImplementedStatement(Statement next) {
            this.next = next;
        }

        @Override
        public void evaluate() throws Exception {
            try {
                next.evaluate();
            } catch (AssumptionViolatedException e) {
                throw e;
            } catch (Throwable e) {
                if (!EXPECTED.isAssignableFrom(e.getClass())) {
                    throw new Exception(e);
                }
            }
        }
    }

}