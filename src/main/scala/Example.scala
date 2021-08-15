import doodle.core._
import doodle.image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.java2d._
import doodle.reactor._
import scala.concurrent.duration._

// Para usar este ejemplo:

//
// 1. run `sbt`
// 2. run the `run` command within `sbt`
object Example {
  val vector = 2

  val roof = Image.triangle(50 * vector, 30 * vector) fillColor Color.brown

  val frontDoor =
    (Image.rectangle(50 * vector, 15 * vector) fillColor Color.red) above (
      (Image.rectangle(10 * vector, 25 * vector) fillColor Color.black) on
        (Image.rectangle(50 * vector, 25 * vector) fillColor Color.red)
      )

  val house = roof above frontDoor

  val tree =
    (
      (Image.circle(50 * vector) fillColor Color.green) above
        (Image.rectangle(10 * vector, 20 * vector) fillColor Color.brown)
      )

  val streetSegment =
    (
      (Image.rectangle(30 * vector, 3 * vector) fillColor Color.yellow) beside
        (Image.rectangle(15 * vector, 3 * vector) fillColor Color.black) above
        (Image.rectangle(45 * vector, 7 * vector) fillColor Color.black)
      )

  val street = streetSegment beside streetSegment beside streetSegment

  val houseAndGarden =
    (house beside tree) above street

  val imagen = (
    houseAndGarden beside
      houseAndGarden beside
      houseAndGarden
    ) strokeWidth 0

  def main(args: Array[String]): Unit = {
    imagen.draw()
  }
}
