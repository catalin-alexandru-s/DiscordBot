package Commands;

import Main.Main;
import Util.TriviaUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;


public class Trivia extends ListenerAdapter {


    TriviaUtil utilTrivia;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        utilTrivia = new TriviaUtil();
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Main.prefix + "trivia")) {
            EmbedBuilder triviaBuilder = new EmbedBuilder();
            triviaBuilder.setColor(Color.GREEN);
            triviaBuilder.setTitle("Test your brain with some intricate java questions: \n");
            triviaBuilder.setDescription("Usage: `" + Main.prefix + "trivia`");
            triviaBuilder.addField("Femeia e un obiect?", "True or false? ", false);

            event.getChannel().sendTyping().queue();

            sendMessageWithReactions(event.getChannel(), triviaBuilder.build(), "✅", "❌");
//            if (event.getReaction().getReactionEmote().getEmoji().equals("✅")) {
//
//            }


            triviaBuilder.clear();
        }

    }

    public void sendMessageWithReactions(MessageChannel channel, MessageEmbed embed, String... reactions) {
        channel.sendMessage(embed).queue(msg -> {
            for (String reaction : reactions) {
                msg.addReaction(reaction).queue();
            }
        });
    }
}