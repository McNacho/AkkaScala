import akka.actor.Actor

class AddActor extends Actor{
  var sum = 0
  override def receive: Receive = {
    case x:Int => sum += x
      sender ! sum
    case _ => println("Valor incorrecto")
  }
}
