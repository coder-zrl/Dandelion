package fedian.cloud.dandelion.predicate.factory;




import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @author zrl
 * @date 2021-08-07 9:30
 */

public class AfterRoutePredicateFactory extends AbstractRoutePredicateFactory<AfterRoutePredicateFactory.Config> {

    public static final String DATETIME_KEY = "datetime";

    public AfterRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(DATETIME_KEY);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        ZonedDateTime datetime = config.getDatetime();
        return exchange -> {
            final ZonedDateTime now = ZonedDateTime.now();
            return now.isAfter(datetime);
        };
    }

    @Data
    public static class Config {
        @NotNull
        private ZonedDateTime datetime;
    }
}
