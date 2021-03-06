package org.tdl.vireo.model.repo.custom;

import org.tdl.vireo.exception.ComponentNotPresentOnOrgException;
import org.tdl.vireo.exception.HeritableModelNonOverrideableException;
import org.tdl.vireo.exception.WorkflowStepNonOverrideableException;
import org.tdl.vireo.model.ControlledVocabulary;
import org.tdl.vireo.model.FieldPredicate;
import org.tdl.vireo.model.FieldProfile;
import org.tdl.vireo.model.InputType;
import org.tdl.vireo.model.ManagedConfiguration;
import org.tdl.vireo.model.Organization;
import org.tdl.vireo.model.WorkflowStep;

public interface FieldProfileRepoCustom {

    public FieldProfile create(WorkflowStep originatingWorkflowStep, FieldPredicate fieldPredicate, InputType inputType, String gloss, Boolean repeatable, Boolean overrideable, Boolean enabled, Boolean optional, Boolean flagged, Boolean logged, String defaultValue);

    public FieldProfile create(WorkflowStep originatingWorkflowStep, FieldPredicate fieldPredicate, InputType inputType, String usage, String gloss, Boolean repeatable, Boolean overrideable, Boolean enabled, Boolean optional, Boolean flagged, Boolean logged, String defaultValue);

    public FieldProfile create(WorkflowStep originatingWorkflowStep, FieldPredicate fieldPredicate, InputType inputType, String usage, String help, String gloss, Boolean repeatable, Boolean overrideable, Boolean enabled, Boolean optional, Boolean flagged, Boolean logged, String defaultValue);

    public FieldProfile create(WorkflowStep originatingWorkflowStep, FieldPredicate fieldPredicate, InputType inputType, String usage, String help, String gloss, Boolean repeatable, Boolean overrideable, Boolean enabled, Boolean optional, Boolean flagged, Boolean logged, ControlledVocabulary controlledVocabulary, String defaultValue);

    public FieldProfile create(WorkflowStep originatingWorkflowStep, FieldPredicate fieldPredicate, InputType inputType, String usage, String help, String gloss, Boolean repeatable, Boolean overrideable, Boolean enabled, Boolean optional, Boolean flagged, Boolean logged, ControlledVocabulary controlledVocabulary, ManagedConfiguration mappedShibAttribute, String defaultValue);

    public FieldProfile create(WorkflowStep originatingWorkflowStep, FieldPredicate fieldPredicate, InputType inputType, String usage, String help, String gloss, Boolean repeatable, Boolean overrideable, Boolean enabled, Boolean optional, Boolean hidden, Boolean flagged, Boolean logged, ControlledVocabulary controlledVocabulary, ManagedConfiguration mappedShibAttribute, String defaultValue);

    public void removeFromWorkflowStep(Organization requestingOrganization, WorkflowStep requestingWorfklowStep, FieldProfile fieldProfileToDisinherit) throws WorkflowStepNonOverrideableException, HeritableModelNonOverrideableException, ComponentNotPresentOnOrgException;

    public FieldProfile update(FieldProfile fieldProfile, Organization requestingOrganization) throws HeritableModelNonOverrideableException, WorkflowStepNonOverrideableException, ComponentNotPresentOnOrgException;

}