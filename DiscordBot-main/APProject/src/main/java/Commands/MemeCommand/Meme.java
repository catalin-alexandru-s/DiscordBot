package Commands.MemeCommand;

import Main.Main;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Meme extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Main.prefix + "meme")) {

            ObjectMapper objectMapper = new ObjectMapper();

            Data dataMeme = new Data();

            try {
                dataMeme = objectMapper.readValue(new URL("https://apis.duncte123.me/meme"), Data.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            EmbedBuilder memeBuilder = new EmbedBuilder();

            memeBuilder.setTitle(dataMeme.data.getTitle(), dataMeme.data.getUrl());
            memeBuilder.setDescription(dataMeme.data.getBody());
            memeBuilder.setImage(dataMeme.data.getImage());
            memeBuilder.setColor(Color.PINK);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(memeBuilder.build()).queue();
        }
    }
}

