package foodmine.runner

import com.twitter.util.Config.intoList
import foodmine.algo.ActiveUsers


object ActiveUsersRunner {
    def main(args: Array[String]): Unit = {
        val path = args(0)
        val activeCount = 1000

        val algo = new ActiveUsers(activeCount, path)

        val result  = algo.run()
        result.map( s => (s._1, s._2.estimate) ).sortBy(_._2).foreach(println)
    }
}
