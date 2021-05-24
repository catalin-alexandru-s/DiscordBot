package Commands.TriviaCommand;

import Main.Main;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;


public class Trivia extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Main.prefix + "trivia")) {

            ObjectMapper objectMapper = new ObjectMapper();

            Result resultTrivia = new Result();

            try {
                resultTrivia = objectMapper.readValue(new URL("https://opentdb.com/api.php?amount=50&category=18&type=multiple"), Result.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            EmbedBuilder triviaBuilder = new EmbedBuilder();

            Random rand = new Random();                    //generating a random question
            Integer randomQuestion = rand.nextInt(50);

            triviaBuilder.setTitle(resultTrivia.results.get(randomQuestion).getQuestion());
            triviaBuilder.setDescription(
                    "Category: " + resultTrivia.results.get(randomQuestion).category + "\n" +
                            "Dificulty: " + resultTrivia.results.get(randomQuestion).getDifficulty() + "\n" +
                            "\uD83E\uDD70 " + resultTrivia.results.get(randomQuestion).getIncorrect_answers().get(0) + "\n" +
                            "\uD83D\uDC40 " + resultTrivia.results.get(randomQuestion).getIncorrect_answers().get(1) + "\n" +
                            "\uD83E\uDD25 " + resultTrivia.results.get(randomQuestion).getIncorrect_answers().get(2) + "\n" +
                            "\uD83D\uDE3C " + resultTrivia.results.get(randomQuestion).getCorrect_answer() + "\n"
            );
            triviaBuilder.setColor(Color.PINK);

            event.getChannel().sendTyping().queue();
            sendMessageWithReactions(event.getChannel(),
                    triviaBuilder.build(),
                    "\uD83E\uDD70 ",
                    "\uD83D\uDC40",
                    "\uD83E\uDD25",
                    "\uD83D\uDE3C"
            );

            triviaBuilder.clear();
        }

    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {

        if (!event.getMember().getId().equals("844631948093161496")) {  //if it is not the bot
            MessageReaction reaction = event.getReaction();
            MessageReaction.ReactionEmote emote = reaction.getReactionEmote();
            MessageChannel channel = event.getChannel();

            if (emote.getEmoji().equals("\uD83D\uDE3C")) {
                channel.sendMessage("User <@" + event.getMember().getId() + "> has the right answer. \n").queue();
            }
            else{
                channel.sendMessage("User <@" + event.getMember().getId() + "> try again. \n").queue();
            }
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