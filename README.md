# IDM-Migration-ScriptedCREST

IDM upgrade process requires in-place upgrade of IDM servers and database. This in-place upgrade can result in some downtime. Many deployments requires zero downtime migration which requires parallel IDM deployment  <br />
This module provides custom CREST connector for migration of IDM managed objects.  <br /> 

REST connector for IDM migration: <br />
1. Managed users migration <br />
2. Managed roles migration <br /> 
3. 

These features are not currently supported in this implementation: <br />
1. LiveSync of managed objects from old to new IDM <br />
2. 


Pre-requisites :
================
* Versions used for this project: IDM 4.0 -> IDM 5.0 migration. 
1. IDM 4.0 has been 


IDM 4.0 Configuration:
=================================================
1. Password property in managed objects need to be updated so that it is viewable via REST.
2. 


IDM 5.0 Configuration:
=====================
1. 
      
Migration testing:
=========================




* * *

Copyright © 2017 ForgeRock, AS.

The contents of this file are subject to the terms of the Common Development and
Distribution License (the License). You may not use this file except in compliance with the
License.

You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
specific language governing permission and limitations under the License.

When distributing Covered Software, include this CDDL Header Notice in each file and include
the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
Header, with the fields enclosed by brackets [] replaced by your own identifying
information: "Portions copyright [year] [name of copyright owner]".

Portions Copyrighted 2017 Charan Mann
