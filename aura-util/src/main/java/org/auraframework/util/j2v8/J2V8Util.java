/*
 * Copyright (C) 2013 salesforce.com, inc.
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
package org.auraframework.util.j2v8;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.eclipsesource.v8.V8;

public class J2V8Util {

    private static final Logger logger = Logger.getLogger(J2V8Util.class.getName());

    private static final boolean J2V8_AVAILABLE = isJ2V8AvailableCheck();

    /**
     * @return true if J2V8 is available the current environment, false otherwise
     */
    public static boolean isJ2V8Available() {
        return J2V8_AVAILABLE;
    }

    private static boolean isJ2V8AvailableCheck() {
        try {
            V8 v8 = V8.createV8Runtime();
            v8.release();
            return true;
        } catch (Throwable t) {
            logger.log(Level.SEVERE,
                    "J2V8 not available in current env (" + System.getProperty("os.name") + "), disabling modules", t);
            return false;
        }
    }
}
