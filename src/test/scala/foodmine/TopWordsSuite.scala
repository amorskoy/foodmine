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
    val path = "src/test/resources/test_words.csv"

    test("Should find 2 most used comment words") {
        val activeCount = 2

        val algo = new TopWords(activeCount, path)
        val result = algo.run()

        assert(result.size == 2, "Should be exactly 2 comment words in result")

        val profiles = result.map(_._1).sorted
        assert(profiles == Seq("cool", "food"))
    }

    test("Shoud open stop words") {
        val activeCount = 2
        val algo = new TopWords(activeCount, path)

        assert(algo.getStopWords().size === 570, "Should be exactly 570 enlish stop word")
    }

    test("Shoud filter out stop words: I, it, was, and, the, best, ever, think") {
        val activeCount = 2
        val algo = new TopWords(activeCount, path)
        val testStr = "I think it was cool and the best ever"
        val stopWords = algo.getStopWords()

        var result = testStr.split(" ").filterNot(word => algo.isStopWord(word, stopWords))

        assert(result.sorted === Seq("cool"))

    }
}
