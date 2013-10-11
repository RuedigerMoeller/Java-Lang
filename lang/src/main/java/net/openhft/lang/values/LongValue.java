/*
 * Copyright 2013 Peter Lawrey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.openhft.lang.values;

/**
 * User: plawrey
 * Date: 10/10/13
 * Time: 07:11
 */
public interface LongValue {
    long getValue();

    void setValue(long value);

    long addValue(long delta);

    long addAtomicValue(long delta);

    boolean compareAndSwapValue(long expected, long value);
}