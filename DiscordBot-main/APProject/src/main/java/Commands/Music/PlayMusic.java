package Commands.Music;

import Main.Main;
import Util.CommandContext;
import Util.ICommand;
import Util.PlayMusicUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PlayMusic extends ListenerAdapter {
    private final List<ICommand> commands = new ArrayList<>();


    public PlayMusic() {
        addCommand(new PlayMusicUtil());
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Main.prefix + "playMusic")) {
            EmbedBuilder musicBuilder = new EmbedBuilder();
            musicBuilder.setTitle("Youtube Music Player");
            musicBuilder.setDescription("To use ~playMusic \n do: !!play + youtubeLink \n Play the music that you like right here on Discord or be redirected to Youtube: \n");
            musicBuilder.setColor(Color.CYAN);

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(musicBuilder.build()).queue();
            musicBuilder.clear();
            handle(event, "Main.prefix");


        }
    }

    void handle(GuildMessageReceivedEvent event, String prefix) {
        String[] split = event.getMessage().getContentRaw()
                .replaceFirst("(?i)" + Pattern.quote(prefix), "")
                .split("\\s+");

        String invoke = split[0].toLowerCase();
        ICommand cmd = this.getCommand(invoke);

        if (cmd != null) {
            event.getChannel().sendTyping().queue();
            List<String> args = Arrays.asList(split).subList(1, split.length);

            CommandContext ctx = new CommandContext(event, args);

            cmd.handle(ctx);
        }
    }

    public void addCommand(ICommand cmd) {
        boolean nameFound = this.commands.stream().anyMatch((it) -> it.getName().equalsIgnoreCase(cmd.getName()));

        if (nameFound) {
            throw new IllegalArgumentException("A command with this name is already present");
        }

        commands.add(cmd);
    }

    public ICommand getCommand(String search) {
        String searchLower = search.toLowerCase();

        for (ICommand cmd : this.commands) {
            if (cmd.getName().equals(searchLower) || cmd.getAliases().contains(searchLower)) {
                return cmd;
            }
        }

        return null;
    }


}
