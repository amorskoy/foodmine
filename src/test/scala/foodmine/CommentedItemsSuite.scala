package foodmine

import foodmine.algo.CommentedItems
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  *Suite to test commented items algo
  */

@RunWith(classOf[JUnitRunner])
class CommentedItemsSuite extends FunSuite{
    test("Should find 3 most commentable product ids") {
        val path = "src/test/resources/test.csv"
        val activeCount = 3

        val algo = new CommentedItems(activeCount, path)
        val result = algo.run()

        assert(result.size == 3, "Should be exactly 3 most asctive users in result")

        val profiles = result.map(_._1).sorted
        assert(profiles == Seq("B0019CW0HE", "B001EO5QW8", "B001GVISJM"))
    }
}
