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

    val p1_track = set_up(1)
    val p2_track = set_up(2)
    val corners = mutableListOf<Boolean>()
    for (i in 1..TRACKLENGTH) {
        corners.add(false)
    }
    val corner_tiles = mutableListOf(11,12,13,37,38,39,44,45,46,55,56,57,67,68,69,77,78,79)
    for (i in corner_tiles) {
        corners[i] = true
    }

    var current_turn = 1
    var p1_speed = 0
    var p2_speed = 0
    var p1_boost = 3
    var p2_boost = 3
    var p1_lap = 0
    var p2_lap = 0
    var p1_pos = 0
    var p2_pos = 0
    var win = 0


    println("Generic_Game_Dev presents...")
    println("     -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")
    println("-=-=-=-=-=-=-=-=-=-Kotlin Super Racer!-=-=-=-=-=-=-=-=-=-")
    println("     -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")
    println("")
    print("                Press any key to start: ")
    readln()
    println()
    println("Welcome, to the Kotlin Super Racer world finals!")
    Thread.sleep(500)
    println("Want a rundown of the rules? ")
    while (true) {
        var rouxls = read("Y(es)/N(o)")
        if (rouxls.contains("Y")) {
            println("Alright then,")
            println("")
            break
        }
        if (rouxls.contains("N")) {
            println("Ok then.")
            break
        }
    }

    while (true) {
        repeat(2) {
            var movement = a_b_or_c_or_d(current_turn, p1_speed, p2_speed, p1_boost, p2_boost)
            if (movement.contains("A")) {
                when (current_turn) {
                    1 -> p1_speed += 10
                    2 -> p2_speed += 10
                    else -> p1_speed + 1000000000
                }
            }
            if (movement.contains("B")) {
                when (current_turn) {
                    1 -> p1_speed += 30
                    2 -> p2_speed += 30
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
            when (current_turn) {
                1 -> p1_speed = move_car(current_turn.toString(), p1_speed, p2_speed, p1_track, p2_track, corners)
                2 -> p2_speed = move_car(current_turn.toString(), p1_speed, p2_speed, p1_track, p2_track, corners)
                else -> p1_speed + 1000000000
            }

            when(current_turn) {
                1 -> {
                    if (p1_track.indexOf("1") < p1_pos) {
                        p1_lap++
                    }
                    p1_pos = p1_track.indexOf("1")
                }
                2 -> {
                    if (p2_track.indexOf("2") < p2_pos) {
                        p2_lap++
                    }
                    p2_pos = p2_track.indexOf("2")
                }
            }

            when(current_turn) {
                1 -> current_turn = 2
                2 -> current_turn = 1
            }
        }
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
}

        // Makes a list to act as the track, then fills it with empty slots and adds a race car.
fun set_up(race_no: Int): MutableList<String> {
    val track = mutableListOf<String>()
    for (i in 1..TRACKLENGTH) {
        track.add(EMPTY)
    }
    track[1] = ("$race_no")
    return track
}

fun move_car(racer: String, p1_speed: Int, p2_speed: Int, p1_track: MutableList<String>, p2_track: MutableList<String>, corners: MutableList<Boolean>): Int {
    var speed: Int
    var track: MutableList<String>
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
    if (speed == 0) {
    }
    else {
        var has_moved = 0
        var corners_probably_exist = 0
        speed = (speed/10)
        var start = track.indexOf(racer)
        var end = (track.indexOf(racer) + speed)
        try {
            for (i in (start..end)) {
                if (corners[i] == true) {
                    corners_probably_exist++
                }
            }
        }   catch (e: IndexOutOfBoundsException) {}
        if (corners_probably_exist == 0) {
            try {
                track[start] = (EMPTY)
                track[start + speed] = racer
                has_moved = 1
            } catch (e: IndexOutOfBoundsException) {
                track[start] = racer
            }
        }
        if (has_moved == 0) {
            var crash = 0
            repeat(speed) {
                if (crash == 0) {
                    start = track.indexOf(racer)
                    if (track.indexOf(racer) == 86) {
                        track[track.indexOf(racer)] = (EMPTY)
                        track[0] = racer
                        start = track.indexOf(racer)
                    }
                    if (track.indexOf(racer) < 86) {
                        track[start] = (EMPTY)
                        track[start + 1] = racer
                        if (corners[track.indexOf(racer)] == true) {
                            var RNG = Random.nextInt(1, 100)
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
                            if (speed > 8) {
                                crash++
                            }
                        }
                    }
                }
            }
            if (crash > 0) {
                println("You crashed!")
                println("")
                Thread.sleep(500)
                return (0)
            }
        }
    }
    when (racer) {
        "1" -> return (p1_speed)
        "2" -> return (p2_speed)
        else -> return 0
    }
}

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

fun a_b_or_c_or_d(racer: Int, p1_speed: Int, p2_speed: Int, p1_boost: Int, p2_boost: Int): String {
    var action: String
    var boost: Int
    when (racer) {
        1 -> boost = p1_boost
        2 -> boost = p2_boost
        else -> boost = 0
    }
    println("Player $racer's turn.")
    Thread.sleep(500)
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
        action = read("Input action:")
        if (action.contains("A")) {
            break
        }
        else if (action.contains("B")) {
            if (boost > 0) {
                break
            }
            else {
                println("You're out of boosts!")
                Thread.sleep(500)
                println()
            }
        }
        else if (action.contains("C")) {
            break
        }
        else if (action.contains("D")) {
            break
        }

    }
    return action
}

fun read(question: String): String {
    print("$question ")
    while (true) {
        var answer = readln().uppercase()
        if (answer.isNotBlank()) {
            println()
            return answer
        }
    }
}