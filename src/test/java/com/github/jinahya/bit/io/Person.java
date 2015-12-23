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

package com.github.jinahya.bit.io;


import com.github.jinahya.bit.io.codec.BitDecodable;
import com.github.jinahya.bit.io.codec.BitEncodable;
import java.io.IOException;
import static java.util.concurrent.ThreadLocalRandom.current;


/**
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
public class Person implements BitDecodable, BitEncodable {


    public static Person newRandomInstance() {

        final Person instance = new Person();

        instance.age = current().nextInt(128);
        instance.merried = current().nextBoolean();

        return instance;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.merried != other.merried) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.age;
        hash = 17 * hash + (this.merried ? 1 : 0);
        return hash;
    }


    @Override
    public void decode(final BitInput input) throws IOException {

        setAge(input.readUnsignedInt(7));
        setMerried(input.readBoolean());
    }


    @Override
    public void encode(final BitOutput output) throws IOException {

        output.writeUnsignedInt(7, getAge());
        output.writeBoolean(isMerried());
    }


    public int getAge() {

        return age;
    }


    public void setAge(final int age) {

        this.age = age;
    }


    public Person age(final int age) {

        setAge(age);

        return this;
    }


    public boolean isMerried() {

        return merried;
    }


    public void setMerried(final boolean merried) {

        this.merried = merried;
    }


    public Person merried(final boolean merried) {

        setMerried(merried);

        return this;
    }


    private int age;


    private boolean merried;

}

