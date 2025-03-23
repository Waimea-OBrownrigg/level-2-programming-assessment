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

    //while (true) {
        race()
        draw_track(p1_track, p2_track)
    //}

}

        // Makes a list to act as the track, then fills it with empty slots and adds a race car.
fun set_up(race_no: Int): MutableList<String> {
    val track = mutableListOf<String>()
    for (i in 1..TRACKLENGTH) track.add(EMPTY)
    track[0] = ("p$race_no")
    return track
}

fun race() {
    var current_turn = (1)
    while(true) {
        take_turn(current_turn)
        when(current_turn) {
            1 -> current_turn = 2
            2 -> {
                current_turn = 1
                break
            }
        }
    }
}

fun take_turn(racer: Int) {
    var movement = a_or_b(racer)
    move_car()
}

fun move_car() {

}

fun draw_track(p1_track: MutableList<String>, p2_track: MutableList<String>) {
    println(p1_track)
    println(p2_track)
}

fun a_or_b(racer: Int) {
    println("Player $racer's turn")
}