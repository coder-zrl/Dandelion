package fedian.cloud.dandelion.route;

import com.sun.istack.internal.NotNull;
import fedian.cloud.dandelion.filter.filters.Filter;
import fedian.cloud.dandelion.predicate.predicate.Predicate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @author zrl
 * @date 2021-08-07 9:36
 *这是路由类，包含路由的所有配置信息
 */
@Validated
@NoArgsConstructor
@Data
public class Route {
    /**
     * 路由id，默认是uuid
     */
    @NotEmpty
    private String id = UUID.randomUUID().toString();

    /**
     * 断言
     */
    @NotEmpty
    @Valid
    private List<Predicate> predicates = new ArrayList<>();

    /**
     *过滤器
     */
    @Valid
    private List<Filter> filters = new ArrayList<>();

    /**
     * uri
     */
    @NotNull
    private URI uri;

    /**
     * 排序
     */
    private int order = 0;

    /**
     * 是否是通过引入starter依赖添加的配置，用于判断是否要进行心跳检查
     */
    private boolean isStarter = true;



    public Route(String text) {
        /**
         * 初始化id
         */
        //int eqIdx = text.indexOf('=');
        //if (eqIdx <= 0) {
        //    throw new ValidationException("Unable to parse RouteDefinition text '" + text + "'" +
        //            ", must be of the form name=value");
        //}
        //setId(text.substring(0, eqIdx));

        /**
         * 初始化uri
         */
        //String[] args = tokenizeToStringArray(text.substring(eqIdx+1), ",");
        //setUri(URI.create(args[0]));

        /**
         * 添加断言
         */
        //for (int i=1; i < args.length; i++) {
        //    this.predicates.add(new PredicateDefinition(args[i]));
        //}
    }
}
