import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Requirements:
 * =============
 * + System replaces variable placeholders like ${firstname} in template with values provided at runtime
 * + Attempt to send template with undefined variables raises error
 * + System ignores variables that aren’t in the template
 */
public class Template {

    private String text;
    private Map<String, String> variables;

    public Template(String text)
    {
        this.text = text;
        this.variables = new HashMap<>();
    }

    public void set(String var, String value)
    {
        variables.put(var, value);
    }

    public String evaluate()
    {
        replaceVariables();
        checkForMissingValues();
        return text;
    }

    private void checkForMissingValues() {
        Matcher m = Pattern.compile("\\$\\{.+\\}").matcher(text);
        if(m.find()) {
            throw new MissingValueException("no value for " + m.group());
        }
    }

    private void replaceVariables() {
        for(Map.Entry<String,String> entry: variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            text = text.replaceAll(regex, entry.getValue());
        }
    }


}
