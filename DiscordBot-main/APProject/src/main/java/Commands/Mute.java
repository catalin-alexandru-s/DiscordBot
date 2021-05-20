package Commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Mute extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase("~mute")) {
            if (args.length > 1 && args.length < 3) {
                Member member = event.getGuild().getMemberById(args[1].replace("<@", "").replace(">", ""));
                Role role = event.getGuild().getRoleById("Escape@Muted pe text chat pt ca n ai rol yay");

                if (!member.getRoles().contains(role)) {
                    // Mute user
                    event.getChannel().sendMessage("Muted " + args[1] + ".").queue();
                    //  event.getGuild().getController().addRolesToMember(member, role).complete();
                    //nu functioneaza getController pt ca rol (le decomentezi dupa)
                } else {
                    // Unmute user
                    event.getChannel().sendMessage("Unmuted " + args[1] + ".").queue();
                    //  event.getGuild().getController().removeRolesFromMember(member, role).complete(); //nu functioneaza getController pt ca rol (le decomentezi dupa)
                }
            } else if (args.length == 3) {
                Member member = event.getGuild().getMemberById(args[1].replace("<@", "").replace(">", ""));
                Role role = event.getGuild().getRoleById("Escape@Muted pe text chat pt ca n ai rol yay");

                event.getChannel().sendMessage("Muted " + args[1] + " for " + args[2] + " seconds.").queue();
                // event.getGuild().getController().addRolesToMember(member, role).complete(); //nu functioneaza getController pt ca rol (le decomentezi dupa)

                // Unmute after a few seconds
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                event.getChannel().sendMessage("Unmuted " + args[1] + ".").queue();
                                //    event.getGuild().getController().removeRolesFromMember(member, role).complete();
                            }
                        },
                        Integer.parseInt(args[2]) * 1000L
                );
            } else {
                event.getChannel().sendMessage("Incorrect syntax. Use `~mute [user mention] [time {optional}]`").queue();
            }
        }
    }
}
