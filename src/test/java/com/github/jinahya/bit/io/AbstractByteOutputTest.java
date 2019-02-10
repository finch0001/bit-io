package com.github.jinahya.bit.io;

import org.mockito.Mock;

import java.util.Objects;

/**
 * An abstract class for testing subclasses of {@link AbstractByteOutput}.
 *
 * @param <T> byte output type parameter.
 * @param <U> byte target type parameter.
 */
public abstract class AbstractByteOutputTest<T extends AbstractByteOutput<U>, U> extends ByteOutputTest<T> {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param byteOutputClass a byte output class.
     * @param byteTargetClass a byte target class of the byte output class.
     */
    public AbstractByteOutputTest(final Class<T> byteOutputClass, final Class<U> byteTargetClass) {
        super(byteOutputClass);
        this.byteTargetClass = Objects.requireNonNull(byteTargetClass, "byteTargetClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The byte target class.
     */
    protected final Class<U> byteTargetClass;

    /**
     * A mock of {@link #byteTargetClass}.
     */
    @Mock
    protected U byteTargetMock;
}