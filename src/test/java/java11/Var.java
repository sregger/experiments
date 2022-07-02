package java11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * https://developers.redhat.com/blog/2018/05/25/simplify-local-variable-type-definition-using-the-java-10-var-keyword
 */
public class Var {
    @Test
    public void generics() {
        var arg = new ArrayList<Map<String, Object>>();
        var objects = new ArrayList<>(); // Defaults to Object
        objects.add("Test");
        var strings = new ArrayList<String>();
        strings.add("Test");

        Map<String, List<String>> listofMovies = new HashMap<>();
        var listofMovies2 = new HashMap<String, List<String>>();
    }

    @Test
    public void polymorphic() {
        /**
         * Polymorphic behavior
         */
        var string = new String();
//        string = new Object(); // won't compile

        var object = new Object();
        object = "";

        var string3 = (Object) new String();
        string3 = new Object();
    }

    @Test
    public void lambda() {
//        var invalid = null;

        Function<Boolean, Boolean> function = p -> p;
        function.apply(true);
//        var lambda = p -> p;
        var function2 = (Function<Boolean, Boolean>) p -> p;
        function2.apply(true);
    }
}
