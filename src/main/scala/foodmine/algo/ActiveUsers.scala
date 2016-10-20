package foodmine.algo

import java.io.StringReader

import com.twitter.algebird.{SpaceSaver, SpaceSaverSemigroup}
import org.apache.commons.csv.{CSVFormat, CSVParser}

import scala.io.Source


class ActiveUsers(topCount: Int, filePath: String) {
    def run() = {
        val iterator = Source.fromFile(filePath).getLines
        val sg = new SpaceSaverSemigroup[String]

        iterator.map(process).map(SpaceSaver(2000,_)).reduce(sg.plus).topK(topCount)
    }


    private def process(line: String) = {
        val arr = new CSVParser(new StringReader(line), CSVFormat.DEFAULT).getRecords.get(0)

        arr.get(3)
    }
}
