/*
 * Copyright © 2017 ForgeRock, AS.
 *
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Portions Copyrighted 2017 Charan Mann
 *
 * IDM-Migration-ScriptedCREST: Created by Charan Mann on 9/29/17 , 10:46 AM.
 */
import groovy.json.JsonBuilder

def now = new Date();
println("************* " + now.format("yyyyMMdd-HH:mm:ss.SSS", TimeZone.getTimeZone('EST')) + " Processing role: " + source.name);

def roleId = source._id;
def managedRole = openidm.read("managed/role/" + roleId);

// If no role has been found
if (!managedRole) {
    println("************* Role has not been created yet: " + roleId);
    return [];
}

// Iterate over assignments
List<String> assignments = source.assignments;
for (Map assignment : assignments) {
    def assignmentRef = assignment.get("_ref");
    println("************* Processing assignment: " + assignmentRef);
    List managedAssignments = managedRole.get("assignments")

    if (managedAssignments && !managedAssignments.empty && assignmentRef.equals(managedAssignments[0].get("_ref"))) {
        println("************* Assignment already assigned to role");
        return managedAssignments;
    }

    def builder = new JsonBuilder();
    def assignmentJSON = builder {
        operation 'add'
        field '/assignments/-'
        value(
                _ref: assignmentRef
        )
    };

    def assignmentArray = [assignmentJSON];
    println("************* Patching assignment: " + assignmentJSON.toString());
    openidm.patch("managed/role/" + roleId, managedRole.get("_rev"), assignmentJSON.toString());
}


