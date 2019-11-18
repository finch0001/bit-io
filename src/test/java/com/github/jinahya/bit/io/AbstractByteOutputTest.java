package com.github.jinahya.bit.io;

/*-
 * #%L
 * bit-io
 * %%
 * Copyright (C) 2014 - 2019 Jinahya, Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.junit.jupiter.api.Test;

import static java.util.Objects.requireNonNull;
import static org.mockito.Mockito.mock;

/**
 * An abstract class for testing subclasses of {@link AbstractByteOutput}.
 *
 * @param <T> byte output type parameter
 * @param <U> byte target type parameter
 * @see AbstractByteInputTest
 */
abstract class AbstractByteOutputTest<T extends AbstractByteOutput<U>, U> extends ByteOutputTest<T> {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with given arguments.
     *
     * @param byteOutputClass a class of byte output to test.
     * @param byteTargetClass a class of byte target of the byte output class.
     */
    AbstractByteOutputTest(final Class<T> byteOutputClass, final Class<U> byteTargetClass) {
        super(byteOutputClass);
        this.byteTargetClass = requireNonNull(byteTargetClass, "byteTargetClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Tests {@link AbstractByteOutput#getTarget()} method.
     */
    @Test
    void testGetTarget() {
        final U target = byteOutput().getTarget();
    }

    /**
     * Tests {@link AbstractByteOutput#setTarget(Object)} method.
     */
    @Test
    void testSetTarget() {
        byteOutput().setTarget(null);
        byteOutput().setTarget(byteTarget());
    }

    // -----------------------------------------------------------------------------------------------------------------
    U byteTarget() {
        return mock(byteTargetClass);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The byte target class.
     */
    final Class<U> byteTargetClass;
}
