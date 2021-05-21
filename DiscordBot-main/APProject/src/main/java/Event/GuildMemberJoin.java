
package Event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter {

    String[] messages = {
            "[member] joined. You must construct addition pylons!",
            "Never gonna give [member] up! Never gonna let [member] down!",
            "Hey! Listen! [member] has joined!",
            "Ha! [member] has joined! You activated my trap card!",
            "We've been expecting you, [member].",
            "It's dangerous to go alone, take [member]!",
            "Swoooosh. [member] just landed.",
            "Brace yourselves. [member] just joined the server.",
            "A wild [member] appeared.",
            "[member] just slid into the server!",
            "Ermagherd. [member] is here.",
            "[member] joined your party.",
            "[member] just joined the server. - glhf",
            "[member] just joined. Everyone, look busy!",
            "[member]  just joined. Can I get a heal?",
            "Welcome, [member]. Stay awhile and listen",
            "Welcome, [member]. Leave your weapons by the door.",
            "Welcome, [member]. We hope you brought pizza.",
            "Brace yourselves. [member] just joined the server.",
            "[member] just joined. Hide your bananas.",
            "[member] just arrived. Seems OP - please nerf.",
            "A [member] has spawned in the server.",
            "Big [member] showed up!",
            "Where’s [member]? In the server!",
            "[member] hopped into the server. Kangaroo!!",
            "[member] just showed up. Hold my beer.",
            "Challenger approaching - [member] has appeared!",
            "It's a bird! It's a plane! Nevermind, it's just [member].",
            "It's [member]! Praise the sun! [T]/",
            "Roses are red, violets are blue, [member] joined this server with you",
            "Hello. Is it [member] you're looking for?",
            "[member] is here to kick butt and chew bubblegum. And [member] is all out of gum.",
            "[member] has arrived. Party's over.",
            "Ready player [member]"
    };
    public void onGuildMemberJoin(GuildMemberJoinEvent event)
    {
        Random rand= new Random();
        int number= rand.nextInt(messages.length);

        EmbedBuilder join=new EmbedBuilder();
        join.setColor(0x66d8ff);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
    }
    }


