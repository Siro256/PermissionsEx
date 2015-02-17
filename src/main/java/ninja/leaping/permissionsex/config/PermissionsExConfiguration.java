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
package ninja.leaping.permissionsex.config;

import ninja.leaping.configurate.objectmapping.ObjectMapper;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.permissionsex.backends.DataStore;

import java.util.Map;

/**
 * Configuration for PermissionsEx. This is designed to be serialized with a Configurate {@link ObjectMapper}
 */
public class PermissionsExConfiguration {
    public static final ObjectMapper<PermissionsExConfiguration> MAPPER;

    static {
        try {
            MAPPER = ObjectMapper.mapperForClass(PermissionsExConfiguration.class);
        } catch (ObjectMappingException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Setting("backends") private Map<String, DataStore> backends;
    @Setting("default-backend") private String defaultBackend;
    @Setting("debug") private boolean debugEnabled;

    protected PermissionsExConfiguration() {}

    public DataStore getDataStore(String name) {
        return backends.get(name);
    }

    public DataStore getDefaultDataStore() {
        return backends.get(defaultBackend);
    }

    public boolean isDebugEnabled() {
        return debugEnabled;
    }
}
