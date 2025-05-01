import kotlin.random.Random
/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Generic_Racing_Game
 * Project Author: Oliver
 * GitHub Repo:    https://github.com/Waimea-OBrownrigg/level-2-programming-assessment
 * ---------------------------------------------------------------------
 * Notes:
 * This is a generic racing game, viewed from a top-down perspective,
 * control your speed around the corners to ensure you don't crash,
 * and make sure you finish ahead of your opponent!
 * =====================================================================
 */

const val TRACKLENGTH = 87
const val EMPTY = " "

fun main() {

    // This code is setting up stuff.
    val p1_track = set_up(1)
    val p2_track = set_up(2)
    val corners = mutableListOf<Boolean>()
    for (i in 1..TRACKLENGTH) {
        corners.add(false)
    }
    // This tells the code where the corners on the racetrack are located.
    val corner_tiles = mutableListOf(11,12,13,37,38,39,44,45,46,55,56,57,67,68,69,77,78,79)
    for (i in corner_tiles) {
        corners[i] = true
    }

    // A bunch of variables I use throughout the code.
    var current_turn = 1
    var p1_speed = 0
    var p2_speed = 0
    var p1_boost = 3
    var p2_boost = 3
    var p1_lap = 0
    var p2_lap = 0
    var p1_pos = 0
    var p2_pos = 0
    var inv_frame = false
    var win = 0

    // An intro the game.
    println("Generic_Game_Dev presents...")
    println("     -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")
    println("-=-=-=-=-=-=-=-=-=-Kotlin Super Racer!-=-=-=-=-=-=-=-=-=-")
    println("     -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")
    println("")
    print("                Press ENTER to start: ")
    readln()
    println()
    println("Welcome, to the Kotlin Super Racer world finals!")
    Thread.sleep(500)
    // Getting player names.
    val p1_name = read("Our first racer is... (Input player 1 name.)", 0)
    Thread.sleep(500)
    val p2_name = read("And they will be up against... (Input player 2 name.)", 0)
    Thread.sleep(500)
    // Asking the player if they want to hear the rules.
    println()
    println("Want a rundown of the rules? ")
    while (true) {
        val rouxls = read("Y(es)/N(o)", 1)
        if (rouxls.contains("Y")) {
            println("Alright then,")
            Thread.sleep(1000)
            println("When you start the race, you will have 4 options.")
            Thread.sleep(1000)
            println("First, accelerate, this makes you go faster.")
            Thread.sleep(1000)
            println("Then, there's boost, it makes you accelerate much faster than usual!")
            Thread.sleep(1000)
            println("Third is coast, you keep on driving at the same speed.")
            Thread.sleep(1000)
            println("And finally, you have decelerate, this slows you down.")
            Thread.sleep(1000)
            println("You can accelerate on straights, but if you go too fast around a corner, you'll lose all your speed.")
            Thread.sleep(1000)
            println("And that's all there is to it!")
            Thread.sleep(1000)
            break
        }
        else if (rouxls.contains("N")) {
            println("Ok then.")
            Thread.sleep(500)
            break
        }
        else {
            println("Please input a valid letter.")
        }
    }

    println()
    println("Well, let's get started!")
    println()
    Thread.sleep(1000)

    draw_track(p1_track, p2_track)

    // The main game loop, only breaks once a player has won.
    while (true) {
        // Each "round" consists of two turns, one for each player, hence the "repeat twice".
        repeat(2) {
            // Asking the player what they will do.
            var movement = a_b_or_c_or_d(current_turn, p1_speed, p2_speed, p1_boost, p2_boost, p1_name, p2_name)
            // These then change the players speed depending on what they chose.
            if (movement.contains("A")) {
                when (current_turn) {
                    1 -> p1_speed += 10
                    2 -> p2_speed += 10
                    else -> p1_speed + 1000000000
                }
            }
            if (movement.contains("B")) {
                // This variable makes sure the player doesn't immediately crash after boosting.
                inv_frame = true
                when (current_turn) {
                    1 -> p1_speed += 50
                    2 -> p2_speed += 50
                    else -> p1_speed + 1000000000
                }
                when (current_turn) {
                    1 -> p1_boost--
                    2 -> p2_boost--
                    else -> p1_boost = 0
                }
            }
            if (movement.contains("D")){
                when (current_turn) {
                    1 -> {
                        p1_speed -= 10
                        if (p1_speed < 0) {
                            p1_speed = 0
                        }
                    }
                    2 -> {
                        p2_speed -= 10
                        if (p2_speed < 0) {
                            p2_speed = 0
                        }
                    }
                    else -> p1_speed - 1000000000
                }
            }

            // This moves the players to their new positions on the track.
            when (current_turn) {
                1 -> p1_speed = move_car(current_turn.toString(), p1_speed, p2_speed, p1_track, p2_track, corners, inv_frame)
                2 -> p2_speed = move_car(current_turn.toString(), p1_speed, p2_speed, p1_track, p2_track, corners, inv_frame)
                else -> p1_speed + 1000000000
            }

            // Sets the anti-crash back to false for the next player.
            inv_frame = false

            // Checks to see if either of the players have completed a lap.
            when(current_turn) {
                1 -> {
                    if (p1_track.indexOf("1") < p1_pos) {
                        p1_lap++
                        println("Completed lap $p1_lap/3")
                        Thread.sleep(500)
                    }
                    p1_pos = p1_track.indexOf("1")
                }
                2 -> {
                    if (p2_track.indexOf("2") < p2_pos) {
                        p2_lap++
                        println("Completed lap $p2_lap/3")
                        Thread.sleep(500)
                    }
                    p2_pos = p2_track.indexOf("2")
                }
            }

            // Changes the turn, allowing the next player to go.
            when(current_turn) {
                1 -> current_turn = 2
                2 -> current_turn = 1
            }
        }
        // Shows the players the current state of the game and checks to see if anyone has won.
        println()
        Thread.sleep(500)
        draw_track(p1_track, p2_track)
        if (p1_lap == 3) {
            win = 1
            break
        }
        if (p2_lap == 3) {
            win = 2
            break
        }
    }

    // A small congratulatory message for the winner.
    when (win) {
        1  -> println("$p1_name wins!")
        2  -> println("$p2_name wins!")
    }
    Thread.sleep(1000)
    println("Congratulations! You are the new world champion!")
}

