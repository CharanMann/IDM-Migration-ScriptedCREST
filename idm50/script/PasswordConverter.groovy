//String passwordString = "{\"type\": \"x-simple-encryption\"}";
def now = new Date();
println("************* " + now.format("yyyyMMdd-HH:mm:ss.SSS", TimeZone.getTimeZone('EST')) + " Processing user: " + source.userName);

def jsonPassword = source.password;
println("************* passwordString: " + jsonPassword);

println("************* isEncrypted: " + openidm.isEncrypted(jsonPassword));
def decyptedPassword = openidm.decrypt(jsonPassword);
println("************* decyptedPassword: " + decyptedPassword);

return decyptedPassword;



