package foodmine.runner

import foodmine.algo.TopWords


object TopWordsRunner {
    def main(args: Array[String]): Unit = {
        val path = args(0)
        val activeCount = 1000

        val algo = new TopWords(activeCount, path)

        val result  = algo.run()
        result.map( s => (s._1, s._2.estimate) ).sortBy(_._2).foreach(println)
    }
}
