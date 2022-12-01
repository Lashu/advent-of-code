//package adventOfCode.year2022
//
//import adventOfCode.AdventOfCodeDay
//
//class Day7: AdventOfCodeDay {
//    val rootDirectory = Directory("/", null)
//
////    private fun parseLine(line: String) {
////        when
////    }
//
//    private fun String.isNotLs(): Boolean {
//        return this != "ls"
//    }
//
//    private fun String.isDir(): Boolean {
//        return this != "ls"
//    }
//
//    private fun String.isFile(): Boolean {
//        return this != "ls"
//    }
//
//    private fun String.isCd(): Boolean {
//        return this != "ls"
//    }
//
//
//    override fun partOne(input: List<String>): Any? {
//
////
////        val currentDirectory = rootDirectory
////
////        input.forEach { line ->
////            if (line.isNotLs()) {
////                when {
////                    line.isDir() -> currentDirectory.addDir(line, currentDirectory)
////                    line.isFile() -> currentDirectory.addFile(line)
////                    line.isCd() ->
////                }
////            }
////        }
//
//
//    }
//
//    override fun partTwo(input: List<String>): Any? {
//        TODO("Not yet implemented")
//    }
//}
//
//class Directory(
//    val name: String,
//    val parent: Directory?
//) {
//    private val files = mutableListOf<File>()
//    private var directories = mutableListOf<Directory>()
//
//    fun addDir(directory: String, parent: Directory) {
//        val directoryProps = directory.split(" ")
//        directories.add(Directory(name = directoryProps[0], parent))
//    }
//
//    fun addFile(file: String) {
//        val fileProps = file.split(" ")
//        files.add(File(fileProps[1], fileProps[0].toLong()))
//    }
//}
//
//class File(
//    val name: String,
//    val size: Long
//)