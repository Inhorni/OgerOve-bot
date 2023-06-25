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

    public OgerOve() {
        String token = "redacted";
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
        JDABuilder builder = JDABuilder.createDefault("redacted");
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
        } else if (event.getMessage().getContentRaw().contains(":Oger_Mikeremovebgpreview:")) {
            event.getChannel().sendMessage("aughhhhh").queue();
        }else if (event.getMessage().getStickers().stream().anyMatch(sticker -> sticker.getName().equalsIgnoreCase("WismarerOger"))) {
            event.getChannel().sendMessage("Wildschwein Jagen!!!!!!!!!!!!!").queue();
        }else if (event.getMessage().getContentRaw().equalsIgnoreCase("!michi")) {
            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/1015302578919190548/1121705937351217182/UgaUgaMichi.jpg").queue();
        }else if (event.getMessage().getContentRaw().equalsIgnoreCase("!cancerdog")) {
            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/526697763447111680/1121791547898351778/unknown.jpg https://cdn.discordapp.com/attachments/526697763447111680/1121791547390828654/Leon_Pog.png").queue();
        }else if (event.getMessage().getStickers().stream().anyMatch(sticker -> sticker.getName().equalsIgnoreCase("OgerOve"))) {
            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/1015302578919190548/1121318532559409253/IMG_4628.jpg").queue();
        }else if (event.getMessage().getContentRaw().equalsIgnoreCase("!hebel")) {
            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/526697763447111680/1121791710436003970/Screenshot_20230218_230908.png").queue();
        }else if (event.getMessage().getContentRaw().equalsIgnoreCase("!?")) {
            event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/738160562352947331/1111762523901935706/china.mp4").queue();
        }  else if (event.getMessage().getContentRaw().equalsIgnoreCase("!Jagen")) {
            int randomNumber = (int) (Math.random() * 100); // Generate a random number between 0 and 100
            event.getChannel().sendMessage("Du hast " + randomNumber + " Wildschweine gefangen").queue();
        }else if (event.getMessage().getContentRaw().equalsIgnoreCase("!Schuledodgen")) {
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