/**
 * Makes a list to act as the track.
 * Fills it with empty slots and adds a race car at the start.
  */
fun set_up(race_no: Int): MutableList<String> {
    val track = mutableListOf<String>()
    for (i in 1..TRACKLENGTH) {
        track.add(EMPTY)
    }
    track[1] = ("$race_no")
    return track
}

/**
 * Moves the cars to their new locations on the track.
 * Checks if the car has crashed.
 */
fun move_car(racer: String, p1_speed: Int, p2_speed: Int, p1_track: MutableList<String>, p2_track: MutableList<String>, corners: MutableList<Boolean>, inv_frame: Boolean): Int {
    var speed: Int
    var track: MutableList<String>
    // These "when"s take the relevant speed/track and turn it into a single variable we can use for the rest of the function.
    when (racer) {
        "1" -> speed = p1_speed
        "2" -> speed = p2_speed
        else -> speed = 0
    }
    when (racer) {
        "1" -> track = p1_track
        "2" -> track = p2_track
        else -> track = p1_track
    }
    // Checks to see if the car is actually moving.
    if (speed == 0) {
    }
    else {
        var has_moved = 0
        var corners_probably_exist = 0
        // Turns the speed into a smaller number so we can apply it to the list.
        speed = (speed/10)
        // Where the car is at the start of the turn.
        var start = track.indexOf(racer)
        // Where the car should end up.
        var end = (track.indexOf(racer) + speed)
        // Checks to see if there are corners along the cars path.
        try {
            for (i in (start..end)) {
                if (corners[i] == true) {
                    corners_probably_exist++
                }
            }
        }   catch (e: IndexOutOfBoundsException) {}
        // If there are no corners the car should be able to use the easy way to move forward.
        if (corners_probably_exist == 0) {
            try {
                track[start] = (EMPTY)
                track[start + speed] = racer
                has_moved = 1
            } catch (e: IndexOutOfBoundsException) {
                // But if it's about to complete a lap it may also need to use the complex way.
                track[start] = racer
            }
        }
        // So if it cant go the normal way...
        if (has_moved == 0) {
            var crash = 0
            // It moves forward slot by slot.
            repeat(speed) {
                if (crash == 0) {
                    start = track.indexOf(racer)
                    // If the car is on the last slot of track, it is sent back to the beginning, a "lap".
                    if (track.indexOf(racer) == 86) {
                        track[track.indexOf(racer)] = (EMPTY)
                        track[0] = racer
                        start = track.indexOf(racer)
                    }
                    if (track.indexOf(racer) < 86) {
                        track[start] = (EMPTY)
                        track[start + 1] = racer
                        // If the car isn't using a boost, and therefore isn't immune to crashing...
                        if (inv_frame == false) {
                            // This code randomly decides whether to crash it or spare it.
                            if (corners[track.indexOf(racer)] == true) {
                                var RNG = Random.nextInt(1, 100)
                                // Depending on your speed, you will have a higher or lower chance of survival.
                                if (speed == 4) {
                                    if (RNG == 1) {
                                        crash++
                                    }
                                }
                                if (speed == 5) {
                                    if (RNG <= 3) {
                                        crash++
                                    }
                                }
                                if (speed == 6) {
                                    if (RNG <= 6) {
                                        crash++
                                    }
                                }
                                if (speed == 7) {
                                    if (RNG <= 12) {
                                        crash++
                                    }
                                }
                                if (speed == 8) {
                                    if (RNG <= 20) {
                                        crash++
                                    }
                                }
                                // If you're going 90 or above you crash.
                                if (speed > 8) {
                                    crash++
                                }
                            }
                        }
                    }
                }
            }
            // If you crashed, you will be told so here.
            if (crash > 0) {
                println("")
                println("You crashed!")
                Thread.sleep(500)
                return (0)
            }
        }
    }
    // Returns the players speed as 0 if they crashed or whatever it was originally.
    when (racer) {
        "1" -> return (p1_speed)
        "2" -> return (p2_speed)
        else -> return 0
    }
}

