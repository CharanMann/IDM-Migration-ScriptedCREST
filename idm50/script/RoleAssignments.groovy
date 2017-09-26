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
    println("************* Patching assignment: " + assignmentArray);
    openidm.patch("managed/role/" + roleId, managedRole.get("_rev"), assignmentArray);
}


