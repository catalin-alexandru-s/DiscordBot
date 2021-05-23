package Commands.JokeCommand;

import Main.Main;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Joke extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Main.prefix + "joke")) {

            ObjectMapper objectMapper = new ObjectMapper();

            Data dataJoke = new Data();

            try {
                dataJoke = objectMapper.readValue(new URL("https://apis.duncte123.me/joke"), Data.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            EmbedBuilder jokeBuilder = new EmbedBuilder();

            jokeBuilder.setTitle(dataJoke.data.getTitle(), dataJoke.data.getUrl());
            jokeBuilder.setDescription(dataJoke.data.getBody());
            jokeBuilder.setColor(Color.PINK);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(jokeBuilder.build()).queue();
        }

    }

}