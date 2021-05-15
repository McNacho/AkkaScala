import akka.actor.ActorSystem
import akka.actor.Props
import akka.util.Timeout
import akka.pattern.ask
import scala.concurrent.duration._
import scala.concurrent.Await
import scala.language.postfixOps

object ActorSetUp extends App {
  implicit val timeout = Timeout(10 seconds)
  val  system = ActorSystem("cartago")
  val actor =   system.actorOf(Props[AddActor],"addActor")
  val loginactor =   system.actorOf(Props[LoginActor],"loginActor")
  val future = (actor ? 5).mapTo[Int]
  val result = Await.result(future,10 seconds)
   println(result)

  loginactor!"Anibal"
  loginactor!"Asdrubal"
  loginactor!"Escipion"
  loginactor!"Romulo"
  loginactor!"logout"
  loginactor!"Maharbal"
  loginactor!"Anibal"
  loginactor!"Asdrubal"

}
