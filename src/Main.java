import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static Set<String> vocabulary = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<String> stringList = new ArrayList<>();
        while (true) {
            input = br.readLine();
            if (input != null && !input.equals("end")){
                stringList.add(input);
            } else {
                break;
            }
        }
        Function<String, List<String>> splitToList = s -> {return Arrays.stream(s.split(" ")).toList();};
        Set<String>  set = makeVocabulary(stringList, splitToList);
        vocabulary.addAll(set);
        vocabulary.forEach(System.out::println);
    }

    public static Set<String> makeVocabulary(List<String> stringList, Function<String, List<String>> splitToList){
        return stringList.stream()
                .map(splitToList::apply)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
