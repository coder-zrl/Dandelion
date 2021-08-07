package fedian.cloud.gateway.predicate.factory;

import fedian.cloud.gateway.utils.NameUtils;

import java.util.function.Consumer;

/**
 * @author zrl
 * @date 2021-08-07 9:58
 */
@FunctionalInterface
public interface RoutePredicateFactory<C> extends ShortcutConfigurable, Configurable<C> {
    String PATTERN_KEY = "pattern";

    // useful for javadsl
    default Predicate<ServerWebExchange> apply(Consumer<C> consumer) {
        C config = newConfig();
        consumer.accept(config);
        beforeApply(config);
        return apply(config);
    }

    default AsyncPredicate<ServerWebExchange> applyAsync(Consumer<C> consumer) {
        C config = newConfig();
        consumer.accept(config);
        beforeApply(config);
        return applyAsync(config);
    }

    default Class<C> getConfigClass() {
        throw new UnsupportedOperationException("getConfigClass() not implemented");
    }

    @Override
    default C newConfig() {
        throw new UnsupportedOperationException("newConfig() not implemented");
    }

    default void beforeApply(C config) {}

    Predicate<ServerWebExchange> apply(C config);

    default AsyncPredicate<ServerWebExchange> applyAsync(C config) {
        return toAsyncPredicate(apply(config));
    }

    default String name() {
        return NameUtils.normalizeRoutePredicateName(getClass());
    }

}
