import java.util.regex.*;
class Solution{
static String toCamelCase(String s){
    Pattern p = Pattern.compile( "[_-](\\w)" );
    Matcher m = p.matcher( s );
    StringBuffer ss = new StringBuffer();
    while (m.find()) {
        m.appendReplacement(ss, m.group(1).toUpperCase());
    }
    m.appendTail(ss);
    return ss.toString();
    }
}
