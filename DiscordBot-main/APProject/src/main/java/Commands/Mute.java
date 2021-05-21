package Commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class Mute extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase("~mute")) {
            if (args.length == 2) {
                Guild guild = event.getGuild();
                Role role = guild.getRoleById("844997838278492220");
                List<Member> member = event.getMessage().getMentionedMembers();

                if (!member.get(0).getRoles().contains(role)) {
                    // Mute user

                    event.getChannel().sendMessage("Muted " + member + ".").queue();
                    event.getGuild().addRoleToMember(member.get(0), role).complete();
                } else {
                    // Unmute user
                    event.getChannel().sendMessage("Unmuted " + member + ".").queue();
                    event.getGuild().removeRoleFromMember(member.get(0), role).complete();
                }
            } else {
                event.getChannel().sendMessage("Incorrect syntax. Use `~mute [user mention]`").queue();
            }
        }
    }
}
