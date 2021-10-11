package terminus.parser;

import terminus.command.BackCommand;
import terminus.command.zoomlink.AddLinkCommand;
import terminus.command.ViewCommand;
import terminus.command.DeleteCommand;
import terminus.common.CommonFormat;
import terminus.common.Messages;
import terminus.content.Link;
import terminus.module.NusModule;

public class LinkCommandParser extends CommandParser {

    public LinkCommandParser() {
        super(CommonFormat.COMMAND_SCHEDULE);
    }

    public static LinkCommandParser getInstance() {
        LinkCommandParser parser = new LinkCommandParser();
        parser.addCommand(CommonFormat.COMMAND_BACK, new BackCommand());
        parser.addCommand(CommonFormat.COMMAND_ADD, new AddLinkCommand());
        parser.addCommand(CommonFormat.COMMAND_VIEW, new ViewCommand(Link.class));
        parser.addCommand(CommonFormat.COMMAND_DELETE, new DeleteCommand(Link.class));
        return parser;
    }

    @Override
    public String getWorkspaceBanner(NusModule module) {
        return String.format(Messages.SCHEDULE_BANNER, module.getContentManager(Link.class).getContents().size());
    }
}
