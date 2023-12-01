package run.halo.toolbox;

import org.pf4j.PluginWrapper;
import org.springframework.stereotype.Component;
import run.halo.app.plugin.BasePlugin;
import run.halo.app.plugin.PluginContext;

@Component
public class ToolBoxPlugin extends BasePlugin {

    @Deprecated
    public ToolBoxPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    public ToolBoxPlugin(PluginContext context) {
        super(context);
    }

    @Override
    public void start() {
        System.out.println("plugin-toolbox started success");
    }

    @Override
    public void stop() {
        System.out.println("plugin-toolbox stop");
    }
}
