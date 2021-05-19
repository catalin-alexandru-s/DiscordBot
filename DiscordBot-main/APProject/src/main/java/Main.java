import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main {
    public static JDABuilder builder;
    public static String prefix;

    public static void main(String[] args) throws Exception {
        String token = "ODQ0NjMxOTQ4MDkzMTYxNDk2.YKVOzA.vtYg1L7y3uGZOQ55uwBFZ7SFtN4";
        prefix = "~";
        builder = JDABuilder.createDefault(token);


        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);

        //If enabled, JDA will separate the bulk delete event into individual delete events, but this isn't as efficient as handling a single event would be.
        builder.setBulkDeleteSplittingEnabled(false);

        //Sets the compression algorithm used with the gateway connection, this will decrease the amount of used bandwidth for the running bot instance for the cost of a few extra cycles for decompression.
        builder.setCompression(Compression.NONE);

        builder.setActivity(Activity.watching("over the java project"));

        registerListeners();
        builder.build();
    }

    public static void registerListeners() {
        builder.addEventListeners(new Clear());
    }
}
