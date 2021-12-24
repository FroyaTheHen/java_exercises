import java.util.Scanner;

public class Scrabble {
    enum Letter {
        A(1, 'A'),
        E(1, 'E'),
        I(1, 'I'),
        O(1, 'O'),
        U(1, 'U'),
        L(1,'L'),
        N(1,'N'),
        R(1,'R'),
        S(1,'S'),
        T(1,'T'),
        D(2,'D'),
        G(2,'G'),
        B(3, 'B'),
        C(3, 'C'),
        M(3, 'M'),
        P(3, 'P'),
        F(4, 'F'),
        H(4, 'H'),
        V(4, 'V'),
        W(4, 'W'),
        Y(4, 'Y'),
        K(5, 'K'),
        J(8, 'J'),
        X(8, 'X'),
        Q(10, 'Q'),
        Z(10, 'Z');

        private final int value;
        private final Character letter;

        Letter(int value, Character letter) {
            this.value = value;
            this.letter = letter;
        }

        public static int getScore(Character ch){
            for(Letter one : Letter.values()){
                if(ch == one.letter){
                    return one.value;
                }
            }
            return 0;
        }
    }

        public static void main(String[] args) {
            System.out.println("Let's play!");

            int total_score = 0;
            int word_score = 0;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Type a word to play or 'quit' to exit the game.");
                String word = scanner.nextLine();

                if (word.equals("quit")) break;

                word = word.toUpperCase();

                for (Character letter : word.toCharArray()) {
                    word_score = word_score + Letter.getScore(letter);
                }
                System.out.println("You've scored: " +word_score+", for the word: " +word+ "!");
                total_score = total_score + word_score;
                word_score = 0;
            }
            System.out.println("Total score:" +total_score+", thank you for playing!");
        }
    }

