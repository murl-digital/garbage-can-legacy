package xyz.joesorensen.starbot2.commands.fun;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThesaurusCmd extends Command {

    public ThesaurusCmd() {
        this.name = "thesaurus";
        this.help = "replace every word in arguments with a synonym";
        this.guildOnly = false;
        this.aliases = new String[]{"ths"};
    }

    @Override
    protected void execute(CommandEvent event) {
        String args = event.getArgs();

        if (args.isBlank() || args.isEmpty())
            event.replyError("You must provide a statement!");
        else {
            Thread th = new Thread(() -> {
                String[] statement = args.replaceAll("([^A-Za-z0-9\\s\\-':()])+", "").split(" ");
                List<String> replaced = new ArrayList<>();
                for (String word : statement) {
                    try {
                        URL serverAddress = new URL("http://thesaurus.altervista.org/thesaurus/v1" + "?word=" + URLEncoder.encode(word, StandardCharsets.UTF_8) + "&language=" + "en_US" + "&key=" + "XOWb458ysKHwRsnd4ka0" + "&output=" + "json");
                        HttpURLConnection connection = (HttpURLConnection) serverAddress.openConnection();
                        connection.connect();
                        int rc = connection.getResponseCode();
                        if (rc == 200) {
                            String line = null;
                            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                            StringBuilder sb = new StringBuilder();
                            while ((line = br.readLine()) != null)
                                sb.append(line + '\n');
                            JSONObject obj = (JSONObject) JSONValue.parse(sb.toString());
                            JSONArray array = (JSONArray) obj.get("response");

                            JSONObject list = (JSONObject) ((JSONObject) array.get(new Random().nextInt(array.size()))).get("list");
                            String syn = (String) list.get("synonyms");
                            syn = syn.replaceAll("\\s\\([^)]*\\)", "");
                            String[] arr = syn.split("[|]");
                            replaced.add(arr[new Random().nextInt(arr.length)]);

                        } else {
                            replaced.add(word);
                        }
                        connection.disconnect();
                    } catch (IOException e) {
                        replaced.add(word);
                    }
                }
                StringBuilder builder = new StringBuilder();
                for (String word : replaced) {
                    builder.append(word).append(" ");
                }
                event.reply(builder.toString());
            });
            th.start();
        }
    }
}
