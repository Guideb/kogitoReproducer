package com;

import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("subproc")
@io.quarkus.runtime.Startup()
public class SubprocProcess extends org.kie.kogito.process.impl.AbstractProcess<com.SubprocModel> {

    @javax.inject.Inject()
    public SubprocProcess(org.kie.kogito.app.Application app) {
        super(app, java.util.Arrays.asList());
        activate();
    }

    public SubprocProcess() {
    }

    @Override()
    public com.SubprocProcessInstance createInstance(com.SubprocModel value) {
        return new com.SubprocProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.SubprocProcessInstance createInstance(java.lang.String businessKey, com.SubprocModel value) {
        return new com.SubprocProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    @Override()
    public com.SubprocModel createModel() {
        return new com.SubprocModel();
    }

    public com.SubprocProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.SubprocModel) value);
    }

    public com.SubprocProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.SubprocModel) value);
    }

    public com.SubprocProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.SubprocProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.SubprocProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.SubprocProcessInstance(this, this.createModel(), wpi);
    }

    public org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("subproc");
        factory.variable("object2", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(com.model.Object2.class), null, "customTags", "input");
        factory.name("subproc");
        factory.packageName("com");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        factory.imports("com.model.Object2");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode1 = factory.endNode(1);
        endNode1.name("End");
        endNode1.terminate(false);
        endNode1.metaData("UniqueId", "_BE75DE21-C49D-45EF-9CEA-D31A3485538F");
        endNode1.metaData("x", 689);
        endNode1.metaData("width", 56);
        endNode1.metaData("y", 226);
        endNode1.metaData("height", 56);
        endNode1.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode2 = factory.actionNode(2);
        actionNode2.name("Print name");
        actionNode2.action(kcontext -> {
            com.model.Object2 object2 = (com.model.Object2) kcontext.getVariable("object2");
            System.out.println(object2.getName());
        });
        actionNode2.metaData("UniqueId", "_B5849257-A150-44F4-AFDB-E0ECC528050E");
        actionNode2.metaData("elementname", "Print name");
        actionNode2.metaData("NodeType", "ScriptTask");
        actionNode2.metaData("x", 455);
        actionNode2.metaData("width", 154);
        actionNode2.metaData("y", 203);
        actionNode2.metaData("height", 102);
        actionNode2.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode3 = factory.startNode(3);
        startNode3.name("Start");
        startNode3.interrupting(false);
        startNode3.metaData("UniqueId", "_49212777-4C83-4341-A9F0-07BF295EEF82");
        startNode3.metaData("x", 309);
        startNode3.metaData("width", 56);
        startNode3.metaData("y", 226);
        startNode3.metaData("height", 56);
        startNode3.done();
        factory.connection(2, 1, "_5ED1D939-E5A5-4CC8-A79B-6B79FABBAAED");
        factory.connection(3, 2, "_D68FEA00-BD8B-4DD7-BC81-EFD2497B0C70");
        factory.validate();
        return factory.getProcess();
    }
}
