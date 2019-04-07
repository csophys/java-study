package base.regex;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(8)
@Fork(1)
public class TestString {

    private static final String NAME = "asdr你这大发送到股份的股份的sgdflwec/asdrsgdflwecqa我也不知道xz阿萨德阿fawq是吗p230sdasf.daw∂asfs;gamfdm";
    private static Pattern p = Pattern.compile("[^(A-Za-z0-9)]");

    @Benchmark
    public void test1() throws Exception {
        StringBuilder sb = new StringBuilder(32);
        for (int i = 0; i < NAME.length(); i++) {
            final char charAt = NAME.charAt(i);

            if (charAt > 126 || charAt < 32) {
                sb.append(".");
            } else {
                sb.append(charAt);
            }
        }
        //InvalidStringBuilder.getValidString(NAME);
    }

    @Benchmark
    public void test2() throws Exception {
        StringBuffer sb = new StringBuffer(32);
        Matcher m = p.matcher(NAME);
        while (m.find()) {
            m.appendReplacement(sb, ".");
        }

        //InvalidStringBuilder.getValidString(NAME);
        //NAME.replaceAll("[^(A-Za-z0-9)]", ".");
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(TestString.class.getSimpleName()).build();
        new Runner(opt).run();
    }


}