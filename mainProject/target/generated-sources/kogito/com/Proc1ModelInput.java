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

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "proc1", name = "Proc1", hidden = true)
@ProcessInput(processName = "proc1")
public class Proc1ModelInput implements Model, MapInput, MapInputId, MapOutput, MappableToModel<Proc1Model> {

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "object1")
    @javax.validation.Valid()
    private com.model.Object1 object1;

    public com.model.Object1 getObject1() {
        return object1;
    }

    public void setObject1(com.model.Object1 object1) {
        this.object1 = object1;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "listObject2")
    @javax.validation.Valid()
    private java.util.List listObject2;

    public java.util.List getListObject2() {
        return listObject2;
    }

    public void setListObject2(java.util.List listObject2) {
        this.listObject2 = listObject2;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "results")
    @javax.validation.Valid()
    private java.util.List results;

    public java.util.List getResults() {
        return results;
    }

    public void setResults(java.util.List results) {
        this.results = results;
    }

    @Override()
    public Proc1Model toModel() {
        Proc1Model result = new Proc1Model();
        result.setObject1(getObject1());
        result.setListObject2(getListObject2());
        result.setResults(getResults());
        return result;
    }
}
