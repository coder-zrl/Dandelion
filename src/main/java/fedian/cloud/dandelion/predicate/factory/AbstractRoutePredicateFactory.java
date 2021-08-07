package fedian.cloud.dandelion.predicate.factory;

/**
 * @author zrl
 * @date 2021-08-07 9:31
 * 是所有工厂的父类，用户如果想自定义一个断言需要继承这个类
 */
public abstract class AbstractRoutePredicateFactory<C> extends AbstractConfigurable<C>
        implements RoutePredicateFactory<C> {

    public AbstractRoutePredicateFactory(Class<C> configClass) {
        super(configClass);
    }

}
