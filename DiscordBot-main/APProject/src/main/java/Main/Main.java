package Main;

import Commands.Clear;
import Commands.Info;

import Commands.Invite;
//import Event.GuildMemberJoin;

import Commands.Mute;

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
        jda.getPresence().setActivity(Activity.listening("commands"));

        jda.addEventListener(new Clear());
        jda.addEventListener(new Info());
        jda.addEventListener(new Mute());
        jda.addEventListener(new Invite());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new GuildMemberLeave());
    }
}
