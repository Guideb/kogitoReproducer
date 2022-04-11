package com;

import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.ListDataType;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("proc1")
@io.quarkus.runtime.Startup()
public class Proc1Process extends org.kie.kogito.process.impl.AbstractProcess<com.Proc1Model> {

    @javax.inject.Inject()
    org.kie.kogito.process.Process<SubprocModel> processsubproc;

    public Proc1Process(org.kie.kogito.app.Application app) {
        this(app, new org.kie.kogito.handlers.JavaClass_giveMeTheList_3_Handler());
    }

    @javax.inject.Inject()
    public Proc1Process(org.kie.kogito.app.Application app, org.kie.kogito.handlers.JavaClass_giveMeTheList_3_Handler javaClass_giveMeTheList_3_Handler) {
        super(app, java.util.Arrays.asList(javaClass_giveMeTheList_3_Handler));
        activate();
    }

    public Proc1Process() {
    }

    @Override()
    public com.Proc1ProcessInstance createInstance(com.Proc1Model value) {
        return new com.Proc1ProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.Proc1ProcessInstance createInstance(java.lang.String businessKey, com.Proc1Model value) {
        return new com.Proc1ProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    @Override()
    public com.Proc1Model createModel() {
        return new com.Proc1Model();
    }

    public com.Proc1ProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.Proc1Model) value);
    }

    public com.Proc1ProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.Proc1Model) value);
    }

    public com.Proc1ProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.Proc1ProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.Proc1ProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.Proc1ProcessInstance(this, this.createModel(), wpi);
    }

    public org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("proc1");
        factory.variable("object1", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(com.model.Object1.class), null, "customTags", null);
        factory.variable("listObject2", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.util.List.class), null, "customTags", null);
        factory.variable("results", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.util.List.class), null, "customTags", null);
        factory.name("proc1");
        factory.packageName("com");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.ForEachNodeFactory<?> forEachNode1 = factory.forEachNode(1);
        forEachNode1.name("Sub-process");
        forEachNode1.sequential(false);
        forEachNode1.metaData("UniqueId", "_AEFEC915-B983-45ED-9233-6D0BB115B4BB");
        forEachNode1.metaData("x", 597);
        forEachNode1.metaData("width", 153);
        forEachNode1.metaData("y", 185);
        forEachNode1.metaData("height", 101);
        forEachNode1.tempVariable("foreach_output", org.jbpm.process.core.datatype.DataTypeResolver.fromType("java.util.Collection", java.lang.Thread.currentThread().getContextClassLoader()));
        forEachNode1.outputVariable("object2", "object2", org.jbpm.process.core.datatype.DataTypeResolver.fromType("com.model.Object2", java.lang.Thread.currentThread().getContextClassLoader()));
        forEachNode1.variable("object2", "object2", org.jbpm.process.core.datatype.DataTypeResolver.fromType("com.model.Object2", java.lang.Thread.currentThread().getContextClassLoader()));
        forEachNode1.collectionExpression("listObject2");
        forEachNode1.outputCollectionExpression("results");
        forEachNode1.tempVariable("object2", new ObjectDataType("com.model.Object2"));
        org.jbpm.ruleflow.core.factory.SubProcessNodeFactory<?> subProcessNode1 = forEachNode1.subProcessNode(1);
        subProcessNode1.name("Sub-process");
        subProcessNode1.processId("com.subproc");
        subProcessNode1.processName("");
        subProcessNode1.waitForCompletion(true);
        subProcessNode1.independent(false);
        subProcessNode1.subProcessNode(new org.jbpm.workflow.core.node.SubProcessFactory<SubprocModel>() {

            public SubprocModel bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                com.SubprocModel model = new com.SubprocModel();
                java.util.Map<java.lang.String, java.lang.Object> inputs = org.jbpm.workflow.core.impl.NodeIoHelper.processInputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
                model.setListObject2((java.util.List) (inputs.get("listObject2")));
                return model;
            }

            public org.kie.kogito.process.ProcessInstance<SubprocModel> createInstance(SubprocModel model) {
                return processsubproc.createInstance(model);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, SubprocModel model) {
                java.util.Map<java.lang.String, java.lang.Object> outputs = new java.util.HashMap<java.lang.String, java.lang.Object>();
                org.jbpm.workflow.core.impl.NodeIoHelper.processOutputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return outputs.get(name);
                }, (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
            }
        });
        subProcessNode1.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("listObject2", "listObject2", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_AEFEC915-B983-45ED-9233-6D0BB115B4BB_listObject2InputX", "listObject2", "java.util.ArrayList", null), null, null));
        subProcessNode1.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("listObject2", "listObject2", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_AEFEC915-B983-45ED-9233-6D0BB115B4BB_IN_COLLECTIONInputX", "IN_COLLECTION", "java.util.ArrayList", null), null, null));
        subProcessNode1.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("object2", "object2", "com.model.Object2", null)), new org.jbpm.workflow.core.impl.DataDefinition("_AEFEC915-B983-45ED-9233-6D0BB115B4BB_object2InputX", "object2", "com.model.Object2", null), null, null));
        subProcessNode1.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_AEFEC915-B983-45ED-9233-6D0BB115B4BB_object2OutputX", "object2", "com.model.Object2", null)), new org.jbpm.workflow.core.impl.DataDefinition("object2", "object2", "com.model.Object2", null), null, null));
        subProcessNode1.metaData("UniqueId", "_AEFEC915-B983-45ED-9233-6D0BB115B4BB:1");
        subProcessNode1.metaData("elementname", "Sub-process");
        subProcessNode1.metaData("hidden", true);
        subProcessNode1.metaData("MICollectionOutput", "OUT_COLLECTION");
        subProcessNode1.metaData("MICollectionInput", "IN_COLLECTION");
        subProcessNode1.done();
        forEachNode1.linkIncomingConnections(1);
        forEachNode1.linkOutgoingConnections(1);
        forEachNode1.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode2 = factory.endNode(2);
        endNode2.name("End");
        endNode2.terminate(false);
        endNode2.metaData("UniqueId", "_C89DF41F-825A-4825-8264-CE790C8C21BE");
        endNode2.metaData("x", 851);
        endNode2.metaData("width", 56);
        endNode2.metaData("y", 207);
        endNode2.metaData("height", 56);
        endNode2.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode3 = factory.workItemNode(3);
        workItemNode3.name("Task 1");
        workItemNode3.workName("com.service.JavaClass_giveMeTheList_3_Handler");
        workItemNode3.workParameter("NodeName", "Task 1");
        workItemNode3.workParameter("Interface", "com.service.JavaClass");
        workItemNode3.workParameter("Operation", "giveMeTheList");
        workItemNode3.workParameter("interfaceImplementationRef", "com.service.JavaClass");
        workItemNode3.workParameter("operationImplementationRef", "giveMeTheList");
        workItemNode3.workParameter("implementation", "Java");
        workItemNode3.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("object1", "object1", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_51885DE5-505A-4C57-8CFF-93105291DEFB_object1InputX", "object1", "com.model.Object1", null), null, null));
        workItemNode3.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_51885DE5-505A-4C57-8CFF-93105291DEFB_listObject2OutputX", "listObject2", "java.util.ArrayList", null)), new org.jbpm.workflow.core.impl.DataDefinition("listObject2", "listObject2", "java.lang.Object", null), null, null));
        workItemNode3.done();
        workItemNode3.metaData("UniqueId", "_51885DE5-505A-4C57-8CFF-93105291DEFB");
        workItemNode3.metaData("Implementation", "Java");
        workItemNode3.metaData("elementname", "Task 1");
        workItemNode3.metaData("Type", "Service Task");
        workItemNode3.metaData("OperationRef", "_51885DE5-505A-4C57-8CFF-93105291DEFB_ServiceOperation");
        workItemNode3.metaData("x", 383);
        workItemNode3.metaData("width", 154);
        workItemNode3.metaData("y", 184);
        workItemNode3.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode4 = factory.startNode(4);
        startNode4.name("Start");
        startNode4.interrupting(false);
        startNode4.metaData("UniqueId", "_BFA1368A-B9A0-42EB-97FE-B95487361D84");
        startNode4.metaData("x", 229);
        startNode4.metaData("width", 56);
        startNode4.metaData("y", 207);
        startNode4.metaData("height", 56);
        startNode4.done();
        factory.connection(3, 1, "_843A9FBB-0711-467A-910C-80E9434D704F");
        factory.connection(1, 2, "_1A85E5BF-CC8A-41F4-B0EB-C941FB39ED9C");
        factory.connection(4, 3, "_A418C52A-7ABD-4FE4-9BC1-EE64DED71976");
        factory.validate();
        return factory.getProcess();
    }

    protected void registerListeners() {
        services.getSignalManager().addEventListener("com.subproc", completionEventListener);
    }
}
