/**
 * PermissionsEx
 * Copyright (C) zml and PermissionsEx contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ninja.leaping.permissionsex;

import ninja.leaping.permissionsex.backends.DataStore;
import ninja.leaping.permissionsex.config.PermissionsExConfiguration;
import ninja.leaping.permissionsex.exception.PermissionsLoadingException;

import java.io.File;

public class PermissionsEx {
    private final PermissionsExConfiguration config;
    private final File basedir;
    private DataStore activeDataStore;

    public PermissionsEx(PermissionsExConfiguration config, File basedir) throws PermissionsLoadingException {
        this.config = config;
        this.basedir = basedir;
        this.activeDataStore = config.getDefaultDataStore();
        this.activeDataStore.initialize(this);
    }

    public void close() {
        this.activeDataStore.close();
    }

    public File getBaseDirectory() {
        return this.basedir;
    }

    public DataStore getActiveDataStore() {
        return this.activeDataStore;
    }
}
