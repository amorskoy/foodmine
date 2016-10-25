package foodmine.algo

import java.io.{InputStream, StringReader}

import com.twitter.algebird.{SpaceSaver, SpaceSaverSemigroup}
import org.apache.commons.csv.{CSVFormat, CSVParser}

import scala.io.Source


class TopWords(topCount: Int, filePath: String) {
    // defines data size to be mapped into RAM for multi-core processing
    val GROUP_SIZE = 100

    def run() = {
        val iterator = Source.fromFile(filePath).getLines.drop(1)
        val sg = new SpaceSaverSemigroup[String]
        val stopWords = getStopWords()

        iterator.grouped(GROUP_SIZE)
            .map(g => g.par.flatMap(process).filterNot(isStopWord(_, stopWords)).map(SpaceSaver(2000,_)).reduce(sg.plus))
            .reduce(sg.plus)
            .topK(topCount)
    }


    private def process(line: String) = {
        val arr = new CSVParser(new StringReader(line), CSVFormat.DEFAULT).getRecords.get(0)

        arr.get(9).replaceAll("\\p{Punct}", "").split(" ")
    }

    def getStopWords() = {
        val stream : InputStream = getClass.getResourceAsStream("/english.stop.txt")
        val lines = scala.io.Source.fromInputStream( stream ).getLines

        lines.map(w => (w,1)).toMap
    }

    def isStopWord(word:String, stopWords:Map[String, Int]) = stopWords.contains(word.toLowerCase)

}
