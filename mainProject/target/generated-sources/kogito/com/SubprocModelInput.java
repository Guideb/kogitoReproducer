/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com;

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;
import org.kie.kogito.ProcessInput;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "subproc", name = "Subproc", hidden = true)
@ProcessInput(processName = "subproc")
public class SubprocModelInput implements Model, MapInput, MapInputId, MapOutput, MappableToModel<SubprocModel> {

    @org.kie.kogito.codegen.VariableInfo(tags = "input")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "object2")
    @javax.validation.Valid()
    private com.model.Object2 object2;

    public com.model.Object2 getObject2() {
        return object2;
    }

    public void setObject2(com.model.Object2 object2) {
        this.object2 = object2;
    }

    @Override()
    public SubprocModel toModel() {
        SubprocModel result = new SubprocModel();
        result.setObject2(getObject2());
        return result;
    }
}
