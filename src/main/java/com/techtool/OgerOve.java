package com.techtool;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import java.util.Random;

public class OgerOve extends ListenerAdapter {

    private final ShardManager shardManager;
    private final String[] responses = {
            "Ja, auf jeden Fall!",
            "Vielleicht...",
            "Ich weiß es nicht.",
            "Frag mich später nochmal.",
            "Nein, auf keinen Fall!"
    };

    public OgerOve() {
        String token = "";
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("BoarHunt Oger Edition"));

        // Enable necessary intents
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_EMOJIS_AND_STICKERS, GatewayIntent.GUILD_MESSAGE_REACTIONS);

        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault("");
        builder.addEventListeners(new OgerOve());

        // Enable necessary intents
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_EMOJIS_AND_STICKERS, GatewayIntent.GUILD_MESSAGE_REACTIONS);

        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        double rand = Math.random();
        if (event.getAuthor().isBot()) return;
        if (event.getMessage().getContentRaw().equalsIgnoreCase("!Oger")) {
            event.getChannel().sendMessage("Oger HUNGRIG!!!!!! 😡").queue();
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("!commands")) {
            event.getChannel().sendMessage("Verfügbare Befehle:\n" +
                    "!Oger - Wütender Oger\n" +
                    "!commands - Zeigt Befehle\n" +
                    "!michi - postet bild von MICHI!!!!!\n" + "!?\n" + "!gamble\n" + "!Schuledodgen").queue();
        } 
        else if (event.getMessage().getContentRaw().contains(":Oger_Mikeremovebgpreview:")) {
            event.getChannel().sendMessage("aughhhhh").queue();
        }
        else if (event.getMessage().getStickers().stream().anyMatch(sticker -> sticker.getName().equalsIgnoreCase("WismarerOger"))) {
            event.getChannel().sendMessage("Wildschwein Jagen!!!!!!!!!!!!!").queue();
        } 
        else if (event.getMessage().getContentRaw().equalsIgnoreCase("!Jagen")) {
            int randomNumber = (int) (Math.random() * 100); // Generate a random number between 0 and 100
            event.getChannel().sendMessage("Du hast " + randomNumber + " Wildschweine gefangen").queue();
        }
        else if (event.getMessage().getContentRaw().equalsIgnoreCase("!Schuledodgen")) {
            // Generate a random response
            Random random = new Random();
            boolean shouldDodge = random.nextBoolean();

            // Send the response
            if (shouldDodge) {
                event.getChannel().sendMessage("Bleib zuhause du schwuchtel").queue();
            } else {
                event.getChannel().sendMessage("Du kommst morgen du wixxer").queue();
            }
            }
        else if(event.getMessage().getContentRaw().equalsIgnoreCase("!holyogre")) {
            // Generate a random response
            Random random = new Random();
            String response = responses[random.nextInt(responses.length)];

            // Send the response
            event.getChannel().sendMessage(response).queue();
        }
    }


    @Override
    public void onMessageReactionAdd( MessageReactionAddEvent event) {
        if (event.getUser().isBot()) return;
        String targetEmote = "Oger_Mikeremovebgpreview";
        if (event.getEmoji().getName().equalsIgnoreCase(targetEmote)) {
            event.getChannel().sendMessage("AUGHHHHHHHHH AMBATAKAM").queue();
        }
    }
}

