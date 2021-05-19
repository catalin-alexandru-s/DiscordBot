/*
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageListener extends ListenerAdapter {
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("hello")) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("Hello!").queue();
            return;
        }
        if (messageSent.equalsIgnoreCase(Main.prefix + "help")) ;
        event.getMessage().delete().queue();
        event.getChannel().sendMessage("Commands available:").queue();
        event.getChannel().sendMessage("-trivia").queue();
        event.getChannel().sendMessage("-clear [int]").queue();
        event.getChannel().sendMessage("-ask").queue();

        TODO HELP

    }

}

 */
