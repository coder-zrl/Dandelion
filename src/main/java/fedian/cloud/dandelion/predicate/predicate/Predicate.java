package fedian.cloud.dandelion.predicate.predicate;

import fedian.cloud.dandelion.utils.NameUtils;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.util.StringUtils.tokenizeToStringArray;

/**
 * @author zrl
 * @date 2021-08-07 9:52
 */
@Validated
@Data
public class Predicate {
    @NotNull
    private String name;
    private Map<String, String> args = new LinkedHashMap<>();


    public Predicate(String text) {
        int eqIdx = text.indexOf('=');
        if (eqIdx <= 0) {
            throw new ValidationException("Unable to parse PredicateDefinition text '" + text + "'" +
                    ", must be of the form name=value");
        }
        setName(text.substring(0, eqIdx));

        String[] args = tokenizeToStringArray(text.substring(eqIdx+1), ",");

        for (int i=0; i < args.length; i++) {
            this.args.put(NameUtils.generateName(i), args[i]);
        }
    }

    public void addArg(String key, String value) {
        this.args.put(key, value);
    }
}
