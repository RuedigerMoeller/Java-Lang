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

package net.openhft.lang.io;

import net.openhft.lang.Jvm;
import org.junit.Test;

import java.io.File;
import java.nio.channels.FileChannel;

import static org.junit.Assert.assertEquals;

public class MappedStoreTest {
    @Test
    public void testCreateSlice() throws Exception {
        File file = new File(System.getProperty("java.io.tmpdir") + "/MappedStoreTest-testCreateSlice");
        file.deleteOnExit();
        long size = Jvm.is64Bit() ? 3L << 30 : 256 << 20;
        MappedStore ms = new MappedStore(file, FileChannel.MapMode.READ_WRITE, size);
        DirectBytes slice = ms.createSlice();
        assertEquals(1, slice.refCount());

        assertEquals(0L, slice.readLong(0L));
        assertEquals(0L, slice.readLong(ms.size() - 8));
//        System.in.read();
        slice.release();

    }
}
