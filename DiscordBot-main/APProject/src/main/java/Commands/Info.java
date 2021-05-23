package Commands;

import Main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Info extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Main.prefix + "info")) {
            EmbedBuilder infoBuilder = new EmbedBuilder();
            infoBuilder.setTitle("Commands available:");
            infoBuilder.setDescription("~clear integer\n~trivia\n~invite\n~mute\n~search\n~playMusic\n~whatIs\n~joke\n~meme\n");
            infoBuilder.setColor(0x9e1fff);

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(infoBuilder.build()).queue();
            infoBuilder.clear();
        }

    }

}


