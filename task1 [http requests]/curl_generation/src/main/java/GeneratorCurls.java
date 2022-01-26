import java.util.Iterator;

public record GeneratorCurls(String base, int beginAmount, int endAmount) implements Iterable<String> {

    @Override
    public Iterator<String> iterator() {
        return new GeneratorCurlsIterator();
    }

    class GeneratorCurlsIterator implements Iterator<String> {
        private int currentAmount;

        public GeneratorCurlsIterator() {
            this.currentAmount = beginAmount;
        }

        @Override
        public boolean hasNext() {
            return currentAmount != endAmount + 1;
        }

        @Override
        public String next() {
            String DATA_FORMAT = "  --data-raw '_af=34be50b38beccce4&proof=%d&amount=%d&submit=Submit' \\\n";
            return base + String.format(DATA_FORMAT, currentAmount * currentAmount, currentAmount++);
        }
    }
}
