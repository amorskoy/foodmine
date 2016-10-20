package foodmine

import foodmine.algo.ActiveUsers
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  *Suite to test active users algo
  */

@RunWith(classOf[JUnitRunner])
class AciveUsersSuite extends FunSuite{
    test("Should find 2 most active profiles - Wolfee1 and Canadian Fan") {
        val path = "src/test/resources/test.csv"
        val activeCount = 2

        val algo = new ActiveUsers(activeCount, path)
        val result = algo.run()

        assert(result.size == 2, "Should be exactly 2 most asctive users in result")

        val profiles = result.map(_._1).sorted
        assert(profiles == Seq("Canadian Fan", "Wolfee1"))
    }
}
