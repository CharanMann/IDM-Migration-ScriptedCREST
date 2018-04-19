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

//String passwordString = "{\"type\": \"x-simple-encryption\"}";
def now = new Date();
println("************* " + now.format("yyyyMMdd-HH:mm:ss.SSS", TimeZone.getTimeZone('EST')) + " Processing user: " + source.userName);

def jsonPassword = source.password;
println("************* passwordString: " + jsonPassword);

println("************* isEncrypted: " + openidm.isEncrypted(jsonPassword));
def decyptedPassword = openidm.decrypt(jsonPassword);
println("************* decyptedPassword: " + decyptedPassword);

return decyptedPassword;



