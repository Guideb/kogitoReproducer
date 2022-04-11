package com;

public class Proc1ProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<Proc1Model> {

    public Proc1ProcessInstance(com.Proc1Process process, Proc1Model value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public Proc1ProcessInstance(com.Proc1Process process, Proc1Model value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public Proc1ProcessInstance(com.Proc1Process process, Proc1Model value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public Proc1ProcessInstance(com.Proc1Process process, Proc1Model value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    protected java.util.Map<String, Object> bind(Proc1Model variables) {
        return variables.toMap();
    }

    protected void unbind(Proc1Model variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
