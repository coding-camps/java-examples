package lang.string;

import java.util.Optional;

public class StringComparer {

    public static void main(String[] args) {
        Optional<Diff> diff = StringComparer.compare2strs("abc", "adc");
        if(diff.isPresent()) {
            System.out.println(diff.get());
        }
    }

    public static Optional<Diff> compare2strs(String s1, String s2) {

        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                Diff diff = new Diff(
                        new Line(1, i, s1.substring(i)),
                        new Line(2, i, s2.substring(i)));
                return Optional.of(diff);
            }
        }

        if (s1.length() > s2.length()) {

            Diff diff = new Diff(
                    new Line(1, s2.length(), s1.substring(s2.length())),
                    new Line(2, s2.length(), "")
            );
            return Optional.of(diff);

        } else if (s1.length() < s2.length()) {

            Diff diff = new Diff(
                    new Line(1, s2.length(), ""),
                    new Line(2, s2.length(), s2.substring(s1.length()))
            );
            return Optional.of(diff);

        }

        return Optional.empty();
    }

    public static class Diff {

        public Line line1;
        public Line line2;

        public Diff(Line line1, Line line2) {
            this.line1 = line1;
            this.line2 = line2;
        }

        @Override
        public String toString() {
            return String.format("%s%n%s%n", line1, line2);
        }

    }

    static class Line {

        int strIndex;
        int diffIndex;
        String diffStr;

        Line(int strIndex, int diffIndex, String diffStr) {
            this.strIndex = strIndex;
            this.diffIndex = diffIndex;
            this.diffStr = diffStr;
        }

        @Override
        public String toString() {
            return String.format("%d @ [%d] -> [%s]", strIndex, diffIndex, diffStr);
        }

    }

}
