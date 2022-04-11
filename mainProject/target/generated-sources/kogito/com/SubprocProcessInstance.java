package com;

public class SubprocProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<SubprocModel> {

    public SubprocProcessInstance(com.SubprocProcess process, SubprocModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public SubprocProcessInstance(com.SubprocProcess process, SubprocModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public SubprocProcessInstance(com.SubprocProcess process, SubprocModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public SubprocProcessInstance(com.SubprocProcess process, SubprocModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    protected java.util.Map<String, Object> bind(SubprocModel variables) {
        return variables.toMap();
    }

    protected void unbind(SubprocModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
