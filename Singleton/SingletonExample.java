/*Singletons are classes which can have no more than one object. They're most useful for storing global state across a system.

Some situations where one might use a singleton include:

A system-wide "global value," that many parts of the system may need to access—e.g. the software's license number. Some software 
requires a valid "license" in order to run. Such software might want to make the current license available to different parts of 
the software system while it's running. A singleton is a good place to store that information, since there's only ever one correct 
answer to the question "what license are we using?"
Logging. You might want different loggers with different configurations. For example, you might want a "loud" logger that emails 
exceptions back to the software maintainer, to alert her of crucial issues, as well as a "quiet" logger that simply logs errors 
to a file on the user's system. Your software might have several components (read: several classes) that want to use the loud 
logger (e.g. payment-related stuff) and several components that want to use the quiet logger (e.g. caching systems—if the cache
fails the system might still run correctly, just more slowly). java.util.logging.LogManager manages a set of individual loggers
which are singletons. You can access them by name with getLogger(), and you can add new ones with addLogger().
Singletons are contentious these days. Many people believe they should be avoided, or at least be used less often than they
generally are.

Even so, implementing a singleton is an interesting coding challenge.

Suppose we wanted a singleton called InstallationDetails that stored some information, including the licenseNumber. How would we 
implement this?

Lazy Solution: 
*/

public final class InstallationDetails {
    private static InstallationDetails INSTANCE = null;

    private long licenseNumber;

    public long getLicenseNumber() {
        return licenseNumber;
    }

    // by making the constructor private, we prevent instantiation
    private InstallationDetails() {
        this.licenseNumber = ... ;
    }

    public static InstallationDetails getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new InstallationDetails();
        }
        return INSTANCE;
    }
}