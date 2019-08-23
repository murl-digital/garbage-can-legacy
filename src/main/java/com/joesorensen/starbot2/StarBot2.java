package com.joesorensen.starbot2;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.jagrosh.jdautilities.examples.command.AboutCommand;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import javax.security.auth.login.LoginException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class StarBot2 {
    private final static Permission[] RECOMMENDED_PERMS = new Permission[]{Permission.MESSAGE_READ, Permission.MESSAGE_WRITE, Permission.MESSAGE_HISTORY, Permission.MESSAGE_ADD_REACTION,
            Permission.MESSAGE_EMBED_LINKS, Permission.MESSAGE_ATTACH_FILES, Permission.MESSAGE_MANAGE, Permission.MESSAGE_EXT_EMOJI,
            Permission.MANAGE_CHANNEL, Permission.VOICE_CONNECT, Permission.VOICE_SPEAK, Permission.NICKNAME_CHANGE};

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger log = LoggerFactory.getLogger("Startup");

        java.io.InputStream is = StarBot2.class.getResourceAsStream("StarBot.properties");
        java.util.Properties p = new Properties();
        try {
            p.load(is);
        } catch (IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            System.exit(1);
        }

        log.info("StarBot2 v"+p.getProperty("version"));

        log.info("Loading config...");

        Object raw = null;
        try {
            raw = new JSONParser().parse(new FileReader("config.json"));
        } catch (FileNotFoundException e) {
            log.error("FileNotFoundException: config file not found. Please ensure that the config file exsists, is in the same directory as the jar, and is called config.json");
            System.exit(1);
        } catch (IOException | ParseException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            System.exit(1);
        }
        JSONObject config = (JSONObject) raw;
        String token = (String) config.get("token");
        String ownerID = (String) config.get("ownerID");
        String prefix = (String) config.get("prefix");
        if(token.equals("") || ownerID.equals("") || prefix.equals("")) {
            log.error("Incomplete config file. Please ensure that properties token, ownerID, and prefix are present and not empty");
            System.exit(1);
        }

        log.info("Building Command Client...");

        AboutCommand ab = new AboutCommand(
                Color.CYAN, "StarBot, but better! JoeSorensen's official server bot. (v"+p.getProperty("version")+")",
                new String[]{"Stream Tracking", "Join Events"},
                RECOMMENDED_PERMS
        );

        EventWaiter waiter = new EventWaiter();
        CommandClientBuilder cb = new CommandClientBuilder().
            setOwnerId(ownerID).
            setPrefix(prefix).
            setHelpWord("help").
            setLinkedCacheSize(200).
            addCommands(ab
            );

        cb.setStatus(OnlineStatus.ONLINE);

        CommandClient client = cb.build();

        log.info("Attempting login...");

        try
        {
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(token)
                    .setStatus(OnlineStatus.DO_NOT_DISTURB)
                    .setActivity(Activity.playing("loading..."))
                    .addEventListeners(client, waiter, new Listener())
                    .build();
        }
        catch (LoginException ex)
        {
            log.error("Invalid Token");
            System.exit(1);
        }
    }
}
