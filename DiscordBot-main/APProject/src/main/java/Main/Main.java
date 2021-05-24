package Main;

import Commands.*;
import Commands.JokeCommand.Joke;
import Commands.MemeCommand.Meme;
import Commands.Music.PlayMusic;
import Event.GuildMemberJoin;
import Event.GuildMemberLeave;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Main {
    public static JDA jda;
    public static String prefix = "~";

    public static void main(String[] args) throws LoginException {

        jda = JDABuilder.createDefault("ODQ0NjMxOTQ4MDkzMTYxNDk2.YKVOzA.vtYg1L7y3uGZOQ55uwBFZ7SFtN4").enableIntents(GatewayIntent.GUILD_MEMBERS).disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE).setBulkDeleteSplittingEnabled(false).setCompression(Compression.NONE).setActivity(Activity.watching("over the java project")).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.listening("the Java project"));

        jda.addEventListener(new Clear());    //commands
        jda.addEventListener(new Info());
        jda.addEventListener(new Mute());
        //jda.addEventListener(new Trivia());
        jda.addEventListener(new Invite());
        jda.addEventListener(new Searching());
        jda.addEventListener(new PlayMusic());
        jda.addEventListener(new Joke());
        jda.addEventListener(new Meme());
        jda.addEventListener(new Kick());
        jda.addEventListener(new GuildMemberJoin());  //events
        jda.addEventListener(new GuildMemberLeave());

    }
}
