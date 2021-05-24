package Commands;


import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Kick extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContentRaw().startsWith("~kick")){
            if(event.getMember().hasPermission(Permission.KICK_MEMBERS)){
                for(Member member: event.getMessage().getMentionedMembers()){
                    member.kick().queue();
                    event.getChannel().sendMessage("Sucessfully kicked!");
                }
            }
        }
    }
}
