package run.halo.toolbox.router;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import run.halo.app.plugin.ReactiveSettingFetcher;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
@AllArgsConstructor
public class EssayRouter {
    private final ReactiveSettingFetcher settingFetcher;
    private final String KEY = "essay";
    private final String TITLE = "说说";
    private final String SUBTITLE = "分享美好";

    RouterFunction<ServerResponse> essayRouter() {
        return route(GET("/essay"),
            request -> ServerResponse.ok().render(KEY,
                "title", Mono.fromCallable(() -> this.settingFetcher.get("basic")
                    .map(setting -> setting.get(KEY).asText(TITLE))),
                "subtitle", Mono.fromCallable(() -> this.settingFetcher
                    .get("basic").map(
                        setting -> setting.get("directorySubContent")
                            .asText(SUBTITLE)))
            )
        );
    }
}
