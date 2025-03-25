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
//                — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — —
//              /  3    3   3   3   3   3   3   3   3   3   3   3   3    3   3   3  3   3     3  \
//            /         3   3   3   3   3   3   3   3   3   3   3   3   3   3   3   3   3          \
//          /  3    3 — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — —  3    3  \
//        /      3  /                                                                        \  3      \
//      /  3   3  /                                                                            \  3   3  \
//     |  3   3  |                                                                              |  3   3  |
//     |  3   3  |                                                                              |  3   3  |
//     |  3   3  |                                                                              |  3   3  |
//     |  3   3  |                                                                              |  3   3  |
//     |  3   3  |                                                                              |  3   3  |
//     |  3   3  |                                                                              |  3   3  |
//     |  3   3  |                                                                              |  3   3  |
//      \  3   3  \                                                                             |  3   3  |
//        \      3  \                                                                           |  3   3  |
//          \  3    3 — — — — — — — — — — — — — — — — — — — —                                   |  3   3  |
//            \         3   3   3   3   3   3   3   3   3   3  \                                |  3   3  |
//              \  3    3   3   3   3   3   3   3   3   3        \                              |  3   3  |
//                — — — — — — — — — — — — — — — — — — — —  3    3  \                            |  3   3  |
//                                                         \  3      \                          |  3   3  |
//                                                           \  3   3  \                        |  3   3  |
//                                                            |  3   3  |                       |  3   3  |
//                                                            |  3   3  |                       |  3   3  |
//                                                            |  3   3  |                       |  3   3  |
//                                                            |  3   3  |                       |  3   3  |
//                                                            |  3   3  |                       |  3   3  |
//                                                            |  3   3  |                       |  3   3  |
//                                                            |  3   3  |                       |  3   3  |
//                                                            |  3   3  |                       |  3   3  |
//                                                             \  3   3  \                     /  3   3  /
//                                                               \      3  \                 /  3      /
//                                                                 \  3    3 — — — — — — — — 3    3  /
//                                                                   \        3   3   3   3        /
//                                                                     \ 3    3   3   3   3    3 /
//                                                                        — — — — — — — — — — —
//
//
//
//
//                            There are 87 places your car could be at any given moment.
//
//
//
//
//

const val TRACKLENGTH = 87      // The total number of cages
const val EMPTY = " "     // Represents an empty cage

fun main() {

    val p1_track = set_up(1)
    val p2_track = set_up(2)

    var p1_speed = 0
    var p2_speed = 0
    var current_turn = (1)

    while (true) {
        while(true) {
            var movement = a_or_b(current_turn)
            if (movement.contains("A")) {
                when (current_turn) {
                    1 -> p1_speed + 20
                    2 -> p2_speed + 20
                    else -> p1_speed + 1000000000
                }
            }
            else {
                when (current_turn) {
                    1 -> {
                        p1_speed - 20
                        if (p1_speed < 0) {
                            // p1_speed = 0
                        }
                    }
                    2 -> {
                        p2_speed - 20
                        if (p2_speed < 0) {
                            //p2_speed = 0
                        }
                    }
                    else -> p1_speed - 1000000000
                }
            }
            when(current_turn) {
                1 -> current_turn = 2
                2 -> {
                    current_turn = 1
                    break
                }
            }
        }
        move_car(current_turn, p1_speed, p2_speed)
        println(p1_speed)
        draw_track(p1_track, p2_track)
    }

}

        // Makes a list to act as the track, then fills it with empty slots and adds a race car.
fun set_up(race_no: Int): MutableList<String> {
    val track = mutableListOf<String>()
    for (i in 1..TRACKLENGTH) track.add(EMPTY)
    track[0] = ("p$race_no")
    return track
}

fun take_turn(racer: Int, p1_speed: Int, p2_speed: Int) {
    var movement = a_or_b(racer)
    if (movement.contains("A")) {
        when (racer) {
            1 -> p1_speed + 20
            2 -> p2_speed + 20
            else -> p1_speed + 1000000000
        }
    }
    else {
        when (racer) {
            1 -> {
                p1_speed - 20
                if (p1_speed < 0) {
                   // p1_speed = 0
                }
            }
            2 -> {
                p2_speed - 20
                if (p2_speed < 0) {
                    //p2_speed = 0
                }
            }
            else -> p1_speed - 1000000000
        }
    }
}

fun move_car(racer: Int, p1_speed: Int, p2_speed: Int) {
    var speed: Int
    when (racer) {
        1 -> speed = p1_speed
        2 -> speed = p2_speed
        else -> speed = 0
    }
}

fun draw_track(p1_track: MutableList<String>, p2_track: MutableList<String>) {
    println(p1_track)
    println(p2_track)
    println("")
}

fun a_or_b(racer: Int): String {
    var action: String
    println("Player $racer's turn")
    println("A = Accelerate")
    println("B = Brake")
    while (true) {
        print("Input action: ")
        action = readln().uppercase()
        if (action.isNotBlank()) {
            println("")
            break
        }
    }
    return action
}