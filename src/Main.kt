import java.util.Random
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val random = Random()

    println("🎯 Number Guessing Master-ga xush kelibsiz!")
    println("Dastur 1 dan 100 gacha bo'lgan son o'yladi. Uni topa olasizmi?")

    val targetNumber = random.nextInt(100) + 1
    var attempts = 0
    var hasGuessedCorrectly = false

    while (!hasGuessedCorrectly) {
        print("\n🔢 Taxminingizni kiriting: ")

        val input = scanner.next()
        val guess = input.toIntOrNull()

        if (guess == null) {
            println("⚠️ Iltimos, faqat butun son kiriting!")
            continue
        }

        attempts++

        when {
            guess < 1 || guess > 100 -> println("🚫 Son 1 va 100 oralig'ida bo'lishi kerak!")
            guess < targetNumber -> {
                val difference = targetNumber - guess
                if (difference > 20) println("📉 Juda kichik! (Juda sovuq ❄️)")
                else println("📉 Kichik, lekin yaqin! (Iliq 🔥)")
            }
            guess > targetNumber -> {
                val difference = guess - targetNumber
                if (difference > 20) println("📈 Juda katta! (Juda sovuq ❄️)")
                else println("📈 Katta, lekin yaqin! (Iliq 🔥)")
            }
            else -> {
                hasGuessedCorrectly = true
                println("\n🎉 TABRIKLAYMIZ! Siz g'alaba qozondingiz!")
                println("🔢 Men o'ylagan son: $targetNumber")
                println("🕒 Urinishlar soni: $attempts")

                val rank = when {
                    attempts <= 3 -> "🌟 Afsonaviy (Genius)!"
                    attempts <= 7 -> "🥇 Zo'r natija!"
                    attempts <= 12 -> "🥈 Yaxshi!"
                    else -> "🥉 Nihoyat topdingiz!"
                }
                println("🏆 Sizning darajangiz: $rank")
            }
        }
    }

    println("\nO'yin tugadi. Qatnashganingiz uchun rahmat! 😊")
}