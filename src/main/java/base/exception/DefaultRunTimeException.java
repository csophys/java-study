package base.exception;

import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.junit.Assert.fail;

/**
 * Created by csophys on 15/11/1.
 */
public class DefaultRunTimeException {

    private enum ExceptionEnum {NULL, ILLEGALARGS, ILLEGALSTATE, INDEXOUTOFBOUNDS, CONCURRENTMODIFY, UNSUPPORTOPERATION}

    @Test
    public void invokeMethodWithThrowDefaultException() {
        try {
            methodWithThrowDefaultException(ExceptionEnum.NULL);
            fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof NullPointerException);
        }

        try {
            methodWithThrowDefaultException(ExceptionEnum.ILLEGALARGS);
            fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            methodWithThrowDefaultException(ExceptionEnum.ILLEGALSTATE);
            fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof IllegalStateException);
        }
        try {
            methodWithThrowDefaultException(ExceptionEnum.INDEXOUTOFBOUNDS);
            fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof IndexOutOfBoundsException);
        }
        try {
            methodWithThrowDefaultException(ExceptionEnum.CONCURRENTMODIFY);
            fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof ConcurrentModificationException);
        }
        try {
            methodWithThrowDefaultException(ExceptionEnum.UNSUPPORTOPERATION);
            fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof UnsupportedOperationException);
        }
    }


    private void methodWithThrowDefaultException(ExceptionEnum exceptionEnum) {

        switch (exceptionEnum) {
            case NULL:
                throw new NullPointerException();
            case ILLEGALARGS:
                throw new IllegalArgumentException();
            case ILLEGALSTATE:
                throw new IllegalStateException();
            case INDEXOUTOFBOUNDS:
                throw new IndexOutOfBoundsException();
            case CONCURRENTMODIFY:
                throw new ConcurrentModificationException();
            case UNSUPPORTOPERATION:
                throw new UnsupportedOperationException();

        }
    }
}