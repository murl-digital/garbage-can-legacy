package xyz.joesorensen.xputil.commands.xp;

import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import xyz.joesorensen.xputil.User;
import xyz.joesorensen.xputil.UserManager;
import xyz.joesorensen.xputil.commands.XpCommand;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

/**
 * -=XPUtil=-
 *
 * @author Soren Dangaard (joseph.md.sorensen@gmail.com)
 */
public class LvlCmd extends XpCommand {

    public LvlCmd() {
        this.name = "lvl";
        this.help = "display user xp and level.";
        this.aliases = new String[]{
                "rank",
                "xp",
                "level"
        };
    }

    private static String progress(double progressPercentage) {
        final int width = 15;
        StringBuilder result = new StringBuilder();

        result.append("[");
        int i = 0;
        for (; i <= (int) (progressPercentage * width); i++) {
            result.append("#");
        }
        for (; i < width; i++) {
            result.append(" ");
        }
        result.append("]");

        return result.toString();
    }

    @Override
    protected void execute(CommandEvent event) {
        MessageEmbed msg;
        if (event.getArgs().equals("")) {
            msg = genEmbed(event.getMember());
        } else {
            msg = genEmbed(event.getMessage().getMentionedMembers().get(0));
        }
        event.reply(msg);
    }

    private MessageEmbed genEmbed(Member member) {
        List<User> users = UserManager.getUsers();
        users.sort(Collections.reverseOrder());
        User user = UserManager.getUser(member.getUser().getId());
        int placement = users.indexOf(user) + 1;
        EmbedBuilder embed = new EmbedBuilder();
        float[] rgb;
        if (member.getNickname() != null) {
            embed.setAuthor(member.getNickname(), null, member.getUser().getAvatarUrl());
        } else {
            embed.setAuthor(member.getUser().getName(), null, member.getUser().getAvatarUrl());
        }
        embed.setTitle("User Rank");
        embed.addField("Level", Integer.toString(user.getLvl()), true);
        embed.addField("XP", new DecimalFormat("#.##").format(user.getXp()) + " | Placement: " + placement, false);
        embed.addField("",
                "```java\n" +
                        progress((user.getXp() - ((user.getLvl() * 250) - 250)) / 250) +
                        " (" + new DecimalFormat("#.##").format(user.getXp() - (user.getLvl() * 250)) + "/" + (user.getLvl() * 250) + ")" +
                        "\n```",
                false);
        rgb = Color.RGBtoHSB(204, 255, 94, null);
        embed.setColor(Color.getHSBColor(rgb[0], rgb[1], rgb[2]));

        return embed.build();
    }
}
