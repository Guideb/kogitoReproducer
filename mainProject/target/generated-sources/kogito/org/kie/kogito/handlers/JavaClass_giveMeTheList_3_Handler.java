package org.kie.kogito.handlers;

import org.kie.kogito.process.workitem.WorkItemExecutionException;

@javax.enterprise.context.ApplicationScoped()
public class JavaClass_giveMeTheList_3_Handler implements org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler {

    com.service.JavaClass service;

    public JavaClass_giveMeTheList_3_Handler() {
        this(new com.service.JavaClass());
    }

    @javax.inject.Inject()
    public JavaClass_giveMeTheList_3_Handler(com.service.JavaClass service) {
        this.service = service;
    }

    public void executeWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
        java.lang.Object result;
        result = service.giveMeTheList((com.model.Object1) workItem.getParameter("object1"));
        workItemManager.completeWorkItem(workItem.getStringId(), java.util.Collections.singletonMap("listObject2", result));
    }

    public void abortWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
    }

    public String getName() {
        return "com.service.JavaClass_giveMeTheList_3_Handler";
    }
}