/**
 * A function to ask the player what they want to do.
 */
fun a_b_or_c_or_d(racer: Int, p1_speed: Int, p2_speed: Int, p1_boost: Int, p2_boost: Int, p1_name: String, p2_name: String): String {
    var action: String
    var boost: Int
    var name: String
    when (racer) {
        1 -> boost = p1_boost
        2 -> boost = p2_boost
        else -> boost = 0
    }
    when (racer) {
        1 -> name = p1_name
        2 -> name = p2_name
        else -> name = "Darker, darker, yet darker"
    }
    println("")
    println("It is $name's turn.")
    Thread.sleep(500)
    // Informs the player of some useful statistics.
    when (racer) {
        1 -> {
            println("Your current speed is $p1_speed KMpH!")
        }
        2 -> {
            println("Your current speed is $p2_speed KMpH!")
        }
    }
    Thread.sleep(500)
    println("You have $boost boosts left!")
    Thread.sleep(500)
    println("")
    println("A = Accelerate")
    println("B = Boost")
    println("C = Coast")
    println("D = Decelerate")
    while (true) {
        // The part where it asks you.
        action = read("Input action:", 1)
        // Checks if the input is a valid option.
        if (action.contains("A")) {
            break
        }
        else if (action.contains("B")) {
            // Checks to see if you actually have any boosts left.
            if (boost > 0) {
                break
            }
            else {
                println("You're out of boosts!")
                Thread.sleep(500)
            }
        }
        else if (action.contains("C")) {
            break
        }
        else if (action.contains("D")) {
            break
        }
        else {
            println("Please input a valid letter.")
        }

    }
    return action
}

