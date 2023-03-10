import java.util.Comparator;

public class Leader {

        private String name;

        private int score;

        public Leader(String name, int score)
        {
            this.name = name;

            this.score = score;
        }
        public  int getScore(){
        return  score;
        }
        public String getName(){return  name;}

    public static Comparator<Leader> scorecomparator = new Comparator<Leader>() {

            public int compare(Leader s1, Leader s2) {

                int score1 = s1.getScore();
                int score2 = s2.getScore();

                return score2 - score1;

            }
        };
    }

