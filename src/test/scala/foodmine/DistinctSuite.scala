package foodmine

import bloomfilter.mutable.BloomFilter
import foodmine.domain.Review
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  *Suite to test input's distinct control
  * @see Bloom's filter theory
 */

@RunWith(classOf[JUnitRunner])
class DistinctSuite extends FunSuite{
    test ("Should detect duplicated reviews") {
        val review = new Review(1,"B001E4KFG0", "A3SGXH7AUHU8GW", "delmartian" ,1,1,5,1303862400, "Good Quality Dog Food", "Really good!")
        val key = s"${review.productId.hashCode}_${review.userId.hashCode}"

        val bf = BloomFilter[String](600000, 0.1f)
        bf.add(key)

        assert(bf.mightContain(key), s"Should see duplicate for (${review.productId}, ${review.userId}) using hash $key")

        bf.dispose()

    }

    test ("Should detect duplicated reviews using united bloom filters") {
        val review1 = new Review(1,"B001E4KFG0", "A3SGXH7AUHU8GW", "delmartian" ,1,1,5,1303862400, "Good Quality Dog Food", "Really good!")
        val review2 = new Review(1,"B001E4KFG0", "A3SGXH7AUHU8GW", "delmartian" ,1,1,5,1303862400, "Good Quality Dog Food", "Really good!")
        val key1 = s"${review1.productId.hashCode}_${review1.userId.hashCode}"
        val key2 = s"${review2.productId.hashCode}_${review2.userId.hashCode}"

        val bf1 = BloomFilter[String](600000, 0.1f)
        val bf2 = BloomFilter[String](600000, 0.1f)
        bf1.add(key1)
        bf2.add(key2)

        val bfUnion = bf1.union(bf2)

        assert(bfUnion.mightContain(key1), s"Should see duplicate for (${review1.productId}, ${review1.userId}) using hash $key1")
        assert(bfUnion.mightContain(key2), s"Should see duplicate for (${review2.productId}, ${review2.userId}) using hash $key2")

        bf1.dispose()
        bf2.dispose()
        bfUnion.dispose()

    }

}
