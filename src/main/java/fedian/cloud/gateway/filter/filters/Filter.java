package fedian.cloud.gateway.filter.filters;

import fedian.cloud.gateway.utils.NameUtils;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static org.springframework.util.StringUtils.tokenizeToStringArray;

/**
 * @author zrl
 * @date 2021-08-07 9:56
 */
@Validated
@Data
public class Filter {
    @NotNull
    private String name;
    private Map<String, String> args = new LinkedHashMap<>();

    public Filter(String text) {
        int eqIdx = text.indexOf('=');
        if (eqIdx <= 0) {
            setName(text);
            return;
        }
        setName(text.substring(0, eqIdx));

        String[] args = tokenizeToStringArray(text.substring(eqIdx+1), ",");

        for (int i=0; i < args.length; i++) {
            this.args.put(NameUtils.generateName(i), args[i]);
        }
    }
}
