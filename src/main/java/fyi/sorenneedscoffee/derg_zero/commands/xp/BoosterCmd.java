package fyi.sorenneedscoffee.derg_zero.commands.xp;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import fyi.sorenneedscoffee.derg_zero.DergZero;
import fyi.sorenneedscoffee.derg_zero.boosters.BoosterResult;
import fyi.sorenneedscoffee.derg_zero.boosters.data.DataContext;
import fyi.sorenneedscoffee.derg_zero.boosters.data.models.Booster;
import fyi.sorenneedscoffee.derg_zero.boosters.data.models.UserBooster;
import fyi.sorenneedscoffee.derg_zero.commands.AdminCommand;
import fyi.sorenneedscoffee.derg_zero.commands.XpCommand;
import fyi.sorenneedscoffee.derg_zero.moderation.util.ModUtil;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.utils.MarkdownUtil;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

public class BoosterCmd extends XpCommand {
    protected static DataContext context;

    public BoosterCmd() {
        this.name = "booster";
        this.aliases = new String[]{"boosters"};
        this.children = new Command[] {
                new AddBoosterCmd(),
                new ViewBoostersCmd(),
                new GiveBoosterCmd(),
                new UseBoosterCmd()
        };
    }

    public static void setContext(DataContext context) {
        BoosterCmd.context = context;
    }

    @Override
    protected void execute(CommandEvent event) {
        List<UserBooster> boosters = context.getUserBoosters(event.getAuthor().getId());
        boosters.sort(Comparator.comparingDouble(a -> a.multiplier));
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < boosters.size(); i++) {
            stringBuilder.append(i + 1)
                    .append(" - ")
                    .append(boosters.get(i).toString())
                    .append("\n");
        }

        event.reply(MarkdownUtil.codeblock(stringBuilder.toString()));
    }

    private static class AddBoosterCmd extends AdminCommand {

        protected AddBoosterCmd() {
            this.name = "add";
        }

        @Override
        protected void execute(CommandEvent event) {
            String[] args = event.getArgs().split(" ");

            double multiplier = Double.parseDouble(args[0]);
            long duration = Long.parseLong(args[1]);
            ChronoUnit unit = ChronoUnit.valueOf(args[2]);

            BoosterResult result = DergZero.manager.add(multiplier, duration, unit, true);

            if (result == BoosterResult.ADDED) {
                event.replySuccess("The given booster is now active");
            } else if (result == BoosterResult.QUEUED) {
                event.replySuccess("The given booster has been added to the queue");
            }
        }
    }

    private static class ViewBoostersCmd extends AdminCommand {

        protected ViewBoostersCmd() {
            this.name = "view";
        }

        @Override
        protected void execute(CommandEvent event) {
            User target = ModUtil.getTarget(event.getArgs());

            List<UserBooster> boosters = context.getUserBoosters(target.getId());
            boosters.sort(Comparator.comparingDouble(a -> a.multiplier));
            StringBuilder stringBuilder = new StringBuilder();

            for(int i = 0; i < boosters.size(); i++) {
                stringBuilder.append(i + 1)
                        .append(" - ")
                        .append(boosters.get(i).toString())
                        .append("\n\n");
            }

            event.reply(MarkdownUtil.codeblock(stringBuilder.toString()));
        }
    }

    private static class GiveBoosterCmd extends AdminCommand {

        protected GiveBoosterCmd() {
            this.name = "give";
        }

        @Override
        protected void execute(CommandEvent event) {
            String[] args = event.getArgs().split(" ");

            User target = ModUtil.getTarget(args[0]);
            double multiplier = Double.parseDouble(args[1]);
            long duration = Long.parseLong(args[2]);
            ChronoUnit unit = ChronoUnit.valueOf(args[3]);

            context.saveUserBooster(new UserBooster(context.getNewUId(), target.getId(), multiplier, duration, unit));
        }
    }

    private static class UseBoosterCmd extends AdminCommand {

        protected UseBoosterCmd() {
            this.name = "use";
        }

        @Override
        protected void execute(CommandEvent event) {
            int index = Integer.parseInt(event.getArgs()) - 1;

            List<UserBooster> boosters = context.getUserBoosters(event.getAuthor().getId());
            boosters.sort(Comparator.comparingDouble(a -> a.multiplier));

            UserBooster selection = boosters.get(index);

            BoosterResult result = DergZero.manager.add(selection.multiplier, selection.duration, selection.unit, true);

            if(result == BoosterResult.ADDED) {
                event.replySuccess("Your " + selection.multiplier + "x booster is now active!");
                context.removeUserBooster(selection.id);
            } else if (result == BoosterResult.QUEUED) {
                event.replySuccess("Your " + selection.multiplier + "x booster has been queued.");
                context.removeUserBooster(selection.id);
            } else {
                event.replyError("There are no slots available and the queue is full.");
            }
        }
    }
}
