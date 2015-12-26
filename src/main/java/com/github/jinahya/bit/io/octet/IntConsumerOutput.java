/*
 * Copyright 2015 Jin Kwon &lt;jinahya_at_gmail.com&gt;.
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


package com.github.jinahya.bit.io.octet;


import java.io.IOException;
import java.util.function.IntConsumer;


/**
 * A {@link ByteOutput} implementation uses a {@link IntConsumer} instance.
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
public class IntConsumerOutput extends AbstractByteOutput<IntConsumer> {


    public IntConsumerOutput(final IntConsumer target) {

        super(target);
    }


    /**
     * {@inheritDoc} The {@code write(int)} method of {@code IntConsumerOutput}
     * class invokes {@link IntConsumer#accept(int)} with given value. Override
     * this method if {@link #target} is supposed to be lazily initialized and
     * set.
     *
     * @param value {@inheritDoc }
     *
     * @throws IOException {@inheritDoc }
     */
    @Override
    public void write(final int value) throws IOException {

        target.accept(value);
    }

}
