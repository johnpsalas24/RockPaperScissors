import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rockButton: Button = findViewById(R.id.rockButton)
        val paperButton: Button = findViewById(R.id.paperButton)
        val scissorsButton: Button = findViewById(R.id.scissorsButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        rockButton.setOnClickListener { playGame("Rock", resultTextView) }
        paperButton.setOnClickListener { playGame("Paper", resultTextView) }
        scissorsButton.setOnClickListener { playGame("Scissors", resultTextView) }
    }

    private fun playGame(userChoice: String, resultTextView: TextView) {
        val choices = arrayOf("Rock", "Paper", "Scissors")
        val computerChoice = choices.random()
        val result = determineWinner(userChoice, computerChoice)
        resultTextView.text = "Computer chose: $computerChoice\n$result"
    }

    private fun determineWinner(userChoice: String, computerChoice: String): String {
        return when {
            userChoice == computerChoice -> "It's a draw!"
            (userChoice == "Rock" && computerChoice == "Scissors") ||
            (userChoice == "Scissors" && computerChoice == "Paper") ||
            (userChoice == "Paper" && computerChoice == "Rock") -> "You win!"
            else -> "Computer wins!"
        }
    }
}
