/*
 * Copyright 2013 Jin Kwon <onacit at gmail.com>.
 *
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
 */


package com.github.jinahya.io.bit;


import java.io.IOException;
import java.nio.ByteBuffer;


/**
 * A {@link ByteOutput} implementation writes bytes to an underlying
 * {@link ByteBuffer}.
 */
public class BufferOutput extends ByteOutput<ByteBuffer> {


    /**
     * Creates a new instance built on the top of the specified byte buffer.
     *
     * @param target {@code inheritDoc}
     */
    public BufferOutput(final ByteBuffer target) {

        super(target);
    }


    /**
     * {@inheritDoc}
     * <p/>
     * The {@code writeUnsignedByte(int)} method of {@code BufferWriter} class
     * calls {@link ByteBuffer#put(byte)} on the underlying byte buffer with
     * given {@code value}.
     *
     * @param value {@inheritDoc }
     *
     * @throws IllegalStateException {@inheritDoc}
     * @throws IOException {@inheritDoc }
     *
     * @see ByteBuffer#put(byte)
     */
    @Override
    public void writeUnsignedByte(final int value) throws IOException {

        if (target == null) {
            throw new IllegalStateException("#target is currently null");
        }

        target.put((byte) value); // BufferOverflowException, ReadOnlyBufferException
    }


    /**
     * {@inheritDoc}
     * <p/>
     * The {@code close()} method of {@code BufferWriter} class does nothing.
     *
     * @throws IOException {@inheritDoc }
     */
    @Override
    public void close() throws IOException {

        // do nothing
    }


}

