package Commands;

import Main.Main;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.CustomsearchRequestInitializer;
import com.google.api.services.customsearch.model.Result;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;


public class Searching extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase("~search")) {
            EmbedBuilder searchBuilder = new EmbedBuilder();
            searchBuilder.setColor(Color.YELLOW);
            searchBuilder.setTitle("Search whatever comes up to your mind : \n");
            searchBuilder.setDescription("Usage: `" + Main.prefix + "search`");

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(searchBuilder.build()).queue();
            searchBuilder.clear();

            String searchQuery = args[1]; //The query to search
            String cx = "28de3993a9c3da920"; //Your search engine

            //Instance Customsearch
            Customsearch cs = null;
            try {
                cs = new Customsearch.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null)
                        .setApplicationName("APProject")
                        .setGoogleClientRequestInitializer(new CustomsearchRequestInitializer("AIzaSyCh62zA3hPwaIQRNivaFOa9iY5UVGSODFg"))
                        .build();
            } catch (GeneralSecurityException | IOException e) {
                e.printStackTrace();
            }

            //Set search parameter
            Customsearch.Cse.List list = null;
            try {
                list = cs.cse().list(searchQuery).setCx(cx);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Execute search
            com.google.api.services.customsearch.model.Search result = null;
            try {
                result = list.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            event.getChannel().sendMessage("The first searches related to the topic that you're interested in are: \n").queue();
            if (result.getItems() != null) {
                for (Result ri : result.getItems()) {
                    //Get title, link, body etc. from search
                    event.getChannel().sendMessage(ri.getTitle() + ", " + ri.getLink() + "\n").queue();
                }
            }
        }
    }
}
