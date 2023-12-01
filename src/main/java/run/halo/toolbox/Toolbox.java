package run.halo.toolbox;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import run.halo.app.extension.AbstractExtension;
import run.halo.app.extension.GVK;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Data
@EqualsAndHashCode(callSuper = true)
@GVK(group = "toolbox.plugin.halo.run", version = "v1alpha1", kind = "toolbox", plural = "toolbox"
    , singular = "toolbox")
public class Toolbox extends AbstractExtension {

    @Schema(requiredMode = REQUIRED)
    private  ToolboxSpec spec;

    @Data
    public static class ToolboxSpec{
        @Schema(requiredMode = REQUIRED,minLength=1)
        private String title;
    }
}
