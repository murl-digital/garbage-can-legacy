package xyz.joesorensen.starbot2.commands.user;

import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import xyz.joesorensen.starbot2.commands.UserCommand;
import xyz.joesorensen.starbot2.models.User;
import xyz.joesorensen.starbot2.models.UserManager;

import java.awt.*;

public class LvlCommand extends UserCommand {

    public LvlCommand() {
        this.name = "lvl";
        this.help = "display user xp and level.";
        this.aliases = new String[]{
                "rank",
                "xp",
                "level"
        };
    }

    @Override
    protected void execute(CommandEvent event) {
        User user = UserManager.getUser(event.getAuthor().getId());
        EmbedBuilder embed = new EmbedBuilder();
        float[] rgb;
        embed.setTitle("User Level");
        embed.setDescription("Level for "+event.getAuthor().getName());
        embed.addField("Level", Integer.toString(user.getLvl()), true);
        embed.addField("XP", Double.toString(user.getXp()), false);
        embed.addField("Progress to next level", "```"+progress(user.getXp()/(user.getLvl()*250))+"```", false);
        rgb = Color.RGBtoHSB(204, 255, 94, null);
        embed.setColor(Color.getHSBColor(rgb[0], rgb[1], rgb[2]));

        event.reply(embed.build());
    }

    private static String progress(double progressPercentage) {
        final int width = 53;
        StringBuilder result = new StringBuilder();

        result.append("[");
        int i = 0;
        for (; i <= (int)(progressPercentage*width); i++) {
            result.append("#");
        }
        for (; i < width; i++) {
            result.append(" ");
        }
        result.append("]");

        return result.toString();
    }
}
