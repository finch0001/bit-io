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


import com.github.jinahya.bit.io.BitOutput;
import com.github.jinahya.bit.io.Company;
import com.github.jinahya.bit.io.Employee;
import com.github.jinahya.bit.io.codec.BitEncoder;
import com.github.jinahya.bit.io.codec.BitEncoder;
import com.github.jinahya.bit.io.codec.NullableEncoder;
import com.github.jinahya.bit.io.codec.NullableEncoder;
import java.io.IOException;
import java.io.UncheckedIOException;


/**
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
public class CompanyEncoder extends NullableEncoder<Company> {


    public CompanyEncoder(final boolean nullable) {

        super(nullable);

        employeeEncoder = NullableEncoder.newInstance(
            Company.EMPLOYEE_NULLABLE,
            (BitEncoder<Employee>) (o, v) -> {
                try {
                    v.write(o);
                } catch (final IOException ioe) {
                    throw new UncheckedIOException(ioe);
                }
            });
    }


    @Override
    protected void encodeValue(final BitOutput output, final Company value)
        throws IOException {

        output.writeInt(true, Company.EMPLOYEES_SIZE,
                        value.getEmployees().size());

        for (final Employee employee : value.getEmployees()) {
            employeeEncoder.encode(output, employee);
        }
    }


    private final BitEncoder<Employee> employeeEncoder;

}
