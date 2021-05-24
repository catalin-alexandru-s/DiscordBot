package Event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class GuildMemberLeave extends ListenerAdapter {
    String[] messages = {
            "[member] left. bye bye [member]!",
            "[member] unfortunately, left the party!"

    };

    public void onGuildMemberRemove(GuildMemberRemoveEvent event) throws NullPointerException {
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder leave = new EmbedBuilder();
        leave.setColor(Color.MAGENTA);
        leave.setDescription(messages[number].replace("[member]", event.getUser().getAsMention()));

        event.getGuild().getDefaultChannel().sendMessage(leave.build()).queue();
    }
}
