
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Info extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args=event.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase(Main.prefix + "info")){
            EmbedBuilder info= new EmbedBuilder();
            info.setTitle("Commands available:");
            info.setDescription("~clear integer\n~trivia");
            info.setColor(0x9e1fff);

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }

    }

}


