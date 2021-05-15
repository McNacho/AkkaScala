import akka.actor.Actor

class LoginActor extends Actor {
  override def receive: Receive = {
    case x:String =>
        if (x.equals("Anibal")){
          context.become(isAuth)
        }
  }

  def isAuth:Receive = {
    case x:String =>
      if (x.equals("Escipion")){
        println("Roma!!")
      }
      if (x.equals("logout")){
        println("Invasion Rechazada!!")
        context.become(notAuth)
      }
    case _ => println("Todo Normal")
  }
  def notAuth:Receive = {
    case x:String =>
      if (x.equals("Anibal")){
        context.become(isAuth)
      }
    case _ => println("Invasion")

  }
}
