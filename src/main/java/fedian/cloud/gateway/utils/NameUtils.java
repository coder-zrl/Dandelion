package fedian.cloud.gateway.utils;

import fedian.cloud.gateway.predicate.factory.RoutePredicateFactory;

/**
 * @author zrl
 * @date 2021-08-07 9:55
 */
public class NameUtils {
    public static final String GENERATED_NAME_PREFIX = "_genkey_";

    public static String generateName(int i) {
        return GENERATED_NAME_PREFIX + i;
    }

    public static String normalizeRoutePredicateName(Class<? extends RoutePredicateFactory> clazz) {
        return removeGarbage(clazz.getSimpleName().replace(RoutePredicateFactory.class.getSimpleName(), ""));
    }

    public static String normalizeFilterFactoryName(Class<? extends GatewayFilterFactory> clazz) {
        return removeGarbage(clazz.getSimpleName().replace(GatewayFilterFactory.class.getSimpleName(), ""));
    }

    private static String removeGarbage(String s) {
        int garbageIdx = s.indexOf("$Mockito");
        if (garbageIdx > 0) {
            return s.substring(0, garbageIdx);
        }
        return s;
    }
}
