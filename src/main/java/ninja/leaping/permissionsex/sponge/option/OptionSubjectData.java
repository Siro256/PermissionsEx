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
package ninja.leaping.permissionsex.sponge.option;

import org.spongepowered.api.service.permission.SubjectData;
import org.spongepowered.api.service.permission.context.Context;

import java.util.Map;
import java.util.Set;

public interface OptionSubjectData extends SubjectData {
    public Map<Set<Context>, Map<String, String>> getAllOptions();

    public Map<String, String> getOptions(Set<Context> contexts);

    public boolean setOption(Set<Context> contexts, String key, String value);

    public boolean clearOptions(Set<Context> contexts);

    public boolean clearOptions();
}
