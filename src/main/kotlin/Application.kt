import actions.copyPasteDirs
import actions.pdfToDir
import colorString

fun main() {
    showGreeting()
    showMenu()
}

fun showGreeting() {
    clearConsole()
    val vNum: Float = 1.0F
    val lastUpdate: String = "Feb 26, 2024"
    println(colorString("Butler CLI (Command Line Interface)", AnsiColor.GREEN))
    println(colorString("Version: $vNum -- Last updated: $lastUpdate", AnsiColor.GREEN))
    println(colorString("Created by Carlos Rodriguez", AnsiColor.GREEN))
}

fun showMenu() {
    println(colorString("\nWhat would you like to do?", AnsiColor.CYAN))
    println("---------------------------------------")
    println("1. Turn PDF files to Directories")
    println("2. Copy/Paste Directories")
    println(colorString("3. Exit", AnsiColor.YELLOW))
    println("---------------------------------------")

    print(colorString("Select an option (type number only): ", AnsiColor.CYAN))
    val userSelection = readlnOrNull()
    validateUserSelection(userSelection)
}

fun validateUserSelection(userSelection: String?) {
    if (userSelection != null) {
        when (userSelection) {
            "1" -> pdfToDir()
            "2" -> copyPasteDirs()
            "3" -> exit()
            else -> println("Invalid selection")
        }
    }
}

fun exit() {
    println("Exiting...")
}

fun clearConsole() {
    when {
        System.getProperty("os.name").contains("Windows") -> Runtime.getRuntime().exec("cls")
        else -> Runtime.getRuntime().exec("clear")
    }
}