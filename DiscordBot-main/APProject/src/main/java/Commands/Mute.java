package Commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Mute extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase("~mute")) {
            if (args.length == 2) {
                Guild guild = event.getGuild();
                List<Member> member = event.getMessage().getMentionedMembers();
                guild.addRoleToMember(member.get(0), event.getGuild().getRoleById("844997838278492220")).queue();
                if (!member.get(0).getRoles().contains(event.getGuild().getRoleById("844997838278492220"))) {
                    // Mute user
                    event.getChannel().sendMessage("Muted " + member.get(0) + ".").queue();
                    event.getGuild().addRoleToMember(member.get(0), event.getGuild().getRoleById("844997838278492220")).queue();
                } else {
                    // Unmute user
                    event.getChannel().sendMessage("Unmuted " + member.get(0) + ".").queue();
                    event.getGuild().removeRoleFromMember(member.get(0), event.getGuild().getRoleById("844997838278492220")).queue();
                }
            } else {
                event.getChannel().sendMessage("Incorrect syntax. Use `~mute [user mention]`").queue();
            }
        }
    }
}
