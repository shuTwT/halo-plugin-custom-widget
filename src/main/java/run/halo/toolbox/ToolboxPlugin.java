package run.halo.toolbox;

import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import run.halo.app.extension.Scheme;
import run.halo.app.extension.SchemeManager;
import run.halo.app.plugin.BasePlugin;
import run.halo.app.plugin.PluginContext;

@Component
public class ToolboxPlugin extends BasePlugin {

    private final SchemeManager schemeManager;

    @Deprecated
    public ToolboxPlugin(PluginWrapper wrapper,SchemeManager schemeManager) {
        super(wrapper);
        this.schemeManager=schemeManager;
    }

    public ToolboxPlugin(PluginContext context, SchemeManager schemeManager) {
        super(context);
        this.schemeManager = schemeManager;
    }

    @Override
    public void start() {
        schemeManager.register(Toolbox.class);
    }

    @Override
    public void stop() {
        Scheme toolboxScheme=schemeManager.get(Toolbox.class);
        schemeManager.unregister(toolboxScheme);
    }
}