/**
 * A function to get me player inputs.
 */
fun read(question: String, type_question: Int): String {
    var answer: String
    while (true) {
        println()
        print("$question ")
        // There are two types of question, 1, for single-letter answers, and 0, for whole words.
        if (type_question == 1) {
            // Makes the answer always uppercase for the checks it will need to go through.
            answer = readln().uppercase()
            // Makes sure the answer is only one letter.
            if (answer.length == 1) {
                if (answer.isNotBlank()) {
                    return answer
                }
            }
            else {
                if (answer.isNotBlank()) {
                    println("Your input must be one letter.")
                }
                else {
                    println("Your input must not be blank.")
                }
            }
        }
        if (type_question == 0) {
            answer = readln()
            if (answer.isNotBlank()) {
                return answer
            }
            else {
                println("Your input must not be blank.")
            }
        }
    }
}

/**
 *  A function that prints an overhead visualization of the racetrack.
 */
fun draw_track(p1_track: MutableList<String>, p2_track: MutableList<String>) {
    println("                — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — —")
    println("              /  ${p1_track[79]}    ${p1_track[80]}   ${p1_track[81]}   ${p1_track[82]}   ${p1_track[83]}   ${p1_track[84]}   ${p1_track[85]}   ${p1_track[86]} | ${p1_track[1]}   ${p1_track[2]}   ${p1_track[3]}   ${p1_track[4]}   ${p1_track[5]}   ${p1_track[6]}   ${p1_track[7]}   ${p1_track[8]}   ${p1_track[9]}   ${p1_track[10]}     ${p1_track[11]}  \\")
    println("            /         ${p2_track[80]}   ${p2_track[81]}   ${p2_track[82]}   ${p2_track[83]}   ${p2_track[84]}   ${p2_track[85]}   ${p2_track[86]} | ${p2_track[1]}   ${p2_track[2]}   ${p2_track[3]}   ${p2_track[4]}   ${p2_track[5]}   ${p2_track[6]}   ${p2_track[7]}   ${p2_track[8]}   ${p2_track[9]}   ${p2_track[10]}          \\")
    println("          /  ${p1_track[78]}    ${p2_track[79]} — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — —  ${p2_track[11]}    ${p1_track[12]}  \\")
    println("        /      ${p2_track[78]}  /                                                                        \\  ${p2_track[12]}      \\")
    println("      /  ${p1_track[77]}   ${p2_track[77]}  /                                                                            \\  ${p2_track[13]}   ${p1_track[13]}  \\")
    println("     |  ${p1_track[76]}   ${p2_track[76]}  |                                                                              |  ${p2_track[14]}   ${p1_track[14]}  |")
    println("     |  ${p1_track[75]}   ${p2_track[75]}  |                                                                              |  ${p2_track[15]}   ${p1_track[15]}  |")
    println("     |  ${p1_track[74]}   ${p2_track[74]}  |                                                                              |  ${p2_track[16]}   ${p1_track[16]}  |")
    println("     |  ${p1_track[73]}   ${p2_track[73]}  |                                                                              |  ${p2_track[17]}   ${p1_track[17]}  |")
    println("     |  ${p1_track[72]}   ${p2_track[72]}  |                                                                              |  ${p2_track[18]}   ${p1_track[18]}  |")
    println("     |  ${p1_track[71]}   ${p2_track[71]}  |                                                                              |  ${p2_track[19]}   ${p1_track[19]}  |")
    println("     |  ${p1_track[70]}   ${p2_track[70]}  |                                                                              |  ${p2_track[20]}   ${p1_track[20]}  |")
    println("      \\  ${p1_track[69]}   ${p2_track[69]}  \\                                                                             |  ${p2_track[21]}   ${p1_track[21]}  |")
    println("        \\      ${p2_track[68]}  \\                                                                           |  ${p2_track[22]}   ${p1_track[22]}  |")
    println("          \\  ${p1_track[68]}    ${p2_track[67]} — — — — — — — — — — — — — — — — — — — —                                   |  ${p2_track[23]}   ${p1_track[23]}  |")
    println("            \\         ${p2_track[66]}   ${p2_track[65]}   ${p2_track[64]}   ${p2_track[63]}   ${p2_track[62]}   ${p2_track[61]}   ${p2_track[60]}   ${p2_track[59]}   ${p2_track[58]}   ${p2_track[57]}  \\                                |  ${p2_track[24]}   ${p1_track[24]}  |")
    println("              \\  ${p1_track[67]}    ${p1_track[66]}   ${p1_track[65]}   ${p1_track[64]}   ${p1_track[63]}   ${p1_track[62]}   ${p1_track[61]}   ${p1_track[60]}   ${p1_track[59]}   ${p1_track[58]}        \\                              |  ${p2_track[25]}   ${p1_track[25]}  |")
    println("                — — — — — — — — — — — — — — — — — — — —  ${p1_track[57]}    ${p2_track[56]}  \\                            |  ${p2_track[26]}   ${p1_track[26]}  |")
    println("                                                         \\  ${p1_track[56]}      \\                          |  ${p2_track[27]}   ${p1_track[27]}  |")
    println("                                                           \\  ${p1_track[55]}   ${p2_track[55]}  \\                        |  ${p2_track[28]}   ${p1_track[28]}  |")
    println("                                                            |  ${p1_track[54]}   ${p2_track[54]}  |                       |  ${p2_track[29]}   ${p1_track[29]}  |")
    println("                                                            |  ${p1_track[53]}   ${p2_track[53]}  |                       |  ${p2_track[30]}   ${p1_track[30]}  |")
    println("                                                            |  ${p1_track[52]}   ${p2_track[52]}  |                       |  ${p2_track[31]}   ${p1_track[31]}  |")
    println("                                                            |  ${p1_track[51]}   ${p2_track[51]}  |                       |  ${p2_track[32]}   ${p1_track[32]}  |")
    println("                                                            |  ${p1_track[50]}   ${p2_track[50]}  |                       |  ${p2_track[33]}   ${p1_track[33]}  |")
    println("                                                            |  ${p1_track[49]}   ${p2_track[49]}  |                       |  ${p2_track[34]}   ${p1_track[34]}  |")
    println("                                                            |  ${p1_track[48]}   ${p2_track[48]}  |                       |  ${p2_track[35]}   ${p1_track[35]}  |")
    println("                                                            |  ${p1_track[47]}   ${p2_track[47]}  |                       |  ${p2_track[36]}   ${p1_track[36]}  |")
    println("                                                             \\  ${p1_track[46]}   ${p2_track[46]}  \\                     /  ${p2_track[37]}   ${p1_track[37]}  /")
    println("                                                               \\      ${p2_track[45]}  \\                 /  ${p2_track[38]}      /")
    println("                                                                 \\  ${p1_track[45]}    ${p2_track[44]} — — — — — — — — ${p2_track[39]}    ${p1_track[38]}  /")
    println("                                                                   \\        ${p2_track[43]}   ${p2_track[42]}   ${p2_track[41]}   ${p2_track[40]}        /")
    println("                                                                     \\ ${p1_track[44]}    ${p1_track[43]}   ${p1_track[42]}   ${p1_track[41]}   ${p1_track[40]}    ${p1_track[39]} /")
    println("                                                                        — — — — — — — — — — —")
    Thread.sleep(1500)
    println("")

}