//package adventOfCode.year2021
//
//import adventOfCode.AdventOfCodeDay
//import spock.lang.Specification
//import spock.lang.Subject
//
//class Day13Spec extends Specification {
//
//    @Subject
//    AdventOfCodeDay day13 = new Day13()
//
//    def "should solve part one"() {
//        given:
//            def input = [
//                    "6,10",
//                    "0,14",
//                    "9,10",
//                    "0,3",
//                    "10,4",
//                    "4,11",
//                    "6,0",
//                    "6,12",
//                    "4,1",
//                    "0,13",
//                    "10,12",
//                    "3,4",
//                    "3,0",
//                    "8,4",
//                    "1,10",
//                    "2,14",
//                    "8,10",
//                    "9,0",
//                    "",
//                    "fold along y=7",
//                    "fold along x=5",
//            ]
//
//        when:
//            def result = day13.partOne(input)
//
//        then:
//            result == 17
//    }
//
//    def "should solve part two"() {
//        given:
//            def input = [
//                    "6,10",
//                    "0,14",
//                    "9,10",
//                    "0,3",
//                    "10,4",
//                    "4,11",
//                    "6,0",
//                    "6,12",
//                    "4,1",
//                    "0,13",
//                    "10,12",
//                    "3,4",
//                    "3,0",
//                    "8,4",
//                    "1,10",
//                    "2,14",
//                    "8,10",
//                    "9,0",
//                    "",
//                    "fold along y=7",
//                    "fold along x=5",
//            ]
//
//        when:
//            def result = day13.partTwo(input)
//
//        then:
//            result == 17
//    }
//
//}
