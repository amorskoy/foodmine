package foodmine

import foodmine.algo.TopWords
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  *Suite to test active users algo
  */

@RunWith(classOf[JUnitRunner])
class TopWordsSuite extends FunSuite{
    test("Should find 2 most used comment words") {
        val path = "src/test/resources/test_words.csv"
        val activeCount = 2

        val algo = new TopWords(activeCount, path)
        val result = algo.run()

        assert(result.size == 2, "Should be exactly 2 comment words in result")

        val profiles = result.map(_._1).sorted
        assert(profiles == Seq("best", "ever"))
    }
}
