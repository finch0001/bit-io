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

/**
 * A class for testing {@link ArrayByteInput} class.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see ArrayByteOutputTest
 */
class ArrayByteInputTest extends AbstractByteInputTest<ArrayByteInput, byte[]> {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    ArrayByteInputTest() {
        super(ArrayByteInput.class, byte[].class);
    }

    // ----------------------------------------------------------------------------------------------------- getIndex()I
    @Test
    void testGetIndex() {
        final int index = byteInput().getIndex();
    }

    // ---------------------------------------------------------------------------------------------------- setIndex(I)V
    @Test
    void testSetIndex() {
        byteInput().setIndex(0);
    }

    // ------------------------------------------------------------------------------------------------------ byteSource
    @Override
    byte[] byteSource() {
        return new byte[0];
    }
}
