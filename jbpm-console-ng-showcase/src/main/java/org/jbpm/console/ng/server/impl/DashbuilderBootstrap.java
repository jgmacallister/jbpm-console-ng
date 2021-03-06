/*
 * Copyright 2015 JBoss Inc
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
package org.jbpm.console.ng.server.impl;

import org.dashbuilder.dataset.DataSetFactory;
import org.dashbuilder.dataset.def.DataSetDefRegistry;
import org.jbpm.console.ng.ht.client.editors.taskslist.grid.dash.DataSetTasksListGridViewImpl;
import org.uberfire.commons.services.cdi.Startup;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Startup
@ApplicationScoped
public class DashbuilderBootstrap {

    public static final String HUMAN_TASKS_DATASET = "jbpmHumanTasks";
    public static final String JBPM_DATASOURCE = "java:jboss/datasources/ExampleDS";
    public static final String HUMAN_TASKS_TABLE = "AuditTaskImpl";
    @Inject
    protected DataSetDefRegistry dataSetDefRegistry;

    @PostConstruct
    protected void init() {
        registerDataSetDefinitions();
    }

    protected void registerDataSetDefinitions() {
        System.out.println("Bootstrapping Dashbuilder stuff.....");
        dataSetDefRegistry.registerDataSetDef(
                DataSetFactory.newSQLDataSetDef()
                .uuid( HUMAN_TASKS_DATASET )
                .name( "Human tasks" )
                .dataSource( JBPM_DATASOURCE )
                .dbTable( HUMAN_TASKS_TABLE, false )
                .date( DataSetTasksListGridViewImpl.COLUMN_ACTIVATIONTIME )
                .label( DataSetTasksListGridViewImpl.COLUMN_ACTUALOWNER )
                .label( DataSetTasksListGridViewImpl.COLUMN_CREATEDBY )
                .date( DataSetTasksListGridViewImpl.COLUMN_CREATEDON )
                .label( DataSetTasksListGridViewImpl.COLUMN_DEPLOYMENTID )
                .text( DataSetTasksListGridViewImpl.COLUMN_DESCRIPTION )
                .date( DataSetTasksListGridViewImpl.COLUMN_DUEDATE )
                .label( DataSetTasksListGridViewImpl.COLUMN_NAME )
                .label( DataSetTasksListGridViewImpl.COLUMN_PARENTID )
                .label( DataSetTasksListGridViewImpl.COLUMN_PRIORITY )
                .label( DataSetTasksListGridViewImpl.COLUMN_PROCESSID )
                .label( DataSetTasksListGridViewImpl.COLUMN_PROCESSINSTANCEID )
                .label( DataSetTasksListGridViewImpl.COLUMN_PROCESSSESSIONID )
                .label( DataSetTasksListGridViewImpl.COLUMN_STATUS )
                .label( DataSetTasksListGridViewImpl.COLUMN_TASKID )
                .label( DataSetTasksListGridViewImpl.COLUMN_WORKITEMID )
                .label( DataSetTasksListGridViewImpl.COLUMN_POTENTIALOWNERS )
                .label( DataSetTasksListGridViewImpl.COLUMN_BUSINESSADMINISTRATORS )
                .buildDef());
    }
}
