public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rockButton = findViewById(R.id.rockButton);
        Button paperButton = findViewById(R.id.paperButton);
        Button scissorsButton = findViewById(R.id.scissorsButton);
        TextView resultTextView = findViewById(R.id.resultTextView);

        rockButton.setOnClickListener(view -> playGame("Rock", resultTextView));
        paperButton.setOnClickListener(view -> playGame("Paper", resultTextView));
        scissorsButton.setOnClickListener(view -> playGame("Scissors", resultTextView));
    }

    private void playGame(String userChoice, TextView resultTextView) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int computerChoice = random.nextInt(3);
        String computerDecision = choices[computerChoice];

        String result = determineWinner(userChoice, computerDecision);
        resultTextView.setText("Computer chose: " + computerDecision + "\n" + result);
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a draw!";
        } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                   (userChoice.equals("Scissors") && computerChoice.equals("Paper")) ||
                   (userChoice.equals("Paper") && computerChoice.equals("Rock"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}
